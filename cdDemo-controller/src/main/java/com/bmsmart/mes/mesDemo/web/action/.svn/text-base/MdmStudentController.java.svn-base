package com.bmsmart.mes.mesDemo.web.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmsmart.mes.base.util.UUID;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.commons.web.datatables.DataTablePage;
import com.bmsmart.mes.mesDemo.domain.po.MdmStudentInfo;
import com.bmsmart.mes.mesDemo.service.MdmStudentService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/8
 * 学生档案
 */
@Controller
@RequestMapping(value="/mdmStudent")
public class MdmStudentController extends BaseController{

	  @Autowired 
	  private MdmStudentService mdmStudentService;
  
	   /**
		 * 分页查询
		 */
		@ResponseBody
		@RequestMapping("/findByMap")
		public DataTablePage<MdmStudentInfo> findPage(HttpServletRequest request, HttpServletResponse response){
			Map<String, String> datas = WebUtil.request2Map(request);
			DataTablePage<MdmStudentInfo> dataTable = new DataTablePage<MdmStudentInfo>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageInfo<MdmStudentInfo> pageInfo = mdmStudentService.findPage(dataTable.getPage_num(),
					dataTable.getPage_size(), datas);
			dataTable = dataTable.convert(dataTable, pageInfo);
			return dataTable;
		}
		
		/**
		 * 数据查询
		 */
		@ResponseBody
		@RequestMapping("/findList")
		public List<MdmStudentInfo> findList(MdmStudentInfo entity,HttpServletRequest request, HttpServletResponse response){
			return mdmStudentService.findList(entity);
		}
	    
		 /**
		 * 删除信息
		 */
		@ResponseBody
		@RequestMapping("/delete")
		public ModelAndView delete(MdmStudentInfo entity){
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				mdmStudentService.delete(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "删除信息成功! ", null);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("delete 学生信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 新增学生信息
		 */
		@ResponseBody
		@RequestMapping(value = "/add")
		public ModelAndView add(MdmStudentInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setId(UUID.getUUID());
			entity.setCreateTime(new Date());
			entity.setCreateUser("admin");
			try {
				mdmStudentService.save(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "新增信息成功! ", null);
			} catch (Exception e) {
				logger.error("insert istrInfo  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
		
		/**
		 * 修改学生信息
		 */
		@ResponseBody
		@RequestMapping(value = "/update")
		public ModelAndView update(MdmStudentInfo entity, HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> datas = WebUtil.request2Map(request);
			logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
			AjaxResponder result = null;
			entity.setUpdateTime(new Date());
			entity.setUpdateUser("admin");
			try {
				mdmStudentService.update(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "更新信息成功! ", null);
			} catch (Exception e) {
				logger.error("insert 学生  error by Controller ,exception:{}", e.getMessage());
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
		public MdmStudentInfo getById(MdmStudentInfo entity) {
			MdmStudentInfo res = mdmStudentService.get(entity);
			if(res ==  null){
				 res = new MdmStudentInfo();
			}
			return res;
		}
		
}
