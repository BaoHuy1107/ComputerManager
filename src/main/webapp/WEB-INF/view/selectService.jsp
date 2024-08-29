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
    <title>Danh sách dịch vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" href="/css/selectService.css">
    <style>
        .btn {
            background-color: #A68868;
            border: #A68868;
        }

        .btn:hover {
            background-color: #868787;
        }

        .fas:hover {
            color: #f7f4f2;
        }
    </style>
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
        <div class="col-9">
            <h2>
                <a href="/create/service">
                    <i class="fa fa-arrow-left" aria-hidden="true"></i>
                </a>
                Danh sách dịch vụ
            </h2>
        </div>
        <div class="col-3">
            <form action="">
                <div class="input-group">
                    <div class="form-outline" data-mdb-input-init>
                        <input type="search" id="form1" class="form-control" placeholder="Tìm kiếm" name="keyword"/>
                    </div>
                    <button type="button" class="btn btn-primary" data-mdb-ripple-init>
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </form>
        </div>
        <hr>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Mã dịch vụ</th>
            <th scope="col">Tên dịch vụ</th>
            <th scope="col">Đơn vị tính</th>
            <th scope="col">Đơn giá</th>
            <th>Hoạt động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${service}">
        <tr>
            <td>${service.id}</td>
            <td>${service.name}</td>
            <td>${service.unit}</td>
            <td>${service.price}</td>
            <td>
                <a href="/update/service/${service.id}">
                    <i class="fa-solid fa-gears"></i>
                </a>
                <a href="#">
                    <i class="fa-solid fa-box-archive"></i>
                </a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>


<script>
    $(document).ready(function () {
        $('.fa-box-archive').on('click', function (e) {
            alert('Bạn có đồng ý xóa dịch vụ này không ?')
            e.preventDefault();
            // Xác nhận xem người dùng có thực sự muốn xóa dòng này không
            if (confirm) {
                var row = $(this).closest('tr'); // Lấy dòng hiện tại
                row.remove(); // Xóa dòng khỏi bảng
            }
        });
    });
</script>
</body>
</html>