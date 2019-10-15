package com.virtusa.transpostsystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.cabdao.CabDaoimpl;
import com.virtusa.userbooking.model.UserBooking;
import com.virtusa.userbookingdao.UserBookingDaoImp;

/**
 * Servlet implementation class AllocateServlet
 */
@WebServlet("/AllocateServlet")
public class AllocateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		if(status.equals("accept")) {
			String cabid = request.getParameter("cabid");
			
			String emp = request.getParameter("empid");
			int empid = Integer.valueOf(emp.trim());
			String source = request.getParameter("source");
			String dest = request.getParameter("destination");
			String time = request.getParameter("time");
			UserBooking u = new UserBooking(empid,source, dest, time, status, cabid);
			UserBookingDaoImp user = new UserBookingDaoImp();
			CabDaoimpl cab = new CabDaoimpl();
			user.update(empid,status,cabid);
			cab.update(cabid);
			response.sendRedirect("allocate.jsp");
			
		}
		else {
			String cabid = "rejected";
			String emp = request.getParameter("empid");
			int empid = Integer.valueOf(emp.trim());
			UserBookingDaoImp user = new UserBookingDaoImp();
			user.update(empid,status,cabid);
			response.sendRedirect("allocate.jsp");
		}
		
	}

}
