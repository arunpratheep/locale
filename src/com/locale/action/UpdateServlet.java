package com.locale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.locale.model.UserData;
import com.locale.service.UpdateService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet()
    {
	super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	try
	{

	    Long id = Long.parseLong(request.getParameter("id"));
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String houseName = request.getParameter("houseName");
	    String fatherName = request.getParameter("fatherName");
	    String motherName = request.getParameter("motherName");
	    Long mobile = Long.parseLong(request.getParameter("mobile"));
	    UserData userData = new UserData(firstName, lastName, houseName, fatherName, motherName, mobile);
	    UpdateService updateService = new UpdateService();
	    updateService.Update(id,userData);
	    response.getWriter().write("Done");
	} catch (Exception e)
	{
	    response.getWriter().write("Fail");
	}

    }

}
