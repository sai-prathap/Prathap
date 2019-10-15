package com.virtusa.transpostsystem;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.cabdao.CabDaoimpl;
import com.virtusa.cabmodel.Cab;

/**
 * Servlet implementation class Addcabservlet
 */
@WebServlet("/Addcabservlet")
public class Addcabservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcabservlet() {
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
		String cab_no = request.getParameter("cabno");
		String name = request.getParameter("drivername");
		String phno = request.getParameter("phno");
		int status = 0;
		Cab c = new Cab(cab_no, name, phno, status);
		CabDaoimpl cab = new CabDaoimpl();
		cab.add(c);
		ServletContext cabs = getServletContext();
		cabs.setAttribute("cab", "cabdetails added");
		response.sendRedirect("admin.jsp");
		System.out.println("cab details added");
	}

}
