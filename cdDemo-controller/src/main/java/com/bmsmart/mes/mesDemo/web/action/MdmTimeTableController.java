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
import com.bmsmart.mes.mesDemo.domain.po.MdmTimeTableInfo;
import com.bmsmart.mes.mesDemo.service.MdmTimeTableService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *   排课课程表
 */
@Controller
@RequestMapping(value="/mdmTimeTable")
public class MdmTimeTableController {

	  @Autowired 
	  private MdmTimeTableService  mdmTimeTableService;
  
	  /**
		 * 分页查询
		 */
		@ResponseBody
		@RequestMapping("/findByMap")
		public DataTablePage<MdmTimeTableInfo> findPage(HttpServletRequest request, HttpServletResponse response){
			Map<String, String> datas = WebUtil.request2Map(request);
			DataTablePage<MdmTimeTableInfo> dataTable = new DataTablePage<MdmTimeTableInfo>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageInfo<MdmTimeTableInfo> pageInfo = mdmTimeTableService.findPage(dataTable.getPage_num(),
					dataTable.getPage_size(), datas);
			dataTable = dataTable.convert(dataTable, pageInfo);
			return dataTable;
		}
		
		/**
		 * 数据查询
		 */
		@ResponseBody
		@RequestMapping("/findList")
		public List<MdmTimeTableInfo> findList(MdmTimeTableInfo entity,HttpServletRequest request, HttpServletResponse response){
			return mdmTimeTableService.findList(entity);
		}
	    
		 /**
		 * 删除信息
		 */
		@ResponseBody
		@RequestMapping("/delete")
		public ModelAndView delete(MdmTimeTableInfo entity){
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setCreateUser("admin");
			try {
				mdmTimeTableService.delete(entity);
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
		public ModelAndView add(MdmTimeTableInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			AjaxResponder result = null;
			entity.setId(UUID.getUUID());
			entity.setCreateTime(new Date());
			entity.setCreateUser("admin");
			try {
				mdmTimeTableService.save(entity);
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
		public ModelAndView update(MdmTimeTableInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				mdmTimeTableService.update(entity);
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
		public MdmTimeTableInfo getById(@RequestParam(required = false) String id) {
			return mdmTimeTableService.get(id);
		}
}
