<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.horizon.ex3.Product, org.horizon.ex3.ProductList" %>
<%
    String name = request.getParameter("name");
    String quantityStr = request.getParameter("quantity");
    Product product = null;
    int quantity = 0;
    double totalTTC = 0.0;

    if (name != null && quantityStr != null) {
        quantity = Integer.parseInt(quantityStr);
        ProductList list = new ProductList();
        product = list.findByName(name);

        if (product != null) {
            totalTTC = quantity * product.getPriceExcludingTax() * (1 + product.getVat());
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Order</title>
</head>
<body>
<h2>Calculate Total Amount (TTC)</h2>

<form action="index.jsp" method="post">
    <label>Product Name:</label>
    <input type="text" name="name" required><br><br>

    <label>Quantity:</label>
    <input type="number" name="quantity" min="1" required><br><br>

    <input type="submit" value="Calculate">
</form>

<hr>

<% if (name != null) { %>
<% if (product != null) { %>
<h2>Product: <%= product.getName() %></h2>
<p>Price (HT): <%= product.getPriceExcludingTax() %> TND</p>
<p>VAT: <%= product.getVat() * 100 %>%</p>
<p>Quantity: <%= quantity %></p>
<h3>Total Amount (TTC): <%= String.format("%.2f", totalTTC) %> TND</h3>
<% } else { %>
<h3 style="color:red;">Product not found!</h3>
<% } %>
<% } %>
</body>
</html>
