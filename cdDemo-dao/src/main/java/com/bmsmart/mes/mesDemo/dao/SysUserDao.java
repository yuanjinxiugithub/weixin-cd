package com.bmsmart.mes.mesDemo.dao;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.SysUserInfo;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2018年3月22日 下午4:30:45 类说明
 */
@MyBatisDao
public interface SysUserDao {
	public SysUserInfo get(String id);

	public List<SysUserInfo> findList(SysUserInfo entity);

	public List<SysUserInfo> findByMap(Map<String, String> map);

	public void insert(SysUserInfo entity);

	public void delete(SysUserInfo entity);

	public int update(SysUserInfo entity);
	
	public int updateUserInfo(SysUserInfo entity);

	public SysUserInfo getByOpenId(String openId);// 根据用户openId 判断用户是否绑定账号

	public SysUserInfo getByUserId(String userId);// 根据账号 判断用户是否存在

	public int remove(SysUserInfo entity);
}
