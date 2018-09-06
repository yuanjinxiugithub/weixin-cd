package com.bmsmart.mes.mesDemo.web.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmsmart.mes.base.util.UUID;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.commons.web.datatables.DataTablePage;
import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;
import com.bmsmart.mes.mesDemo.service.SysUserService;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 :yjx
* @version 创建时间：2018年3月22日 下午4:24:58
* 类说明  用户登录信息
*/
@Controller
@RequestMapping(value="/sysUser")
public class SysUserController extends BaseController {
	    @Autowired 
		private SysUserService sysUserService;
	 
	     /**
		 * 分页查询
		 */
		@ResponseBody
		@RequestMapping("/findByMap")
		public DataTablePage<SysUserInfo> findPage(HttpServletRequest request, HttpServletResponse response){
			Map<String, String> datas = WebUtil.request2Map(request);
			// 使用DataTables的属性接收分页数据
			DataTablePage<SysUserInfo> dataTable = new DataTablePage<SysUserInfo>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageInfo<SysUserInfo> pageInfo = sysUserService.findPage(dataTable.getPage_num(),
					dataTable.getPage_size(), datas);
			dataTable = dataTable.convert(dataTable, pageInfo);
			return dataTable;
		}
	    
		/**
		 * 数据查询
		 */
		@ResponseBody
		@RequestMapping("/findList")
		public List<SysUserInfo> findList(SysUserInfo entity,HttpServletRequest request, HttpServletResponse response){
			return sysUserService.findList(entity);
		}
		
		 /**
		 * 删除信息
		 */
		@ResponseBody
		@RequestMapping("/delete")
		public ModelAndView delete(SysUserInfo entity){
			AjaxResponder result = null;
			entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
			try {
				sysUserService.delete(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "删除信息成功! ", null);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("delete 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 新增信息
		 */
		@ResponseBody
		@RequestMapping(value = "/add")
		public ModelAndView add(SysUserInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setId(UUID.getUUID());
			entity.setCreateTime(new Date());
			entity.setCreateUser("admin");
			try {
				sysUserService.save(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "新增信息成功! ", null);
			} catch (Exception e) {
				logger.error("insert 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 修改信息
		 */
		@ResponseBody
		@RequestMapping(value = "/update")
		public ModelAndView update(SysUserInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				sysUserService.update(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "更新信息成功! ", null);
			} catch (Exception e) {
				logger.error("update 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 解除绑定
		 */
		@ResponseBody
		@RequestMapping(value = "/remove")
		public ModelAndView remove(SysUserInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				sysUserService.remove(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "解除绑定成功! ", null);
			} catch (Exception e) {
				logger.error("update 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		@ResponseBody
		@RequestMapping(value = "/updateInfo")
		public ModelAndView updateUserInfo(SysUserInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				sysUserService.updateUserInfo(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "更新信息成功! ", null);
			} catch (Exception e) {
				logger.error("update 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 根据id 获取信息
		 */
		@RequestMapping(value = "/get")
		@ResponseBody
		public SysUserInfo getById(@RequestParam(required = false) String id) {
			return sysUserService.get(id);
		}
		
		
		/**  根据用户userId获取用户信息
		 * @param userid
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getByUserId")
		public  SysUserInfo getByUserId(@RequestParam(required = true) String userid) {
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
