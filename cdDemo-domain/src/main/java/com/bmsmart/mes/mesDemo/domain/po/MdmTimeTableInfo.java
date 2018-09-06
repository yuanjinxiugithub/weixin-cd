package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yjx 排课表
 *
 */
public class MdmTimeTableInfo  extends MesDataEntity<MdmCourseInfo>{

	private static final long serialVersionUID = 1L;

	private String id;
	private String code;
	private String courseCode;//课程编码
	private String courseName;//课程编码名称
	private String timeCode;//排课时间
	private String timeName;//排课时间
    private String tearchCode;//教师编码
    private String tearchName;//教师名称
    
    private String  classCode;//班级编码
    private String  className;//班级名称
    
    
    private String name;//时间名称
    private String week;//星期
    private String timeSeq;//时间段
    private String tCode;//时间编码    
    
    private String createUser; // 创建者
	private String updateUser; // 更新者
	private Date createTime;	// 创建日期
	private Date updateTime;	// 更新日期
	
	private String arriveId;//关联id
	
	
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public String getTearchName() {
		return tearchName;
	}
	public void setTearchName(String tearchName) {
		this.tearchName = tearchName;
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
	public String getTimeSeq() {
		return timeSeq;
	}
	public void setTimeSeq(String timeSeq) {
		this.timeSeq = timeSeq;
	}
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
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}
	public String getTearchCode() {
		return tearchCode;
	}
	public void setTearchCode(String tearchCode) {
		this.tearchCode = tearchCode;
	}
	@Override
	public String toString() {
		return "MdmTimeTableInfo [id=" + id + ", code=" + code + ", courseCode=" + courseCode + ", timeCode=" + timeCode
				+ ", tearchCode=" + tearchCode + "]";
	}
	public String gettCode() {
		return tCode;
	}
	public void settCode(String tCode) {
		this.tCode = tCode;
	}
	public String getArriveId() {
		return arriveId;
	}
	public void setArriveId(String arriveId) {
		this.arriveId = arriveId;
	}
	
	
}
