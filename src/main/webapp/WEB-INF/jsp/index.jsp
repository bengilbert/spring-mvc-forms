<%@page language="java" session="true"
	contentType="text/html;charset=ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Home</title>
</head>

<body>
	<h1>Hello!</h1>

	<form:form method="POST"  modelAttribute="form">
		<c:forEach items="${form.candidates}" var="candidate" varStatus="status">
			<form:label path="candidates[${status.index}].id">Candidate:</form:label>
			<form:select path="candidates[${status.index}].id" items="${candidates}" itemValue="id" itemLabel="name"></form:select>
		</c:forEach>
		<input type="submit" value="Add candidate"/>
	</form:form>
</body>
</html>
