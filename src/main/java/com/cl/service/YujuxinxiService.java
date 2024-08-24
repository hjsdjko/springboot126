package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YujuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YujuxinxiView;


/**
 * 渔具信息
 *
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
public interface YujuxinxiService extends IService<YujuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YujuxinxiView> selectListView(Wrapper<YujuxinxiEntity> wrapper);
   	
   	YujuxinxiView selectView(@Param("ew") Wrapper<YujuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YujuxinxiEntity> wrapper);
   	

}

