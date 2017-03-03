package model;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class VotingMachine extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VoteTally tally = new VoteTally();
	VotingDAO dao = new VotingDAO();
	static String newElectionID;
	static String newElectionName;
	static String newcand1;
	static String newcand2;
	static String newcand3;
	
	//elements for voting panel
	String adminPassword = "applesauce";
	JLabel voteMessage = new JLabel("                              Please vote for a candidate                                 ");
	String[] candidates;
	JButton choice1 = new JButton(tally.getCandidates()[0]);
	JButton choice2 = new JButton(tally.getCandidates()[1]);
	JButton choice3 = new JButton(tally.getCandidates()[2]);
	String userSelection = null;
	JLabel displayTally = new JLabel();
	
	//elements for confirmation panel
	JLabel confirmMessage = new JLabel("");
	JButton confirm = new JButton("Confirm");
	JButton reset = new JButton("Reset");
	
	//elements for Thank You panel
	JLabel thankyou = new JLabel("Thank you for your vote.");
	JButton ok = new JButton("OK");
	
	
	//elements for Password Panel
	JLabel passEnter = new JLabel("Please enter the Administrator password to continue:");
	JTextField passWord = new JTextField(10);
	JButton passCheck = new JButton("Submit");
	JLabel passError = new JLabel("");
	
	//elements for Admin Panel
	JButton nextVote = new JButton("Next Voter");
	JButton checkResults = new JButton("Show Results");
	JButton changePass = new JButton("Change Password");
	
	//elements for Result Panel
	JLabel header = new JLabel ("Current results of Election");
	JLabel totalresult = new JLabel ("");
	JButton goAdmin = new JButton("Return to Admin Screen");
	
	//elements for Password Change Panel
	JLabel newpassEnter = new JLabel("Please enter the new password in both fields and submit:");
	JTextField newpassword1 = new JTextField(10);
	JTextField newpassword2 = new JTextField(10);
	JButton passChange = new JButton("Submit");
	JLabel errorMsg = new JLabel("");
	
	//elements for Password Changed Panel
	JLabel newpassdone = new JLabel("Password has been changed!");
	 //goadmin
	
	//elements for Election Creation
	static JTextField electionID = new JTextField(20);
	static JTextField electionname = new JTextField(20);
	static JTextField cand1name = new JTextField(20);
	static JTextField cand2name = new JTextField(20);
	static JTextField cand3name = new JTextField(20);
	JLabel electionIDlabel = new JLabel("Election ID:");
	JLabel electionnamelabel = new JLabel("Election Name:");
	JLabel cand1namelabel = new JLabel("Candidate 1 Name:");
	JLabel cand2namelabel = new JLabel("Candidate 2 Name:");
	JLabel cand3namelabel = new JLabel("Candidate 3 Name:");
	JButton createElection = new JButton("Create Election");
	
	
	
	//elements for Start/Choose Election Page
	JButton newElection = new JButton("Create a new Election");
	JButton resumeElection = new JButton("Resume an existing Election");
	
	//elements for Resume Election Page
	Container c = getRootPane();
	ArrayList<VoteTally> allListItems = dao.getAllItems();
	JButton selectElection = new JButton("Select Election");
	
	JButton backToChoose = new JButton("Back");
	JList<Object> elections = new JList<Object>(allListItems.toArray());
	JScrollPane scroll = new JScrollPane(elections);
	
	
	
	//elements 
	JPanel choose = new JPanel();
	JPanel confirmPanel = new JPanel();
	JPanel thankYouPanel = new JPanel();
	JPanel passwordPanel = new JPanel();
	JPanel adminPanel = new JPanel();
	JPanel resultsPanel = new JPanel();
	JPanel passchangePanel = new JPanel();
	JPanel passchangedPanel = new JPanel();
	JPanel createElectionPanel = new JPanel();
	JPanel chooseElectionPanel = new JPanel();
	JPanel resumeElectionPanel = new JPanel();
	
	
	
	
	
	
	
	
	
	
	
	
	
	public VotingMachine(){
		//Start with Voting Page
		//choose.add(voteMessage);
		//choose.add(choice1);
		//choose.add(choice2);
		//choose.add(choice3);
		//choose.add(displayTally);
		//add(choose);
		
		
		chooseElectionPanel.add(newElection);
		chooseElectionPanel.add(resumeElection);
		add(chooseElectionPanel);
		
		
		//Start w/password
		//passwordPanel.add(passEnter);
		//passwordPanel.add(passWord);
		//passwordPanel.add(passCheck);
		
		//add(passwordPanel);
		
		//Adding Action Listeners to Buttons
		vote1 v1 = new vote1();
		choice1.addActionListener(v1);
		vote2 v2 = new vote2();
		choice2.addActionListener(v2);
		vote3 v3 = new vote3();
		choice3.addActionListener(v3);
		//confirm c1 = new confirm();
		//confirm.addActionListener(c1);
		reset r1 = new reset();
		reset.addActionListener(r1);
		ok o1 = new ok();
		ok.addActionListener(o1);
		passCheck p1 = new passCheck();
		passCheck.addActionListener(p1);
		nextVote n1 = new nextVote();
		nextVote.addActionListener(n1);
		checkResults cr1 = new checkResults();
		checkResults.addActionListener(cr1);
		goAdmin g1 = new goAdmin();
		goAdmin.addActionListener(g1);
		changePass cp1 = new changePass();
		changePass.addActionListener(cp1);
		passChange pc1 = new passChange();
		passChange.addActionListener(pc1);
		newElection ne1 = new newElection();
		newElection.addActionListener(ne1);
		createElection ce1 = new createElection();
		createElection.addActionListener(ce1);
		resumeElection re1 = new resumeElection();
		resumeElection.addActionListener(re1);
		selectElection se1 = new selectElection();
		selectElection.addActionListener(se1);
		backToChoose btc1 = new backToChoose();
		backToChoose.addActionListener(btc1);
		
	}
	
	class vote1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			candidates = tally.getCandidates();
			
			tally.tally(0);
			displayTally.setText(tally.displayTallies() + "");
			System.out.println(tally.displayTallies() + "");
			remove(choose);
			thankYouPanel.add(thankyou);
			thankYouPanel.add(ok);
			add(thankYouPanel);
			revalidate();
			repaint();
			
		}
		
	}
	class vote2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			candidates = tally.getCandidates();
			userSelection = candidates[1];
			tally.tally(1);
			displayTally.setText(tally.displayTallies() + "");
			System.out.println(tally.displayTallies() + "");		
		   remove(choose);
		   
		   thankYouPanel.add(thankyou);
			thankYouPanel.add(ok);
			add(thankYouPanel);
			revalidate();
			repaint();

		}
		
	}
	class vote3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			candidates = tally.getCandidates();
			userSelection = candidates[2];
			tally.tally(2);
			displayTally.setText(tally.displayTallies() + "");
			System.out.println(tally.displayTallies() + "");
			remove(choose);

			thankYouPanel.add(thankyou);
			thankYouPanel.add(ok);
			add(thankYouPanel);
			revalidate();
			repaint();

		}
		
	}
	
	
	//class confirm implements ActionListener{
		//@Override
		//public void actionPerformed(ActionEvent e) {
			
			//remove(confirmPanel);
			//removeAll();
			
			//thankYouPanel.add(thankyou);
			//thankYouPanel.add(ok);
			//add(thankYouPanel);
			//revalidate();
			//repaint();
		//}
	//}
	
		class reset implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tally.untally(userSelection);
				remove(confirmPanel);
				revalidate();
				repaint();
				displayTally.setText(tally.displayTallies() + "");
				System.out.println(tally.displayTallies() + "");
				choose.add(voteMessage);
				choose.add(choice1);
				choose.add(choice2);
				choose.add(choice3);
				//choose.add(displayTally);
				add(choose);
			}
		
	}
		
		class ok implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(thankYouPanel);
				
				passwordPanel.add(passEnter);
				passwordPanel.add(passWord);
				passwordPanel.add(passCheck);
				passwordPanel.remove(passError);
				add(passwordPanel);
				revalidate();
				repaint();
			}
		
	}
		class passCheck implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
			if (passWord.getText().equals(adminPassword)){
				passWord.setText("");
				remove(passwordPanel);
				
				adminPanel.add(nextVote);
				adminPanel.add(checkResults);
				//adminPanel.add(backToChoose);
				add(adminPanel);
				revalidate();
				repaint();
			}
			else{
				System.out.println("INCORRECT PASSWORD");
				passWord.setText("");
				passError.setText("Incorrect Password. Try again.");
				passwordPanel.add(passError);
				revalidate();
				repaint();
			}

			}
		
	}
	
		class nextVote implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				candidates = tally.getCandidates();
				remove(adminPanel);
				revalidate();
				repaint();
				choice1.setText(candidates[0]);
				choice2.setText(candidates[1]);
				choice3.setText(candidates[2]);

				choose.add(voteMessage);
				choose.add(choice1);
				choose.add(choice2);
				choose.add(choice3);
				//choose.add(displayTally);
				add(choose);
				revalidate();
				repaint();
			}
		
	}
	
		class checkResults implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(adminPanel);
				
				resultsPanel.add(header);
				resultsPanel.add(totalresult);
				resultsPanel.add(goAdmin);
				totalresult.setText(tally.displayTallies());
				add(resultsPanel);
				revalidate();
				repaint();
			}
		
	}
		
		class changePass implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(adminPanel);
				
				passchangePanel.add(newpassEnter);
				passchangePanel.add(newpassword1);
				passchangePanel.add(newpassword2);
				passchangePanel.add(passChange);
				passchangePanel.add(goAdmin);
				passchangePanel.remove(errorMsg);
				add(passchangePanel);
				revalidate();
				repaint();
			}
		
	}
		
		class passChange implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (newpassword1.getText().equals(newpassword2.getText())){
					adminPassword = newpassword1.getText();
					newpassword1.setText("");
					newpassword2.setText("");
					remove(passchangePanel);
				}
				else{
					newpassword1.setText("");
					newpassword2.setText("");
					//System.out.println("Passwords do not match!");
					errorMsg.setText("Passwords do not match. Try again.");
					passchangePanel.add(errorMsg);
					repaint();
				}
				
				
				passchangedPanel.add(newpassdone);
				passchangedPanel.add(goAdmin);
				add(passchangedPanel);
				revalidate();
				repaint();
			}
		
	}
		
		class goAdmin implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(resultsPanel);
				remove(passchangePanel);
				remove(passchangedPanel);
				
				adminPanel.add(nextVote);
				adminPanel.add(checkResults);
				//adminPanel.add(backToChoose);
				add(adminPanel);

				revalidate();
				repaint();
			}
		
	}
		
		
		class newElection implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(chooseElectionPanel);
				createElectionPanel.add(electionIDlabel);
				createElectionPanel.add(electionID);
				createElectionPanel.add(electionnamelabel);
				createElectionPanel.add(electionname);
				createElectionPanel.add(cand1namelabel);
				createElectionPanel.add(cand1name);
				createElectionPanel.add(cand2namelabel);
				createElectionPanel.add(cand2name);
				createElectionPanel.add(cand3namelabel);
				createElectionPanel.add(cand3name);
				createElectionPanel.add(createElection);

				add(createElectionPanel);

				revalidate();
				repaint();
			}
		
	}
		class createElection implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				newElectionID = electionID.getText();
				newElectionName = electionname.getText();
				newcand1 = cand1name.getText();
				newcand2 = cand2name.getText();
				newcand3 = cand3name.getText();
				tally = dao.insertNewElection(tally);
				//tally = dao.newElection;
				remove(createElectionPanel);

				passwordPanel.add(passEnter);
				passwordPanel.add(passWord);
				passwordPanel.add(passCheck);
				
				add(passwordPanel);

				revalidate();
				repaint();
			}
		
	}
		
		class resumeElection implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(chooseElectionPanel);
				
				setLayout(new BorderLayout());
				//title.setFont(new Font("Serif", Font.PLAIN, 16));
				
			    
			    
			    //JScrollPane scroll = new JScrollPane(list);
				
			    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		        scroll.setPreferredSize(new Dimension(350, 100));
				
				
				//add(title, BorderLayout.NORTH);
				add(scroll, BorderLayout.CENTER);
				
				

				
				resumeElectionPanel.add(elections);
				resumeElectionPanel.add(selectElection);
				resumeElectionPanel.add(backToChoose);
				
				add(resumeElectionPanel);

				revalidate();
				repaint();
			}
		
	}
		
		class selectElection implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = elections.getSelectedIndex();
				
				System.out.println(index);
				VoteTally tempItem = dao.getAllItems().get(index);
				
				System.out.println(tempItem.getElectionName());
				//System.out.println(tempItem.getCandidates()[0]);
				//dao
				tally = dao.selectElect(tempItem.getElectionName());
				
				//tally.setCandidates(tempItem.getCandidates());
				//dao.selectElect(index);
				//tally = tempItem;
				remove(resumeElectionPanel);
				
				passwordPanel.add(passEnter);
				passwordPanel.add(passWord);
				passwordPanel.add(passCheck);
				
				add(passwordPanel);
				
				revalidate();
				repaint();
			}
		
	}
		
		class backToChoose implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				remove(resumeElectionPanel);
				remove(adminPanel);

				chooseElectionPanel.add(newElection);
				chooseElectionPanel.add(resumeElection);
				add(chooseElectionPanel);

				revalidate();
				repaint();
			}
		
	}
		

}