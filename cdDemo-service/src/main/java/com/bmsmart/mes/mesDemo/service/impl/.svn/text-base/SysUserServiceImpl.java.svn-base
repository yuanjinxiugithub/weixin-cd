package com.bmsmart.mes.mesDemo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmsmart.mes.mesDemo.dao.SysUserDao;
import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;
import com.bmsmart.mes.mesDemo.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月22日 下午4:57:46
* 类说明
*/

@Transactional(readOnly = true)
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

	@Override
	public SysUserInfo get(String id) {
		// TODO Auto-generated method stub
		return sysUserDao.get(id);
	}

	@Override
	public List<SysUserInfo> findList(SysUserInfo entity) {
		// TODO Auto-generated method stub
		return sysUserDao.findList(entity);
	}

	@Override
	public PageInfo<SysUserInfo> findPage(int pageNum, int pageSize, Map<String, String> datas) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SysUserInfo> list =  sysUserDao.findByMap(datas);
		PageInfo<SysUserInfo> pages = new PageInfo<SysUserInfo>(list);
		return pages;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(SysUserInfo entity) {
		// TODO Auto-generated method stub
		sysUserDao.insert(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(SysUserInfo entity) {
		// TODO Auto-generated method stub
		sysUserDao.delete(entity);
	}

	@Transactional(readOnly = false)
	@Override
	public int update(SysUserInfo entity) {
		// TODO Auto-generated method stub
	return 	sysUserDao.update(entity);
	}

	@Override
	public SysUserInfo getByOpenId(String openId) {
		// TODO Auto-generated method stub
		return sysUserDao.getByOpenId(openId);
	}

	@Override
	public SysUserInfo getByUserId(String userId) {
		// TODO Auto-generated method stub
		return sysUserDao.getByUserId(userId);
	}

	@Transactional(readOnly = false)
	@Override
	public int updateUserInfo(SysUserInfo entity) {
		// TODO Auto-generated method stub
		return sysUserDao.updateUserInfo(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public int remove(SysUserInfo entity) {
		// TODO Auto-generated method stub
		return sysUserDao.remove(entity);
	}


}
