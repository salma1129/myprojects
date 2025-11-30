<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Engine Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f3f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background: white;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            text-align: center;
            width: 350px;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            color: #34495e;
        }

        input[type="text"] {
            width: 90%;
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
            margin-top: 8px;
            margin-bottom: 20px;
        }

        .radio-group {
            margin-bottom: 20px;
        }

        input[type="radio"] {
            margin: 0 6px 0 15px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<form action="hello-servlet" method="get">
    <h2>Search Engine Selector</h2>

    <label for="keywords">Keywords:</label><br>
    <input type="text" id="keywords" name="keywords" required><br>

    <div class="radio-group">
        <input type="radio" id="google" name="searchEngine" value="Google" >
        <label for="google">Google</label>

        <input type="radio" id="bing" name="searchEngine" value="Bing">
        <label for="bing">Bing</label>

        <input type="radio" id="ask" name="searchEngine" value="ASK">
        <label for="ask">ASK</label>
    </div>

    <input type="submit" value="Search">
</form>
</body>
</html>