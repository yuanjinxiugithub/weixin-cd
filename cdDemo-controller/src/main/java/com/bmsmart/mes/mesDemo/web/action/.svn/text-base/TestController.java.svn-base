package com.bmsmart.mes.mesDemo.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmsmart.mes.base.util.StringUtil;
import com.bmsmart.mes.base.util.UUID;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.commons.web.datatables.DataTablePage;
import com.bmsmart.mes.mesDemo.domain.po.DemoTest;
import com.bmsmart.mes.mesDemo.domain.po.DemoTest1;
import com.bmsmart.mes.mesDemo.domain.vo.response.DemoResponseVo;
import com.bmsmart.mes.mesDemo.service.TestService;
import com.bmsmart.mes.platform.auth.base.AuthPassport;
import com.github.pagehelper.PageInfo;


/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Malan
 * @date 2017年5月24日 下午3:09:11  
 *
 */
@Controller
public class TestController extends BaseController {

    @Resource(name = "testService")
    private TestService testService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@ResponseBody
	@RequestMapping(value = "/get")
	public ModelAndView get(HttpServletRequest request,HttpServletResponse response) {
    	Map<String,String> datas = WebUtil.request2Map(request);
    	String id=datas.get("id");
		DemoTest entity = null;
		AjaxResponder result =null;
		try {
		 entity = testService.get(id);
		 if(StringUtil.isNotBlank(entity.getId())){
		  result = AjaxResponder.getInstance(Boolean.TRUE , "提取信息成功"  , entity);
		}else{
			result = AjaxResponder.getInstance(Boolean.FALSE , "提取信息失败,请联系管理员!"  , entity);
			  }
	     } catch (Exception e) {
				logger.error(" gey error by TestController ,exception:{}", e);
				result=AjaxResponder.getInstance(Boolean.FALSE ,  "提取信息失败,请联系管理员!"  , null);
		 }
		ModelAndView mv = new ModelAndView("response");
	    mv.addObject("result",result);
		return mv;
	}
    @RequestMapping(value = "/test/querytest.do")
    public ModelAndView queryTest(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("test");
        DemoResponseVo DemoResponseVo;
        List<DemoResponseVo> DemoResponseVoList = new ArrayList<DemoResponseVo>();

        List<DemoTest> DemoTestList = testService.queryTest();

        for (DemoTest DemoTest : DemoTestList){

            DemoResponseVo = new DemoResponseVo();

                try {
					PropertyUtils.copyProperties(DemoResponseVo, DemoTest);
				} catch (IllegalAccessException e) {
					 logger.error("queryTest error by controller,exception:{}", e.getMessage());
				} catch (InvocationTargetException e) {
					 logger.error("queryTest error by controller,exception:{}", e.getMessage());
				} catch (NoSuchMethodException e) {
					 logger.error("queryTest error by controller,exception:{}", e.getMessage());
				}
        

            DemoResponseVoList.add(DemoResponseVo);
        }

        view.addObject("DemoResponseVoList", DemoResponseVoList);
        view.addObject("page", DemoResponseVoList);

        return view;

    }
    @RequestMapping(value = {"/", "index.html"})
    public String index() {
        return "index";
    }
    @RequestMapping(value = {"/success"})
    public String index2() {
        return "index2";
    }
    @ResponseBody
    @RequestMapping("/test")
    public List<DemoTest> selectAll() {
        return testService.queryTest();
    }
    @ResponseBody
    @RequestMapping("/testpage")
    public PageInfo<DemoTest> selectForPage() {
        return testService.queryPage();
    }
    
 /*   @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response) {
    	Map<String,String> datas = WebUtil.request2Map(request);
    	String username=datas.get("username");
     String password=datas.get("password");
	 //username="admin";
	//  password="admin";
	final String server = "http://192.168.2.241:8080/cas/v1/tickets";
	final String service = "http://192.168.2.242:9080/mes-demo/success.do"; // 随意写
	//	final String proxyValidate = "http://127.0.0.1:8080/cas/proxyValidate";
	 // 	final String server = "http://10.0.43.42:18080/cas/v1/tickets";
	//	final String service = "http://127.0.0.1:8080/mes-demo/success.do"; // 随意写
    String  ticketStr="";//CasClient.getTicket(server, username, password, service);
    if(ticketStr!=null) {
     // CasClient.ticketValidate(proxyValidate, ticketStr, service);
     return "sucess";
    }else {
    	return "error";
    }
    }*/
    @AuthPassport
    @ResponseBody
    @RequestMapping("/testadd")
    public String add(HttpServletRequest request, HttpServletResponse response) {
    	Map<String,String> datas = WebUtil.request2Map(request);
    	String id=datas.get("id");
    	String name=datas.get("name");
    	DemoTest d=new DemoTest();
    	String id1=UUID.getUUID();
    	d.setId(id+id1);
    	d.setName(id+"name:"+name);
    	testService.add(d);
    	return "success";
    }
    @ResponseBody
  	@RequestMapping(value = "save")
  	public ModelAndView save(DemoTest demoTest, Model model) {
  	if (!beanValidator(model, demoTest)){
  		//	return form(testData, model);
  		}
  		AjaxResponder result = null;
      	try {
      	//	testService.add(demoTest);
  		result =  AjaxResponder.getInstance(Boolean.TRUE ,  "保存成功! "  , null);
  	} catch (Exception e) {
  		logger.error("save   error by Controller ,exception:{}", e.getMessage());
  		result =  AjaxResponder.getInstance(Boolean.FALSE ,e.getMessage(), null);
  	}
  	ModelAndView mv = new ModelAndView("response");
  	mv.addObject("result", result);
  	return mv;
  	}
    
     //测试---2017-08-10--这里新建了一个简单测试用的实体类 
    @ResponseBody
    @RequestMapping("/testselect")
    public List<DemoTest1> testSelect(){
    	List<DemoTest1> list = new ArrayList<>();
    	list.add(new DemoTest1("产品value1","产品A"));
    	list.add(new DemoTest1("产品value2","产品B"));
    	list.add(new DemoTest1("产品value3","产品C"));
    	list.add(new DemoTest1("产品value4","产品D"));
    	list.add(new DemoTest1("产品value5","产品E"));
    	list.add(new DemoTest1("产品value6","产品F"));
    	list.add(new DemoTest1("产品value7","产品AA"));
    	list.add(new DemoTest1("产品value8","产品BB"));
    	list.add(new DemoTest1("产品value9","产品CC"));
    	list.add(new DemoTest1("产品value10","产品DD"));
    	list.add(new DemoTest1("产品value11","产品EE"));
    	list.add(new DemoTest1("产品value12","产品FF"));
    	return list;
    }
    
    @RequestMapping("/ajaxtest")
    public void  testAjaxSelect(HttpServletRequest request, HttpServletResponse response){
    	String data  = request.getParameter("q");//前台获取的查询数据
    	System.out.println(data);//测试
    }
    
   	
   	
    @RequestMapping(value="/datatablesTest")  
    @ResponseBody  
    public DataTablePage<DemoTest> datatablesTest(HttpServletRequest request){  
    	 logger.debug("----->>>>>[getPage]:");
         //使用DataTables的属性接收分页数据
         DataTablePage<DemoTest> dataTable = new DataTablePage<DemoTest>(request);
         //开始分页：PageHelper会处理接下来的第一个查询
         PageInfo<DemoTest> pageInfo=   testService.queryPage(dataTable.getPage_num(),dataTable.getPage_size(),null);
         //封装数据给DataTables
		 dataTable= dataTable.convert(dataTable,pageInfo);
         return dataTable;  
    }  
}
