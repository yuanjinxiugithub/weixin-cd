package com.bmsmart.mes.mesDemo.service.export;

import com.bmsmart.mes.mesDemo.dao.DemoTestDao;
import com.bmsmart.mes.mesDemo.domain.bean.Result;
import com.bmsmart.mes.mesDemo.export.TestServiceExport;
import com.bmsmart.mes.mesDemo.export.request.TestRequest;
import com.bmsmart.mes.mesDemo.export.response.TestResponse;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Malan
 * @date 2017年5月24日 下午2:58:12  
 *
 */
public class TestServiceExportImpl implements TestServiceExport {

    protected DemoTestDao demoTestDao;

    public TestResponse queryTestExport(TestRequest testRequest) {
        TestResponse testResponse = new TestResponse();

        Result result = new Result();

        result.setSuccess(true);

        result.setTxnStatus(Result.PROGRESS);
        try {
            testResponse.setDemoTestList(demoTestDao.selectDemoTest());
            result.setTxnStatus(Result.SUCCESSED);
        }catch (Exception e){
            result.setTxnStatus(Result.FAILURE);
        }

        testResponse.setResult(result);

        return testResponse;
    }

	public DemoTestDao getDemoTestDao() {
		return demoTestDao;
	}

	public void setDemoTestDao(DemoTestDao demoTestDao) {
		this.demoTestDao = demoTestDao;
	}

   
}
