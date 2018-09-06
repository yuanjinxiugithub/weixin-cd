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
import com.bmsmart.mes.mesDemo.domain.po.CdLeaveDetailInfo;
import com.bmsmart.mes.mesDemo.service.CdLeaveService;
import com.github.pagehelper.PageInfo;


/**
 * @author yjx  请假controller
 *
 */
@Controller
@RequestMapping(value="/cdLeave")
public class CdLeaveController extends BaseController {

	@Autowired 
	 private CdLeaveService  cdLeaveService;
	
	/**
  	 * 分页查询--已经审核的
  	 */
  	@ResponseBody
  	@RequestMapping("/findByMap")
  	public DataTablePage<CdLeaveDetailInfo> findPage(HttpServletRequest request, HttpServletResponse response){
  		Map<String, String> datas = WebUtil.request2Map(request);
  		DataTablePage<CdLeaveDetailInfo> dataTable = new DataTablePage<CdLeaveDetailInfo>(request);
  		// 开始分页：PageHelper会处理接下来的第一个查询
  		PageInfo<CdLeaveDetailInfo> pageInfo = cdLeaveService.findPage(dataTable.getPage_num(),
  				dataTable.getPage_size(), datas);
  		dataTable = dataTable.convert(dataTable, pageInfo);
  		return dataTable;
  	}
  	
  	/**
  	 * 分页查询--没有审核的
  	 */
  	@ResponseBody
  	@RequestMapping("/findByMap1")
  	public DataTablePage<CdLeaveDetailInfo> findPage1(HttpServletRequest request, HttpServletResponse response){
  		Map<String, String> datas = WebUtil.request2Map(request);
  		DataTablePage<CdLeaveDetailInfo> dataTable = new DataTablePage<CdLeaveDetailInfo>(request);
  		// 开始分页：PageHelper会处理接下来的第一个查询
  		PageInfo<CdLeaveDetailInfo> pageInfo = cdLeaveService.findPageNo(dataTable.getPage_num(),
  				dataTable.getPage_size(), datas);
  		dataTable = dataTable.convert(dataTable, pageInfo);
  		return dataTable;
  	}
  	
  	@ResponseBody
  	@RequestMapping("/findByMapApp")
  	public PageInfo<CdLeaveDetailInfo> findPageApp(HttpServletRequest request, HttpServletResponse response){
  		Map<String, String> datas = WebUtil.request2Map(request);
  		PageInfo<CdLeaveDetailInfo> pageInfo = cdLeaveService.findPageNo(Integer.parseInt(datas.get("pagseNums")),Integer.parseInt(datas.get("pagseSize")), datas);

  		return pageInfo;
  	}
      
  	/**
  	 * 分页查询--审核的
  	 */
  	@ResponseBody
  	@RequestMapping("/findByMapAppYes")
  	public PageInfo<CdLeaveDetailInfo> findByMapAppYes(HttpServletRequest request, HttpServletResponse response){
  		Map<String, String> datas = WebUtil.request2Map(request);
		PageInfo<CdLeaveDetailInfo> pageInfo = cdLeaveService.findPage(Integer.parseInt(datas.get("pagseNums")),Integer.parseInt(datas.get("pagseSize")), datas);
		return pageInfo;
  	}
  	
	/**
  	 * 分页查询--请假人员
  	 */
  	@ResponseBody
  	@RequestMapping("/findByMapLeave")
  	public DataTablePage<CdLeaveDetailInfo> findByMapLeave(HttpServletRequest request, HttpServletResponse response){
  		Map<String, String> datas = WebUtil.request2Map(request);
  		DataTablePage<CdLeaveDetailInfo> dataTable = new DataTablePage<CdLeaveDetailInfo>(request);
  		// 开始分页：PageHelper会处理接下来的第一个查询
  		PageInfo<CdLeaveDetailInfo> pageInfo = cdLeaveService.findPageLeave(dataTable.getPage_num(),
  				dataTable.getPage_size(), datas);
  		dataTable = dataTable.convert(dataTable, pageInfo);
  		return dataTable;
  	}
  	
  	/**
  	 * 数据查询 
  	 */
  	@ResponseBody
  	@RequestMapping("/findList")
  	public List<CdLeaveDetailInfo> findList(CdLeaveDetailInfo entity,HttpServletRequest request, HttpServletResponse response){
  		return cdLeaveService.findList(entity);
  	}
  	
  	 /**
  	 * 删除信息 
  	 */
  	@ResponseBody
  	@RequestMapping("/delete")
  	public ModelAndView delete(CdLeaveDetailInfo entity){
  		AjaxResponder result = null;
  		entity.setUpdateUser("admin");
		entity.setUpdateTime(new Date());
  		try {
  			cdLeaveService.delete(entity);
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
  	 * 新增
  	 */
  	@ResponseBody
  	@RequestMapping(value = "/add")
  	public ModelAndView add(CdLeaveDetailInfo entity, HttpServletRequest request,
  			HttpServletResponse response) {
  		Map<String, String> datas = WebUtil.request2Map(request);
  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
  		AjaxResponder result = null;
  		entity.setId(UUID.getUUID());
  		entity.setLeaveTime(new Date());
  		entity.setCreateTime(new Date());
  		entity.setCreateUser("admin");
  		try {
  			cdLeaveService.save(entity);
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
  	 * 新增
  	 */
  	@ResponseBody
  	@RequestMapping(value = "/addApp")
  	public ModelAndView addApp(CdLeaveDetailInfo entity, HttpServletRequest request,
  			HttpServletResponse response) {
  		Map<String, String> datas = WebUtil.request2Map(request);
  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
  		AjaxResponder result = null;
  		entity.setId(UUID.getUUID());
  		entity.setCreateTime(new Date());
  		entity.setCreateUser("admin");
  		try {
  			cdLeaveService.save(entity);
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
  	 * 修改 -
  	 */
  	@ResponseBody
  	@RequestMapping(value = "/update")
  	public ModelAndView update(CdLeaveDetailInfo entity, HttpServletRequest request,
  			HttpServletResponse response) {
  		Map<String, String> datas = WebUtil.request2Map(request);
  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
  		AjaxResponder result = null;
  		entity.setUpdateTime(new Date());
  		entity.setUpdateUser("admin");
  		try {
  			cdLeaveService.update(entity);
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
  	 * 修改 -请假状态-通过/不通过
  	 */
  	@ResponseBody
  	@RequestMapping(value = "/updateStatus")
  	public ModelAndView updateStatus(CdLeaveDetailInfo entity, HttpServletRequest request,
  			HttpServletResponse response) {
  		Map<String, String> datas = WebUtil.request2Map(request);
  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
  		AjaxResponder result = null;
  		entity.setUpdateTime(new Date());
  		entity.setUpdateUser("admin");
  		try {
  			cdLeaveService.updateStatus(entity);
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
	public CdLeaveDetailInfo getById(@RequestParam(required = false) String id) {
		return cdLeaveService.get(id);
	}
}
