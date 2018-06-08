/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-05-11 19:36:32
 * @version $Id$
 */


//全局变量
var good_id;
var mission_id;
var is_batch=0;
//转换管理内容
$('.classify .item').click(function(){
	$(this).addClass('current').siblings('.item').removeClass('current');
	$('.detail-content:eq('+$(this).index()+')').addClass('current').siblings('.detail-content').removeClass('current');
	$('.detail-content:eq('+$(this).index()+')').show().siblings('.detail-content').hide();
})

//下拉框内容变动
$('.dropdown-menu li').click(function(event) {
	$('#btn-good').text($(this).text()).append('<span class="caret"></span>');
});
//搜索框动态效果
$('.search-box').focus(function(event) {
	$('.search-container').addClass('search-container-focus');
});
$('.search-box').blur(function(event) {
	$('.search-container').removeClass('search-container-focus');
});

//商品管理
//点击详细按钮事件
$('#goods .more').click(function(event) {
	var goodName=$(this).parent().siblings('.name').text();
	$.ajax({
		type:"POST",
		data:goodName,
		url:"./../good/moreInfo",
		dataType:"json",
		success:function(data){
			good_id=data.id;
			$('.info-form .good-name').val(data.goodName);
			$('.info-form .good-info').val(data.infomation);
			$('.info-form .good-supplier').val(data.supplier);
			$('.info-form .good-server').val(data.server);
			$('.info-form .good-price').val(data.price);
			$('.info-form .dropdown-toggle').text(data.tags);
			$('.info-form .good-return').val(data.backDeadline);
			
		}
	});
	$('.more-info').show();
	$('.background').show();
});

//将毫秒转换成年月日
function getDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ oMonth +'-'+ oDay +' ';//最后拼接时间  
    return oTime;  
};  

//获取商品信息
function getGoods(){
	$.ajax({
		type:"GET",
		url:"./../good",
		dataType:"json",
		success:function(data){
			$('#goods .table-list').children().remove();
			for(var i=0;i<data.length;i++){
				var line="<tr class='table-item'><td class='name'>"+data[i].name+"</td><td class='price'>"+data[i].price+"</td><td class='cla'>"+data[i].tags+"</td>" +
						"<td class='supplier'>"+data[i].supplier+"</td><td class='server'>"+data[i].server+"</td><td class='mobile'>"+data[i].contactWay+"</td>" +
						"<td class='buyback'>"+data[i].backDeadLine+"</td><td class='grouding'>"+getDate(data[i].groundDate)+"</td>" +
						"<td class='operate'><a class='delete'>删除</a>/<a class='more'>详细信息</a></td></tr>";
				$('#goods .table-list').append(line);
			}	
		},
		error:function(data){
			alert("error");
		}
	})
}

//获取用户信息
function getUsers(){
	$.ajax({
		type:"POST",
		url:"./../user",
		dataType:"json",
		success:function(data){
			$('#users .table-list').children().remove();
			for(var i=0;i<data.length;i++){
				var line="<tr class='table-item'><td class='account'>"+data[i].id+"</td>" +
						"<td class='nickname'>"+data[i].nickname+"</td><td class='star'>"+data[i].star+"</td>" +
						"<td class='balance'>"+data[i].userImportant.money+"</td><td class='login-pwd'>"+data[i].password+"</td>" +
						"<td class='pay-pwd'>"+data[i].userImportant.payPassword+"</td><td class='login-time'>"+data[i].lastLogin+"</td>" +
						"<td class='operate'><a class='delete'>删除</a> / <a class='reset'>重置密码</a></td></tr>";
				$('#users .table-list').append(line);
			}
		}
	})
}

//获取订单信息
function getOrders(){
	$.ajax({
		type:"POST",
		url:"./../order",
		dataType:"json",
		success:function(data){
			$('#orders .table-list').children().remove();
			for(var i=0;i<data.length;i++){
				var line="<tr class='table-item'><td class='id'>"+data[i].id+"</td><td class='number'>"+data[i].goodId+"</td>" +
						"<td class='name'>"+data[i].goodName+"</td><td class='account'>"+data[i].userId+"</td>" +
						"<td class='price'>"+data[i].price+"</td><td class='date'>"+data[i].buyDate+"</td>" +
						"<td class='status'>"+data[i].status+"</td><td class='operate'><a class='buy-back'>处理退购</a></td></tr>";
				$('#orders .table-list').append(line);
			}
		}
	})
}

