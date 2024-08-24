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

import com.cl.entity.GuihaixinxiEntity;
import com.cl.entity.view.GuihaixinxiView;

import com.cl.service.GuihaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 归还信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
@RestController
@RequestMapping("/guihaixinxi")
public class GuihaixinxiController {
    @Autowired
    private GuihaixinxiService guihaixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuihaixinxiEntity guihaixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			guihaixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();

		PageUtils page = guihaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuihaixinxiEntity guihaixinxi, 
		HttpServletRequest request){
        EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();

		PageUtils page = guihaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuihaixinxiEntity guihaixinxi){
       	EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guihaixinxi, "guihaixinxi")); 
        return R.ok().put("data", guihaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuihaixinxiEntity guihaixinxi){
        EntityWrapper< GuihaixinxiEntity> ew = new EntityWrapper< GuihaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guihaixinxi, "guihaixinxi")); 
		GuihaixinxiView guihaixinxiView =  guihaixinxiService.selectView(ew);
		return R.ok("查询归还信息成功").put("data", guihaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuihaixinxiEntity guihaixinxi = guihaixinxiService.selectById(id);
		guihaixinxi = guihaixinxiService.selectView(new EntityWrapper<GuihaixinxiEntity>().eq("id", id));
        return R.ok().put("data", guihaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuihaixinxiEntity guihaixinxi = guihaixinxiService.selectById(id);
		guihaixinxi = guihaixinxiService.selectView(new EntityWrapper<GuihaixinxiEntity>().eq("id", id));
        return R.ok().put("data", guihaixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
    	guihaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guihaixinxi);
        guihaixinxiService.insert(guihaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
    	guihaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guihaixinxi);
        guihaixinxiService.insert(guihaixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaixinxi);
        guihaixinxiService.updateById(guihaixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guihaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
