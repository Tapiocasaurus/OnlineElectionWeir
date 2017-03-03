package model;
import javax.swing.JFrame;

public class votingTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JFrame frame = new VotingMachine();
			frame.setSize(400, 200);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setTitle("VOTING MACHINE");
	}

}
