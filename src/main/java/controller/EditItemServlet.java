package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Phone;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
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
		PhoneHelper ph =  new PhoneHelper();
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String date = request.getParameter("releaseDate");
		
		String year = date.substring(0, 4);
		String month = date.substring(date.indexOf('-') + 1, date.lastIndexOf('-'));
		String day = date.substring(date.lastIndexOf('-') + 1);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Phone phoneToUpdate = ph.searchForItemById(tempId);
		phoneToUpdate.setName(name);
		phoneToUpdate.setColor(color);
		phoneToUpdate.setReleaseDate(ld);
		
		ph.updateItem(phoneToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
