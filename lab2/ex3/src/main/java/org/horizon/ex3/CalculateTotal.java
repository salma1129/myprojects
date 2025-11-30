package org.horizon.ex3;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import org.horizon.ex3.ProductList;

@WebServlet(name = "CalculateTotalServlet", value = "/CalculateTotal")
public class CalculateTotal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductList list = new ProductList();
        Product product = list.findByName(name);

        // Set attributes for JSP
        request.setAttribute("product", product);
        request.setAttribute("quantity", quantity);
        if (product != null) {
            double totalTTC = quantity * product.getPriceExcludingTax() * (1 + product.getVat());
            request.setAttribute("totalTTC", totalTTC);
        }

        // Forward to result JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
