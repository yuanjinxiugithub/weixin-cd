//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgUrls:[
    ]
  },
  
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      });
    }

// wx.request 测试
    // wx.request({
    //   url: app.globalData.serverUrl+'/cdNotice/findList.do',
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function (res) {
    //     console.log(res.data)
    //   }
    // });
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  //点名
  redicToArrive:function(e){
    wx.navigateTo({
      url: '../arrive/arrive',
    })
  },
  //点名记录
  redicToArriveRe:function(e){
    wx.navigateTo({
      url: '../arrive/arrive-record',
    });
  },
  // 请假
  redicToLeave: function (e) {
    wx.navigateTo({
      url: '../leave/leave',
    });
  },
  //请假记录
  redicToLeaveRe:function(e){
    wx.navigateTo({
      url: '../leave/leave-record',
    });
  },
  //通知
  redicToNotice: function (e) {
    wx.navigateTo({
      url: '../notice/notice',
    });
  },
  //通知记录
  redicToNoticeRe: function (e) {
    wx.navigateTo({
      url: '../notice/notice-record',
    });
  },

  //用户中心
  redicToUser: function (e) {
    wx.navigateTo({
      url: '../user/user',
    });
  },
  //关于我们
  redicToAbout: function (e) {
    wx.navigateTo({
      url: '../about/about',
    });
  },
})
