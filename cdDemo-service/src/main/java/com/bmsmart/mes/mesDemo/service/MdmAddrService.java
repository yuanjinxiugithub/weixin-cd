package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.MdmAddrInfo;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  教室
 *
 */
public interface MdmAddrService {

	 public MdmAddrInfo  get(String id);
	 
	 public List<MdmAddrInfo> findList(MdmAddrInfo entity);
	 
	 public PageInfo<MdmAddrInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(MdmAddrInfo entity);
	 
	 public void delete(MdmAddrInfo entity);
	 
	 public void update(MdmAddrInfo entity);
}
