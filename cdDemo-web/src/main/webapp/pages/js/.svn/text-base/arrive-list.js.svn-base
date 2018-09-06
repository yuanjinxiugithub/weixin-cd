const controller = "/cd-demo/cdCourse";

var ArriveList = {
		loadTab :function(){
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'scheduleCode'},
				  {'data':'courseName'},
				  {'data':'coureCode'},
				  {'data':null,
					  'render':function(data,type,full){
						  return "必修";
					  }
				  },
				  {'data':'className'},
				  {'data':'timeCode'},
				  {'data':'teacherCode'},
				  {'data':'teacherName'},
				  {'data':'arriveTime'},
				  {'data':'allNum'},
				  {'data':'arriveNum'},
				  {'data':'leaveNum'},
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='arrive-detail.html?id="+full.id+"&classCode="+full.classCode+"'>查看详情</a>"
			                       return actions;
				           }   
					  
				  }
	           ];  
			 var table =  $('#dataTable');//定义获取的table对象	
			 var url =controller+"/findByMap.do";//定义请求的地址
			 var datas = $("#searchForm").serializeObject();
				 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
		},
		
		 reloadTab:function(){
			 var table = $('#dataTable').DataTable();
			    table.destroy();
			    ArriveList.loadTab();
		 },
		 
		 searchTab:function() {
			 ArriveList.reloadTab();
		 },
		 
	};