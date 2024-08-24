package com.cl.dao;

import com.cl.entity.YujuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YujuxinxiView;


/**
 * 渔具信息
 * 
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
public interface YujuxinxiDao extends BaseMapper<YujuxinxiEntity> {
	
	List<YujuxinxiView> selectListView(@Param("ew") Wrapper<YujuxinxiEntity> wrapper);

	List<YujuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YujuxinxiEntity> wrapper);
	
	YujuxinxiView selectView(@Param("ew") Wrapper<YujuxinxiEntity> wrapper);
	

}
