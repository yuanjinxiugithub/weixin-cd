package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author 作者 E-mail:
* @version 创建时间：2018年3月23日 下午12:05:43
* 类说明  文件信息
*/
public class SysFileInfo extends MesDataEntity<SysFileInfo>{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fileName;//文件名称
	private String extName; //文件扩展名
	private String filePath;//文件路径
	protected String createUser;	// 创建者
	protected Date createTime;	// 创建日期
	protected String updateUser;	// 更新者
	protected Date updateTime;	// 更新日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	
	

}
