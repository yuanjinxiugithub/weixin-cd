package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.SysLogsInfo;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月22日 下午5:59:35
* 类说明   日志
*/
public interface SysLogService {
	public SysLogsInfo  get(String id);
	 
	 public List<SysLogsInfo> findList(SysLogsInfo entity);
	 
	 public PageInfo<SysLogsInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(SysLogsInfo entity);
	 
	 public void delete(SysLogsInfo entity);
	 
	 public void update(SysLogsInfo entity);
}
