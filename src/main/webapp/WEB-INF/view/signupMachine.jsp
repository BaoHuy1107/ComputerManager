<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng kí sử dụng máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/css/signup.css">
</head>
<body>

<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-lg-5">


        <a class="navbar-brand" href="/">Bao Huy Gaming Center</a>

        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"
                   data-bs-toggle="dropdown"
                   aria-expanded="false">
                    Tạo mới
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/create/machine">Máy</a>
                    <a class="dropdown-item" href="/create/customer">Khách hàng</a>
                    <a class="dropdown-item" href="/create/service">Dịch vụ</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"
                   data-bs-toggle="dropdown"
                   aria-expanded="false">
                    Liệt kê
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/select/machine">Danh sách máy</a>
                    <a class="dropdown-item" href="/select/customer">Danh sách khách hàng</a>
                    <a class="dropdown-item" href="/select/service">Danh sách dịch vụ</a>
                    <a class="dropdown-item" href="/select/all">Tất cả</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"
                   data-bs-toggle="dropdown"
                   aria-expanded="false">
                    Đăng ký
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/signup/machine">Sử dụng máy</a>
                    <a class="dropdown-item" href="/signup/service">Sử dụng dịch vụ</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5 form">
    <div class="row">
        <h1>Đăng kí sử dụng máy</h1>
    </div>

    <!-- Hiển thị thông báo thành công -->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <form:form method="post" action="${pageContext.request.contextPath}/view/signup/machine" modelAttribute="newMachineUsage">
        <label>Mã khách hàng</label>
        <form:select class="form-control" path="customer.id">
            <form:option value=""> Chọn khách hàng </form:option>
            <c:forEach var="customer" items="${customer}">
                <form:option value="${customer.id}">${customer.id}</form:option>
            </c:forEach>
        </form:select>
        <label>Mã máy</label>
        <form:select class="form-control" path="machine.id">
            <form:option value=""> Chọn máy </form:option>
            <c:forEach var="machine" items="${machine}">
                <form:option value="${machine.id}">${machine.id}</form:option>
            </c:forEach>
        </form:select>
        <div class="form-group">
            <label>Ngày bắt đầu sử dụng</label>
            <form:input type="date" class="form-control" path="startDate"/>
            <form:errors path="startDate" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label>Giờ bắt đầu sử dụng</label>
            <form:input type="time" class="form-control" path="startTime"/>
            <form:errors path="startTime" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label>Thời gian sử dụng</label>
            <form:input class="form-control" path="usageDuration"/>
            <form:errors path="usageDuration" cssClass="text-danger"/>
        </div>

        <button type="submit" class="btn btn-primary">Đăng ký</button>
    </form:form>
</div>
</body>
</html>