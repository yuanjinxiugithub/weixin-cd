package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmCourseTimeDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmCourseTimeInfo;
import com.bmsmart.mes.mesDemo.service.MdmCourseTimeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * @author yjx 2018/2/28
 *   学期时间
 */
@Transactional(readOnly = true)
@Service("mdmCourseTimeService")
public class MdmCourseTimeServiceImpl implements MdmCourseTimeService {

	@Autowired
	private MdmCourseTimeDao mdmCourseTimeDao;
	
	@Override
	public MdmCourseTimeInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmCourseTimeDao.get(id);
	}

	@Override
	public List<MdmCourseTimeInfo> findList(MdmCourseTimeInfo entity) {
		// TODO Auto-generated method stub
		return mdmCourseTimeDao.findList(entity);
	}

	@Override
	public PageInfo<MdmCourseTimeInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmCourseTimeInfo> list =  mdmCourseTimeDao.findByMap(datas);
		PageInfo<MdmCourseTimeInfo> pages = new PageInfo<MdmCourseTimeInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmCourseTimeInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseTimeDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmCourseTimeInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseTimeDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmCourseTimeInfo entity) {
		// TODO Auto-generated method stub
		mdmCourseTimeDao.update(entity);
	}


}
