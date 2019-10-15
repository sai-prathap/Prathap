package com.virtusa.transpostsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.cabdao.CabDaoimpl;
import com.virtusa.cabmodel.Cab;
import com.virtusa.employeedao.EmployeeImpl;
import com.virtusa.model.Employee;
import com.virtusa.userbooking.model.UserBooking;
import com.virtusa.userbookingdao.UserBookingDaoImp;

/**
 * Servlet implementation class adminaction
 */
@WebServlet("/adminaction")
public class adminaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeImpl add = new EmployeeImpl();
	CabDaoimpl c = new CabDaoimpl();
	UserBookingDaoImp user = new UserBookingDaoImp();
	List<Employee> empList = null;
	List<Cab> cablist= null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		System.out.println(option);
		if(option.equals("add")) {
			request.setAttribute("option", option);
			request.getRequestDispatcher("/admin.jsp?option="+option).forward(request, response);
		}
		else if(option.equals("view"))
		{
			
			 empList = add.findAll(); 
			request.setAttribute("posts", empList);
			request.getRequestDispatcher("viewemp.jsp").forward(request, response);
		}
		else if(option.equals("delete")) {
			 empList = add.findAll();
			request.setAttribute("posts", empList);
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}
		else if(option.equals("assign"))
		{
			List<UserBooking> userData = user.findAll();
			
			for(UserBooking u:userData) {
				System.out.println(u.getSource());
			}
			request.setAttribute("status", userData);
			request.getRequestDispatcher("allocate.jsp").forward(request, response);
		}
		else if(option.equals("cab"))
		{
			request.setAttribute("option", option);
			request.getRequestDispatcher("addcab.jsp").forward(request, response);
		}
		else if(option.equals("viewcab")) {
			cablist = c.findAll(); 
			request.setAttribute("cab", cablist);
			request.getRequestDispatcher("viewcab.jsp").forward(request, response);

		}
	}


}
