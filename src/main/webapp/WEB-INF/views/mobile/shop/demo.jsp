<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>demo1</title>
    <script type="text/javascript" src="js/template-web.js"></script>
</head>
<body>
<div id="content"></div>
<script id="test" type="text/html">
    {{if isAdmin}}
    <h1>{{title}}</h1>
    <ul>
        {{each list value i}}
        <li>索引{{i+1}}：{{value}}</li>
        {{/each}}
    </ul>
    {{/if}}
</script>
<script>
    var data = {
        title: '基本例子',
        isAdmin:true,
        list:['文艺','博客','hhh']
    };
    var html = template('test',data);
    document.getElementById('content').innerHTML = html;
</script>
</body>
</html>