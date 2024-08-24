package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZulinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZulinxinxiView;


/**
 * 租赁信息
 *
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface ZulinxinxiService extends IService<ZulinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZulinxinxiView> selectListView(Wrapper<ZulinxinxiEntity> wrapper);
   	
   	ZulinxinxiView selectView(@Param("ew") Wrapper<ZulinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZulinxinxiEntity> wrapper);
   	

}

