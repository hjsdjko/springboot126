package com.cl.dao;

import com.cl.entity.YujufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YujufenleiView;


/**
 * 渔具分类
 * 
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
public interface YujufenleiDao extends BaseMapper<YujufenleiEntity> {
	
	List<YujufenleiView> selectListView(@Param("ew") Wrapper<YujufenleiEntity> wrapper);

	List<YujufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YujufenleiEntity> wrapper);
	
	YujufenleiView selectView(@Param("ew") Wrapper<YujufenleiEntity> wrapper);
	

}
