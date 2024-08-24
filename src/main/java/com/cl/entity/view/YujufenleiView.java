package com.cl.entity.view;

import com.cl.entity.YujufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 渔具分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
@TableName("yujufenlei")
public class YujufenleiView  extends YujufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YujufenleiView(){
	}
 
 	public YujufenleiView(YujufenleiEntity yujufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, yujufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
