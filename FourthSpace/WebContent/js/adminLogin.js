/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-05-11 18:40:34
 * @version $Id$
 */
var i=1;
$('#back-img').animate({opacity:"1"}, 3000,function(){
	$('#back-img').animate({opacity:"0"}, 1500,rowback);
});
function rowback(){
	if(i==1){
		i=2;
		$('#back-img').attr('src','img/background2.jpg');
	}
	else{
		i=1;
		$('#back-img').attr('src','img/background1.jpg');
	}
	setTimeout(function(){
		$('#back-img').animate({opacity:"1"}, 3000,function(){
			$('#back-img').animate({opacity:"0"}, 1500,rowback);
		});
	},500);
	
}

//form表单接收后台返回的数据
function formSubmit(){
	if($('#login-id').val()==''){
		$('.reg-form-error .IdisNull').show().siblings('p').hide();
		$('.reg-form-error').show();
	}else if($('#login-pwd').val()==''){
		$('.reg-form-error .PasswordisNull').show().siblings('p').hide();
		$('.reg-form-error').show();
	}else{
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"./admin/login",
			data:$('#login').serialize(),
			success:function(result){
				if(result=="0"){
					$('.reg-form-error .IdorPwdNotRight').show().siblings('p').hide();
					$('.reg-form-error').show();
				}else{
					window.location.href="./admin/"+result;
					$('.reg-form-error').hide();
				}
			},
			error:function(data){
				alert(data);
			}
			
		});
	}
	return false;
};
