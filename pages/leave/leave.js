// // pages/leave/leave.js
Page({
  data: {
    array: ['请选择','数据挖掘', '算法设计', '课程设计', 'java程序设计'],
    index:0,
    imgSrc: '/imgs/z_add.png'  ,//图片路径
  },
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },

//获取文件并上传到服务器
  chooiceImg:function(e){
    var _this = this; 
    //从本地选择图片或者使用相机进行拍照
  wx.chooseImage({
    count:1,
    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有  
    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有  
    success: function(res) {//成功则返回图片的本地文件路径
      console.log(res);
      // _this.setData({
      //   imgSrc:res.tempFilePaths
      //   });
      console.log(_this.data.imgSrc);
        //获取文件成功之后进行上传
    
    },
    fail:function(){
      wx.showToast({
        title: '获取图片失败',
        icon: 'loading',
        duration: 1000
      });    
    }
  });
  },
  
  //提交表单数据
  formSubmit:function(){
  console.log("表单提交中");
  },
  //重置表单数据
  formReset:function(){
    this.setData({});  //数据设置为空。
    console.log("表单数据清空中");
  },
})