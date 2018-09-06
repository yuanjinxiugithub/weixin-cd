package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.CdNoticeDao;
import com.bmsmart.mes.mesDemo.dao.CdleaveDao;
import com.bmsmart.mes.mesDemo.domain.po.CdCourseInfo;
import com.bmsmart.mes.mesDemo.domain.po.CdNoticeInfo;
import com.bmsmart.mes.mesDemo.service.CdNoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail: 通知列表
* @version 创建时间：2018年3月8日 下午7:13:55
* 类说明
*/

@Transactional(readOnly = true)
@Service("cdNoticeService")
public class CdNoticeServiceImpl implements CdNoticeService{

	@Autowired
    private CdNoticeDao cdNoticeDao;
	
	@Override
	public CdNoticeInfo get(String id) {
		// TODO Auto-generated method stub
		return cdNoticeDao.get(id);
	}

	@Override
	public List<CdNoticeInfo> findList(CdNoticeInfo entity) {
		// TODO Auto-generated method stub
		return cdNoticeDao.findList(entity);
	}

	@Override
	public PageInfo<CdNoticeInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<CdNoticeInfo> list =  cdNoticeDao.findByMap(datas);
		PageInfo<CdNoticeInfo> pages = new PageInfo<CdNoticeInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(CdNoticeInfo entity) {
		// TODO Auto-generated method stub
		cdNoticeDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(CdNoticeInfo entity) {
		// TODO Auto-generated method stub
		cdNoticeDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(CdNoticeInfo entity) {
		// TODO Auto-generated method stub
		cdNoticeDao.update(entity);
	}


}
