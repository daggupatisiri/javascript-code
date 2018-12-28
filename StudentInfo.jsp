<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager users</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <div>
            <form action="StudentServlet" method="POST">
                <table>
                    <tr>
                        <td> Id</td>
                        <td><input type="text" name="Id" value="${student.Id}"</td>
                    </tr>
                    <tr>
                        <td> Name</td>
                        <td><input type="text" name="Name" value="${student.Name}"</td>
                    </tr>
                    <tr>
                        <td> Email </td>
                        <td><input type="text" name="email" value="${student.email}"</td>
                    </tr>
                    
                    <tr>
                        <td> Class </td>
                        <td><input type="text" name="class" value="${student.class}"</td>
                    </tr>
                    <tr>
                        <td> Year </td>
                        <td><input type="text" name="year" value="${student.year}"</td>
                    </tr>
                    <tr>
                        <td> City </td>
                        <td><input type="text" name="city" value="${student.city}"</td>
                    </tr>
                    <tr>
                        <td> Country </td>
                        <td><input type="text" name="country" value="${student.country}"</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="action" value="Display"/>
                            <input type="submit" name="action" value="Add"/>
                            <input type="submit" name="action" value="Edit"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
                    <br/>
                    <div>
                        <table border="1">
                            <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Class</th>
                            <th>Year</th>
                            <th>City</th>
                            <th>Country</th>
                            </tr>
                            <c:forEach items="${requestScope.allStudent}" var="stud">
                            <tr>
                                <td>${stud.Id}</td>
                                <td>${stud.Name}</td>
                                <td>${stud.Email}</td>
                                <td>${stud.Class}</td>
                                <td>${stud.year}</td>
                                <td>${stud.City}</td>
                                <td>${stud.Country}</td>
                                
                            </tr>
                            </c:forEach>
                        </table> 
                    </div>
    </body>
</html>
