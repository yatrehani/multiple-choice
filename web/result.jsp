<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype") %>

<html>
    <head>
        <title>Survey Results</title>           
    </head>
    <body>
        <h3>Distributed Systems Class Clicker</h3>
        <p>The results from the survey are as follows</p>
        <%= request.getAttribute("results")%>
        <p>These results have now been cleared</p>
    </body>
</html>

