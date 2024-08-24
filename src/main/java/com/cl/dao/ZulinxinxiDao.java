package com.cl.dao;

import com.cl.entity.ZulinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZulinxinxiView;


/**
 * 租赁信息
 * 
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface ZulinxinxiDao extends BaseMapper<ZulinxinxiEntity> {
	
	List<ZulinxinxiView> selectListView(@Param("ew") Wrapper<ZulinxinxiEntity> wrapper);

	List<ZulinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZulinxinxiEntity> wrapper);
	
	ZulinxinxiView selectView(@Param("ew") Wrapper<ZulinxinxiEntity> wrapper);
	

}
