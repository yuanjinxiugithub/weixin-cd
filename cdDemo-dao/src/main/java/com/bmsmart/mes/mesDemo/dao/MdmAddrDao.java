package com.bmsmart.mes.mesDemo.dao;

import com.bmsmart.mes.commons.persistence.MesCrudDao;
import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.MdmAddrInfo;

/**
 * @author yjx 2018/2/28
 *  教室档案
 */
@MyBatisDao
public interface MdmAddrDao extends MesCrudDao<MdmAddrInfo>{

}
