package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.CdCourseDao;
import com.bmsmart.mes.mesDemo.domain.po.CdCourseInfo;
import com.bmsmart.mes.mesDemo.service.CdCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional(readOnly = true)
@Service("cdArriveService")
public class CdCourseServiceImpl implements CdCourseService{

	@Autowired
	private CdCourseDao cdArriveDao;
	
	@Override
	public CdCourseInfo get(String id) {
		// TODO Auto-generated method stub
		return cdArriveDao.get(id);
	}

	@Override
	public List<CdCourseInfo> findList(CdCourseInfo entity) {
		// TODO Auto-generated method stub
		return cdArriveDao.findList(entity);
	}

	@Override
	public PageInfo<CdCourseInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdCourseInfo> list =  cdArriveDao.findByMap(datas);
		PageInfo<CdCourseInfo> pages = new PageInfo<CdCourseInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(CdCourseInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(CdCourseInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDao.delete(entity);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(CdCourseInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDao.update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateAdd(CdCourseInfo entity) {
		// TODO Auto-generated method stub
		return cdArriveDao.updateAdd(entity);
	}

}
