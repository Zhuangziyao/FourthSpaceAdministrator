<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%String path=request.getContextPath(); %>
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="title"/></title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="<%=path %>/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%=path %>/css/adminLogin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="head">
		<div class="head-icon">
            <img src="<%=path %>/img/logo.jpg" class="logo">      
        </div>
	</div>
    <div class="back">
        <img src="<%=path %>/img/background1.jpg" class="back-img" id="back-img">
    	<div class="container">
    			<div class="reg col-md-4">
    			<div class="reg-head">
    				<div class="reg-head-name"><spring:message code="reg-name"/></div>
    			</div>
    			
    			<form onsubmit="return formSubmit()" class="reg-form" id="login">
    				<div class="reg-form-error">
    					<div class="input-error">
    					<i class="iconfont">&#xe600;</i>
    					<p class="IdorPwdNotRight"><spring:message code="IdorPwdNotRight"/></p>
    					<p class="IdisNull"><spring:message code="IdisNull"/></p>
    					<p class="PasswordisNull"><spring:message code="PasswordisNull"/></p>
    				</div>
    				</div>
    				<div class="reg-form-input">
    					<input type="text" name="id" placeholder="<spring:message code="adminId"/>" class="input-box" id="login-id">
    				</div>
    				<div class="reg-form-input">
    					<input type="password" name="password" placeholder="<spring:message code="adminPassword"/>" class="input-box" id="login-pwd">
    				</div>
    				<div class="btns">
    					<input type="submit" name="submit" value="<spring:message code="reg-login"/>" class="btn-login">
    				</div>
    			</form>
    			<div class="reg-tip"><spring:message code="tip"/></div>
    		</div> 		
    		</div>
    </div>
    <div class="tail">
        <div class="tips">
            CopyRight<i class="iconfont">&#xe6d5;</i> ?-?
            <a href="?locale=zh_CN"><spring:message code="language.cn"/></a>|
            <a href="?locale=en_US"><spring:message code="language.en"/></a>
        </div>
    </div>
    <script type="text/javascript" src="<%=path %>/lib/jQuery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/jQuery/jquery-form.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/adminLogin.js"></script>
</body>
</html>