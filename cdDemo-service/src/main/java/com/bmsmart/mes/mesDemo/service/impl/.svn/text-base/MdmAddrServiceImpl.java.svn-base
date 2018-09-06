package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmAddrDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmAddrInfo;
import com.bmsmart.mes.mesDemo.service.MdmAddrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx   2018/3/1
 * 教室
 */
@Transactional(readOnly = true)
@Service("mdmAddrService")
public class MdmAddrServiceImpl implements MdmAddrService{
	@Autowired
	private MdmAddrDao mdmAddrDao;
	
	@Override
	public MdmAddrInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmAddrDao.get(id);
	}

	@Override
	public List<MdmAddrInfo> findList(MdmAddrInfo entity) {
		// TODO Auto-generated method stub
		return mdmAddrDao.findList(entity);
	}

	@Override
	public PageInfo<MdmAddrInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmAddrInfo> list =  mdmAddrDao.findByMap(datas);
		PageInfo<MdmAddrInfo> pages = new PageInfo<MdmAddrInfo>(list);
 		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmAddrInfo entity) {
		// TODO Auto-generated method stub
		mdmAddrDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmAddrInfo entity) {
		// TODO Auto-generated method stub
		mdmAddrDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmAddrInfo entity) {
		// TODO Auto-generated method stub
		mdmAddrDao.update(entity);
	}

}
