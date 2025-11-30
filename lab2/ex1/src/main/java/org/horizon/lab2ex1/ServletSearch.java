package org.horizon.lab2ex1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="HelloServlet" , value="/hello-servlet")
public class ServletSearch extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keywords = request.getParameter("keywords");
        String searchEngine = request.getParameter("searchEngine");

        if (searchEngine.equals("Google")) {
            response.sendRedirect("https://www.google.com/search?q=" + keywords);
        } else if (searchEngine.equals("Bing")) {
            response.sendRedirect("https://www.bing.com/search?q=" + keywords);
        } else if (searchEngine.equals("ASK")) {
            response.sendRedirect("https://fr.ask.com/web?q=" + keywords);
        }
    }
}