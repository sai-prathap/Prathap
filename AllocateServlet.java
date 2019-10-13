package com.virtusa.transpostsystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String cabid = request.getParameter("cabid");
		String emp = request.getParameter("empid");
		int empid = Integer.valueOf(emp);
		String source = request.getParameter("source");
		String dest = request.getParameter("destination");
		String time = request.getParameter("time");
		UserBooking u = new UserBooking(empid,source, dest, time, status, cabid);
		UserBookingDaoImp user = new UserBookingDaoImp();
		user.update(u);
		
	}

}
