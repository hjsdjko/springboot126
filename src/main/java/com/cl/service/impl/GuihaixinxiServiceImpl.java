package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.GuihaixinxiDao;
import com.cl.entity.GuihaixinxiEntity;
import com.cl.service.GuihaixinxiService;
import com.cl.entity.view.GuihaixinxiView;

@Service("guihaixinxiService")
public class GuihaixinxiServiceImpl extends ServiceImpl<GuihaixinxiDao, GuihaixinxiEntity> implements GuihaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuihaixinxiEntity> page = this.selectPage(
                new Query<GuihaixinxiEntity>(params).getPage(),
                new EntityWrapper<GuihaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuihaixinxiEntity> wrapper) {
		  Page<GuihaixinxiView> page =new Query<GuihaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GuihaixinxiView> selectListView(Wrapper<GuihaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuihaixinxiView selectView(Wrapper<GuihaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
