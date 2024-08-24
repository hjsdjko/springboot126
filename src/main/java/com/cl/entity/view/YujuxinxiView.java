package com.cl.entity.view;

import com.cl.entity.YujuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 渔具信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
@TableName("yujuxinxi")
public class YujuxinxiView  extends YujuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YujuxinxiView(){
	}
 
 	public YujuxinxiView(YujuxinxiEntity yujuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yujuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
