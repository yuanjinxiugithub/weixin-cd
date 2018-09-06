package com.bmsmart.mes.mesDemo.dao;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmIstrInfo;

/**
 * @author yjx 2018/2/28
 *  学院档案
 */
@MyBatisDao
public interface MdmIstrDao {

     public MdmIstrInfo  get(String id);
	 
	 public List<MdmIstrInfo> findList(MdmIstrInfo entity);
	 
	 public  List<MdmIstrInfo> findByMap(Map<String,String> map);
	 
	 public void insert(MdmIstrInfo entity);
	 
	 public void delete(MdmIstrInfo entity);
	 
	 public int update(MdmIstrInfo  entity);
}
