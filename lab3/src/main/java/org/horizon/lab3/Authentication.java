package org.horizon.lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/verif")
public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String pwd = request.getParameter("password");

        if ("guest".equals(login) && "horizon2024".equals(pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            response.sendRedirect("index.jsp?msg=Authentication successful !");
        } else {
            response.sendRedirect("login.jsp?error=Invalid login or password.");
        }
    }
}

