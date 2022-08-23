<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search a User</title>
</head>
<body>
<fm:form action="searchingEmp" method="get" modelAttribute="emp">
Enter User Id:<input type="number" name="id">
<input type="submit" name="search">

</fm:form>
</body>
</html>