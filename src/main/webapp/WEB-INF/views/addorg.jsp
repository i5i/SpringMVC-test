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
        <title>Asutus</title>
    </head>
    <body>
    <a href="${pageContext.request.contextPath}/0">HOME</a>
        <div align="center">
	<form:form method="POST" modelAttribute="Org" action="add">
	<table>
	<tbody>
	    <tr>
	        <td>Nimi:</td>
	        <td><form:input path="name" data-validation="length"  data-validation-length="2-20" data-validation-error-msg="Nimes peab olema 2 kuni 20 tähte"></form:input></td>
	        </tr>
    	    <tr>
	        <td>Tüüp:</td>
	        <td><form:input path="type" data-validation="length" data-validation-length="2-20" data-validation-error-msg="Tüüp peab olema 2 kuni 20 tähte"></form:input></td>       
            </tr>
            <tr>
	        <td>Asukoht:</td>
	        <td><form:input path="location" data-validation="length" data-validation-length="2-20" data-validation-error-msg="Asukoht peab olema 2 kuni 20 tähte"></form:input></td>       
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
        </div>
    </body>
</html>
