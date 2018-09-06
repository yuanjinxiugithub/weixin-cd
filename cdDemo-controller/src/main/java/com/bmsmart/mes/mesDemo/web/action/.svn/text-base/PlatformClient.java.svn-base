/** 
 * (C) Copyright 2017 BBMSmart(beijing) Co., Ltd  
 * All Rights Reserved. 
 **/
package com.bmsmart.mes.mesDemo.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmsmart.mes.base.util.StringUtil;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;
import com.bmsmart.mes.mesDemo.service.SysUserService;
/**
 * @author yjx
 *  平台登录
 */
@Controller
@RequestMapping(value="/platForm")
public class PlatformClient extends BaseController{
	   @Autowired
	   private SysUserService sysUserService;
	
	    @ResponseBody
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public AjaxResponder login(HttpServletRequest request, HttpServletResponse response) {
	        AjaxResponder result = null;
	        SysUserInfo entity = null;
	        Map<String, String> datas = WebUtil.request2Map(request);
	        String userId = datas.get("userId");
	        String password = datas.get("password");
	        if (StringUtil.isNotBlank(userId) && StringUtil.isNotBlank(password)) {
	        	entity = sysUserService.getByUserId(userId);
	        	if (entity == null) {
	    			entity = new SysUserInfo();
	    		}
	        	System.out.println(entity);
	            if (password.equals(entity.getPwd())) {
	                result = AjaxResponder.getInstance(Boolean.TRUE, "登陆成功!", entity);
	            } else {
	                result = AjaxResponder.getInstance(Boolean.FALSE, "登陆失败，账号或密码错误", null);
	            }
	        } else {
	            result = AjaxResponder.getInstance(Boolean.FALSE, "登陆失败,登陆名、密码必填!", null);
	        }
	        return result;
	    }
	
}
