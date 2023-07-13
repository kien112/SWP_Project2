<%-- 
    Document   : addNewUser
    Created on : Jun 26, 2023, 8:54:14 AM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./CSS/userStyle.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div style="border: 1px solid black; width: fit-content; text-align: center; margin: auto;
             margin-bottom: 35px; padding: 5px; margin-top: 90px; font-size: 20px; ">
            <h1>Add New User</h1>
            <form action="addNewUser" method="post">
                <div class="input-field">
                    <label>Email</label>
                    <input name="email" required="" style="height: 100%;" type="email"/>
                    <p>${message}</p>
                </div>
                <div class="input-field">
                    <label>Password</label>
                    <input name="password" required="" style="height: 100%;" type="password" minlength="6" maxlength="31"/>
                </div>
                <div class="input-field">
                    <label>Full Name</label>
                    <input name="fullname" required="" style="height: 100%;" type="text"/>
                </div>
                <div class="input-field">
                    <label>Gender</label>
                    <select name="gender" style="height: 100%;">
                        <option value="1" selected>Male</option>
                        <option value="0">Female</option>
                    </select>
                </div>
                <div class="input-field">
                    <label>Address</label>
                    <input name="address" required=""  style="height: 100%;"type="text"/>
                </div>
                <div class="input-field">
                    <label>Phone</label>
                    <input name="phone_number" required="" style="height: 100%;" type="number" minlength="10" maxlength="11"/>
                </div>
                
                <button type="submit">Add New</button>
                <a href="userList">Back to user list</a>
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
