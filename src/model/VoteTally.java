package model;
public class VoteTally {
	private String userSelection;
	private int[] tallies = {0,0,0};
	private int totalTally = 0;
	private String[] candidates = {null, null, null};
	private String electionName;
	VotingDAO dao = new VotingDAO();

	public VoteTally(){
		
	}
	public VoteTally(String elecName, String cand1n,String cand2n,String cand3n,int cand1v,int cand2v,int cand3v){
		setElectionName(elecName);
		candidates[0] = cand1n;
		candidates[1] = cand2n;
		candidates[2] = cand3n;
		tallies[0] = cand1v;
		tallies[1] = cand2v;
		tallies[2] = cand3v;
		
	}

	public String getUserSelection() {
		return userSelection;
	}

	public void setUserSelection(String userSelection) {
		this.userSelection = userSelection;
	}

	public int[] getTallies() {
		return tallies;
		
	}

	public void setTallies(int[] tallies) {
		this.tallies = tallies;
	}
	
	public int getTotalTally(){
		totalTally = tallies[0] + tallies[1] + tallies[2];
		return totalTally;
	}

	public String[] getCandidates() {
		return candidates;
	}

	public void setCandidates(String[] candidates) {
		this.candidates = candidates;
	}
	
	public void tally(int select){
		
				this.tallies[select] += 1;
				dao.updateElection(select, this.tallies[select], electionName);
				//totalTally += 1;	
	}
	
	
	public void untally(String userSelection){
		for(int i=0; i<candidates.length; i++){
			if(userSelection.equals(candidates[i])){
				this.tallies[i] -= 1;
				//totalTally -= 1;
			}
		}
	}
	public String displayTallies(){
		String message = "The current tallies are: \n";
		for(int i = 0; i<tallies.length; i++){
			message += candidates[i] + ": " + tallies[i] + " \n";
		}
		message += "Total Votes: " + getTotalTally();
		return message;
	}
	
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

}
