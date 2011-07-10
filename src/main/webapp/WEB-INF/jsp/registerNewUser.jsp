<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>Register new user</title>
</head>

<body>
	<h1>Register a new user</h1>

	<form:form method="POST" modelAttribute="alternativeName">
		<form:label path="name">Name:</form:label>
		<form:input path="name" />

		<input type="submit" value="Register" />
	</form:form>
</body>

</html>
