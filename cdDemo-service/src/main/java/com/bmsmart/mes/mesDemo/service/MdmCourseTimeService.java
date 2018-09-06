package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.MdmCourseTimeInfo;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/3/1
 * 学期时间
 */
public interface MdmCourseTimeService {

	  public MdmCourseTimeInfo  get(String id);
		 
		 public List<MdmCourseTimeInfo> findList(MdmCourseTimeInfo entity);
		 
		 public PageInfo<MdmCourseTimeInfo> findPage(int pageNum, int pageSize,
				Map<String, String> datas);
		 
		 public void save(MdmCourseTimeInfo entity);
		 
		 public void delete(MdmCourseTimeInfo entity);
		 
		 public void update(MdmCourseTimeInfo entity);
}
