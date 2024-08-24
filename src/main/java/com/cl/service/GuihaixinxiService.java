package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GuihaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GuihaixinxiView;


/**
 * 归还信息
 *
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
public interface GuihaixinxiService extends IService<GuihaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuihaixinxiView> selectListView(Wrapper<GuihaixinxiEntity> wrapper);
   	
   	GuihaixinxiView selectView(@Param("ew") Wrapper<GuihaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuihaixinxiEntity> wrapper);
   	

}

