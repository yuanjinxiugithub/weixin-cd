package com.bmsmart.mes.mesDemo.dao;

import java.util.List;

import com.bmsmart.mes.commons.persistence.annotation.MyBatisDao;
import com.bmsmart.mes.mesDemo.domain.po.DemoTest;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Malan
 * @date 2017年5月24日 下午2:46:39  
 *
 */
@MyBatisDao
public interface DemoTestDao {
	public DemoTest get(String id);
    public List<DemoTest> selectDemoTest ();
    public void insert(DemoTest d);
    public void insertBatch(List<DemoTest> d);
    /*
     * 批量删除
     */
    public void deleteBatchDeleteEmps(List<String> idList);
}
