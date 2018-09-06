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
import com.bmsmart.mes.commons.web.datatables.DataTablePage;
import com.bmsmart.mes.mesDemo.domain.po.MdmCourseTimeInfo;
import com.bmsmart.mes.mesDemo.service.MdmCourseTimeService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  2018/2/28
 * 学期时间
 */
@Controller
@RequestMapping(value="/mdmCourseTime")
public class MdmCourseTimeController {

	    @Autowired 
		private MdmCourseTimeService mdmCourseTimeService;
	    
	    
	    /**
		 * 分页查询
		 */
		@ResponseBody
		@RequestMapping("/findByMap")
		public DataTablePage<MdmCourseTimeInfo> findPage(HttpServletRequest request, HttpServletResponse response){
			Map<String, String> datas = WebUtil.request2Map(request);
			// 使用DataTables的属性接收分页数据
			DataTablePage<MdmCourseTimeInfo> dataTable = new DataTablePage<MdmCourseTimeInfo>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageInfo<MdmCourseTimeInfo> pageInfo = mdmCourseTimeService.findPage(dataTable.getPage_num(),
					dataTable.getPage_size(), datas);
			dataTable = dataTable.convert(dataTable, pageInfo);
			return dataTable;
		}
	    
		/**
		 * 数据查询
		 */
		@ResponseBody
		@RequestMapping("/findList")
		public List<MdmCourseTimeInfo> findList(MdmCourseTimeInfo entity,HttpServletRequest request, HttpServletResponse response){
			return mdmCourseTimeService.findList(entity);
		}
		
		 /**
		 * 删除信息
		 */
		@ResponseBody
		@RequestMapping("/delete")
		public ModelAndView delete(MdmCourseTimeInfo entity){
			AjaxResponder result = null;
			entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
			try {
				mdmCourseTimeService.delete(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "删除信息成功! ", null);
			} catch (Exception e) {
				// TODO: handle exception
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 新增学院信息
		 */
		@ResponseBody
		@RequestMapping(value = "/add")
		public ModelAndView add(MdmCourseTimeInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			AjaxResponder result = null;
			entity.setId(UUID.getUUID());
			entity.setCreateTime(new Date());
			entity.setCreateUser("admin");
			try {
				mdmCourseTimeService.save(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "新增信息成功! ", null);
			} catch (Exception e) {
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 修改学院信息
		 */
		@ResponseBody
		@RequestMapping(value = "/update")
		public ModelAndView update(MdmCourseTimeInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				mdmCourseTimeService.update(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "更新信息成功! ", null);
			} catch (Exception e) {
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
		public MdmCourseTimeInfo getById(@RequestParam(required = false) String id) {
			return mdmCourseTimeService.get(id);
		}
}
