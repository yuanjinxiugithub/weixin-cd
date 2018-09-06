package com.bmsmart.mes.mesDemo.web.api;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bmsmart.mes.base.util.StringUtil;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;
import com.bmsmart.mes.mesDemo.service.SysUserService;
import com.bmsmart.mes.mesDemo.web.util.HttpUtil;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2018年3月30日 下午9:46:09 类说明
 */
@Controller
@RequestMapping(value = "/api/platform")
public class PlatFormApiController extends BaseController {
	private static String OPEN_ID = "wx3c27ec8be19ecccf";
	private static String APP_SERCET = "a3216bdeefb2fb20f0829e7884204939";
	private static String WX_URL = "https://api.weixin.qq.com/sns/jscode2session";
	private static String GRANT_TYPE = "authorization_code";
	private String params = "appid=" + OPEN_ID + "&secret=" + APP_SERCET + "&grant_type=" + GRANT_TYPE;
	
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 判断是否绑定
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isBind")
	public AjaxResponder isBind(HttpServletRequest request, HttpServletResponse response) {
		AjaxResponder results = null;
		Map<String, String> datas = WebUtil.request2Map(request);
		SysUserInfo userInfo = new SysUserInfo();
		String code = datas.get("code");
		String openId = datas.get("openId");
	    String resposeData = "";
	    String userOpenId = "";
	    String sessionKey = "";
	    String errorMsg = "";
		System.out.println(code+"|"+openId);
		params += "&js_code=" + code;
		userOpenId = openId;
		System.out.println(StringUtil.isBlank(openId));
		System.out.println(openId.equals("")||openId.equals(null) || openId.equals("null"));
		if (openId.equals("")||openId.equals(null) || openId.equals("null")) {
			resposeData = HttpUtil.get(WX_URL, params);
			JSONObject json = JSON.parseObject(resposeData);
			userOpenId = (String) json.get("openid");
			sessionKey  = (String) json.get("session_key");
			errorMsg = (String) json.get("errmsg");
			System.out.println(userOpenId);
		}
		if (StringUtil.isNotBlank(userOpenId)) {
			userInfo = getByOpenId(userOpenId);// 根据用户openid 获取用户绑定信息
			if (StringUtil.isNotBlank(userInfo.getId())) { // 已经绑定了账号 直接进入主页
				results = AjaxResponder.getInstance(Boolean.TRUE, "已经绑定,获取绑定信息成功! ", userInfo);
			} else {// 没有绑定
				results = AjaxResponder.getInstance(Boolean.FALSE, "没有绑定账号！",userOpenId);
			}
		} else {
			results = AjaxResponder.getInstance(Boolean.FALSE, "获取用户唯一标识失败! ", null);
		}
		
		return results;
	}

	/**
	 * 通过openId 获取绑定的用户信息
	 * 
	 * @param openId
	 * @return 返回用户信息
	 */
	@ResponseBody
	@RequestMapping("/getByOpenId")
	public SysUserInfo getByOpenId(String openId) {
		System.out.println(openId);
		SysUserInfo entity = null;
		try {
			entity = sysUserService.getByOpenId(openId);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new SysUserInfo();
		}
		if (entity == null) {
			entity = new SysUserInfo();
		}
		return entity;
	}

	/**
	 * 绑定用户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bind")
	public AjaxResponder bind(HttpServletRequest request, HttpServletResponse response) {
		AjaxResponder results = null;
		Map<String, String> datas = WebUtil.request2Map(request);
		SysUserInfo userInfo = new SysUserInfo();
		String openId = datas.get("openId");
		String userId = datas.get("userId");
		System.out.println(userId);
		String pwd = datas.get("pwd");
		System.out.println(openId+"/"+userId+"|"+pwd);

		if (StringUtil.isNotBlank(userId) && StringUtil.isNotBlank(pwd)) {
			userInfo = getByUserId(userId);// 根据用户openid 获取用户绑定信息
			if (StringUtil.isNotBlank(userInfo.getId())) {
				if (userInfo.getPwd().equals(pwd)) {
					SysUserInfo updateEntity = new SysUserInfo();
					updateEntity.setUpdateTime(new Date());
					updateEntity.setUpdateUser("admin");
					updateEntity.setOpenId(openId);
					updateEntity.setUserId(userId);
					if (sysUserService.update(updateEntity) == 1) {
						userInfo = getByUserId(userId);
						results = AjaxResponder.getInstance(Boolean.TRUE, "绑定成功", userInfo);
					} else {
						results = AjaxResponder.getInstance(Boolean.FALSE, "绑定失败", userInfo);
					}

				} else {
					results = AjaxResponder.getInstance(Boolean.FALSE, "账号密码不匹配! ", null);
				}
			} else {
				results = AjaxResponder.getInstance(Boolean.FALSE, "账号不存在! ", null);
			}
		} else {
			results = AjaxResponder.getInstance(Boolean.FALSE, "请输入账号,密码! ", null);
		}
		return results;
	}

	/**
	 * 通过userId 获取用户信息
	 * 
	 * @param openId
	 * @return 返回用户信息
	 */
	@ResponseBody
	@RequestMapping("/getByUserId")
	public  SysUserInfo getByUserId(String userid) {
		System.out.println(userid);
		SysUserInfo entity = null;
			try {
				entity = sysUserService.getByUserId(userid);
			} catch (Exception e) {
				// TODO: handle exception
				entity = new SysUserInfo();
			}
			System.out.println(entity);
		if (entity == null) {
			entity = new SysUserInfo();
		}
		return entity;
	}
	

	
	
	
	
}
