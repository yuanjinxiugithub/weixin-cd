package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmStudentDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmStudentInfo;
import com.bmsmart.mes.mesDemo.service.MdmStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx  2018/2/28
 *  学生档案
 */
@Transactional(readOnly = true)
@Service("mdmStudentService")
public class MdmStudentServiceImpl implements MdmStudentService {

	@Autowired
	private MdmStudentDao mdmStudentDao;
	
	@Override
	public MdmStudentInfo get(MdmStudentInfo entity) {
		// TODO Auto-generated method stub
		return mdmStudentDao.get(entity);
	}

	@Override
	public List<MdmStudentInfo> findList(MdmStudentInfo entity) {
		// TODO Auto-generated method stub
		return mdmStudentDao.findList(entity);
	}

	@Override
	public PageInfo<MdmStudentInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmStudentInfo> list =  mdmStudentDao.findByMap(datas);
		PageInfo<MdmStudentInfo> pages = new PageInfo<MdmStudentInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmStudentInfo entity) {
		// TODO Auto-generated method stub
		mdmStudentDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmStudentInfo entity) {
		// TODO Auto-generated method stub
		mdmStudentDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmStudentInfo entity) {
		// TODO Auto-generated method stub
		mdmStudentDao.update(entity);
	}

}
