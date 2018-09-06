package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.CdLeaveDetailInfo;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月7日 下午8:41:22
* 类说明
*/
public interface CdLeaveService {

	public CdLeaveDetailInfo  get(String id);
	 
	 public List<CdLeaveDetailInfo> findList(CdLeaveDetailInfo entity);
	 
	 public PageInfo<CdLeaveDetailInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(CdLeaveDetailInfo entity);
	 
	 public void delete(CdLeaveDetailInfo entity);
	 
	 public void update(CdLeaveDetailInfo entity);
	 
	 public PageInfo<CdLeaveDetailInfo> findPageNo(int pageNum, int pageSize,
				Map<String, String> datas);
	 
	 public PageInfo<CdLeaveDetailInfo> findPageLeave(int pageNum, int pageSize,
				Map<String, String> datas);
	 
	 public void updateStatus(CdLeaveDetailInfo entity);
}
