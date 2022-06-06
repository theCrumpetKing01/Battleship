package main;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//contains the data to represent the play board
public class Board {

	private int[] ships1 = {2, 2, 2, 3, 3, 4};
	private int plyr;
	
	private boolean[][] board = new boolean[10][10];
	
	//if board[row][col] is true it sets the space as false and returns true
	public boolean railgun(int row, int col){
		if(board[row][col]){
			board[row][col]=false;
			return true;
		}
		return false;
	}
	//returns true if all items in board are false
	public boolean win(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j]){
					return true;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Player " + plyr + "loses!");
		return false;
	}
	//allows the user to place vertical "ships" in the array at the specified x and y
	public void insertPatternVert(int i){
		String x = JOptionPane.showInputDialog(battle()+"\nselect row: ");
		String y = JOptionPane.showInputDialog(battle()+"\nselect col: ");
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		
		if(xx<1){
			xx=1;
		}
		else if(xx>board.length-i){
			xx=board.length-i;
		}
		if(yy<1){
			yy=1;
		}
		else if(yy>board[xx].length-1){
			yy=board[xx].length-1;
		}
		if(i==2){
			board[xx][yy]=true;
			board[xx+1][yy]=true;
		}
		else if(i==3){
			board[xx][yy]=true;
			board[xx+1][yy]=true;
			board[xx+2][yy]=true;
		}
		else{
			board[xx][yy]=true;
			board[xx+1][yy]=true;
			board[xx+2][yy]=true;
			board[xx+3][yy]=true;
		}
	}
	//allows the user to place horizontal "ships" in the array at the specified x and y
	public void insertPatternHori(int i){
		String x = JOptionPane.showInputDialog(battle()+"\nselect row: ");
		String y = JOptionPane.showInputDialog(battle()+"\nselect col: ");
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		
		if(xx<1){
			xx=1;
		}
		else if(xx>board.length-1){
			xx=board.length-1;
		}
		if(yy<1){
			yy=1;
		}
		else if(yy>board[xx].length-i){
			yy=board[xx].length-i;
		}
		if(i==2){
			board[xx][yy]=true;
			board[xx][yy+1]=true;
		}
		else if(i==3){
			board[xx][yy]=true;
			board[xx][yy+1]=true;
			board[xx][yy+2]=true;
		}
		else{
			board[xx][yy]=true;
			board[xx][yy+1]=true;
			board[xx][yy+2]=true;
			board[xx][yy+3]=true;
		}
	}
	
	//returns the string representation of the board
	public String battle(){
		String ret = "";
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j]){
					ret+="[]";
				}
				else{
					ret+="  ";
				}
			}
			ret+="\n";
		}
		return ret;
	}
	
	//creates a board for the specified player object and allows them to place ships with insertPatternHori or insertPatternVert
	public Board(int ply){
		plyr=ply;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				board[i][j]=false;
			}
		}
		for(int j=0; j<ships1.length; j++){
			Object[] options = {"Place ship horizontal", "Place ship verical"};
			int opt = JOptionPane.showOptionDialog(null, battle(), "War Ships player " + plyr,
			        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			if(opt==0){
				insertPatternHori(ships1[j]);
			}
			else if(opt==1){
				insertPatternVert(ships1[j]);
			}
			else{System.exit(0);}
		}
	}
	
}
