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
import com.bmsmart.mes.mesDemo.domain.po.CdCourseInfo;
import com.bmsmart.mes.mesDemo.domain.po.MdmTimeTableInfo;
import com.bmsmart.mes.mesDemo.service.CdCourseService;
import com.bmsmart.mes.mesDemo.service.MdmTimeTableService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  课程控制器--根据时间的推移 每天进行上课
 *
 */
@Controller
@RequestMapping(value="/cdCourse")
public class CdCourseController extends BaseController{

	 @Autowired 
	 private CdCourseService  cdArriveService;
	 
	  @Autowired 
	  private MdmTimeTableService  mdmTimeTableService;
	  /**
	  	 * 分页查询--查询上课的信息（分页）
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMap")
	  	public DataTablePage<CdCourseInfo> findPage(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		DataTablePage<CdCourseInfo> dataTable = new DataTablePage<CdCourseInfo>(request);
	  		// 开始分页：PageHelper会处理接下来的第一个查询
	  		PageInfo<CdCourseInfo> pageInfo = cdArriveService.findPage(dataTable.getPage_num(),
	  				dataTable.getPage_size(), datas);
	  		dataTable = dataTable.convert(dataTable, pageInfo);
	  		return dataTable;
	  	}
	      
	  	/**
	  	 * 数据查询 --查询上课信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findList")
	  	public List<CdCourseInfo> findList(CdCourseInfo entity,HttpServletRequest request, HttpServletResponse response){
	  		return cdArriveService.findList(entity);
	  	}
	  	
	  	 /**
	  	 * 删除信息 --主
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/delete")
	  	public ModelAndView delete(CdCourseInfo entity){
	  		AjaxResponder result = null;
	  		entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
	  		try {
	  			cdArriveService.delete(entity);
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
	  	 * 新增 --课程信息
	  	 */
	  	@ResponseBody
	  	@RequestMapping(value = "/add")
	  	public ModelAndView add(CdCourseInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setId(UUID.getUUID());
	  		entity.setCreateTime(new Date());
	  		entity.setCreateUser("admin");
	  		entity.setArriveTime(new Date());
	  		MdmTimeTableInfo mdmTimeTableInfo =  new MdmTimeTableInfo();
	  		mdmTimeTableInfo.setUpdateTime(new Date());
	  		mdmTimeTableInfo.setUpdateUser(entity.getTeacherName());
	  		mdmTimeTableInfo.setCode(entity.gettCode());
	  		mdmTimeTableInfo.setArriveId(entity.getId());
	  		try {
	  			cdArriveService.save(entity);
	  			mdmTimeTableService.updateArrive(mdmTimeTableInfo);
	  			result = AjaxResponder.getInstance(Boolean.TRUE, "新增信息成功! ", entity.getId());
	  		} catch (Exception e) {
	  			logger.error("insert 班级信息  error by Controller ,exception:{}", e.getMessage());
	  			result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
	  		}
	  		ModelAndView mv = new ModelAndView("response");
	  		mv.addObject("result", result);
	  		return mv;
	  	}
	  	
	  	/**
	  	 * 修改 --主
	  	 */
	  	@ResponseBody
	  	@RequestMapping(value = "/update")
	  	public ModelAndView update(CdCourseInfo entity, HttpServletRequest request,
	  			HttpServletResponse response) {
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
	  		AjaxResponder result = null;
	  		entity.setUpdateTime(new Date());
	  		entity.setUpdateUser("admin");
	  		try {
	  			cdArriveService.update(entity);
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
		public CdCourseInfo getById(@RequestParam(required = false) String id) {
			return cdArriveService.get(id);
		}
		 
		 
}
