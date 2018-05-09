<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>${ title }</title>
    <link href="/css/ydui.css" rel="stylesheet">
    <link href="/css/shop-index.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="static/js/jquery.cookie.js"></script>
    <script src="/js/shop-index.js"></script>
    <script src="/js/ydui.flexible.js"></script>
    <script src="/js/ydui.js"></script>
</head>
<body>
<header class="m-navbar">
    <a href="#" class="navbar-item">
        <i class="icon-setting"></i>
    </a>
    <div class="navbar-center">
        <span class="navbar-title">我的</span>
    </div>
    <div class="navbar-item">
        <a href="#">
            <i class="icon-search"></i>
        </a>
    </div>
</header>
<footer class="m-tabbar">
    <a href="#" class="tabbar-item">
        <span class="tabbar-icon">
            <i class="icon-home-outline"></i>
        </span>
        <span class="tabbar-txt">首页</span>
    </a>
    <a href="#" class="tabbar-item">
        <span class="tabbar-icon">
            <i class="icon-discover"></i>
            <span class="tabbar-dot"></span>
        </span>
        <span class="tabbar-txt">交流圈</span>

    </a>
    <a href="#" class="tabbar-item">
        <span class="tabbar-icon">
            <i class="icon-shopcart-outline"></i>
            <span class="tabbar-dot"></span>
        </span>
        <span class="tabbar-txt">购物车</span>

    </a>
    <a href="#" class="tabbar-item tabbar-active">
        <span class="tabbar-icon">
            <i class="icon-ucenter"></i>
            <span class="badge badge-danger">2</span>
        </span>
        <span class="tabbar-txt">我的</span>
    </a>
</footer>
</body>
</html>
