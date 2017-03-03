package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.VoteTally;
import model.VotingDAO;

/**
 * Servlet implementation class NewElectionServlet
 */
@WebServlet("/NewElectionServlet")
public class NewElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		String elecID = request.getParameter("eID");
		String elecName = request.getParameter("ename");
		String cand1Name = request.getParameter("c1name");
		String cand2Name = request.getParameter("c2name");
		String cand3Name = request.getParameter("c3name");
		VoteTally li = new VoteTally(elecName, cand1Name, cand2Name, cand3Name, 0,0,0);
		VotingDAO dao = new VotingDAO();
		
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("Submit Election")){
			dao.insertNewElection(li);
			System.out.println("Launch us to vote");
			getServletContext().getRequestDispatcher("/voting.jsp").forward(request, response);
		}
		
		
		//getServletContext().getRequestDispatcher("/VotingServlet").forward(request, response);
		//doGet(request, response);
	}

}
