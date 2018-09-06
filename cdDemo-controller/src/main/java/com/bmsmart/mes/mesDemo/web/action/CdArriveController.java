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
import com.bmsmart.mes.mesDemo.domain.po.CdArriveDetailInfo;
import com.bmsmart.mes.mesDemo.domain.po.CdCourseInfo;
import com.bmsmart.mes.mesDemo.service.CdArriveDetailService;
import com.bmsmart.mes.mesDemo.service.CdCourseService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  点到
 *
 */
@Controller
@RequestMapping(value="/cdArrive")
public class CdArriveController extends BaseController{

	 @Autowired 
	 private CdArriveDetailService  cdArriveDetailService;
	 
	 @Autowired 
	 private CdCourseService  cdCourseService;
	 
	   /**
	  	 * 分页查询--查询达到的学生列表 根据arriveId(分页)
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMap")
	  	public DataTablePage<CdArriveDetailInfo> findPage(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		DataTablePage<CdArriveDetailInfo> dataTable = new DataTablePage<CdArriveDetailInfo>(request);
	  		// 开始分页：PageHelper会处理接下来的第一个查询
	  		PageInfo<CdArriveDetailInfo> pageInfo = cdArriveDetailService.findPage(dataTable.getPage_num(),
	  				dataTable.getPage_size(), datas);
	  		dataTable = dataTable.convert(dataTable, pageInfo);
	  		return dataTable;
	  	}
	      
	  	/**
	  	 * 数据查询 --查询达到的学生列表
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findList")
	  	public List<CdArriveDetailInfo> findList(CdArriveDetailInfo entity,HttpServletRequest request, HttpServletResponse response){
	  		return cdArriveDetailService.findList(entity);
	  	}
	  	
	  	 /**
	  	 * 删除信息 --删除达到的学生信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/delete")
	  	public ModelAndView delete(CdArriveDetailInfo entity){
	  		AjaxResponder result = null;
	  		entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
	  		try {
	  			cdArriveDetailService.delete(entity);
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
	  	public ModelAndView add(CdArriveDetailInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setId(UUID.getUUID());
	  		entity.setCreateTime(new Date());
	  		entity.setCreateUser(entity.getStudentName());
	  		entity.setCreateTime(new Date());
	  		entity.setArriveTime(new Date());
	  		CdCourseInfo cdCourseInfo = new CdCourseInfo();
	  		cdCourseInfo.setUpdateTime(new Date());
	  		cdCourseInfo.setId(entity.getArriveId());
	  		try {
	  			cdArriveDetailService.save(entity);
	  			cdCourseService.updateAdd(cdCourseInfo);
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
	  	public ModelAndView update(CdArriveDetailInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setUpdateTime(new Date());
	  		entity.setUpdateUser("admin");
	  		try {
	  			cdArriveDetailService.update(entity);
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
		public CdArriveDetailInfo getById(@RequestParam(required = false) String id) {
			return cdArriveDetailService.get(id);
		}
		
		
		/**
	  	 * 分页查询--查询未达到的学生列表
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMap1")
	  	public DataTablePage<CdArriveDetailInfo> findPage1(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		DataTablePage<CdArriveDetailInfo> dataTable = new DataTablePage<CdArriveDetailInfo>(request);
	  		// 开始分页：PageHelper会处理接下来的第一个查询
	  		PageInfo<CdArriveDetailInfo> pageInfo = cdArriveDetailService.findPageNo(dataTable.getPage_num(),
	  				dataTable.getPage_size(), datas);
	  		dataTable = dataTable.convert(dataTable, pageInfo);
	  		return dataTable;
	  	}
	  	
}
