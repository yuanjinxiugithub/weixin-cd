package com.bmsmart.mes.mesDemo.dao;

import java.util.List;
import java.util.Map;

import com.bmsmart.mes.commons.persistence.MesCrudDao;
import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.CdLeaveDetailInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月7日 下午4:51:06
* 类说明 请假 dao 
*/
@MyBatisDao
public interface CdleaveDao extends MesCrudDao<CdLeaveDetailInfo>{
	public List<CdLeaveDetailInfo> findByMapNo(Map<String,String> map);
	
	public List<CdLeaveDetailInfo> findByMapLeave(Map<String,String> map);//根据couseId 查询请假列表
	
	public  int updateStatus(CdLeaveDetailInfo entity);
}
