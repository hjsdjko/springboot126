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


import com.cl.dao.YujufenleiDao;
import com.cl.entity.YujufenleiEntity;
import com.cl.service.YujufenleiService;
import com.cl.entity.view.YujufenleiView;

@Service("yujufenleiService")
public class YujufenleiServiceImpl extends ServiceImpl<YujufenleiDao, YujufenleiEntity> implements YujufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YujufenleiEntity> page = this.selectPage(
                new Query<YujufenleiEntity>(params).getPage(),
                new EntityWrapper<YujufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YujufenleiEntity> wrapper) {
		  Page<YujufenleiView> page =new Query<YujufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YujufenleiView> selectListView(Wrapper<YujufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YujufenleiView selectView(Wrapper<YujufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
