package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.CdArriveDetailDao;
import com.bmsmart.mes.mesDemo.domain.po.CdArriveDetailInfo;
import com.bmsmart.mes.mesDemo.service.CdArriveDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional(readOnly = true)
@Service("cdArriveDetailService")
public class CdArriveDetailServiceImpl implements CdArriveDetailService{

	@Autowired
	private CdArriveDetailDao cdArriveDetailDao;
	
	@Override
	public CdArriveDetailInfo get(String id) {
		// TODO Auto-generated method stub
		return cdArriveDetailDao.get(id);
	}

	@Override
	public List<CdArriveDetailInfo> findList(CdArriveDetailInfo entity) {
		// TODO Auto-generated method stub
		return cdArriveDetailDao.findList(entity);
	}

	@Override
	public PageInfo<CdArriveDetailInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdArriveDetailInfo> list =  cdArriveDetailDao.findByMap(datas);
		PageInfo<CdArriveDetailInfo> pages = new PageInfo<CdArriveDetailInfo>(list);
		return pages;
	}

	
	@Transactional(readOnly = false)
	@Override
	public void save(CdArriveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDetailDao.insert(entity);
	}

	
	@Transactional(readOnly = false)
	@Override
	public void delete(CdArriveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDetailDao.delete(entity);
	}

	
	@Transactional(readOnly = false)
	@Override
	public void update(CdArriveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdArriveDetailDao.update(entity);
	}

	@Override
	public PageInfo<CdArriveDetailInfo> findPageNo(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdArriveDetailInfo> list =  cdArriveDetailDao.findByMapNo(datas);
		PageInfo<CdArriveDetailInfo> pages = new PageInfo<CdArriveDetailInfo>(list);
		return pages;
	}

}
