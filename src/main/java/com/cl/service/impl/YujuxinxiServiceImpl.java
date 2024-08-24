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


import com.cl.dao.YujuxinxiDao;
import com.cl.entity.YujuxinxiEntity;
import com.cl.service.YujuxinxiService;
import com.cl.entity.view.YujuxinxiView;

@Service("yujuxinxiService")
public class YujuxinxiServiceImpl extends ServiceImpl<YujuxinxiDao, YujuxinxiEntity> implements YujuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YujuxinxiEntity> page = this.selectPage(
                new Query<YujuxinxiEntity>(params).getPage(),
                new EntityWrapper<YujuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YujuxinxiEntity> wrapper) {
		  Page<YujuxinxiView> page =new Query<YujuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YujuxinxiView> selectListView(Wrapper<YujuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YujuxinxiView selectView(Wrapper<YujuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
