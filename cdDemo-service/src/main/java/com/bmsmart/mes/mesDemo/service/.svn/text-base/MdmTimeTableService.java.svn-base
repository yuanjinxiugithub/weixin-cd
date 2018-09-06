package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.MdmTimeTableInfo;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  排课表
 *
 */
public interface MdmTimeTableService {
 public MdmTimeTableInfo  get(String id);
	 
	 public List<MdmTimeTableInfo> findList(MdmTimeTableInfo entity);
	 
	 public PageInfo<MdmTimeTableInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(MdmTimeTableInfo entity);
	 
	 public void delete(MdmTimeTableInfo entity);
	 
	 public void update(MdmTimeTableInfo entity);
	 
	 public int updateArrive(MdmTimeTableInfo entity);
}
