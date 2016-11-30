<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title> Tag Example</title>
</head>
<body>

<!--  this is the example for c url and param  *****************PARAM******************-->

<%-- <c:url value="../hw1/Login.jsp" var="loginUrl">
 <c:param name="ID" value="1">
 
 </c:param>
 <c:param name="name"  value="guru"></c:param>
</c:url>

<a href ='<c:url value="${loginUrl}"> </c:url>'> Login Page</a> --%>

<!-- this is the example for C REDIRECT  *******************REDIRECT***************************-->

<c:redirect url = '../hw1/Login.jsp'></c:redirect>

</body>
</html>