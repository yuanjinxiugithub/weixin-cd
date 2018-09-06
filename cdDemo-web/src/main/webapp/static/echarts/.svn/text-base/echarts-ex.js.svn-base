function ToEcharts(ctrName ,url){
	 var myChart = echarts.init(document.getElementById(ctrName));
	  
	  myChart.showLoading({
		    text:"努力加载中，请稍后",
		    //textColor:"#444",//文本颜色
		   // maskColor:"",//背景色
		    textStyle: { color: '#444' },//设置文本样式
		    effectOption: {backgroundColor: 'rgba(0, 0, 0, 0.2)'}
		});
	  
		   $.ajax({
		     url: url,
		     type: "post",
		     data: { id: '0' },
		     dataType: "text",
		     success: function(msg) {
				  myChart.hideLoading();
			      var obj =$.parseJSON(msg);//string解析成json对象
			      console.log(obj);
			      myChart.setOption(obj);
		     },
		     error: function(XMLHttpRequest, textStatus, errorThrown) {
			  //错误调试
		      // alert(XMLHttpRequest.status);
		      //alert(XMLHttpRequest.readyState);
		     // alert(textStatus);
		     }
		    });
}