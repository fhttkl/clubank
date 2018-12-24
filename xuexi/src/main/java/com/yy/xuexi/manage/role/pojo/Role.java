package com.yy.xuexi.manage.role.pojo;

import java.util.Date;

public class Role {

	private Integer id;//角色信息主键
	private String roleName;//角色名称
	private Integer sort;//角色序号，角色的唯一标识，不可修改
	private Date createDate;//创建日期
	private Date modifyDate;//修改日期
	private Integer enabledMark;//有效标志：1-有效，0-无效
	private Integer deleteMark;//删除标记
	private String description;//备注
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public Integer getEnabledMark() {
		return enabledMark;
	}
	public void setEnabledMark(Integer enabledMark) {
		this.enabledMark = enabledMark;
	}
	public Integer getDeleteMark() {
		return deleteMark;
	}
	public void setDeleteMark(Integer deleteMark) {
		this.deleteMark = deleteMark;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Role(String roleName, Integer sort, Date createDate,
			Date modifyDate, Integer enabledMark, Integer deleteMark,
			String description) {
		super();
		this.roleName = roleName;
		this.sort = sort;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.enabledMark = enabledMark;
		this.deleteMark = deleteMark;
		this.description = description;
	}
	public Role(Integer id, String roleName, Integer sort, Date createDate,
			Date modifyDate, Integer enabledMark, Integer deleteMark,
			String description) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.sort = sort;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.enabledMark = enabledMark;
		this.deleteMark = deleteMark;
		this.description = description;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
}
