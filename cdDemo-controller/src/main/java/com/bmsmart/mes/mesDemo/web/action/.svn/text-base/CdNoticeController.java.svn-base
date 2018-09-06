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
import com.bmsmart.mes.mesDemo.domain.po.CdNoticeInfo;
import com.bmsmart.mes.mesDemo.service.CdNoticeService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/3/4
 *  通知列表
 */
@Controller
@RequestMapping(value="/cdNotice")
public class CdNoticeController extends BaseController{

	 @Autowired 
	 private CdNoticeService  cdNoticeService;
	 
	   /**
	  	 * 分页查询--查询达到的学生列表 根据arriveId(分页)
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMap")
	  	public DataTablePage<CdNoticeInfo> findPage(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		DataTablePage<CdNoticeInfo> dataTable = new DataTablePage<CdNoticeInfo>(request);
	  		// 开始分页：PageHelper会处理接下来的第一个查询
	  		PageInfo<CdNoticeInfo> pageInfo = cdNoticeService.findPage(dataTable.getPage_num(),
	  				dataTable.getPage_size(), datas);
	  		dataTable = dataTable.convert(dataTable, pageInfo);
	  		return dataTable;
	  	}
	  	
	  	/**
	  	 * 分页查询--查询达到的学生列表 根据arriveId(分页)
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMapApp")
	  	public PageInfo<CdNoticeInfo> findPageApp(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		PageInfo<CdNoticeInfo> pageInfo = cdNoticeService.findPage(Integer.parseInt(datas.get("pagseNums")),Integer.parseInt(datas.get("pagseSize")), datas);
	  		return pageInfo;
	  	}
	      
	  	/**
	  	 * 数据查询 --查询达到的学生列表
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findList")
	  	public List<CdNoticeInfo> findList(CdNoticeInfo entity,HttpServletRequest request, HttpServletResponse response){
	  		return cdNoticeService.findList(entity);
	  	}
	  	
	  	 /**
	  	 * 删除信息 --删除达到的学生信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/delete")
	  	public ModelAndView delete(CdNoticeInfo entity){
	  		AjaxResponder result = null;
	  		entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
	  		try {
	  			cdNoticeService.delete(entity);
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
	  	 * 新增 --新增一条学生的达到信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping(value = "/add")
	  	public ModelAndView add(CdNoticeInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setId(UUID.getUUID());
	  		entity.setCreateTime(new Date());
	  		entity.setCreateUser("admin");
	  		entity.setNoticeTime(new Date());
	  		try {
	  			cdNoticeService.save(entity);
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
	  	 * 修改 --更新一条学生的达到信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping(value = "/update")
	  	public ModelAndView update(CdNoticeInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setUpdateTime(new Date());
	  		entity.setUpdateUser("admin");
	  		try {
	  			cdNoticeService.update(entity);
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
		public CdNoticeInfo getById(@RequestParam(required = false) String id) {
			return cdNoticeService.get(id);
		}
}
