package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VotingDAO;

/**
 * Servlet implementation class VotingServlet
 */
@WebServlet("/VotingServlet")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/voting.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VotingDAO dao = new VotingDAO();
		String eN = ElectionMasterControl.getElecName();
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("1")){
			System.out.println("Launch us to vote for 1");
			int vote1= dao.getVote(1, eN);
			System.out.println(vote1);
			vote1 += 1;
			System.out.println(vote1);
			dao.updateElection(1,vote1,eN);
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
			
		}
		else if (actionToPerform.equals("2")){
			int vote2= dao.getVote(2, eN);
			vote2 += 1;
			dao.updateElection(2,vote2,eN);
			System.out.println("Launch us to vote for 2");
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
			
		} 	else if (actionToPerform.equals("3")){
			System.out.println("Launch us to vote for 3");
			int vote3= dao.getVote(3, eN);
			vote3 += 1;
			dao.updateElection(3,vote3,eN);
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
