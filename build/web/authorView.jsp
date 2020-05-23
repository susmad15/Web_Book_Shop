<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : authorView
    Created on : 22.05.2020, 15:22:17
    Author     : markus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Book Shop</title>
        
        <link rel="stylesheet" href="stylesheet.css">
    </head>
    <body>
        <h1>Web Book Shop</h1>

        Search for an Author: <input type="text" id="authorInput"name="authorInput" size="10" onkeydown="loadFillteredAuthors(event)" />
        
        <br>
        <br>

        <form method="GET">

            <select id="authorSelect" name="authorSelect" size="30" style="margin-right: 50px" onclick="loadBookDetails()" >

                <c:forEach var="author" items="${authors}">
                    <option>${author}</option>
                </c:forEach>

            </select>
            
            <select id="bookSelect" size="30">
                
            </select>

        </form>
        
        <script type="text/javascript" src="books.js"></script>
        <script type="text/javascript">
            
            var books = new Books();
            
            const loadFillteredAuthors = (evt) => {
                books.getFillteredAuthors(evt);
            };
            
            const loadBookDetails = () => {
                books.showBookData();
            };
            
        </script>
    </body>
</html>
