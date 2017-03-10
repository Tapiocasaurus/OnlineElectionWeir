package model;

public class ElectionSelect {
static int electionID;
public static int getElectionID() {
	return electionID;
}
public static void setElectionID(int electionID) {
	ElectionSelect.electionID = electionID;
}
public static String getElectionName() {
	return electionName;
}
public static void setElectionName(String electionName) {
	ElectionSelect.electionName = electionName;
}
public static String getCandidate1() {
	return candidate1;
}
public static void setCandidate1(String candidate1) {
	ElectionSelect.candidate1 = candidate1;
}
public static String getCandidate2() {
	return candidate2;
}
public static void setCandidate2(String candidate2) {
	ElectionSelect.candidate2 = candidate2;
}
public static String getCandidate3() {
	return candidate3;
}
public static void setCandidate3(String candidate3) {
	ElectionSelect.candidate3 = candidate3;
}
static String electionName;
static String candidate1;
static String candidate2;
static String candidate3;

}
