package com.bmsmart.mes.mesDemo.domain.po;
/**
 * 保存文件信息
 * @author yjx
 * @version 2017-09-21
 */
public class FileInfo {
	public static final String SUCCESSED = "1";
    public static final String FAILURE = "2";
    public static final String PROGRESS = "3";

    /** 调用是否成功 **/
    private boolean isSuccess;
    /** 返回结果码 **/
    private String code;
    /** 返回结果信息 **/
    private String info;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
    
	

}
