<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style style="text/css">
        .entry:hover {background-color:#ffff99; cursor:pointer;}
        </style>
        <title>Admin</title>
    </head>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    
		<h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>  
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		<a href="${pageContext.request.contextPath}/admin/addform">Lisa Aukoht</a>
    <body>
         <div align="right">
            <form:form method="POST" commandName="pager" action="${pageContext.request.contextPath}/admin/0">
            <input type="hidden" name="sortby" value="${pager.sortby}"/>
            <input type="hidden" name="asc" value="${pager.asc}"/>
	        <input type="hidden" name="page" value="0"/>
	        Otsi:
            <form:input path="search"></form:input>
            <input value="Otsi" type="submit">
	        </form:form>
        </div>

        <div align="center">
	            <h1>Asutuste Haldamine</h1>
        	    <table border="1" class="OrgTable">
	        	<c:forEach var="head" items="${pager.sortable}" varStatus="loop">
	        	<th style="width:190px;"><div style="float:left; padding-left:5px; padding-top:20px;">${pager.headers[loop.count-1]}</div><div align="right">
	        	    <form:form method="POST" commandName="pager" >
	        		<input type="hidden" name="search" value="${pager.search}"/>
              	    <input type="hidden" name="sortby" value="${head}"/>
              	    <input type="hidden" name="page" value="${pager.page}"/>
                	<input type="hidden" name="asc" value="true"/>
                	<form:button type="submit" class="asc">&#8657;</form:button></form:form>
                	
	            	<form:form method="POST" commandName="pager">
	        		<input type="hidden" name="search" value="${pager.search}"/>
               		<input type="hidden" name="sortby" value="${head}"/>
               		<input type="hidden" name="page" value="${pager.page}"/>
                	<input type="hidden" name="asc" value="false"/>
                	<form:button type="submit" class="desc">&#8659;</form:button>
	            	</form:form> </div>
	            </th>
	        	</c:forEach>
	            <c:forEach begin="1" end="10" varStatus="status">
	        	<c:if test="${userList[(pager.page*10)+(status.count-1)].id>0}">
	        	<tr class="entry" data-url="comment/${userList[(pager.page*10)+(status.count-1)].id}">
					<td>${userList[(pager.page*10)+(status.count-1)].name}</td>
					<td>${userList[(pager.page*10)+(status.count-1)].type}</td>
					<td>${userList[(pager.page*10)+(status.count-1)].location}</td>
					<td>${userList[(pager.page*10)+(status.count-1)].average}</td>
					<td>${userList[(pager.page*10)+(status.count-1)].count}</td>
					<td><a href="${pageContext.request.contextPath}/admin/del/${userList[(pager.page*10)+(status.count-1)].id}">kustuta</a>  <a href="${pageContext.request.contextPath}/admin/editform/${userList[(pager.page*10)+(status.count-1)].id}">muuda</a> <td>
	        	</tr>
	        	</c:if>
	        	</c:forEach>   	
        	</table>
        	        	<c:if test="${pager.page!=0}"> 
        	        <form:form method="POST" commandName="pager" >
        	        <input type="hidden" name="search" value="${pager.search}"/>
	                <input type="hidden" name="page" value="${pager.page-1}"/>
	               <input type="hidden" name="sortby" value="${pager.sortby}"/>
                	<input type="hidden" name="asc" value="${pager.asc}"/>
                	<form:button type="submit"><<</form:button></form:form>
        	</c:if>
        	<c:if test="${pager.page != pager.maxpage-1 }"> 
            	    <form:form method="POST" commandName="pager" >
            	    <input type="hidden" name="sortby" value="${pager.sortby}"/>
                	<input type="hidden" name="asc" value="${pager.asc}"/>
	                <input type="hidden" name="page" value="${pager.page+1}"/>
                	<form:button type="submit">>></form:button></form:form></c:if>
                	${pager.page} 
        </div>
    <script>
    $(document).ready(function () {
        $(".entry").click(function () {
            window.location.href = $(this).data('url');
        });
    })
    </script>  
	
    </body>
    	</c:if>
</html>
