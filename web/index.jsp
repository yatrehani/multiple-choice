<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<%= request.getAttribute("doctype") %>-->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DS Clicker</title>
    </head>

    <body>
        <h3>Distributed Systems Class Clicker</h3>
        <p>Submit your answer to the current question</p>
        <form action="submit" method="post">
            <input type="radio" name="answer" value="A">A<br>
            <input type="radio" name="answer" value="B">B<br>
            <input type="radio" name="answer" value="C">C<br>
            <input type="radio" name="answer" value="D">D<br><p>
            <input type="submit" value="submit"></p>
        </form>
    </body>
</html>

