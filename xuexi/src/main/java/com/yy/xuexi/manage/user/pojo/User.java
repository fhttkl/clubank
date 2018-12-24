package com.yy.xuexi.manage.user.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ��Ա
 * @author fanhong
 *
 */
public class User {

	private Integer id;//����
	private String cardNo;//��Ա����
	private String name;//����
	private String tel;//�ֻ���
	private Integer sex;//�Ա�:1�� 2Ů
	private Date createDate;//����ʱ��
	private Date modifyDate;//�޸�ʱ��
	private String email;//�����ʼ�
	private BigDecimal totalBalance;//�˻����
	private String password;//����
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public BigDecimal getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}
	

	public User(String cardNo, String name, String tel, Integer sex,
			Date createDate, Date modifyDate, String email,
			BigDecimal totalBalance, String password) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.tel = tel;
		this.sex = sex;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.email = email;
		this.totalBalance = totalBalance;
		this.password = password;
	}
	public User(Integer id, String cardNo, String name, String tel,
			Integer sex, Date createDate, Date modifyDate, String email,
			BigDecimal totalBalance, String password) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.name = name;
		this.tel = tel;
		this.sex = sex;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.email = email;
		this.totalBalance = totalBalance;
		this.password = password;
	}
	public User() {
		super();
	}
}
