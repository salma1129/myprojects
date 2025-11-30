package org.horizon.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculServlet", value = "/calcul-servlet")
public class CalculServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta charset='UTF-8'><title>Calculation Result</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
            out.println(".calculator-form { background-color: #fff; padding: 30px 40px; border-radius: 10px; box-shadow: 0 5px 15px rgba(0,0,0,0.2); width: 300px; text-align: center; }");
            out.println("h2 { color: #333; margin-bottom: 20px; }");
            out.println("p { font-size: 20px; color: #222; margin-bottom: 20px; }");
            out.println("a { text-decoration: none; color: #fff; background-color: #4CAF50; padding: 8px 15px; border-radius: 5px; }");
            out.println("a:hover { background-color: #45a049; }");
            out.println("</style></head><body>");
            out.println("<div class='calculator-form'>");

            try {
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                String operation = request.getParameter("operation");

                Calcul calcul = new Calcul();
                calcul.setA(a);
                calcul.setB(b);

                double result;
                String opSymbol;

                switch (operation) {
                    case "add":
                        result = calcul.addition();
                        opSymbol = "+";
                        break;
                    case "sub":
                        result = calcul.subtraction();
                        opSymbol = "-";
                        break;
                    case "mul":
                        result = calcul.multiplication();
                        opSymbol = "*";
                        break;
                    case "div":
                        result = calcul.division();
                        opSymbol = "/";
                        break;
                    default:
                        out.println("<h2>Invalid operation!</h2>");
                        out.println("<a href='index.jsp'>Back</a>");
                        out.println("</div></body></html>");
                        return;
                }

                out.println("<h2>Calculation Result</h2>");
                out.println("<p>" + a + " " + opSymbol + " " + b + " = <b>" + result + "</b></p>");
                out.println("<a href='index.jsp'>Back</a>");

            } catch (NumberFormatException e) {
                out.println("<h2>Error: Please enter valid integers.</h2>");
                out.println("<a href='index.jsp'>Back</a>");
            } catch (ArithmeticException e) {
                out.println("<h2>Error: " + e.getMessage() + "</h2>");
                out.println("<a href='index.jsp'>Back</a>");
            }

            out.println("</div></body></html>");
        }
    }
}

