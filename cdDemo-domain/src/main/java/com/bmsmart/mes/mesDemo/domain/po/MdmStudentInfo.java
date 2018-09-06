package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yjx 学生档案
 *
 */
public class MdmStudentInfo extends MesDataEntity<MdmStudentInfo>{

	private static final long serialVersionUID = 1L;

	private String id;
	private String code;
	private String name;
	private String classCode;//所属班级
	private String className;//所属班级
	private String parentCode;//所属学院
	
	private String createUser; // 创建者
	private String updateUser; // 更新者
	private Date createTime;	// 创建日期
	private Date updateTime;	// 更新日期
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
