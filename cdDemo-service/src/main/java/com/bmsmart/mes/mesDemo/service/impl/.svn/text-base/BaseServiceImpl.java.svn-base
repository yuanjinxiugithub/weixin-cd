package com.bmsmart.mes.mesDemo.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Malan
 * @date 2017年5月24日 下午2:50:58  
 *
 */
public class BaseServiceImpl {


    protected TransactionStatus initTansactionStatus(
            PlatformTransactionManager transactionManager, int propagetion) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();// 事务定义类
        def.setPropagationBehavior(propagetion);
        return transactionManager.getTransaction(def);
    }
}
