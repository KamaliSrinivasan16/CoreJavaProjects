<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Product ID:</th>
			<th>Product name:</th>
			<td>Price:</td>
		</tr>
		<tr>
            
            <td><%=session.getAttribute("id") %></td>
            <td><%=session.getAttribute("name") %></td>
            <td><%=session.getAttribute("price") %></td>
            
         </tr> 
	</table>
</body>
</html>