//获取任务信息
function getMissions(){
	$.ajax({
		type:"POST",
		url:"./../mission",
		dataType:"json",
		success:function(data){
			$('#missions .table-list').children().remove();
			for(var i=0;i<data.length;i++){
				var line="<tr class='table-item'><td class='id'>"+data[i].id+"</td>" +
						"<td class='name'>"+data[i].name+"</td><td class='require'>"+data[i].description+"</td>" +
						"<td class='reward'>"+data[i].reward+"</td>" +
						"<td class='operate'><a class='delete'>删除</a>/<a class='edite'>编辑</a></div></tr>";
				$('#missions .table-list').append(line);
			}
		}
	})
}

getGoods();
getUsers();
getOrders();
getMissions();
//编辑商品详细信息
$(document).on("click",'#goods .more',function(){
	var goodName=$(this).parent().siblings('.name').text();
	$.ajax({
		type:"POST",
		data:{goodName:goodName},
		url:"./../good/moreInfo",
		dataType:"json",
		success:function(data){
			good_id=data.id;
			$('.info-form .good-name').val(data.name);
			$('.info-form .good-info').val(data.information);
			$('.info-form .good-supplier').val(data.supplier);
			$('.info-form .good-server').val(data.server);
			$('.info-form .good-price').val(data.price);
			$('.info-form .good-contact').val(data.contactWay);
			$('.info-form .dropdown-toggle').text(data.tags);
			$('.info-form .good-return').val(data.backDeadLine);
		}
	});
	$('.more-info').show();
	$('.background').show();
});
//编辑任务
$(document).on("click","#missions .edite",function(){
	mission_id=$(this).parent().siblings('.id').text();
	var missionName=$(this).parent().siblings('.name').text();
	var missionDesc=$(this).parent().siblings('.require').text();
	var missionReward=$(this).parent().siblings('.reward').text();
	$('.edite-form .mission-name').val(missionName);
	$('.edite-form .mission-desc').val(missionDesc);
	$('.edite-form .mission-reward').val(missionReward);
	
});

function MissionSubmit(){
	$.ajax({
		type:"POST",
		data:{id:mission_id,
			 name:$('.edite-form .mission-name').val(),
			 description:$('.edite-form .mission-desc').val(),
			 reward:$('.edite-form .mission-reward').val()},
		url:"./../mission/changeMission",
		dataType:"json",
		success:function(data){
			if(data!=0)
				getMissions();
			
		}
	});
	$('.mission-edite').hide();
	$('.background').hide();
	
	return false;
}

//删除任务
$(document).on("click",'#missions .delete',function(){
	var missionid=$(this).parent().siblings('.id').text();
	$.ajax({
		type:"POST",
		data:{missionId:missionid},
		url:"./../mission/delete",
		dataType:"json",
		success:function(data){
			getMissions();
		}
	});
});
//删除用户
$(document).on("click",'#users .delete',function(){
	var userId=$(this).parent().siblings('.account').text();
	$.ajax({
		type:"POST",
		data:{userId:userId},
		url:"./../user/delete",
		dataType:"json",
		success:function(data){
			getUsers();
		}
	});
});
//删除商品
$(document).on("click",'#goods .delete',function(){
	var goodName=$(this).parent().siblings('.name').text();
	$.ajax({
		type:"POST",
		data:{goodName:goodName},
		url:"./../good/deleteGood",
		success:function(data){
			getGoods();
		}
	});
});

//详细信息 取消 按钮点击事件
$('.more-info .cancel').click(function(event) {
	$('.background').hide();
	$('.more-info').hide();
});

//任务管理
//编辑任务按钮点击事件
$('#missions .edite').click(function(event) {
	$('.background').show();
	$('.mission-edite').show();
});
$(document).on("click",'#missions .edite',function(){
	$('.background').show();
	$('.mission-edite').show();
})

//编辑任务 取消 按钮点击事件
$('.mission-edite .cancel').click(function(event) {
	$('.mission-edite').hide();
	$('.background').hide();
});

//黑色背景点击事件
$('.background').click(function(event) {
	$(this).hide();
	$('.mission-edite').hide();
	$('.more-info').hide();
});


