<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>comment</title>
    </head>
    <body>
    <a href="${pageContext.request.contextPath}/0">HOME</a>
    <a href="${pageContext.request.contextPath}/admin/0">ADMIN</a>
        <div align="center">
	        <h1>Halda kommentaare</h1>
        	<table border="1">
        	    <th>Nimi</th>
        	    <th></th>
        	    <th>Kommentaar</th>
        	    <th>Hinne</th>
        	    <th>Kustuta</th>
				<c:forEach var="Rev" items="${comList}" varStatus="status">
	        	<tr>
					<td>${Rev.name}<td> 
					<td>${Rev.com}</td>
					<td>${Rev.rate}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/delrev/${Rev.id}/${Oid}">&#10006;</a></td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
