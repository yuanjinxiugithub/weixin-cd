package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmTimeTableDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmTimeTableInfo;
import com.bmsmart.mes.mesDemo.service.MdmTimeTableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional(readOnly = true)
@Service("mdmTimeTableService")
public class MdmTimeTableServiceImpl implements MdmTimeTableService{
	@Autowired
	private MdmTimeTableDao mdmTimeTableDao;
	
	@Override
	public MdmTimeTableInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmTimeTableDao.get(id);
	}

	@Override
	public List<MdmTimeTableInfo> findList(MdmTimeTableInfo entity) {
		// TODO Auto-generated method stub
		return mdmTimeTableDao.findList(entity);
	}

	@Override
	public PageInfo<MdmTimeTableInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmTimeTableInfo> list =  mdmTimeTableDao.findByMap(datas);
		PageInfo<MdmTimeTableInfo> pages = new PageInfo<MdmTimeTableInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmTimeTableInfo entity) {
		// TODO Auto-generated method stub
		mdmTimeTableDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmTimeTableInfo entity) {
		// TODO Auto-generated method stub
		mdmTimeTableDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmTimeTableInfo entity) {
		// TODO Auto-generated method stub
		mdmTimeTableDao.update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateArrive(MdmTimeTableInfo entity) {
		// TODO Auto-generated method stub
		return mdmTimeTableDao.updateArrive(entity);
	}

}
