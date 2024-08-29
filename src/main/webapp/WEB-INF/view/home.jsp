<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý quán net</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/home.css">
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
<!-- Header-->
<header class="py-5">
    <div class="container px-lg-5">
        <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
            <div class="m-4 m-lg-5">
                <h1 class="display-5 fw-bold">Chào mừng bạn đã đến với website quản lí Bao Huy Gaming</h1>
            </div>
        </div>
    </div>
</header>
<!-- Page Content-->
<section class="pt-4">
    <div class="container px-lg-5">
        <!-- Page Features-->
        <div class="row gx-lg-5">
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="/create/machine">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-collection"></i></div>
                            <h2 class="fs-4 fw-bold">Tạo mới máy</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="/create/customer">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-cloud-download"></i></div>
                            <h2 class="fs-4 fw-bold">Tạo mới khách hàng</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="/create/service">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-card-heading"></i></div>
                            <h2 class="fs-4 fw-bold">Tạo mới dịch vụ</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="select/machine">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-bootstrap"></i></div>
                            <h2 class="fs-4 fw-bold">Liệt kê danh sách máy</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="select/customer">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-code"></i></div>
                            <h2 class="fs-4 fw-bold">Liệt kê danh sách khách hàng</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="select/service">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-patch-check"></i></div>
                            <h2 class="fs-4 fw-bold">Liệt kê danh sách dịch vụ</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="signup/machine">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-patch-check"></i></div>
                            <h2 class="fs-4 fw-bold">Đăng ký sử dụng máy</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="signup/service">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-patch-check"></i></div>
                            <h2 class="fs-4 fw-bold">Đăng ký sử dụng dịch vụ</h2>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-6 col-xxl-4 mb-5">
                <a href="select/all">
                    <div class="card bg-light border-0 h-100">
                        <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4"><i
                                    class="bi bi-patch-check"></i></div>
                            <h2 class="fs-4 fw-bold">Liệt kê tất cả thông tin</h2>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; My Website 2024</p>
    </div>
</footer>
</body>

</html>
