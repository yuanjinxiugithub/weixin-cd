const controller = "/cd-demo/cdLeave";

var LeaveList = {
		loadTab :function(){ //加载未审核的列表
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
				  {'data':'className'},
				  {'data':'courseName'},
				  {'data':'coureCode'},
				  {'data':'timeCodeName'},
				  {'data':'teacherCode'},
				  {'data':'teacherName'},
				  {'data':'leaveTime'},
				  {'data':'leaveReason'},
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='javascript:LeaveList.lookImg(\"" + full.fileId + "\");'>查看附件</a>&nbsp;&nbsp;<a href='javascript:LeaveList.updateYes(\"" + data + "\");'>通过</a>&nbsp;&nbsp;<a href='javascript:LeaveList.updateNo(\"" + data + "\");'>不通过</a>"
			                       return actions;
				           }   
					  
				  }
	           ];  
			 var table =  $('#dataTable');//定义获取的table对象	
			 var url =controller+"/findByMap1.do";//定义请求的地址
			 var datas = $("#searchForm").serializeObject();
				 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		
		 reloadTab:function(){
			 var table = $('#dataTable').DataTable();
			    table.destroy();
			    LeaveList.loadTab();
		 },
		 
		 loadTab1:function(){
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
				  {'data':'courseName'},
				  {'data':'coureCode'},
				  {'data':'timeCode'},
				  {'data':'teacherCode'},
				  {'data':'teacherName'},
				  {'data':'leaveTime'},
				  {'data':'leaveReason'},
				  {'data':'stauts',
				  'render':function(data,type,full){ 
				        	 var actions = "";
				        	 if(data=="0"){
				        		 actions="不通过";
				        	 } if(data=="1"){
				        		 actions="通过";
				        	 }
			                       return actions;
			        }
				  },
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='javascript:LeaveList.lookImg(\"" + full.fileId + "\");'>查看附件</a>&nbsp;&nbsp;"
			                       return actions;
				           }   
					  
				  }
	           ];  
			 var table =  $('#dataTable1');//定义获取的table对象	
			 var url =controller+"/findByMap.do";//定义请求的地址
			 var datas = $("#searchForm").serializeObject();
				 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		
		 reloadTab1:function(){
			 var table = $('#dataTable1').DataTable();
			    table.destroy();
			    LeaveList.loadTab1();
		 },
		 
		 searchTab:function() { //查询
			 LeaveList.reloadTab();
			 LeaveList.reloadTab1();
		 },
		 
		lookImg:function(fileId){ //查看附件
			 var datas = {id:fileId};
			 var url = "/fileOp/get.do";
				 Mes.loadJson(url, $.param(datas), function(results) {
					window.open("/cd-demo/imgs/"+results.fileName);
				 }); 
		},
		
		updateYes:function(id){//通过
			 var datas = {id:id,stauts:'1'};
			 var url = "/cdLeave/updateStatus.do";
				 Mes.loadJson(url, $.param(datas), function(results) {
					 console.log(results);
					 LeaveList.searchTab();
					
				 }); 
			
		},
		
		updateNo:function(id){//不通过
			 var datas = {id:id,stauts:'0'};
			 var url = "/cdLeave/updateStatus.do";
				 Mes.loadJson(url, $.param(datas), function(results) {
					 console.log(results);
					LeaveList.searchTab();
				 }); 
		},
		
	};