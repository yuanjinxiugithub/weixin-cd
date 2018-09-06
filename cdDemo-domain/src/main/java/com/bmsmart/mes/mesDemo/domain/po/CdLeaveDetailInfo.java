package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yjx 2018/3/5
 *   请假明细
 */
public class CdLeaveDetailInfo extends MesDataEntity<CdLeaveDetailInfo>{
	private static final long serialVersionUID = 8186170631428451222L;
	
	private String id;
	private String leaveId;
	private String studentCode;//学生编码
	private String studentName;//学生名称
	private String studentClass;//学生班级
	private String className;//学生班级
	private Date leaveTime;//请假时间
	private String fileId;//上传附件
	private String leaveReason;//请假原因
	private String isCheck;//是否通过审核 0默认未审核 1表示审核
	private String stauts;//通过或者不通过 0--没通过 1--通过
	
	private String scheduleCode;//排课编码 --暂时无用

    private String timeCode; //上课时间编码
    private String timeCodeName;//时间描述
    private String courseName;
	private String coureCode;
    private String teacherCode;
    private String teacherName;
    private String addrCode;//上课编码
    private String addrName;//上课名称
    
	private String createUser;	// 创建者
  	private String updateUser;	// 更新者
  	private Date createTime;	// 创建日期
  	private Date updateTime;	// 更新日期
  	
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public String getCoureCode() {
		return coureCode;
	}
	public void setCoureCode(String coureCode) {
		this.coureCode = coureCode;
	}
	public String getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getAddrCode() {
		return addrCode;
	}
	public void setAddrCode(String addrCode) {
		this.addrCode = addrCode;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
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
  	
	public String getLeaveReason() {
		return leaveReason;
	}
	
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getIsCheck() {
		return isCheck;
	}
	
	
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTimeCodeName() {
		return timeCodeName;
	}
	public void setTimeCodeName(String timeCodeName) {
		this.timeCodeName = timeCodeName;
	}
}
