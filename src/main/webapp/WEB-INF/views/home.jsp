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
        <title>Home</title>
    </head>
    <body>
         <div align="right">
            <form:form method="POST" commandName="pager" action="${pageContext.request.contextPath}/${pager.type}/0">
            <input type="hidden" name="sortby" value="${pager.sortby}"/>
            <input type="hidden" name="asc" value="${pager.asc}"/>
	        <input type="hidden" name="page" value="0"/>
	        Otsi:
            <form:input path="search"></form:input>
            <input value="Otsi" type="submit">
	        </form:form>
        </div>
        <div style="float:left;padding-top:100px;">
        <div style="background-color:Gainsboro;" border="1">
        <a href="${pageContext.request.contextPath}/0">HOME</a> <br>
        <a <c:if test="${pager.type=='tyyp'}"> style="background-color:#ffff99;"</c:if>href="${pageContext.request.contextPath}/tyyp/0">tyyp</a><br>
        <a <c:if test="${pager.type=='söögikoht'}"> style="background-color:#ffff99;"</c:if>href="${pageContext.request.contextPath}/söögikoht/0">söögikohad</a><br>     
        <a <c:if test="${pager.type=='remonditöökoda'}"> style="background-color:#ffff99;"</c:if>href="${pageContext.request.contextPath}/remonditöökoda/0">remonditöökojad</a><br>
        <a <c:if test="${pager.type=='kino'}"> style="background-color:#ffff99;"</c:if>href="${pageContext.request.contextPath}/kino/0">kinod</a><br>
        <a <c:if test="${pager.type=='jne'}"> style="background-color:#ffff99;"</c:if>href="${pageContext.request.contextPath}/jne/0">jne.</a>
        </div>
        </div>
        <div align="center">
	            <h1>Asutuste Hindamine</h1>
        	    <table border="1" class="OrgTable">
	        	<c:forEach var="head" items="${pager.sortable}" varStatus="loop">
	        	<th style="width:190px;"><div style="float:left; padding-left:5px; padding-top:20px;">${pager.headers[loop.count-1]}</div><div align="right">
	        	    <form:form method="POST" commandName="pager" >
	        		<input type="hidden" name="search" value="${pager.search}"/>
	                <input type="hidden" name="pager" value="${pager.page}"/>
              	    <input type="hidden" name="sortby" value="${head}"/>
                	<input type="hidden" name="asc" value="true"/>
                	<form:button type="submit" class="asc">&#8657;</form:button></form:form>
                	
	            	<form:form method="POST" commandName="pager">
	        		<input type="hidden" name="search" value="${pager.search}"/>
	        		
               		<input type="hidden" name="sortby" value="${head}"/>
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
	        	</tr>
	        	</c:if>
	        	</c:forEach>   	
        	</table><div >
        	<c:if test="${pager.page!=0}"> 
        	        <form:form method="POST" commandName="pager" style="display:inline-block;">
        	        <input type="hidden" name="search" value="${pager.search}"/>
	                <input type="hidden" name="page" value="${pager.page-1}"/>
	               <input type="hidden" name="sortby" value="${pager.sortby}"/>
                	<input type="hidden" name="asc" value="${pager.asc}"/>
                	<form:button type="submit"><<</form:button></form:form>
        	</c:if>
        	${pager.page+1} / ${pager.maxpage}
        	<c:if test="${pager.page != pager.maxpage-1 }"> 
            	    <form:form method="POST" commandName="pager" style="display:inline-block;">
            	    <input type="hidden" name="sortby" value="${pager.sortby}"/>
                	<input type="hidden" name="asc" value="${pager.asc}"/>
	                <input type="hidden" name="page" value="${pager.page+1}"/>
                	<form:button type="submit">>></form:button></form:form></c:if></div>
            </div>
    <script>
    $(document).ready(function () {
        $(".entry").click(function () {
            window.location.href = $(this).data('url');
        });
    })
    </script> 
    </body>
</html>
