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
 * 渔具信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
@TableName("yujuxinxi")
public class YujuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YujuxinxiEntity() {
		
	}
	
	public YujuxinxiEntity(T t) {
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
	 * 渔具图片
	 */
					
	private String yujutupian;
	
	/**
	 * 租赁价格/天
	 */
					
	private Double zulinjiage;
	
	/**
	 * 使用场地
	 */
					
	private String shiyongchangdi;
	
	/**
	 * 渔具详情
	 */
					
	private String yujuxiangqing;
	
	/**
	 * 租赁状态
	 */
					
	private String zulinzhuangtai;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
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
	 * 设置：渔具图片
	 */
	public void setYujutupian(String yujutupian) {
		this.yujutupian = yujutupian;
	}
	/**
	 * 获取：渔具图片
	 */
	public String getYujutupian() {
		return yujutupian;
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
	 * 设置：使用场地
	 */
	public void setShiyongchangdi(String shiyongchangdi) {
		this.shiyongchangdi = shiyongchangdi;
	}
	/**
	 * 获取：使用场地
	 */
	public String getShiyongchangdi() {
		return shiyongchangdi;
	}
	/**
	 * 设置：渔具详情
	 */
	public void setYujuxiangqing(String yujuxiangqing) {
		this.yujuxiangqing = yujuxiangqing;
	}
	/**
	 * 获取：渔具详情
	 */
	public String getYujuxiangqing() {
		return yujuxiangqing;
	}
	/**
	 * 设置：租赁状态
	 */
	public void setZulinzhuangtai(String zulinzhuangtai) {
		this.zulinzhuangtai = zulinzhuangtai;
	}
	/**
	 * 获取：租赁状态
	 */
	public String getZulinzhuangtai() {
		return zulinzhuangtai;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
