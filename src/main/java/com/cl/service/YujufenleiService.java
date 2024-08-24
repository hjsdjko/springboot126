package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YujufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YujufenleiView;


/**
 * 渔具分类
 *
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
public interface YujufenleiService extends IService<YujufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YujufenleiView> selectListView(Wrapper<YujufenleiEntity> wrapper);
   	
   	YujufenleiView selectView(@Param("ew") Wrapper<YujufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YujufenleiEntity> wrapper);
   	

}

