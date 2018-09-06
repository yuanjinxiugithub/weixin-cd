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
import com.bmsmart.mes.mesDemo.domain.po.MdmClassInfo;
import com.bmsmart.mes.mesDemo.service.MdmClassService;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  2018/2/28
 * 班级档案
 */
@Controller
@RequestMapping(value="/mdmClass")
public class MdmClassController extends BaseController{

    @Autowired 
	private MdmClassService mdmClassService;
    
    /**
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping("/findByMap")
	public DataTablePage<MdmClassInfo> findPage(HttpServletRequest request, HttpServletResponse response){
		Map<String, String> datas = WebUtil.request2Map(request);
		// 使用DataTables的属性接收分页数据
		DataTablePage<MdmClassInfo> dataTable = new DataTablePage<MdmClassInfo>(request);
		// 开始分页：PageHelper会处理接下来的第一个查询
		PageInfo<MdmClassInfo> pageInfo = mdmClassService.findPage(dataTable.getPage_num(),
				dataTable.getPage_size(), datas);
		dataTable = dataTable.convert(dataTable, pageInfo);
		return dataTable;
	}
    
	/**
	 * 数据查询
	 */
	@ResponseBody
	@RequestMapping("/findList")
	public List<MdmClassInfo> findList(MdmClassInfo entity,HttpServletRequest request, HttpServletResponse response){
		return mdmClassService.findList(entity);
	}
	
	 /**
	 * 删除信息
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ModelAndView delete(MdmClassInfo entity){
		AjaxResponder result = null;
		entity.setUpdateUser("admin");
		entity.setUpdateTime(new Date());
		try {
			mdmClassService.delete(entity);
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
	 * 新增学院信息
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public ModelAndView add(MdmClassInfo entity, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> datas = WebUtil.request2Map(request);
		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
		AjaxResponder result = null;
		entity.setId(UUID.getUUID());
		entity.setCreateTime(new Date());
		entity.setCreateUser("admin");
		try {
			mdmClassService.save(entity);
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
	 * 修改学院信息
	 */
	@ResponseBody
	@RequestMapping(value = "/update")
	public ModelAndView update(MdmClassInfo entity, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> datas = WebUtil.request2Map(request);
		logger.info("请求对象参数：{}-请求参数--{}---session-{}", entity, datas, null);
		AjaxResponder result = null;
		entity.setUpdateTime(new Date());
		entity.setUpdateUser("admin");
		try {
			mdmClassService.update(entity);
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
	public MdmClassInfo getById(@RequestParam(required = false) String id) {
		return mdmClassService.get(id);
	}
	
}
