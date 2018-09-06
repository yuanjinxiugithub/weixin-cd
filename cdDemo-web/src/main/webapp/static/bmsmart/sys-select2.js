
//进行绑定
function bindSelect(ctrName){
	var selector = $("."+ctrName);
	selector.select2({
		  language: "zh-CN", 
	});
}

//绑定下拉框到指定的控件上--getJson 数据绑定
function bindSelect(ctrName,url){
	var selector = $("."+ctrName);
	//设置selet2的处理  简单的配置参数
	selector.select2({
		 placeholder:"请选择"
		// allowClear: true,//是否允许清除图标
        //formatResult: formatResult,//函数用于呈现当前的选择
        //formatSelection: formatSelection,///函数用于呈现当前的选择
       // formatSearching:"正在搜索",//字符串包含“搜索… “消息,或函数用于呈现显示的消息 正在进行搜索。
       // formatAjaxError:"加载失败",//	字符串包含消息“加载失败”,或 函数用于呈现信息
        //initSelection:initSelection,//调用Select2创建允许用户初始化选择的值 select2附加到元素
        //query:query,//函数用于搜索词的查询结果。
	});
	
	//绑定getJson的内容
	$.getJSON(url,function(data){
		selector.empty();//清空下拉框
		$.each(data,function(i,item){//循环绑定
			selector.append("<option value='" + item.Value + "'>&nbsp;" + item.Text + "</option>");
		});
	});
}

//允许选择多个值
function bindSelectMultiple(ctrName){
	var selector = $("."+ctrName);
	selector.select2({
		multiple:true
	});
}

//允许选择多个值--getJson请求
function bindSelectMultiple(ctrName,url){
	var selector = $("."+ctrName);
	selector.select2({
		multiple:true,
		closeOnSelect:false,//是否收起下拉框
	});
	$.getJSON(url,function(data){
		selector.empty();//清空下拉框
		$.each(data,function(i,item){//循环绑定
			selector.append("<option value='" + item.Value + "'>&nbsp;" + item.Text + "</option>");
		});
	});
}

//使用 内置ajax对象 请求查询 数据 并返回
function bindSelectAjax(ctrName,url){
	var selector = $("."+ctrName);
	selector.select2({
	placeholer:"输入格式",
	minimumInputLength:2,//至少输入n个字符，才去加载数据
    ajxa:{
    	url:url,
    	dataType:'json',//接受数据的格式
    	data:function(params){//在查询时，向服务器端传递的数据
    		return {
    			q: params.term,
    		};
    	},
    	 processResults: function (data) {
		      return {
		        results: data
		      };
		 },
	    templateSelection:function(){
	    	//选中项回调
	    },
	    processResults:function(){
	    	//返回数据
	    }
    },
    initSelection:function(element,callback){  //初始化，其中doName是自定义的一个属性，用来存放text的值
       var id=$(element).val();
       var text=$(element).attr("doName");
       if(id!=''&&text!=""){
             callback({id:id,text:text});
       }
	},
	formatResult: formatAsText	//渲染查询结果项
	});
}



//使用数组  数组格式id和text属性是必需的每个对象 进行加载
function arrayDataLoad(ctrName,data){
	$("."+ctrName).select2({
		data:data
	});
}


//获取单行选中值 并返回一条数据对象	
function getSelectValue(ctrName){
	return $("."+ctrName).select2("data")[0];
}
//获取多行选中值 并返回数组对象
function getSelectMulti(ctrName){
	return $("."+ctrName).select2("data");
}