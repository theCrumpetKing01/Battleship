package main;

import javax.swing.JOptionPane;


public class View {

	private Board ply1 = new Board(1);
	
	private Board ply2 = new Board(2);
	
	private boolean running = true;
	
	//after ships are placed, this method allows two players to take turns attacking ships
	private void run(){
		JOptionPane.showMessageDialog(null, "Player 1 board: \n" + ply1.battle());
		String x = JOptionPane.showInputDialog("\nselect row to attack: ");
		String y = JOptionPane.showInputDialog("\nselect col to attack: ");
		if(ply2.railgun(Integer.valueOf(x), Integer.valueOf(y))){
			JOptionPane.showMessageDialog(null, "Hit! Switch players!");

		}
		else{JOptionPane.showMessageDialog(null, "Miss. Switch players!");}
		JOptionPane.showMessageDialog(null, "Player 2 board: \n" + ply2.battle());
		String a = JOptionPane.showInputDialog("\nselect row to attack: ");
		String b = JOptionPane.showInputDialog("\nselect col to attack: ");
		if(ply1.railgun(Integer.valueOf(x), Integer.valueOf(y))){
			JOptionPane.showMessageDialog(null, "Hit! Switch players!");

		}
		else{JOptionPane.showMessageDialog(null, "Miss. Switch players!");}
	}
	
	//creates a new game loop
	public View(){
		while(ply1.win()&&ply2.win()){
			run();
		}
	}
	
	
}
