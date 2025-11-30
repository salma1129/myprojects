<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .calculator-form {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            width: 300px;
        }
        .calculator-form h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .calculator-form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        .calculator-form input[type="number"] {
            width: 100%;
            padding: 8px 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .calculator-form input[type="radio"] {
            margin-right: 10px;
        }
        .calculator-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .calculator-form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/calcul-servlet" method="post" class="calculator-form">
    <h2>Simple Calculator</h2>

    <label>First number:</label>
    <input type="number" name="a" required>

    <label>Second number:</label>
    <input type="number" name="b" required>

    <label>Operation:</label><br>
    <input type="radio" name="operation" value="add" required> Addition<br>
    <input type="radio" name="operation" value="sub"> Subtraction<br>
    <input type="radio" name="operation" value="mul"> Multiplication<br>
    <input type="radio" name="operation" value="div"> Division<br><br>

    <input type="submit" value="Calculate">
</form>

</body>
</html>
