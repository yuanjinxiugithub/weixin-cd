package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.CdleaveDao;
import com.bmsmart.mes.mesDemo.domain.po.CdLeaveDetailInfo;
import com.bmsmart.mes.mesDemo.service.CdLeaveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月7日 下午8:41:42
* 类说明 请假impl
*/
@Transactional(readOnly = true)
@Service("cdLeaveService")
public class CdLeaveServiceImpl implements CdLeaveService{
    @Autowired
    private CdleaveDao cdleaveDao;
    
	@Override
	public CdLeaveDetailInfo get(String id) {
		// TODO Auto-generated method stub
		return cdleaveDao.get(id);
	}

	@Override
	public List<CdLeaveDetailInfo> findList(CdLeaveDetailInfo entity) {
		// TODO Auto-generated method stub
		return cdleaveDao.findList(entity);
	}

	@Override
	public PageInfo<CdLeaveDetailInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdLeaveDetailInfo> list =  cdleaveDao.findByMap(datas);
		PageInfo<CdLeaveDetailInfo> pages = new PageInfo<CdLeaveDetailInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(CdLeaveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdleaveDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(CdLeaveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdleaveDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(CdLeaveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdleaveDao.update(entity);
	}

	@Override
	public PageInfo<CdLeaveDetailInfo> findPageNo(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdLeaveDetailInfo> list =  cdleaveDao.findByMapNo(datas);
		PageInfo<CdLeaveDetailInfo> pages = new PageInfo<CdLeaveDetailInfo>(list);
		return pages;
	}

	@Override
	public PageInfo<CdLeaveDetailInfo> findPageLeave(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdLeaveDetailInfo> list =  cdleaveDao.findByMapLeave(datas);
		PageInfo<CdLeaveDetailInfo> pages = new PageInfo<CdLeaveDetailInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void updateStatus(CdLeaveDetailInfo entity) {
		// TODO Auto-generated method stub
		cdleaveDao.updateStatus(entity);
	}

}
