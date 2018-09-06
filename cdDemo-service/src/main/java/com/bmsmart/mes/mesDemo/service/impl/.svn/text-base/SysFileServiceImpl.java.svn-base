package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.SysIFileDao;
import com.bmsmart.mes.mesDemo.domain.po.SysFileInfo;
import com.bmsmart.mes.mesDemo.service.SysFileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月23日 下午12:20:52
* 类说明
*/
@Transactional(readOnly = true)
@Service("sysFile")
public class SysFileServiceImpl implements  SysFileService{
	@Autowired
	private SysIFileDao sysIFileDao;

	@Override
	public SysFileInfo get(String id) {
		// TODO Auto-generated method stub
		return sysIFileDao.get(id);
	}

	@Override
	public List<SysFileInfo> findList(SysFileInfo entity) {
		// TODO Auto-generated method stub
		return sysIFileDao.findList(entity);
	}

	@Override
	public PageInfo<SysFileInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
				PageHelper.startPage(pageNum, pageSize);
				List<SysFileInfo> list =  sysIFileDao.findByMap(datas);
				PageInfo<SysFileInfo> pages = new PageInfo<SysFileInfo>(list);
				return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(SysFileInfo entity) {
		// TODO Auto-generated method stub
		sysIFileDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(SysFileInfo entity) {
		// TODO Auto-generated method stub
		sysIFileDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(SysFileInfo entity) {
		// TODO Auto-generated method stub
		sysIFileDao.update(entity);
	}

}
