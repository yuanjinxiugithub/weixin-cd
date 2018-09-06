package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.MdmIstrInfo;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *   学院档案
 */
public interface MdmIstrService {

     public MdmIstrInfo  get(String id);
	 
	 public List<MdmIstrInfo> findList(MdmIstrInfo entity);
	 
	 public PageInfo<MdmIstrInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(MdmIstrInfo entity);
	 
	 public void delete(MdmIstrInfo entity);
	 
	 public void update(MdmIstrInfo entity);
}
