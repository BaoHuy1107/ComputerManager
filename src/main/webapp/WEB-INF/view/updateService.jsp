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
  <title>Cập nhật dịch vụ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/css/updateService.css">
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

<%--body--%>
<div class="container mt-5 form">
  <div class="row">
    <h1>Cập nhật dịch vụ</h1>
  </div>

  <form:form method="post" action="/view/update/service" modelAttribute="newService">
    <div class="form-group" style="display: none">
      <label>Mã dịch vụ</label>
      <form:input class="form-control" path="id"/>
    </div>
    <div class="form-group">
      <label>Tên dịch vụ</label>
      <form:input class="form-control" path="name"/>
    </div>
    <div class="form-group">
      <label>Đơn vị tính</label>
      <form:input class="form-control" path="unit"/>
    </div>
    <div class="form-group">
      <label>Đơn giá</label>
      <form:input class="form-control" path="price"/>
      <form:errors path="price" cssClass="text-danger"/>
    </div>
    <button type="submit" class="btn btn-primary">Cập nhật</button>
  </form:form>
</div>
</body>
</html>
