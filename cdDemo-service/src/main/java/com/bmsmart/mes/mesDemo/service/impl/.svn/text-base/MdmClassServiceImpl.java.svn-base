package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmClassDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmClassInfo;
import com.bmsmart.mes.mesDemo.service.MdmClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *   班级档案
 */
@Transactional(readOnly = true)
@Service("mdmClassService")
public class MdmClassServiceImpl implements MdmClassService{
	
	@Autowired
	private MdmClassDao mdmClassDao;
	
	@Override
	public MdmClassInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmClassDao.get(id);
	}

	@Override
	public List<MdmClassInfo> findList(MdmClassInfo entity) {
		// TODO Auto-generated method stub
		return mdmClassDao.findList(entity);
	}

	@Override
	public PageInfo<MdmClassInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmClassInfo> list =  mdmClassDao.findByMap(datas);
		PageInfo<MdmClassInfo> pages = new PageInfo<MdmClassInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmClassInfo entity) {
		// TODO Auto-generated method stub
		mdmClassDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmClassInfo entity) {
		// TODO Auto-generated method stub
		mdmClassDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmClassInfo entity) {
		// TODO Auto-generated method stub
		mdmClassDao.update(entity);
	}

}
