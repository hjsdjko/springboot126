package com.cl.dao;

import com.cl.entity.GuihaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GuihaixinxiView;


/**
 * 归还信息
 * 
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface GuihaixinxiDao extends BaseMapper<GuihaixinxiEntity> {
	
	List<GuihaixinxiView> selectListView(@Param("ew") Wrapper<GuihaixinxiEntity> wrapper);

	List<GuihaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GuihaixinxiEntity> wrapper);
	
	GuihaixinxiView selectView(@Param("ew") Wrapper<GuihaixinxiEntity> wrapper);
	

}
