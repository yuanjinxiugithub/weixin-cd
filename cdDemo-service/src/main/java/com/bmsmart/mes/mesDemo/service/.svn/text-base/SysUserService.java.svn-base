package com.bmsmart.mes.mesDemo.service;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月22日 下午4:57:02
* 类说明
*/

public interface SysUserService {
	public SysUserInfo  get(String id);
	 
	 public List<SysUserInfo> findList(SysUserInfo entity);
	 
	 public PageInfo<SysUserInfo> findPage(int pageNum, int pageSize,
			Map<String, String> datas);
	 
	 public void save(SysUserInfo entity);
	 
	 public void delete(SysUserInfo entity);
	 
	 public int update(SysUserInfo entity);
	 
	 public int updateUserInfo(SysUserInfo entity);
	 
	 public SysUserInfo  getByOpenId(String openId);
	 
	 public SysUserInfo  getByUserId(String userId);
	 
	 public int remove(SysUserInfo entity);
}
