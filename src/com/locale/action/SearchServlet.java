package com.locale.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.locale.model.UserData;
import com.locale.service.SearchServie;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet()
    {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String function = request.getParameter("func");
	if (function.equals("name"))
	{

	    try
	    {

		String name = request.getParameter("firstName");
		SearchServie searchService = new SearchServie();
		List<UserData> users = searchService.Search(name);
		String json = new Gson().toJson(users);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	    } catch (Exception e)
	    {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Fail");
	    }
	} else
	{
	    try
	    {

		String name = request.getParameter("houseName");
		System.out.println(name);
		SearchServie searchService = new SearchServie();
		List<UserData> users = searchService.SearchHouse(name);
		String json = new Gson().toJson(users);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	    } catch (Exception e)
	    {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Fail");
	    }
	}
    }

}
