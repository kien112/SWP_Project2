<%-- 
    Document   : AddNewSetting
    Created on : Jun 26, 2023, 4:00:26 PM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Learning</title>
        <link rel="stylesheet" href="./CSS/userStyle.css"/>
    </head>
    <body>
         <jsp:include page="header.jsp"/>
         <div style="border: 1px solid white; width: fit-content; text-align: center; margin: auto; margin-bottom: 115px; padding: 5px; margin-top: 90px; font-size: 20px;">

        <h1>Add New Setting</h1>
        <form action="addNewSetting" method="post" style="width: 100%">
            <div class="input-field">
                <label>Setting Name</label>
                <input name="setting_name"  style="height: 100%;" required=""/>
            </div>
            <div class="input-field">
                <label>Type</label>
                <select name="type"  style="height: 100%;">
                    <c:forEach items="${listR}" var="r">
                        <option value="${r.role_id}">${r.role_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-field">
                <label>Value</label>
                <input name="value"  style="height: 100%;" required="" />
            </div>
            <div class="input-field">
                <label>Order</label>
                <input name="order"  style="height: 100%;" type="number" required="" />
            </div>
            <div class="input-field">
                <label style="position: relative; top: -50px">Description</label>
                <textarea name="description" style="padding: 40px; width: 330px" required="" ></textarea>
            </div>
            <div class="input-field">
                <label>Status</label>
                <select name="status"  style="height: 100%;">
                    <option value="1">Active</option>
                    <option value="0">InActive</option>
                </select>
            </div>
            <button style="margin: 0px 780px;" type="submit">Add New</button>
        </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
