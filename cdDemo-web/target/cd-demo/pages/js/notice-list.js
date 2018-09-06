const controller = "/cd-demo/cdNotice";

var NoticeList = {
	
		loadTab :function(){
		 var columns=[
			  {
	    	 	 "data": null,
	    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
	    		 var startnum = this.api().page() * (this.api().page.info().length);
	    		 $(nTd).html(iRow + 1 + startnum); 
	             }
			  },
			  {'data':'courseName'},
			  {'data':'courdeCode'},
			  {'data':'noticeType'},
			  {'data':'noticeContent'},
			  {'data':'acceptPerson'},
			  {'data':'noticePerson'},
			  {'data':'noticeTime'},
			  {'data':'id',
				  'render':function(data,type,full){ 
			        	 var actions = "<a href='javascript:NoticeList.updateInfo(\"" + data + "\");'>查看附件</a>&nbsp;&nbsp;"
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
		    Teacher.loadTab();
	 },
	 
	 searchTab:function() {
		   Teacher.reloadTab();
	 },
	 
};