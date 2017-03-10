package controller;




import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VoteTally;
import model.VotingDAO;
import model.VotingMachine; 

/**
 * Servlet implementation class ChooseElectionServlet
 */
@WebServlet("/ChooseElectionServlet")
public class ChooseElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VotingDAO dao = new VotingDAO();
		//dao.makeConnection();
		System.out.println(dao.getAllItems());
		request.setAttribute("AllItems", dao.getAllItems());
		getServletContext().getRequestDispatcher("/choose-election.jsp").forward(request, response);
		System.out.println("Leaving choose election");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
