package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Details;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listNavigationServlet() {
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
		DetailsHelper dh = new DetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Details listToDelete = dh.searchForListById(tempId);
				dh.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId =  Integer.parseInt(request.getParameter("id"));
				Details listToEdit = dh.searchForListById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				PhoneHelper phForItems = new PhoneHelper();
				
				request.setAttribute("allItems", phForItems.showAllItems());
				
				if (phForItems.showAllItems().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
