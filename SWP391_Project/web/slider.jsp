<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./CSS/slider.css" rel="stylesheet" type="text/css"/>       
    </head>
    <body>
        <!-- NOTE: None of the included images are mine and I take no credit for them!! -->
        <ul id="body" >           
            <c:forEach items="${requestScope.sliders}" var="s" varStatus="loop">
            <input type="radio" name="radio-btn" id="img-${s.id}" checked />
            <li id="img-container">
                <div id="img-fluid">
                    <a href="<%=request.getContextPath()%>/sliderDetail?id=${s.id}"><img src="${s.image}"></a>
                </div>
                <label for="img-${s.id-1}" class="sb-bignav" title="Previous">&#x2039;</label>
                <label for="img-${s.id+1}" class="sb-bignav" title="Next">&#x203a;</label>
            </li>    
            </c:forEach>            
        </ul>
    </body>
</html>