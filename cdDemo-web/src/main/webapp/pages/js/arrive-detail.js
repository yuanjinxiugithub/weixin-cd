const controller = "/cd-demo/cdArrive";

var ArriveDetail = {
		 loadMainForm:function(){//加载课程信息
			 var id = Mes.getUrlParam("id");
			 var url = "/cdCourse/get.do";
			 var datas = {id:id};
			 Mes.loadJson(url,$.param(datas), function(results) {
				 $("#mainForm").setForm(results);
				});
		 },
		 
		loadTab :function(){//加载达到的学生列表
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'studentName'},
				  {'data':'studentCode'},
				  {'data':'classCode'},
				  {'data':'className'},
				  {'data':'instCode'},
				  {'data':'arriveTime'}
	           ];  
			 var table =  $('#dataTable');//定义获取的table对象	
			 var url =controller+"/findByMap.do";//定义请求的地址
			 var datas = {arriveId:Mes.getUrlParam("id")};
				 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		 
		
		loadTab1 :function(){//加载未达到的学生列表
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'studentName'},
				  {'data':'studentCode'},
				  {'data':'classCode'},
				  {'data':'className'},
				  {'data':'instCode'},
	           ];  
			 var table =  $('#dataTable1');//定义获取的table对象	
			 var url =controller+"/findByMap1.do";//定义请求的地址
			 var datas = {arriveId:Mes.getUrlParam("id")};
			     datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		
		
		loadTab2 :function(){//加载达到的学生列表
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'studentName'},
				  {'data':'studentCode'},
				  {'data':'studentClass'},
				  {'data':'className'},
				  {'data':'leaveTime'},
				  {'data':'stauts'},
				  {'data':'leaveReason'},
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='arrive-detail.html?id="+full.id+"&classCode="+full.classCode+"'>查看附件</a>"
			                       return actions;
				           }   
					  
				  }
	           ];  
			 var table =  $('#dataTable2');//定义获取的table对象	
			 var url ="/cd-demo/cdLeave"+"/findByMapLeave.do";//定义请求的地址
			 var datas = {leaveId:Mes.getUrlParam("id")};
				 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		
	};