package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.SysLogDao;
import com.bmsmart.mes.mesDemo.domain.po.SysLogsInfo;
import com.bmsmart.mes.mesDemo.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月22日 下午6:00:22
* 类说明
*/
@Transactional(readOnly = true)
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public SysLogsInfo get(String id) {
		// TODO Auto-generated method stub
		return sysLogDao.get(id);
	}

	@Override
	public List<SysLogsInfo> findList(SysLogsInfo entity) {
		// TODO Auto-generated method stub
		return sysLogDao.findList(entity);
	}

	@Override
	public PageInfo<SysLogsInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SysLogsInfo> list =  sysLogDao.findByMap(datas);
		PageInfo<SysLogsInfo> pages = new PageInfo<SysLogsInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(SysLogsInfo entity) {
		// TODO Auto-generated method stub
		sysLogDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(SysLogsInfo entity) {
		// TODO Auto-generated method stub
		sysLogDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(SysLogsInfo entity) {
		// TODO Auto-generated method stub
		sysLogDao.update(entity);
	}

}
