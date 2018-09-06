package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmCourseDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmCourseInfo;
import com.bmsmart.mes.mesDemo.service.MdmCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *   课程
 */
@Transactional(readOnly = true)
@Service("mdmCourseService")
public class MdmCourseServiceImpl implements MdmCourseService{
	@Autowired
	private MdmCourseDao mdmCourseDao;
	
	@Override
	public MdmCourseInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmCourseDao.get(id);
	}

	@Override
	public List<MdmCourseInfo> findList(MdmCourseInfo entity) {
		// TODO Auto-generated method stub
		return mdmCourseDao.findList(entity);
	}

	@Override
	public PageInfo<MdmCourseInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmCourseInfo> list =  mdmCourseDao.findByMap(datas);
		PageInfo<MdmCourseInfo> pages = new PageInfo<MdmCourseInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmCourseInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmCourseInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseDao.delete(entity);
	}

	
	@Override
	@Transactional(readOnly = false)
	public void update(MdmCourseInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseDao.update(entity);
	}

}
