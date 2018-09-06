package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.MdmIstrDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmIstrInfo;
import com.bmsmart.mes.mesDemo.service.MdmIstrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yjx 2018/2/28
 *   学院档案 实现层
 */
@Transactional(readOnly = true)
@Service("mdmIstrService")
public class MdmIstrServiceImpl extends BaseServiceImpl  implements MdmIstrService{
	
	@Autowired
	private MdmIstrDao mdmIstrDao;
	
	@Override
	public MdmIstrInfo get(String id) {
		// TODO Auto-generated method stub
		return mdmIstrDao.get(id);
	}

	@Override
	public List<MdmIstrInfo> findList(MdmIstrInfo entity) {
		// TODO Auto-generated method stub
		return mdmIstrDao.findList(entity);
	}

	@Override
	public PageInfo<MdmIstrInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<MdmIstrInfo> list =  mdmIstrDao.findByMap(datas);
		PageInfo<MdmIstrInfo> pages = new PageInfo<MdmIstrInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(MdmIstrInfo entity) {
		// TODO Auto-generated method stub
		mdmIstrDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(MdmIstrInfo entity) {
		// TODO Auto-generated method stub
		mdmIstrDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(MdmIstrInfo entity) {
		// TODO Auto-generated method stub
		mdmIstrDao.update(entity);
	}

}
