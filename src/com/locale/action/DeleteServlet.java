package com.locale.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.locale.service.DeleteService;

/**
 * Servlet implementation class DeleteService
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet()
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
	    DeleteService deleteService = new DeleteService();
	    deleteService.Delete(id);
	    response.getWriter().write("Done");
	} catch (Exception e)
	{
	    response.getWriter().write("Fail");
	}

    }

}