//提交修改的商品数据
function goodSubmit(){
	$.ajax({
		type:"POST",
		data:{id:good_id,
			name:$('.info-form .good-name').val(),
			information:$('.info-form .good-info').val(),
			supplier:$('.info-form .good-supplier').val(),
			server:$('.info-form .good-server').val(),
			price:$('.info-form .good-price').val(),
			contactWay:$('.info-form .good-contact').val(),
			tags:$('.info-form .dropdown-toggle').text(),
			backDeadLine:$('.info-form .good-return').val()},
		url:"./../good/changeGood",
		dataType:"json",
		success:function(data){
			if(data==0)
				alert("update fail");
			else
				alert("update success");
			getGoods();
		},
		error:function(data){
			alert("error");
		}
	});
	$('.background').hide();
	$('.more-info').hide();
	return false;
}


//新建删除商品
//商品导航栏点击按钮
$('#good .btn-operate').click(function(event){
	if($(this).index()==0){
		$('.more-info input').val('');
		$('.more-info textarea').val('');
		$('.more-info .save').val('保存');
		$('.more-info .cancel').val('取消');
		$('.more-info').show();
		$('.background').show();
	}else if($(this).index()==2){
		var size=$('#goods .table-item').length;
		var length=0;
		var myArray=new Array();
		for(var i=0;i<size;i++){
			if($('#goods .table-item:eq('+i+')').css("background-color")=='rgb(57, 131, 255)'){
				myArray[length]=$('#goods .table-item:eq('+i+')').children('.name').text();
				length++;
			}
		}
		$.ajax({
			type:"GET",
			url:"./../good/deleteBatch?myArray="+myArray,
			dataType:"json",
			success:function(data){
				getGoods();
			}
		})
		
		
	}
})
//删除用户
$('#user .btn-operate').click(function(event){
	if($(this).index()==1){
		var size=$('#users .table-item').length;
		var length=0;
		var myArray=new Array();
		for(var i=0;i<size;i++){
			if($('#users .table-item:eq('+i+')').css("background-color")=='rgb(57, 131, 255)'){
				myArray[length]=$('#users .table-item:eq('+i+')').children('.account').text();
				length++;
			}
		}
		$.ajax({
			type:"GET",
			url:"./../user/deleteBatch?myArray="+myArray,
			dataType:"json",
			success:function(data){
				getUsers();
			}
		})
	}
})
//新建删除任务
$('#mission .btn-operate').click(function(event){
	if($(this).index()==0){
		$('.edite-form .mission-name').val();
		$('.edite-form .mission-desc').val();
		$('.edite-form .mission-reward').val();
		$('.mission-edite').show();
		$('.background').show();
	}else if($(this).index()==2){
		var size=$('#missions .table-item').length;
		var length=0;
		var myArray=new Array();
		for(var i=0;i<size;i++){
			if($('#missions .table-item:eq('+i+')').css("background-color")=='rgb(57, 131, 255)'){
				myArray[length]=$('#missions .table-item:eq('+i+')').children('.id').text();
				length++;
			}
		}
		$.ajax({
			type:"GET",
			url:"./../mission/deleteBatch?myArray="+myArray,
			dataType:"json",
			success:function(data){
				getMissions();
			}
		})
	}
})


$('.btn-operate').click(function(){
		if($(this).text()=='选择'){
			if(is_batch==0)
				is_batch=1;
			else
				is_batch=0;
		}
});

//点中了就改变底色
$(document).on('click','.table-list .table-item',function(event){	
	if(is_batch==1)
		$(this).css("background-color","#3983ff");
})

//点击其他地方清空颜色
$('body').click(function(e){
	var target=$(e.target);
	if(!target.is('.table-list .table-item *')&&!target.is('.btn-operate')){
		is_batch=0;
		$('.table-list .table-item').css("background-color","white");
	}
})
//重置密码
$(document).on('click','#users .reset',function(event){
	var id=$(this).parent().siblings('.account').text();
	$.ajax({
		type:"POST",
		data:{userId:id},
		url:"./../user/resetPassword",
		dataType:"json",
		success:function(data){
			getUsers();
			alert("密码重置成功");
		}
	})
})
//处理退购
$(document).on('click','#orders .buy-back',function(){
	var id=$(this).parent().siblings('.id').text();
	
	$.ajax({
		type:"POST",
		data:{orderId:id},
		url:"./../order/checkBuyBack",
		dataType:"json",
		success:function(data){
			if(data.status=='已退购'){
				alert("订单已退购");
			}else{
				var now=new Date();
				var returnDate=now.getFullYear()+'-';
				if(now.getMonth()<9)
					returnDate+='0'+(now.getMonth()+1)+'-';
				else
					returnDate+=(now.getMonth()+1)+'-';
				if(now.getDate()<10)
					returnDate+='0'+now.getDate();
				else
					returnDate+=now.getDate();
				
				$.ajax({
					type:"POST",
					data:{id:id,
						status:'已退购',
						returnDate:new Date()},
					url:"./../order/updateRecord",
					dataType:"json",
					success:function(data){
						alert("退购成功");
						getOrders();
					}
				})	
			}
		}
	})
})


