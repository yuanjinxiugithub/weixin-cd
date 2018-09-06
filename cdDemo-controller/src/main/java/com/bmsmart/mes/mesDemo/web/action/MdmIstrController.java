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
import com.bmsmart.mes.mesDemo.domain.po.MdmIstrInfo;
import com.bmsmart.mes.mesDemo.service.MdmIstrService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 * 学院档案
 */
@Controller
@RequestMapping(value="/mdmIstr")
public class MdmIstrController extends BaseController{

    @Autowired 
	private MdmIstrService mdmIstrService;
    
    
    /**
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping("/findByMap")
	public DataTablePage<MdmIstrInfo> findPage(HttpServletRequest request, HttpServletResponse response){
		Map<String, String> datas = WebUtil.request2Map(request);
		logger.info("请求对象参数：{}-请求参数--{}---session-{}", request, datas, null);
		DataTablePage<MdmIstrInfo> dataTable = new DataTablePage<MdmIstrInfo>(request);
		// 开始分页：PageHelper会处理接下来的第一个查询
		PageInfo<MdmIstrInfo> pageInfo = mdmIstrService.findPage(dataTable.getPage_num(),
				dataTable.getPage_size(), datas);
		dataTable = dataTable.convert(dataTable, pageInfo);
		return dataTable;
	}
	
	/**
	 * 数据查询
	 */
	@ResponseBody
	@RequestMapping("/findList")
	public List<MdmIstrInfo> findList(MdmIstrInfo entity,HttpServletRequest request, HttpServletResponse response){
		return mdmIstrService.findList(entity);
	}
    
	 /**
	 * 删除信息
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ModelAndView delete(MdmIstrInfo entity){
		AjaxResponder result = null;
		entity.setUpdateTime(new Date());
		entity.setUpdateUser("admin");
		try {
			mdmIstrService.delete(entity);
			result = AjaxResponder.getInstance(Boolean.TRUE, "删除信息成功! ", null);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("delete 学院信息  error by Controller ,exception:{}", e.getMessage());
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
	public ModelAndView add(MdmIstrInfo entity, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> datas = WebUtil.request2Map(request);
		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
		AjaxResponder result = null;
		entity.setId(UUID.getUUID());
		entity.setCreateTime(new Date());
		entity.setCreateUser("admin");
		try {
			mdmIstrService.save(entity);
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
	 * 修改学院信息
	 */
	@ResponseBody
	@RequestMapping(value = "/update")
	public ModelAndView update(MdmIstrInfo entity, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> datas = WebUtil.request2Map(request);
		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
		AjaxResponder result = null;
		entity.setUpdateTime(new Date());
		entity.setUpdateUser("admin");
		try {
			mdmIstrService.update(entity);
			result = AjaxResponder.getInstance(Boolean.TRUE, "更新信息成功! ", null);
		} catch (Exception e) {
			logger.error("insert istrInfo  error by Controller ,exception:{}", e.getMessage());
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
	public MdmIstrInfo getById(@RequestParam(required = false) String id) {
		return mdmIstrService.get(id);
	}
}
