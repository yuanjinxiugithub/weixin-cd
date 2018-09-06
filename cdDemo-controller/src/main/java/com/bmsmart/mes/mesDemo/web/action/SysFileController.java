package com.bmsmart.mes.mesDemo.web.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bmsmart.mes.base.util.StringUtil;
import com.bmsmart.mes.base.util.UUID;
import com.bmsmart.mes.base.util.web.AjaxResponder;
import com.bmsmart.mes.base.util.web.WebUtil;
import com.bmsmart.mes.commons.web.BaseController;
import com.bmsmart.mes.commons.web.datatables.DataTablePage;
import com.bmsmart.mes.mesDemo.domain.po.SysFileInfo;
import com.bmsmart.mes.mesDemo.service.SysFileService;
import com.github.pagehelper.PageInfo;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月23日 上午10:28:44
* 类说明  文件上传下载 控制器
*/
@Controller
@RequestMapping(value="/fileOp")
public class SysFileController extends BaseController{
	    @Autowired 
		private  SysFileService sysFileService;
	    
	  /**  
     * 文件上传功能  
     * @param file  
     * @return  
     * @throws IOException   
     */  
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    @ResponseBody  
    public AjaxResponder upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{  
    	AjaxResponder result = null;
    	 String fileName = file.getOriginalFilename();
    	 String fileNameExt = fileName.substring(fileName.lastIndexOf("."));
    	 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    	 String date = df.format(new Date());  
        String path = "C:/Tomact8.5/webapps/cd-demo/imgs/";  
        String fileName1 = date+fileNameExt;    //获取文件名称
        if(!file.isEmpty()){
        	File dir = new File(path,fileName1);          
            if(!dir.exists()){  
                dir.mkdirs();  
            }  
          //将上传文件保存到一个目标文件中 
            file.transferTo(dir);  
            SysFileInfo entity = new SysFileInfo();
            entity.setId(UUID.getUUID());
            entity.setFilePath(path);
            entity.setFileName(fileName1);
            entity.setCreateTime(new Date());
            entity.setCreateUser("admin");
            try {
    			sysFileService.save(entity);
    			result = AjaxResponder.getInstance(Boolean.TRUE, "图片保存成功! ", entity.getId());//返回保存的图片id
    		} catch (Exception e) {
    			// TODO: handle exception
    			logger.error("文件保存信息失败");
    			result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
    		}
        }else{
        	result = AjaxResponder.getInstance(Boolean.FALSE, "上传文件为空! ", null);
        }
        return result;  
    }  

    @RequestMapping(value="/download")  
    @ResponseBody  
    public AjaxResponder download(HttpServletRequest request){  
    	AjaxResponder result = null;
    	Map<String, String> datas = WebUtil.request2Map(request);
    	String id = datas.get("id");
    	SysFileInfo entity = new SysFileInfo();
    	if(StringUtil.isNotBlank(id)){
    		try {
    			entity = sysFileService.get(id);
    			result = AjaxResponder.getInstance(Boolean.TRUE, "获取信息成功! ", entity);
    		} catch (Exception e) {
    			// TODO: handle exception
    			result = AjaxResponder.getInstance(Boolean.FALSE, "获取信息失败! ", null);
    		}
    	}else{
    		result = AjaxResponder.getInstance(Boolean.FALSE, "参数输入有误，请检查! ", null);
    	}
    	   
		return result;  
    }  
    

	   /**
	  	 * 分页查询
	  	 */
	  	@ResponseBody
	  	@RequestMapping("/findByMap")
	  	public DataTablePage<SysFileInfo> findPage(HttpServletRequest request, HttpServletResponse response){
	  		Map<String, String> datas = WebUtil.request2Map(request);
	  		DataTablePage<SysFileInfo> dataTable = new DataTablePage<SysFileInfo>(request);
	  		// 开始分页：PageHelper会处理接下来的第一个查询
	  		PageInfo<SysFileInfo> pageInfo = sysFileService.findPage(dataTable.getPage_num(),
	  				dataTable.getPage_size(), datas);
	  		dataTable = dataTable.convert(dataTable, pageInfo);
	  		return dataTable;
	  	}
	  	
	  	 /**
		 * 删除信息
		 */
		@ResponseBody
		@RequestMapping("/delete")
		public ModelAndView delete(SysFileInfo entity){
			AjaxResponder result = null;
			entity.setUpdateUser("admin");
			entity.setUpdateTime(new Date());
			try {
				sysFileService.delete(entity);
				result = AjaxResponder.getInstance(Boolean.TRUE, "删除信息成功! ", null);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("delete 班级信息  error by Controller ,exception:{}", e.getMessage());
				result = AjaxResponder.getInstance(Boolean.FALSE, e.getMessage(), null);
			}
			ModelAndView mv = new ModelAndView("response");
			mv.addObject("result", result);
			return mv;
		}
    
		/**
		 * 根据id 获取信息
		 */
		@RequestMapping(value = "/get")
		@ResponseBody
		public SysFileInfo getById(@RequestParam(required = false) String id) {
			SysFileInfo entity = new SysFileInfo();
			entity = sysFileService.get(id);
			return entity;
		}
}
