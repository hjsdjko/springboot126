package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 租赁信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
@TableName("zulinxinxi")
public class ZulinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZulinxinxiEntity() {
		
	}
	
	public ZulinxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 租赁编号
	 */
					
	private String zulinbianhao;
	
	/**
	 * 渔具名称
	 */
					
	private String yujumingcheng;
	
	/**
	 * 渔具分类
	 */
					
	private String yujufenlei;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 租赁价格/天
	 */
					
	private Double zulinjiage;
	
	/**
	 * 租赁时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date zulinshijian;
	
	/**
	 * 归还时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date guihaishijian;
	
	/**
	 * 租赁时长
	 */
					
	private String zulinshizhang;
	
	/**
	 * 支付价格
	 */
					
	private String zhifujiage;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	/**
	 * 归还状态
	 */
					
	private String guihaizhuangtai;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：租赁编号
	 */
	public void setZulinbianhao(String zulinbianhao) {
		this.zulinbianhao = zulinbianhao;
	}
	/**
	 * 获取：租赁编号
	 */
	public String getZulinbianhao() {
		return zulinbianhao;
	}
	/**
	 * 设置：渔具名称
	 */
	public void setYujumingcheng(String yujumingcheng) {
		this.yujumingcheng = yujumingcheng;
	}
	/**
	 * 获取：渔具名称
	 */
	public String getYujumingcheng() {
		return yujumingcheng;
	}
	/**
	 * 设置：渔具分类
	 */
	public void setYujufenlei(String yujufenlei) {
		this.yujufenlei = yujufenlei;
	}
	/**
	 * 获取：渔具分类
	 */
	public String getYujufenlei() {
		return yujufenlei;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：租赁价格/天
	 */
	public void setZulinjiage(Double zulinjiage) {
		this.zulinjiage = zulinjiage;
	}
	/**
	 * 获取：租赁价格/天
	 */
	public Double getZulinjiage() {
		return zulinjiage;
	}
	/**
	 * 设置：租赁时间
	 */
	public void setZulinshijian(Date zulinshijian) {
		this.zulinshijian = zulinshijian;
	}
	/**
	 * 获取：租赁时间
	 */
	public Date getZulinshijian() {
		return zulinshijian;
	}
	/**
	 * 设置：归还时间
	 */
	public void setGuihaishijian(Date guihaishijian) {
		this.guihaishijian = guihaishijian;
	}
	/**
	 * 获取：归还时间
	 */
	public Date getGuihaishijian() {
		return guihaishijian;
	}
	/**
	 * 设置：租赁时长
	 */
	public void setZulinshizhang(String zulinshizhang) {
		this.zulinshizhang = zulinshizhang;
	}
	/**
	 * 获取：租赁时长
	 */
	public String getZulinshizhang() {
		return zulinshizhang;
	}
	/**
	 * 设置：支付价格
	 */
	public void setZhifujiage(String zhifujiage) {
		this.zhifujiage = zhifujiage;
	}
	/**
	 * 获取：支付价格
	 */
	public String getZhifujiage() {
		return zhifujiage;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
	/**
	 * 设置：归还状态
	 */
	public void setGuihaizhuangtai(String guihaizhuangtai) {
		this.guihaizhuangtai = guihaizhuangtai;
	}
	/**
	 * 获取：归还状态
	 */
	public String getGuihaizhuangtai() {
		return guihaizhuangtai;
	}

}
