var Demo = {
		/**
		 * @description 异步上传文件 dropzone
		 * 这是一个方法描述
		 * @param {String} url 请求地址(不带域名)
		 * @param {String} selector 绑定的选择器
		 * @param {function} successCallback ajax请求成功的回调函数
		 */
	upDropzone:function(selector,url,successCallback,removeCallback){
		   Dropzone.autoDiscover = false;
		 $(selector).dropzone({ 
			 url: url,
			 maxFiles:1,
			 addRemoveLinks: true,/* 这将添加一个链接到每个文件预览 以删除或取消（如果已经上传）该文件 */
			 method: 'post',
			 filesizeBase: 1024,
		     sending: function(file, xhr, formData) {
			     formData.append("filesize", file.size);
			     console.log(formData);
			    },
			 acceptedFiles: ".apk,.js",/* 上传文件的类型 */
		     success:successCallback,
		     removedfile:removeCallback,/*function(file){//删除事件
		    	 console.log(file);
		    	 console.log("File " + file.name + "removed");
		    	 if (!file.serverId) { return; } // The file hasn't been uploaded
		    	//  $.post("delete-file.php?id=" + file.serverId); // Send the file id along
		     }*/
			   });
    }
}