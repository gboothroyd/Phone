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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		PhoneHelper ph = new PhoneHelper();
		ServiceProviderHelper sph = new ServiceProviderHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Details listToUpdate = dh.searchForListById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String providerName = request.getParameter("providerName");
		String providerYearEstablished = request.getParameter("providerYearEstablished");
		ServiceProvider newServiceProvider = sph.findServiceProvider(providerName);
		newServiceProvider.setYearEstablished(Integer.parseInt(providerYearEstablished));
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Phone> selectedPhonesInList = new ArrayList<Phone>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Phone c = ph.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedPhonesInList.add(c);
			}
			listToUpdate.setListOfPhones(selectedPhonesInList);
		} catch (NullPointerException ex) {
			List<Phone> selectedItemsInList = new ArrayList<Phone>();
			listToUpdate.setListOfPhones(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setProvider(newServiceProvider);
		
		dh.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
