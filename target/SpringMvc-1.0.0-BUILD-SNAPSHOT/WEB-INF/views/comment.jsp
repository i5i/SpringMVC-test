<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>comment</title>
    </head>
    <body>
    <a href="${pageContext.request.contextPath}/0">HOME</a>
        <div align="center">
	        <h1>Hinda</h1>
	<form:form method="POST" modelAttribute="Review" action="add/${Oid}">
	<table>
	<tbody>
	    <tr>
	        <td>Nimi:</td>
	        <td><form:input path="name" data-validation="length" data-validation-length="2-10" data-validation-error-msg="Nimes peab olema 2 kuni 10 tähte"></form:input></td>
	    </tr>
	    <tr>
	        <td>Hinnang:</td><td>
	        <form:radiobutton name="rating" class="required" path="rate" value="1"/>1 
	        <form:radiobutton name="rating" path="rate" value="2"/>2 
	        <form:radiobutton name="rating" path="rate" value="3"/>3 
	        <form:radiobutton name="rating" path="rate" value="4"/>4 
	        <form:radiobutton name="rating" path="rate" value="5" checked="checked"/>5 
	        <form:radiobutton name="rating" path="rate" value="6"/>6 
	        <form:radiobutton name="rating" path="rate" value="7"/>7 
	        <form:radiobutton name="rating" path="rate" value="8"/>8 
	        <form:radiobutton name="rating" path="rate" value="9"/>9 
	        <form:radiobutton name="rating" path="rate" value="10"/>10 
</td>
    </tr>
    	    <tr>
	        <td>Kommentaar:</td>
	        <td><form:textarea style="height:100px; width:400px;" path="com" data-validation="length" data-validation-length="4-255" data-validation-error-msg="*Kommentaar 4-255 tähte"></form:textarea></td>
    </tr> 

	    <tr>
	        <td><input  value="Lisa" type="submit"></td>
	        <td></td>
	    </tr>
	</tbody>
	</table>

	</form:form>
<script> $.validate();

</script>
        	<table border="1">
	        	<th>Nimi</th>
	        	<th>kommentaar</th>
	        	<th>hinne</th>

	        	
				<c:forEach var="Rev" items="${comList}" varStatus="status">
	        	<tr>

					<td>${Rev.name}</td>
					<td>${Rev.com}</td>
					<td>${Rev.rate}</td>

	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
