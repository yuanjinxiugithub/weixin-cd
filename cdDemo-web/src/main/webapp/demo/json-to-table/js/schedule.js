    //获取date 时间
	    	var mydate=new Date();
			var thisyear=mydate.getFullYear();
			var thismonth=mydate.getMonth()+1;
			var thisday=mydate.getDate();
			var today_day=thisday; 
			var weekArr=['日','一','二','三','四','五','六'];
			
			////取得当前日期的下个月的第一天的前一天的日子；即这个月的最后一天的日子 每个月的天数
			var getdaysinonemonth=function(year,month){
				month=parseInt(month);
			var d=new Date(year,month,0);
			  return d.getDate();
		   };
		   
	
			   /*算某个月的某天是星期几*/
			var getday=function(year,month,day){             
				month=month-1;
				var d=new Date(year,month,day);
				return d.getDay();
			}
	    	//填充table  days--月天数 weekday第一天是星期几
	    	function setcalender(days){
	    		  clear_day();//清除数据
	    		 //设置天数
	    		var  $tr_day =$("#day");
	    		for(var i=1;i<=days;i++)
	    		{
	    			var $td ='<td>'+i+'</td>';
	    			$tr_day.append($td);
	    		}
	    		//设置星期与天数一一对应
	    		$("#weekday").append('<td rowspan="2">部门</td>');
	    		$("#weekday").append('<td rowspan="2">日期</td>');
	    		
	    		for(var i=1;i<=days;i++){
	    		   var k=getday(thisyear,thismonth,i);//获取星期几
	    		  $("#weekday").append('<td>'+weekArr[k]+'</td>');
	    		 }
	    		$("#weekday").append('<td rowspan="2">班次</td><td rowspan="2">盘存工作日</td><td rowspan="2">自然月工作日</td>');
	    	    
	    	    for(var i=days;i<31;i++)
	    	    {
	    	    	$("#weekday").append('<td rowspan="2"></td>');
	    	    }  
	    	    
	    	}
	    	
				//清除td
		     function clear_day()
		     {
		     	$("#day td").remove(); 
		     	$("#weekday td").remove();  
		     }