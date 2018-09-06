$(function(){  
	var columns = [  
	 
	    {'data':'id'},  
	    {'data':'name'},  
	    {  
	        'data':null,  
	        'render':function(data,type,full){  
	            var content = '<a href="javascript:;" class="btn default btn-xs purple">';  
	                content += '<i class="fa fa-edit"></i> Edit </a>';  
	            return content;  
	        }  
	    }  
	];  
	var url="http://127.0.0.1:8080/mes-demo/datatablesTest.do";
    var table = $('#demoTable');  
	var reqData = {"menu.name":"admin","menu.url":"123456"};  
	DataTablePack.serverTable(table,url,reqData,columns,1);  
});  

var Demo = {
	currentItem : null,
	showItemDetail : function(item) {
		$("#demo-view").show().siblings(".info-block").hide();
		if (!item) {
			$("#user-view .prop-value").text("");
			return;
		}
		$("#name-view").text(item.name);
		$("#position-view").text(item.position);
		$("#salary-view").text(item.salary);
		$("#start-date-view").text(item.start_date);
		$("#office-view").text(item.office);
		$("#extn-view").text(item.extn);
		$("#role-view").text(item.role?"管理员":"操作员");
		$("#status-view").text(item.status?"在线":"离线");
	},
	addItemInit : function() {
		$("#form-add")[0].reset();
		$("#user-add").show().siblings(".info-block").hide();
	},
	editItemInit : function(item) {
		if (!item) {
			return;
		}
		$("#form-edit")[0].reset();
		$("#title-edit").text(item.name);
		$("#name-edit").val(item.name);
		$("#position-edit").val(item.position);
		$("#salary-edit").val(item.salary);
		$("#start-date-edit").val(item.start_date);
		$("#office-edit").val(item.office);
		$("#extn-edit").val(item.extn);
		$("#role-edit").val(item.role);
		$("#user-edit").show().siblings(".info-block").hide();
	},
	addItemSubmit : function() {
		$.dialog.tips('保存当前添加信息');
	},
	editItemSubmit : function() {
		$.dialog.tips('保存当前编辑信息');
	},
	deleteItem : function(selectedItems) {
		var message;
		if (selectedItems&&selectedItems.length) {
			if (selectedItems.length == 1) {
				message = "确定要删除 '"+selectedItems[0].name+"' 吗?";
				
			}else{
				message = "确定要删除选中的"+selectedItems.length+"项记录吗?";
			}
			$.dialog.confirmDanger(message, function(){
				$.dialog.tips('执行删除操作');
			});
		}else{
			$.dialog.tips('请先选中要操作的行');
		}
	},
	  
	 search:function()  
	{  
	    table.ajax.reload();  
	}  
};