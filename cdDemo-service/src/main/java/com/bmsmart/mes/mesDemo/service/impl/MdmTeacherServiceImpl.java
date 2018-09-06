package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmTeacherDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmTeacherInfo;
import com.bmsmart.mes.mesDemo.service.MdmTeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *  教师档案
 */
@Transactional(readOnly = true)
@Service("mdmTeacherService")
public class MdmTeacherServiceImpl implements MdmTeacherService{
	@Autowired
	private MdmTeacherDao mdmTeacherDao;

	@Override
	public MdmTeacherInfo get(MdmTeacherInfo entity) {
		// TODO Auto-generated method stub
		return mdmTeacherDao.get(entity);
	}

	@Override
	public List<MdmTeacherInfo> findList(MdmTeacherInfo entity) {
		// TODO Auto-generated method stub
		return mdmTeacherDao.findList(entity);
	}

	@Override
	public PageInfo<MdmTeacherInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmTeacherInfo> list =  mdmTeacherDao.findByMap(datas);
		PageInfo<MdmTeacherInfo> pages = new PageInfo<MdmTeacherInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmTeacherInfo entity) {
		// TODO Auto-generated method stub
		mdmTeacherDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmTeacherInfo entity) {
		// TODO Auto-generated method stub
		mdmTeacherDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmTeacherInfo entity) {
		// TODO Auto-generated method stub
		mdmTeacherDao.update(entity);
	}

}
