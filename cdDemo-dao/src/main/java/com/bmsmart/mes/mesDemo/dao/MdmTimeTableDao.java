package com.bmsmart.mes.mesDemo.dao;

import com.bmsmart.mes.commons.persistence.MesCrudDao;
import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmTimeTableInfo;

/**
 * @author yjx 2018/2/28
 * 排课课程表
 */
@MyBatisDao
public interface MdmTimeTableDao extends MesCrudDao<MdmTimeTableInfo>{
	
	public int updateArrive(MdmTimeTableInfo entity);
}
