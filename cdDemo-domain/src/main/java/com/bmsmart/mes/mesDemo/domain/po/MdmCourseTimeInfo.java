package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yjx  授课时间表
 *
 */
public class MdmCourseTimeInfo extends MesDataEntity<MdmCourseTimeInfo>{

	private static final long serialVersionUID = 1L;

	private String id;
	private String code; 
	private String name;
	private String week; //星期 从1~5分别代表值是周一到周五
	private String weekName; //星期 从1~5分别代表值是周一到周五
	private String timeRange; //节次 1-4 1-2节 3-4节 5-6节 7-8节
	
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
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	@Override
	public String toString() {
		return "MdmCourseTimeInfo [id=" + id + ", code=" + code + ", name=" + name + ", week=" + week + ", timeRange="
				+ timeRange + "]";
	}
	public String getWeekName() {
		return weekName;
	}
	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}
	
	
}
