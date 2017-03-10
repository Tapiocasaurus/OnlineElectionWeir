package model;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class VotingDAO {
Connection con = null;
	
	public VotingDAO(){
		makeConnection();
	}
	
	public void makeConnection(){
		String url = "jdbc:mysql://localhost:3306/election";
		String user = "root";
		String password = "DIAD2016";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connection made");
			
			
		} catch (Exception ex){
			System.out.println("Sql Exception");
		}


}
	public ArrayList<VoteTally> getAllItems(){
		ArrayList<VoteTally> allItems = new ArrayList<VoteTally>();
		String q = "SELECT * from currentelections";
		try{
		Statement st = (Statement) con.createStatement();
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()){
			
			int electionid = rs.getInt(1);
			String electionName = rs.getString(2);
			String candidate1name = rs.getString(3);
			String candidate2name = rs.getString(4);
			String candidate3name = rs.getString(5);
			int cand1vote = rs.getInt(6);
			int cand2vote = rs.getInt(7);
			int cand3vote = rs.getInt(8);
			
			VoteTally tempElection = new VoteTally(electionName,candidate1name,candidate2name,candidate3name,cand1vote,cand2vote,cand3vote);
			allItems.add(tempElection);
			
			System.out.println(electionid + "--" + electionName + "--" + candidate1name+ "--" + candidate2name+ "--" + candidate3name+ "--" + cand1vote+ "--" + cand2vote+ "--" + cand3vote);
		}
		} catch (SQLException ex){
			System.out.println("Sql error in get all items");
			System.out.println(ex.getStackTrace());
		}
		
		return allItems;
	}
	
	
	public String getElection(int Eid){
		//ArrayList<VoteTally> Elections = new ArrayList<VoteTally>();
		String election = null;
		String q = "SELECT electionName from currentelections where electionID = '" + Eid +"'";
		try{
		Statement st = (Statement) con.createStatement();
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()){
			
			election = rs.getString(1);
			
			//ListItem tempItem = new ListItem(store,item);
			//allItems.add(tempItem);
			
			//System.out.println(id + "--" + store + "--" + item);
		}
		} catch (SQLException ex){
			System.out.println("Sql error in get all items");
			System.out.println(ex.getStackTrace());
		}
		
		return election;
	}
	public VoteTally selectElect(int index) {
		// TODO Auto-generated method stub
		makeConnection();
		
		//int tempID = i.getID();

		String query = "select * from currentelections where electionID ='" + index + "'";
		System.out.println(query);
		VoteTally electionSelect = null;
		try {
			Statement st = (Statement) con.createStatement();
			//st.executeQuery(query);
			ResultSet rs2 = st.executeQuery(query);
			while(rs2.next()){
				
				//int electionidb = rs2.getInt(1);
				String electionNameb = rs2.getString(2);
				String candidate1nameb = rs2.getString(3);
				String candidate2nameb = rs2.getString(4);
				String candidate3nameb = rs2.getString(5);
				int cand1voteb = rs2.getInt(6);
				int cand2voteb = rs2.getInt(7);
				int cand3voteb = rs2.getInt(8);
				electionSelect = new VoteTally(electionNameb,candidate1nameb,candidate2nameb,candidate3nameb,cand1voteb,cand2voteb,cand3voteb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return electionSelect;

	}
	public String getName(int select,  String index) {
		// TODO Auto-generated method stub
		makeConnection();
		
		//int tempID = i.getID();

		String query = "select candidate" + select + "name from currentelections where electionName ='" + index + "'";
		System.out.println(query);
		String electionidb=null;
		try {
			Statement st = (Statement) con.createStatement();
			//st.executeQuery(query);
			ResultSet rs2 = st.executeQuery(query);
			while(rs2.next()){
				
				electionidb = rs2.getString(1);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(electionidb);
		return electionidb;

	}	
	public int getVote(int select,  String index) {
		// TODO Auto-generated method stub
		makeConnection();
		
		//int tempID = i.getID();

		String query = "select cand" + select + "vote from currentelections where electionName ='" + index + "'";
		System.out.println(query);
		int electionidb=0;
		try {
			Statement st = (Statement) con.createStatement();
			//st.executeQuery(query);
			ResultSet rs2 = st.executeQuery(query);
			while(rs2.next()){
				
				electionidb = rs2.getInt(1);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(electionidb);
		return electionidb;

	}
	

	//public  ArrayList getElectionNames(){
		
//	}
	
	public VoteTally insertNewElection(VoteTally i, int elecID) {
		// TODO Auto-generated method stub
		makeConnection();
		int tempID = elecID;
		String tempElection = i.getElectionName();
		String [] tempCandidates = {i.getCandidates()[0],i.getCandidates()[1],i.getCandidates()[2]};
		int []tempTallies = {0,0,0};
		
		String query = "INSERT INTO currentelections (electionID, electionName, candidate1name, candidate2name, candidate3name, cand1vote, cand2vote, cand3vote) "
				+ "VALUES (" + tempID + ",'" + tempElection + "','" + tempCandidates[0] + "','" + tempCandidates[1] + "','" +tempCandidates[2] 
						+ "'," + tempTallies[0] + "," + tempTallies[1] + "," + tempTallies[2]+ ")";
		
		
				
		System.out.println(query);
		VoteTally newElection = new VoteTally(tempElection, tempCandidates[0], tempCandidates[1],tempCandidates[2],tempTallies[0],tempTallies[1],tempTallies[2] );
		//VotingMachine.tally.setCandidates(tempCandidates);
		
		try {
			Statement st = (Statement) con.createStatement();
			
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newElection;
	}
	
	public void updateElection(int select, int newTally, String index) {
		// TODO Auto-generated method stub
		makeConnection();
		
		
		String query = "UPDATE currentelections SET cand"+ select + "vote="+ newTally + 
" WHERE electionName = '"+ index + "'";
		
		
				
		System.out.println(query);
		
		
		try {
			Statement st = (Statement) con.createStatement();
			
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}