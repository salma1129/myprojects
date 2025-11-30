<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .card {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            width: 350px;
            text-align: center;
        }

        h2 {
            margin-bottom: 25px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background: #0066cc;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: 0.2s;
        }

        input[type="submit"]:hover {
            background: #004a99;
        }

        .error {
            color: #cc0000;
            margin-bottom: 15px;
            font-weight: bold;
        }
    </style>

</head>
<body>

<div class="card">
    <h2>Login</h2>

    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
    <p class="error"><%= error %></p>
    <% } %>

    <form action="verif" method="post">
        <input type="text" name="login" placeholder="Enter login" required />
        <input type="password" name="password" placeholder="Enter password" required />
        <input type="submit" value="Validate" />
    </form>
</div>

</body>
</html>
