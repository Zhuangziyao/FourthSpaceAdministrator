<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<title>管理员端-管理</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="<%=path %>/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%=path %>/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="head">
		<div class="head-icon">
			<img src="<%=path %>/img/logo.jpg" class="logo">      
		</div>
		<div class="head-user">
			<img src="<%=path %>/img/adminAvatar.jpg?random=${randomNum}" class="head-user-avatar">
			<div class="head-user-name"><%=request.getAttribute("adminName") %></div>
		</div>
	</div>
	<div class="content">
		<div class="container">
			<ul class="classify">
				<li class=" item col-md-3 current" id="good">商品管理</li>
				<li class="item col-md-3" id="user">用户管理</li>
				<li class="item col-md-3" id="order">订单管理</li>
				<li class="item col-md-3" id="mission">任务管理</li>
				<li style="clear: both;"></li>
			</ul>
			<div class="detail">
				<div class="detail-content current">
					<div class="navgation" id="good">
						
						<div class="btn-operate">新建</div>
						<div class="btn-operate">选择</div>
						<div class="btn-operate">删除</div>
						<div class="search-container">
							<div class="search-icon">
								<i class="iconfont">&#xe65a;</i>
							</div>
							<input type="text" placeholder="商品名称" class="search-box">
						</div>
					</div>
					
					<div class="col-md-12" id="goods">
						<table class="table table-bordered table-striped">
							<thead class="table-head">
								<td class="name">商品名称</td>
								<td class="price">价格</td>
								<td class="cla">分类</td>
								<td class="supplier">供应商</td>
								<td class="server">服务商</td>
								<td class="mobile">联系方式</td>
								<td class="buyback">退购期限</td>
								<td class="grouding">上架日期</td>
								<td class="operate">操作</td>
							</thead>
						<tbody class="table-list">
							<tr class="table-item">
								<td class="name">LNMP环境</td>
								<td class="price">1000000000000</td>
								<td class="cla">技术</td>
								<td class="supplier">第四空间</td>
								<td class="server">上海微柳网络科技有限公司</td>
								<td class="mobile">4008005185转1036</td>
								<td class="buyback">30天</td>
								<td class="grouding">2018/5/10</td>
								<td class="operate"><a class="delete">删除</a>/<a class="more">详细信息</a></td>
							</tr>
						</tbody>
						</table>
					</div>
				</div>
				<div class="detail-content">
					<div class="navgation" id="user">
						
						<div class="btn-operate">选择</div>
						<div class="btn-operate">删除</div>
						<div class="search-container">
							<div class="search-icon">
								<i class="iconfont">&#xe65a;</i>
							</div>
							<input type="text" placeholder="用户账号" class="search-box">
						</div>
					</div>

					<div class="col-md-12" id="users">
						<table class="table table-bordered table-striped">
							<thead class="table-head">
							<td class="account">用户账号</td>
							<td class="nickname">账号昵称</td>
							<td class="star">星级</td>
							<td class="balance">账户余额</td>
							<td class="login-pwd">登录密码（已加密）</td>
							<td class="pay-pwd">支付密码（已加密）</td>
							<td class="login-time">上次登录时间</td>
							<td class="operate">操作</td>
						</thead>
						<tbody class="table-list">
							<tr class="table-item">
								<td class="account">17705840828</td>
								<td class="nickname">大猪妖</td>
								<td class="star">31</td>
								<td class="balance">100000</td>
								<td class="login-pwd">*&￥%#@</td>
								<td class="pay-pwd">asfeds</td>
								<td class="login-time">2018/5/10</td>
								<td class="operate"><a class="delete">删除</a> / <a class="reset">重置密码</a></td>
							</tr>
						</tbody>
						</table>
						
					</div>
				</div>
				<div class="detail-content">
					<div class="navagation" id="order">
						
						<div class="search-container">
							<div class="search-icon">
								<i class="iconfont">&#xe65a;</i>
							</div>
							<input type="text" placeholder="订单号" class="search-box">
						</div>
					</div>
					<div class="col-md-12" id="orders">
						<table class="table table-bordered table-striped">
							<thead class="table-head">
							<td class="id">订单号</td>
							<td class="number">商品编号</td>
							<td class="name">商品名称</td>
							<td class="account">用户账号</td>
							<td class="price">交易金额</td>
							<td class="date">订单时间</td>
							<td class="status">订单状态</td>
							<td class="operate">操作</td>
						</thead>
						<tbody class="table-list">
							<tr class="table-item">
								<td class="id">415642576879</td>
								<td class="number">a111</td>
								<td class="name">LNMP环境</td>
								<td class="account">17705840828</td>
								<td class="price">18900</td>
								<td class="date">2018/5/10 14:30</td>
								<td class="status">已签收</td>
								<td class="operate"><a class="buy-back">处理退购</a></td>
							</tr>
						</tbody>
						</table>
						
					</div>
				</div>
				<div class="detail-content">
					<div class="navgation" id="mission">					
						<div class="btn-operate">新建</div>
						<div class="btn-operate">选择</div>
						<div class="btn-operate">删除</div>
						<div class="search-container">
							<div class="search-icon">
								<i class="iconfont">&#xe65a;</i>
							</div>
							<input type="text" placeholder="任务编号" class="search-box">
						</div>
					</div>
					<div class="col-md-12" id="missions">
						<table class="table table-bordered table-striped">
							<thead class="table-head">
							<td class="id">任务编号</td>
							<td class="name">任务名称</td>
							<td class="require">任务要求</td>
							<td class="reward">奖励金额</td>
							<td class="operate">操作</td>
						</thead>
						<tbody class="table-list">
							<tr class="table-item">
								<td class="id">415642576879</td>
								<td class="name">登录</td>
								<td class="require">账号登录</td>
								<td class="reward">1000</td>
								<td class="operate">
									<a class="delete">删除</a>/<a class="edite">编辑</a>
								</td>
							</tr>
						</tbody>
						</table>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="tail"></div>
	<div class="background"></div>

	<div class="more-info">
		<div class="info-head">
			<span>详细信息</span>
		</div>
		<form onsubmit="return goodSubmit()" class="info-form">
			<div class="info-name">
				<span>商品名称：</span>
				<input type="text" class="good-name">
			</div>
			<div class="info-intro">
				<div class="intro-name">商品简介：</div>
				<textarea type="text" class="good-info"></textarea>
				<div style="clear: both;margin:0;"></div>
			</div>
			<div class="info-supplier">
				<span>供应商：</span>
				<input type="text" class="good-supplier">
			</div>
			<div class="info-server">
				<span>服务商：</span>
				<input type="text" class="good-server">
			</div>
			<div class="info-mobile">
				<span>联系方式：</span>
				<input type="text" class="good-contact">
			</div>
			<div class="info-kinds">
				<span>价格：</span>
				<input type="text" name="price" class="good-price">
				<span>分类：</span>
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="">日期&nbsp;<span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">日期</a></li>
						<li class="divider"></li>
						<li><a href="#">id</a></li>
					</ul>
				</div>
				<span>退购期限：</span>
				<input type="text" class="good-return" >
			</div>
			<div class="info-btns">
				<input type="submit" name="submit" value="保存" class="save">
				<input type="button" value="取消" class="cancel">
			</div>
		</form>
	</div>

	<div class="mission-edite">
		<div class="edite-head">
			<span>编辑任务</span>
		</div>
		<form onsubmit="return MissionSubmit()" class="edite-form">
			<div class="edite-name">
				<span>任务名称：</span>
				<input type="text" class="mission-name">
			</div>
			<div class="edite-require">
				<div class="require-name">任务要求：</div>
				<textarea class="mission-desc"></textarea>
				<div style="clear: both;margin:0;"></div>
			</div>
			<div class="edite-reward">
				<span>奖励金额：</span>
				<input type="text" class="mission-reward">
				<div class="visible">全员可见</div>
				<input type="checkbox" checked class="mission-visible"></input>
			</div>
			<div class="edite-btns">
				<input type="submit" name="" value="保存" class="save">
				<input type="button" value="取消" class="cancel">
			</div>
		</form>
	</div>

    <script type="text/javascript" src="<%=path %>/lib/jQuery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/admin.js"></script>
</body>
</html>