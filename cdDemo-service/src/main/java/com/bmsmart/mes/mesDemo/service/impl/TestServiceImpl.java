package com.bmsmart.mes.mesDemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.bmsmart.mes.mesDemo.dao.DemoTestDao;
import com.bmsmart.mes.mesDemo.domain.po.DemoTest;
import com.bmsmart.mes.mesDemo.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Malan
 * @date 2017年5月24日 下午2:53:00  
 *
 */
@Service("testService")
public class TestServiceImpl extends BaseServiceImpl implements TestService{

    @Autowired
    private DemoTestDao demoTestDao;
    
   /* @Autowired
    private JedisCommands JedisCommands;*/

    @Autowired
    private PlatformTransactionManager transactionManager;

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	
public List<DemoTest> queryTest() {

	        List<DemoTest> demoTestList = new ArrayList<DemoTest>();
	        TransactionStatus status = null; //事务step1

	        try {
	            status = this.initTansactionStatus(transactionManager, TransactionDefinition.PROPAGATION_REQUIRED);//事务step2
	            demoTestList= demoTestDao.selectDemoTest();
	       //     PageHelper.startPage(1, 1);// 第一页，1条内容
	            // PageHelper.startPage(1, 1, "id desc");  e.g. 使用order
	          /*  byte[] data = JedisCommands.getBytes("_demo_queryTest");
	            if(null == data){
	            	logger.info("缓存中没有发现数据，需要从数据库中获取。。。");
	            	DemoTestList = DemoTestDao.selectDemoTest();
	            	JedisCommands.set("_demo_queryTest", com..erp.base.util.serializer.HessianSerializer.serialize(DemoTestList));
	            	JedisCommands.expire("_demo_queryTest", 60);
	            }else{
	            	logger.info("从缓存中获取数据成功！");
	            	DemoTestList = HessianSerializer.unserialize(data);
	            }*/
	        //    PageInfo page = new PageInfo(DemoTestList); // page中包含关于分页的各类信息
	            transactionManager.commit ( status );//事务step3提交
	        } catch ( Exception e){
	            transactionManager.rollback(status);//事务step4回滚
	            logger.error("queryTest error by service,exception:{}", e.getMessage());
	        }
	        return demoTestList;
	    }


public PageInfo<DemoTest> queryPage() {

	        List<DemoTest> demoTestList = new ArrayList<DemoTest>();
	        TransactionStatus status = null; //事务step1

	        try {
	            status = this.initTansactionStatus(transactionManager, TransactionDefinition.PROPAGATION_REQUIRED);//事务step2
	           PageHelper.startPage(1, 3);//.startPage(1, 1, "id desc"); 
	           /*  byte[] data = JedisCommands.getBytes("_demo_queryTest");
	            if(null == data){
	            	logger.info("缓存中没有发现数据，需要从数据库中获取。。。");
	            	DemoTestList = DemoTestDao.selectDemoTest();
	            	JedisCommands.set("_demo_queryTest", com..erp.base.util.serializer.HessianSerializer.serialize(DemoTestList));
	            	JedisCommands.expire("_demo_queryTest", 60);
	            }else{
	            	logger.info("从缓存中获取数据成功！");
	            	DemoTestList = HessianSerializer.unserialize(data);
	            }*/
	           demoTestList= demoTestDao.selectDemoTest();
	       PageInfo<DemoTest> page = new PageInfo(demoTestList); // page中包含关于分页的各类信息
	            transactionManager.commit ( status );//事务step3提交
	            return page;
	        } catch ( Exception e){
	            transactionManager.rollback(status);//事务step4回滚

	            logger.error("queryTest error by service,exception:{}", e.getMessage());
	        }
	     return null;
	    }
public PageInfo<DemoTest> queryPage(int startPage,int pageSize,Map reqMap ) {

    List<DemoTest> demoTestList = new ArrayList<DemoTest>();
    TransactionStatus status = null; //事务step1

    try {
        status = this.initTansactionStatus(transactionManager, TransactionDefinition.PROPAGATION_REQUIRED);//事务step2
       PageHelper.startPage(startPage, pageSize);//.startPage(1, 1, "id desc"); 
       demoTestList= demoTestDao.selectDemoTest();
   PageInfo<DemoTest> page = new PageInfo<DemoTest>(demoTestList); // page中包含关于分页的各类信息
        transactionManager.commit ( status );//事务step3提交
        return page;
    } catch ( Exception e){
        transactionManager.rollback(status);//事务step4回滚
        logger.error("queryTest error by service,exception:{}", e.getMessage());
    }
 return null;
}
public DemoTestDao getDemoTestDao() {
	return demoTestDao;
}


public void setDemoTestDao(DemoTestDao demoTestDao) {
	this.demoTestDao = demoTestDao;
}


@Override
public void add(DemoTest d) {
	demoTestDao.insert(d);
}


@Override
public DemoTest get(String id) {
	DemoTest demoTest=demoTestDao.get(id);
	return demoTest;
}




}
