<%-- 
    Document   : updateSetting
    Created on : Jun 26, 2023, 11:26:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./CSS/userStyle.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="text-align: center; border: 1px solid white; padding: 80px; width: 100%; font-size: 20px;">
            <form action="updateSetting" >
                <h1 style="font-size: 60px;">Update Setting</h1>
                <input name="setting_id" value="${s.setting_id}"  hidden=""/>
                <div class="input-field">
                    <label>Type</label>
                    <select name="type" style="height: 100%;">
                        <c:forEach items="${listR}" var="r">
                            <option value="${r.role_id}" ${s.role_name==r.role_name?"selected":""}>${r.role_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-field">
                    <label >Value</label>
                    <input name="value" value="${s.value}"  style="height: 100%;" required="" />
                </div>
                <div class="input-field">
                    <label>Order</label>
                    <input name="order" type="number" value="${s.order}"  style="height: 100%;" required="" />
                </div>
                <div class="input-field">
                    <label style="position: relative; top: -50px;">Description</label>

                    <textarea name="description" style="width: 320px; padding: 40px; padding-left: 10px; padding-top: 5px;" value="${s.description}" required="" >${s.description}</textarea>
                </div>
                <div class="input-field">
                    <label ">Status</label>
                    <select name="status" style="height: 100%;">
                        <option value="0" ${s.status?"":"selected"}>Deactive</option>
                        <option value="1" ${s.status?"selected":""}>Active</option>
                    </select>
                </div>
                <button style="margin: 0px 660px;" type="submit">Update</button>
            </form>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
