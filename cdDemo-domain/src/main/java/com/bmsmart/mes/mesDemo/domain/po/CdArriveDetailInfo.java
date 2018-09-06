package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/** 
 * @author yjx 2018/3/5
 *  点到明细
 */
public class CdArriveDetailInfo extends MesDataEntity<CdArriveDetailInfo>{

	private static final long serialVersionUID = 3675991290425261729L;

	private String id;//唯一id
	private String arriveId;//达到id(关联)
    private String studentCode;//达到学生
    private String studentName;//达到学生
    private String classCode;//达到的学生班级
    private String className;//达到学生所属班级
    private String instCode;//达到学生所属学院
    private Date arriveTime;//学生达到时间
    
	private String courseCode;//课程编码
    private String timeCode;//时间编码
    private String courseName;//课程名字
    private String teacherCode;//教师编码
    private String teacherName;//教师名字
    private Date arriveTime1;//点到开始时间
    private String allNum;//总人数
    private String arriveNum;//点到人数
    private String leaveNum;//请假人数
    
    private String createUser;	// 创建者
	private String updateUser;	// 更新者
	private Date createTime;	// 创建日期
	private Date updateTime;	// 更新日期
	
    
    public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArriveId() {
		return arriveId;
	}
	public void setArriveId(String arriveId) {
		this.arriveId = arriveId;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
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
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getArriveTime1() {
		return arriveTime1;
	}
	public void setArriveTime1(Date arriveTime1) {
		this.arriveTime1 = arriveTime1;
	}
	public String getAllNum() {
		return allNum;
	}
	public void setAllNum(String allNum) {
		this.allNum = allNum;
	}
	public String getArriveNum() {
		return arriveNum;
	}
	public void setArriveNum(String arriveNum) {
		this.arriveNum = arriveNum;
	}
	public String getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(String leaveNum) {
		this.leaveNum = leaveNum;
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
	    
	
}
