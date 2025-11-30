package org.horizon.lab3;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/detail")
public class InfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        var out = response.getWriter();

        if (session == null || session.getAttribute("login") == null) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session Required</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; background:#f8d7da; display:flex; ");
            out.println("justify-content:center; align-items:center; height:100vh; margin:0; }");
            out.println(".box { background:white; padding:25px 40px; border-radius:10px;");
            out.println("box-shadow:0 4px 20px rgba(0,0,0,0.1); text-align:center; }");
            out.println("p { color:#b30000; font-size:18px; font-weight:bold; }");
            out.println("a { display:inline-block; margin-top:15px; background:#0066cc;");
            out.println("color:white; padding:10px; text-decoration:none; border-radius:6px; }");
            out.println("a:hover { background:#004a99; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='box'>");
            out.println("<p>You must log in to view this information.</p>");
            out.println("<a href='login.jsp'>Go to Login</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            return;
        }

        String login = (String) session.getAttribute("login");
        Date sessionDate = new Date(session.getCreationTime());
        Date systemDate = new Date();

        long diff = systemDate.getTime() - sessionDate.getTime();
        long seconds = diff / 1000 % 60;
        long minutes = diff / (1000 * 60) % 60;
        long hours = diff / (1000 * 60 * 60);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session Info</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background:#eef2f3; padding:40px; }");
        out.println(".card { background:white; padding:25px 35px; width:450px; margin:auto; ");
        out.println("border-radius:10px; box-shadow:0 4px 20px rgba(0,0,0,0.1); }");
        out.println("h2 { text-align:center; color:#333; }");
        out.println(".info { margin-top:20px; }");
        out.println(".info p { margin:8px 0; font-size:16px; }");
        out.println("a { display:block; margin-top:25px; text-align:center; ");
        out.println("background:#ff4d4d; color:white; padding:10px; border-radius:6px; text-decoration:none; }");
        out.println("a:hover { background:#cc0000; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='card'>");
        out.println("<h2>Session Information</h2>");
        out.println("<div class='info'>");
        out.println("<p><strong>Login:</strong> " + login + "</p>");
        out.println("<p><strong>System Date:</strong> " + systemDate + "</p>");
        out.println("<p><strong>Session Created:</strong> " + sessionDate + "</p>");
        out.println("<p><strong>Session ID:</strong> " + session.getId() + "</p>");
        out.println("<p><strong>Time Elapsed:</strong> "
                + hours + "h " + minutes + "m " + seconds + "s</p>");
        out.println("</div>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

    }
}

