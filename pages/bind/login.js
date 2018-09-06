//login.js
//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultSize: 'default',
    disabled: false,
    plain: false,
    loading: false,
    userId:'',
    password:'',
    userRole:''
  },
  
  setDisabled: function (e) {
    this.setData({
      disabled: !this.data.disabled
    });
  },
  // 获取输入账号
  phoneInput:function(e){
    this.setData({
      userId:e.detail.value
    });
  },
  // 获取输入密码
  passwordInput:function(e){
    this.setData({
      password: e.detail.value
    });
  },
  //获取输入  身份
  radioChange:function(e){
    this.setData({
      userRole: e.detail.value
    });
  },
// 登录
  login:function(){
    //this.data.userId.length == 0 || this.data.password.length == 0 || this.data.userRole.length             == 0
    if (this.data.userId.length != 0){
      wx.showToast({
        title: '绑定账号失败！',
        icon: 'loading',
        duration: 2000
      });    
    }else{ 
        wx.showToast({
          title: '绑定账号成功！',
          icon: 'success',
          duration: 2000,
        });  
        //这里修改跳转的地址
        // wx.switchTab({
        //   url: '/pages/index/index'
        // });
        wx.redirectTo({
          url: '/pages/index/index',
        })
    }
  },
})
