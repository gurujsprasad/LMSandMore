<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/cs320stu110"
	user="root"
	password="abcd"/>

<%-- query --%>
<sql:query var="occupation" sql="select * from user_occupation"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL SQL Example</TITLE> </HEAD>

<table>
  <c:forEach items="${occupation.rows}" var="row">
    
      <tr>
        <td>${row.occupation_id}</td><td>${row.occupation_value}</td>
      </tr>
   
  </c:forEach>
</table>
    <form>
    <input type = "checkbox" value = 'Cricket' name = 'hobby'>cricket
    <input type = "checkbox" value = 'Foot Ball' name = 'hobby'>football
    
    </form>
</BODY>
</HTML>
