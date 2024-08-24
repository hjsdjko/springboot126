package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YujufenleiEntity;
import com.cl.entity.view.YujufenleiView;

import com.cl.service.YujufenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 渔具分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
@RestController
@RequestMapping("/yujufenlei")
public class YujufenleiController {
    @Autowired
    private YujufenleiService yujufenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YujufenleiEntity yujufenlei,
		HttpServletRequest request){
        EntityWrapper<YujufenleiEntity> ew = new EntityWrapper<YujufenleiEntity>();

		PageUtils page = yujufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujufenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YujufenleiEntity yujufenlei, 
		HttpServletRequest request){
        EntityWrapper<YujufenleiEntity> ew = new EntityWrapper<YujufenleiEntity>();

		PageUtils page = yujufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujufenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YujufenleiEntity yujufenlei){
       	EntityWrapper<YujufenleiEntity> ew = new EntityWrapper<YujufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yujufenlei, "yujufenlei")); 
        return R.ok().put("data", yujufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YujufenleiEntity yujufenlei){
        EntityWrapper< YujufenleiEntity> ew = new EntityWrapper< YujufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yujufenlei, "yujufenlei")); 
		YujufenleiView yujufenleiView =  yujufenleiService.selectView(ew);
		return R.ok("查询渔具分类成功").put("data", yujufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YujufenleiEntity yujufenlei = yujufenleiService.selectById(id);
		yujufenlei = yujufenleiService.selectView(new EntityWrapper<YujufenleiEntity>().eq("id", id));
        return R.ok().put("data", yujufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YujufenleiEntity yujufenlei = yujufenleiService.selectById(id);
		yujufenlei = yujufenleiService.selectView(new EntityWrapper<YujufenleiEntity>().eq("id", id));
        return R.ok().put("data", yujufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YujufenleiEntity yujufenlei, HttpServletRequest request){
    	yujufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yujufenlei);
        yujufenleiService.insert(yujufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YujufenleiEntity yujufenlei, HttpServletRequest request){
    	yujufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yujufenlei);
        yujufenleiService.insert(yujufenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YujufenleiEntity yujufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujufenlei);
        yujufenleiService.updateById(yujufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yujufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
