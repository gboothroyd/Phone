package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Details;
import model.Phone;
import model.ServiceProvider;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PhoneHelper ph = new PhoneHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String providerName = request.getParameter("providerName");
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		
		List<Phone> selectedItemsInList = new ArrayList<Phone>();
		
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) 
		{
		for(int i = 0; i < selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		Phone p = ph.searchForItemById(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(p);
		}
		}
		ServiceProvider provider = new ServiceProvider(providerName);
		Details pld = new Details(listName, provider);
		pld.setListOfPhones(selectedItemsInList);
		DetailsHelper plh = new DetailsHelper();
		plh.insertNewListDetails(pld);
		System.out.println("Success!");
		System.out.println(pld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
