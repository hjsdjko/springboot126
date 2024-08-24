package com.cl.dao;

import com.cl.entity.DiscussyujuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyujuxinxiView;


/**
 * 渔具信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface DiscussyujuxinxiDao extends BaseMapper<DiscussyujuxinxiEntity> {
	
	List<DiscussyujuxinxiView> selectListView(@Param("ew") Wrapper<DiscussyujuxinxiEntity> wrapper);

	List<DiscussyujuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyujuxinxiEntity> wrapper);
	
	DiscussyujuxinxiView selectView(@Param("ew") Wrapper<DiscussyujuxinxiEntity> wrapper);
	

}
