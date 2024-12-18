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


import com.cl.dao.ZulinxinxiDao;
import com.cl.entity.ZulinxinxiEntity;
import com.cl.service.ZulinxinxiService;
import com.cl.entity.view.ZulinxinxiView;

@Service("zulinxinxiService")
public class ZulinxinxiServiceImpl extends ServiceImpl<ZulinxinxiDao, ZulinxinxiEntity> implements ZulinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZulinxinxiEntity> page = this.selectPage(
                new Query<ZulinxinxiEntity>(params).getPage(),
                new EntityWrapper<ZulinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZulinxinxiEntity> wrapper) {
		  Page<ZulinxinxiView> page =new Query<ZulinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZulinxinxiView> selectListView(Wrapper<ZulinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZulinxinxiView selectView(Wrapper<ZulinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
