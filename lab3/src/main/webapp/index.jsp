<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #fafafa;
            padding: 40px;
            text-align: center;
        }

        h2 {
            color: #222;
        }

        .msg {
            color: green;
            font-weight: bold;
            margin-bottom: 20px;
            font-size: 18px;
        }

        a {
            display: inline-block;
            margin: 15px;
            padding: 12px 20px;
            background: #0066cc;
            color: white;
            text-decoration: none;
            border-radius: 7px;
            transition: 0.2s;
        }

        a:hover {
            background: #004a99;
        }
    </style>

</head>
<body>

<%
    String msg = request.getParameter("msg");
    if (msg != null) {
%>
<p class="msg"><%= msg %></p>
<% } %>

<h2>Welcome !</h2>

<a href="login.jsp">Connect</a>
<a href="detail">Info Session</a>

</body>
</html>
