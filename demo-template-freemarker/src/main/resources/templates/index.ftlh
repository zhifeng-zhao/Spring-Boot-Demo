<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
${j}
${user.name}
${user.password!"无密码"}

<#list userList as user>
    ${user.name}
</#list>
<#if user.name == "zzf">
    合理
</#if>
<#include "req.ftlh">
</body>
</html>