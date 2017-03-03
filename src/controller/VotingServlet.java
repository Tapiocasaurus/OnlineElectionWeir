package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String actionToPerform = request.getParameter("doThisToItem");
		if(actionToPerform.equals("cand1")){
			System.out.println("Launch us to vote");
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
		}
		else if (actionToPerform.equals("cand2")){
			System.out.println("Launch us to vote");
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
		} 	else if (actionToPerform.equals("cand3")){
			System.out.println("Launch us to vote");
			getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
