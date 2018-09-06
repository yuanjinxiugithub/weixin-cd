const controller = "/cd-demo/fileOp";
var FileList = {
		loadTab :function(){
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'fileName'},
				  {'data':'filePath'},
				  {'data':'createTime'},
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='javascript:FileList.deleteItem(\"" + data + "\");'>删除 </a>" +
				        	 		"<a href='javascript:FileList.lookItem(\"" + full.fileName + "\");'>查看</a>"
			                       return actions;
				           }   
					  
				  }
	           ];  
			 var table =  $('#dataTable');//定义获取的table对象	
			 var url =controller+"/findByMap.do";//定义请求的地址
				 datatable = DataTablePack.serverTable(table,url,{},columns,[]);
		},
		
		reloadTab:function(){ //重新加载tab
			 var table = $('#dataTable').DataTable();
			    table.destroy();
			    FileList.loadTab();
		},
		
		deleteItem:function(id){
			 var datas = {id:id};
			 var url = "/fileOp/delete.do";
			 sysConfirm('确定删除该条记录？', function() {
				 Mes.loadJson(url, $.param(datas), function(results) {
					 sysAlert(results.msg,function(){
						 closeAlert();
						 FileList.reloadTab();// 重新加载tab
					 });
				 }); 
			 });
		},
		lookItem:function(fileName){
			window.open("/cd-demo/imgs/"+fileName);
		}
};