//查询商品
$('#good .search-box').bind('keypress',function(event){
	if(event.keyCode==13){
		$(this).blur();
		var goodName=$(this).val();
		if(goodName=='')
			getGoods();
		else
		$.ajax({
			type:"POST",
			data:{goodName:goodName},
			url:"./../good/query",
			dataType:"json",
			success:function(data){
				$('#goods .table-list').children().remove();
				for(var i=0;i<data.length;i++){
					var line="<li class='table-item'><div class='name'>"+data[i].name+"</div><div class='price'>"+data[i].price+"</div><div class='cla'>"+data[i].tags+"</div>" +
							"<div class='supplier'>"+data[i].supplier+"</div><div class='server'>"+data[i].server+"</div><div class='mobile'>"+data[i].contactWay+"</div>" +
							"<div class='buyback'>"+data[i].backDeadLine+"</div><div class='grouding'>"+getDate(data[i].groundDate)+"</div>" +
							"<div class='operate'><a class='delete'>删除</a>/<a class='more'>详细信息</a></div></li>";
					$('#goods .table-list').append(line);
				}	
			}
		});
	}
})

//查询用户
$('#user .search-box').bind('keypress',function(event){
	if(event.keyCode==13){
		$(this).blur();
		var userId=$(this).val();
		if(userId=='')
			getUsers();
		else
		$.ajax({
			type:"POST",
			data:{userId:userId},
			url:"./../user/query",
			dataType:"json",
			success:function(data){
				$('#users .table-list').children().remove();
				for(var i=0;i<data.length;i++){
					var line="<li class='table-item'><div class='account'>"+data[i].id+"</div>" +
							"<div class='nickname'>"+data[i].nickname+"</div><div class='star'>"+data[i].star+"</div>" +
							"<div class='balance'>"+data[i].userImportant.money+"</div><div class='login-pwd'>"+data[i].password+"</div>" +
							"<div class='pay-pwd'>"+data[i].userImportant.payPassword+"</div><div class='login-time'>"+data[i].lastLogin+"</div>" +
							"<div class='operate'><a class='delete'>删除</a> / <a class='reset'>重置密码</a></div></li>";
					$('#users .table-list').append(line);
				}
			}
		})
	}
})

//查询订单
$('#order .search-box').bind("keypress",function(event){
	if(event.keyCode==13){
		$(this).blur();
		var orderId=$(this).val();
		if(orderId==''){
			getOrders();
		}else
		$.ajax({
			type:"POST",
			data:{orderId:orderId},
			url:"./../order/query",
			dataType:"json",
			success:function(data){
				$('#orders .table-list').children().remove();
				for(var i=0;i<data.length;i++){
					var line="<li class='table-item'><div class='id'>"+data[i].id+"</div><div class='number'>"+data[i].goodId+"</div>" +
							"<div class='name'>"+data[i].goodName+"</div><div class='account'>"+data[i].userId+"</div>" +
							"<div class='price'>"+data[i].price+"</div><div class='date'>"+data[i].buyDate+"</div>" +
							"<div class='status'>"+data[i].status+"</div><div class='operate'><a class='buy-back'>处理退购</a></div></li>";
					$('#orders .table-list').append(line);
				}
			}
		})
	}
})

//查询任务
$('#mission .search-box').bind("keypress",function(event){
	if(event.keyCode==13){
		$(this).blur();
		var missionId=$(this).val();
		if(missionId=='')
			getMissions();
		else
		$.ajax({
			type:"POST",
			data:{missionId:missionId},
			url:"./../mission/query",
			dataType:"json",
			success:function(data){
				$('#missions .table-list').children().remove();
				for(var i=0;i<data.length;i++){
					var line="<li class='table-item'><div class='id'>"+data[i].id+"</div>" +
							"<div class='name'>"+data[i].name+"</div><div class='require'>"+data[i].description+"</div>" +
							"<div class='reward'>"+data[i].reward+"</div>" +
							"<div class='operate'><a class='delete'>删除</a>/<a class='edite'>编辑</a></div></li>";
					$('#missions .table-list').append(line);
				}
			}
		})
	}
})
