package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.MdmClassInfo;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *  班级档案
 */
public interface MdmClassService {
	public MdmClassInfo  get(String id);
	 
	 public List<MdmClassInfo> findList(MdmClassInfo entity);
	 
	 public PageInfo<MdmClassInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(MdmClassInfo entity);
	 
	 public void delete(MdmClassInfo entity);
	 
	 public void update(MdmClassInfo entity);

}
