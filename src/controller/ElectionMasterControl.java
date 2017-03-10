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
 * Servlet implementation class ElectionMasterControl
 */
@WebServlet("/ElectionMasterControl")
public class ElectionMasterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String elecName;
    public static String getElecName() {
		return elecName;
	}

	public static void setElecName(String elecName) {
		ElectionMasterControl.elecName = elecName;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ElectionMasterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside master controller servlet");
		VotingDAO dao = new VotingDAO();
		String selectName;
		//getServletContext().getRequestDispatcher("/choose-election.jsp").forward(request, response);
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("New Election")){
			System.out.println("Launch us to new election");
			getServletContext().getRequestDispatcher("/new-election.jsp").forward(request, response);
		}
		else if(actionToPerform.equals("Choose Election")){
			System.out.println("Launch us to vote in election");
			int tempId = Integer.parseInt(request.getParameter("id"));
			tempId = tempId + 1;
			System.out.println(tempId);
			selectName = dao.getElection(tempId);
			request.setAttribute("ElectionName", selectName);
			elecName = selectName;
			getServletContext().getRequestDispatcher("/voting.jsp").forward(request, response);
		}
		else if(actionToPerform.equals("Cast Next Vote")){
			System.out.println("Launch us to vote in election");
			request.setAttribute("ElectionName", elecName);
			getServletContext().getRequestDispatcher("/voting.jsp").forward(request, response);
		}
		else if(actionToPerform.equals("Show Results")){
			System.out.println("Launch us to vote in election");
			request.setAttribute("ElectionName", elecName);
			getServletContext().getRequestDispatcher("/election-results.jsp").forward(request, response);
		}
		else if(actionToPerform.equals("OK")){
			System.out.println("Launch us to vote in election");
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
		}
		
		doGet(request, response);

}
}