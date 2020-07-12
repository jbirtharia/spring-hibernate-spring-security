<%--
  Created by IntelliJ IDEA.
  User: Jayendra
  Date: 11-07-20
  Time: 01:41
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%-- Taglib for spring form tags --%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %> <%-- Taglib for spring security tags --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Taglib for jstl tags --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <!--===============================================================================================-->

</head>

<body>

<div class="wrap-home1" style="background-color: #28a745;border-bottom-width: 10px">
    <h2 class="login100-form validate-form p-l-55 p-r-55 p-t-178" style="font-family: 'Comic Sans MS';
    font-palette: dark; padding-left: 560px; padding-top: 17px;">
        Company Home Page</h2>
    <hr>
</div>

<br><br>


<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <div class="container-logout-form-btn">
        <input class="logout-form-btn" type="submit" value="Logout"/>
    </div>
</form:form>


<h3> Welcome
    <security:authentication property="principal.username"/> <%-- For displaying username in jsp page --%>
    <br>
    Roles : <security:authentication property="principal.authorities"/> <%-- For displaying user roles in jsp page --%>
</h3>
<br><br>


<%-- Following link will able to see on the basis of roles.
If user has MANGER role then can only see following link--%>
<security:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/managers" class="txt3">
        Link for Managers
    </a>
</security:authorize>
<br><br>


<%-- Following link will able to see on the basis of roles.
If user has ADMIN role then can only see following link--%>
<security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin" class="txt3">
        Link for Admin
    </a>
</security:authorize>


<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>
