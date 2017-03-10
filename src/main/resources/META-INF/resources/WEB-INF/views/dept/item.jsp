<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>item.jsp</title>

<!-- code_assist -->
<c:if test="false">
<link rel="stylesheet" href="../code_assist/animate.css">
<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
${error}<br>

${dept.deptno}, ${dept.dname}, ${dept.loc}<br>

<ol>
<c:forEach var="emps" items="${dept.emps}">
	<li>${emp.empno}, ${emp.ename}, ${emp.hiredate}</li>
</c:forEach>
</ol>
<hr>

${dept}
</body>
</html>