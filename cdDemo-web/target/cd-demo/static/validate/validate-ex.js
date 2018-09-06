//自定义jquery validate验证
 //邮箱 
 jQuery.validator.addMethod("mail", function (value, element) {
 	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
 	return this.optional(element) || (mail.test(value));
 }, "邮箱格式不对");

 //电话验证规则
 jQuery.validator.addMethod("phone", function (value, element) {
     var phone = /^0\d{2,3}-\d{7,8}$/;
     return this.optional(element) || (phone.test(value));
 }, "电话格式如：0371-68787027");

 //区号验证规则  
 jQuery.validator.addMethod("ac", function (value, element) {
     var ac = /^0\d{2,3}$/;
     return this.optional(element) || (ac.test(value));
 }, "区号如：010或0371");

 //无区号电话验证规则  
 jQuery.validator.addMethod("noactel", function (value, element) {
     var noactel = /^\d{7,8}$/;
     return this.optional(element) || (noactel.test(value));
 }, "电话格式如：68787027");

 //手机验证规则  
 jQuery.validator.addMethod("mobile", function (value, element) {
     var mobile = /^1[3|4|5|7|8]\d{9}$/;
 	return this.optional(element) || (mobile.test(value));
 }, "手机格式不对");

 //邮箱或手机验证规则  
 jQuery.validator.addMethod("mm", function (value, element) {
     var mm = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/;
 	return this.optional(element) || (mm.test(value));
 }, "格式不对");

 //电话或手机验证规则  
 jQuery.validator.addMethod("tm", function (value, element) {
     var tm=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
     return this.optional(element) || (tm.test(value));
 }, "格式不对");

 
 //年龄
 jQuery.validator.addMethod("age", function(value, element) {   
 	var age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
 	return this.optional(element) || (age.test(value));
 }, "不能超过120岁"); 
 ///// 20-60   /^([2-5]\d)|60$/

 //传真
 jQuery.validator.addMethod("fax",function(value,element){
     var fax = /^(\d{3,4})?[-]?\d{7,8}$/;
     return this.optional(element) || (fax.test(value));
 },"传真格式如：xxxx-xxxxxxx");

 //验证当前值和目标val的值相等 相等返回为 false
 jQuery.validator.addMethod("equalTo2",function(value, element){
     var returnVal = true;
     var id = $(element).attr("data-rule-equalto2");
     var targetVal = $(id).val();
     if(value === targetVal){
         returnVal = false;
     }
     return returnVal;
 },"不能和原始密码相同");

 //大于指定数
 jQuery.validator.addMethod("gt",function(value, element){
     var returnVal = false;
     var gt = $(element).data("gt");
     if(value > gt && value != ""){
         returnVal = true;
     }
     return returnVal;
 },"不能小于0 或空");

 //汉字
 jQuery.validator.addMethod("chinese", function (value, element) {
     var chinese = /^[\u4E00-\u9FFF]+$/;
     return this.optional(element) || (chinese.test(value));
 }, "格式不对");

 //指定数字的整数倍
 jQuery.validator.addMethod("times", function (value, element) {
     var returnVal = true;
     var base=$(element).attr('data-rule-times');
     if(value%base!=0){
         returnVal=false;
     }
     return returnVal;
 }, "必须整数倍");
//验证值不允许与特定值等于
 jQuery.validator.addMethod("notEqual", function(value, element, param) {
 return value != param;
 }, $.validator.format("输入值不允许为{0}!"));

 // 验证值必须大于特定值(不能等于)
 jQuery.validator.addMethod("gt", function(value, element, param) {
 return value > param;
 }, $.validator.format("输入值必须大于{0}!"));
 
 
 
 //身份证
 jQuery.validator.addMethod("idCard", function (value, element) {
     var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;//(15位)
     var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//(18位)
     return this.optional(element) || (isIDCard1.test(value)) || (isIDCard2.test(value));
 }, "格式不对");
  
 
 //只能是字母数字或下划线
 jQuery.validator.addMethod("numberLine", function(value, element) {
  var val=/^[a-zA-Z]\w*$/;     
  return this.optional(element) || (val.test(value));     
 });
 
 
 
 //验证ip地址
 jQuery.validator.addMethod("ip", function(value, element) { 
	 var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/; 
	 return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256)); 
	 }, "Ip地址格式错误");
 
 
 //select下拉框验证
 $.validator.addMethod("selectNone", function(value, element) {
	 return value == "请选择";
	 }, "必须选择一项");
 
 ///判断手机是否被注册
 $.validator.addMethod("isMobileExist", function(value,element) {  
     var mobile = $("#mobile").val();  
     return eval(  
         $.ajax({  
             url : "",  
             type : 'GET',  
             async : false,  
             dataType : "json"  
             }).responseText) == false;  
         }, "该手机已经被注册！"  
 );  
 
 //验证开始时间 不能大于结束时间
 jQuery.validator.addMethod("compareDate", function(value, element, param) { 
	 var startDate = jQuery(param).val();  
     
     var date1 = new Date(Date.parse(startDate.replace("-", "/")));  
     var date2 = new Date(Date.parse(value.replace("-", "/")));  
     return date1 < date2;  
 
 });
 
 
 //扩展rules规则  
 jQuery.validator.addClassRules("name", {  
     required: true,  
     minlength: 2  
 });  
 jQuery.validator.addClassRules({  
     name: {  
         required: true,  
         minlength: 2  
     },  
     zip: {  
         required: true,  
         digits: true,  
     }  
 });  