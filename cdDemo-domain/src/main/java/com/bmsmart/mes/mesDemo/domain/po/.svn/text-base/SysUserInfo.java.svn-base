package com.bmsmart.mes.mesDemo.domain.po;

import java.util.Date;

import com.bmsmart.mes.commons.persistence.MesDataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author yjx  用户信息  2018/3/4
 *
 */
public class SysUserInfo extends MesDataEntity<SysUserInfo>{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;
	private String pwd;
	private String loginName;//登录名
	private String name;//用户名字
	private String email;
	private String tel;
	private String userType;//用户类型
	private String userImg;//暂时不用
	private String lastIp;//暂时不用
	private Date lastLoginTime;//暂时不用
	private String openId;//用户微信openId
	
	private String createUser; // 创建者
	private String updateUser; // 更新者
	private Date createTime;	// 创建日期
	private Date updateTime;	// 更新日期
	
	private String beloyClass;//所属班级/学院
	
	private String beloyClassName;//所属班级/学院
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getBeloyClass() {
		return beloyClass;
	}
	public void setBeloyClass(String beloyClass) {
		this.beloyClass = beloyClass;
	}
	
	@Override
	public String toString() {
		return "SysUserInfo [id=" + id + ", userId=" + userId + ", pwd=" + pwd + ", loginName=" + loginName + ", name="
				+ name + ", email=" + email + ", tel=" + tel + ", userType=" + userType + ", userImg=" + userImg
				+ ", lastIp=" + lastIp + ", lastLoginTime=" + lastLoginTime + ", openId=" + openId + ", createUser="
				+ createUser + ", updateUser=" + updateUser + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", beloyClass=" + beloyClass + "]";
	}
	public String getBeloyClassName() {
		return beloyClassName;
	}
	public void setBeloyClassName(String beloyClassName) {
		this.beloyClassName = beloyClassName;
	}
}
