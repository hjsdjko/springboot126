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


import com.cl.dao.DiscussyujuxinxiDao;
import com.cl.entity.DiscussyujuxinxiEntity;
import com.cl.service.DiscussyujuxinxiService;
import com.cl.entity.view.DiscussyujuxinxiView;

@Service("discussyujuxinxiService")
public class DiscussyujuxinxiServiceImpl extends ServiceImpl<DiscussyujuxinxiDao, DiscussyujuxinxiEntity> implements DiscussyujuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyujuxinxiEntity> page = this.selectPage(
                new Query<DiscussyujuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyujuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyujuxinxiEntity> wrapper) {
		  Page<DiscussyujuxinxiView> page =new Query<DiscussyujuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyujuxinxiView> selectListView(Wrapper<DiscussyujuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyujuxinxiView selectView(Wrapper<DiscussyujuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
