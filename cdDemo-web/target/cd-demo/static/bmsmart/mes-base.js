//针对jQuery发出的ajax进行全局设置
var _basePath = "/cd-demo"; 
var layerIndex = -1;//layer loading弹出层代码
var latCnt = 0;//ajax服务个数
var loginDataScopeName=''
$.ajaxSetup({
			beforeSend:function(){
				//this.layerIndex = layer.load("");
				 //alert(this.url);
				if (layerIndex == 1){
					var contentData = '<span style="margin-left:-20px"><strong>数据加载中...</strong></span>';
					//var contentData2 = '<span style="margin-left:-50px"><strong>加载中</strong></span>';
					layerIndex= layer.load(2,{content:contentData,time: 10*1000,success: function(layero){
						layero.find('.layui-layer-content').css('padding-top', '40px');
						layero.find('.layui-layer-content').css('width', '100px');
						}});
				}
				latCnt++;
				//alert("cntstart:"+latCnt);
			},
			complete: function () {
				window.setTimeout(function(){
					latCnt--;
					//alert("cntend:"+latCnt);
					if (latCnt == 0){
						layer.close(layerIndex);
						layerIndex = -1;
					}
				},500);
			},
			error:function(request, status, error){
				//alertMsg.error("与服务器交互发生错误！");
				layer.alert('部分数据加载失败，可能会导致页面显示异常，请刷新后重试', {
					skin: 'layui-layer-molv'
				   , closeBtn: 0
				   , shift: 4 //动画类型
				});
			}
		});

var Mes = {
		//使用ajax的方式加载远程数据
		loadScript:function(argUrl,reqDatas,callback){
			radomT="?_v="+(new Date()).getTime();
			var url=_basePath+argUrl+radomT;
			reqDatas+="&_dt=script&_cb="+callback;
			jQuery.ajax({ url:url, type:"POST", async:true, dataType:"script",data:reqDatas});
		},
		loadJson:function(argUrl,reqDatas,succCallBack,errorCallback){
			radomT="?_v="+(new Date()).getTime();
			var url=_basePath+argUrl+radomT;
			reqDatas+="&_dt=json";
			jQuery.ajax({ url:url, type:"POST", async:true, dataType:"json",data:reqDatas,success:succCallBack,error:errorCallback});
		},
		loadModal:function(){ 
			 jQuery("<img src='"+_basePath+"/images/logo.jpg'>").modal({
                escClose:false,  
                close:true,
                overlayCss: {backgroundColor:"dimgrey"},
                zIndex:"9999999"
            });
        },
        closeModal:function(){
        	jQuery.modal.close();
        },
        //处理数据，加载jstemplate模板
		processTemplateData: function(show,templateId,data){
            jQuery(show).setTemplateElement(templateId).processTemplate(data); 
		},
		displayPager:function(continer,currPageNo,pageCount,clickHandler){
			$(continer).pager({ pagenumber: currPageNo, pagecount: pageCount, buttonClickCallback: clickHandler });
		},
		//获取url参数中指定名称的取值
        getUrlParam:function(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r!=null) return unescape(r[2]); return null;
		},
		getHashParam : function(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.hash.substr(1).match(reg);
			if (r!=null) return unescape(r[2]); return null;
		},
		//将key=val&key=val&...转为json对象
		params2Json : function(data){
			var ret = {};
		    data.substr(1).replace(/([\w.]+)=([\w.]+)/ig, function(a, b, c){ret[b] = unescape(c);console.log("a="+a+";b="+b+";c="+c)});  
		    return ret; 
		},
		//将url中的参数转为json对象
		getUrlParamsJson : function(){
			return Mes.params2Json(window.location.search);
		},
		getHashParamsJson : function(){
			return Mes.params2Json(window.location.hash);
		},
		/**
		 * 使用正则表达式验证是否匹配规则
		 * @param regexp ： 正则表达式
		 * @param data ： 待验证的数据
		 * @return true / false
		 */
		regexpTest : function(regexp , data){
			return regexp.test(data);
		},
		regexp : {
			mobile : /1[3|5|7|8|][0-9]{9}/ , 
			email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
		}
};

/**
 * 扩展JQuery表单数据搜集 将一个表单的数据返回成JSON对象
 */
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
				if (o[this.name]) {
					if (!o[this.name].push) {
						o[this.name] = [o[this.name]];
					}
					o[this.name]
							.push(this.value === 0 ? 0 : (this.value || ''));
				} else {
					o[this.name] = this.value === 0 ? 0 : (this.value || '')
				}
			});
	return o;
};

// 页面初始化加载
$(document).ready(function() {
	$(".rightmenulink a").click(function(e){
		$(".rightmenu").addClass("rightmenushow");
		var v_id = $(e.target).attr('id');
		$("a.top").css("right","200px");
	})
	$(".topmenu a").click(function(){
		$(".topmenu a").removeClass("show");
		$(this).addClass("show");
	})
	$("frame").load(function () {
        var mainheight = $(this).contents().find("body").height();
        $(this).height(mainheight);
        $(this).contents().click(function () {
            $(parent.document).trigger('click');
        });
    });
	$(document).bind("click",function(e){ 
		var target = $(e.target); 
		if(target.closest(".rightmenu").length == 0){ 
			$(".rightmenu").removeClass("rightmenushow");
			$("a.top").css("right","0px");
		} 
	})
})

