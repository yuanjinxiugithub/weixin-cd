package com.bmsmart.mes.mesDemo.dao;

import com.bmsmart.mes.commons.persistence.MesCrudDao;
import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmTeacherInfo;

/**
 * @author yjx  2018/2/28
 *  教师档案
 */
@MyBatisDao
public interface MdmTeacherDao extends MesCrudDao<MdmTeacherInfo>{

	
}
