<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<%= request.getAttribute("doctype") %>-->

<html>
    <head>
        <title>DS Clicker</title>           
    </head>
    <body>
        <h3>Distributed Systems Class Clicker</h3>
        <p>Your response  <%= request.getParameter("answer")%> has been registered</p>
        <p>Submit your answer to the next question</p>
        <form action="submit" method="post">
            <input type="radio" name="answer" value="A">A<br>
            <input type="radio" name="answer" value="B">B<br>
            <input type="radio" name="answer" value="C">C<br>
            <input type="radio" name="answer" value="D">D<br><p>
            <input type="submit" value="submit"></p>
        </form>
    </body>
</html>
