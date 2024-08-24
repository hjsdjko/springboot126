package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyujuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyujuxinxiView;


/**
 * 渔具信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface DiscussyujuxinxiService extends IService<DiscussyujuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyujuxinxiView> selectListView(Wrapper<DiscussyujuxinxiEntity> wrapper);
   	
   	DiscussyujuxinxiView selectView(@Param("ew") Wrapper<DiscussyujuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyujuxinxiEntity> wrapper);
   	

}

