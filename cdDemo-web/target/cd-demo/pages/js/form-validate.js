//表单验证

//用户添加的表单验证
var validatForm = $("#userAddForm").validate({
	 debug: true,   
     focusInvalid: true,   
     onfocusout: function(element){ $(element).valid();},
     errorElement : 'div',  
     errorClass : 'help-block col-sm-12 col-sm-offset-4',  
     rules : { 
    	 userId:{
    		 required:true,
//    		 romote:{
//    			 type:"post",
//    			 url:"/mdmStudent/get.do",
//    			 dataType: "json",
//    			 data:{
//    				 code :function(){ return $("#addUserId").val();}
//    			 },
//    			 dataFilter: function(data, type) {
//    				 console.log(data);
//    			 }
//    		 }
     	},
     	pwd:{
     		required:true,
     	},
     	againPwd:{
     		required:true,
     		equalTo:"#pwd"   
     	},
     	email:{
     		email:true,
     	},
     	tel:{
     		mobile:true,
     	},
     	userType:{
     		required:true,
     	}
     },  
     messages : {
    	 userId:{
    		 required: "请输入工号/学号",
    		 //remote:"用户名不可用"
    	 },
    	 pwd:"请输入密码",
    	 againPwd:{
    		 required: "请输入确认密码",  
    		 equalTo: "两次输入密码不一致"  
    	 },
    	 email:"请输入正确的邮箱",
    	 userType:"用户类型必填"
     },  
     errorPlacement : function(error, element) {  
     	  element.closest('.form-group').append(error);
     	  console.log(error);
     },  
     highlight : function(element) {
         $(element).closest('div').addClass('has-error');  
     },  
    success: function(label) {  
         label.prev('div').removeClass('has-error');  
         label.remove();  
    },  
     submitHandler: function(form) {//表单验证成功
    	 UserList.checkMdm();
     },
});
