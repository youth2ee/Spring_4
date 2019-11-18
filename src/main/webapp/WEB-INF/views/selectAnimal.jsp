<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:choose>
	<c:when test="${animal eq 'dog'}">
		<select>
			<option>치와와</option>
			<option>푸들</option>
			<option>말티즈</option>
		</select>
	</c:when>

	<c:when test="${animal eq 'cat'}">
		<select>
			<option>고양이1</option>
			<option>고양이2</option>
			<option>고양이3</option>
		</select>	
	</c:when>

	<c:otherwise>
		<select>
			<option>새1</option>
			<option>새2</option>
			<option>새3</option>
		</select>
	</c:otherwise>

</c:choose> --%>

<select>
	<c:forEach items="${kind}" var = "k">
		<option>${k}</option>
	</c:forEach>
</select>