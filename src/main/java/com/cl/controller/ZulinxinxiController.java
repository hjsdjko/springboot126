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

import com.cl.entity.ZulinxinxiEntity;
import com.cl.entity.view.ZulinxinxiView;

import com.cl.service.ZulinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租赁信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-27 20:53:59
 */
@RestController
@RequestMapping("/zulinxinxi")
public class ZulinxinxiController {
    @Autowired
    private ZulinxinxiService zulinxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZulinxinxiEntity zulinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zulinxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZulinxinxiEntity> ew = new EntityWrapper<ZulinxinxiEntity>();

		PageUtils page = zulinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZulinxinxiEntity zulinxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZulinxinxiEntity> ew = new EntityWrapper<ZulinxinxiEntity>();

		PageUtils page = zulinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZulinxinxiEntity zulinxinxi){
       	EntityWrapper<ZulinxinxiEntity> ew = new EntityWrapper<ZulinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zulinxinxi, "zulinxinxi")); 
        return R.ok().put("data", zulinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZulinxinxiEntity zulinxinxi){
        EntityWrapper< ZulinxinxiEntity> ew = new EntityWrapper< ZulinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zulinxinxi, "zulinxinxi")); 
		ZulinxinxiView zulinxinxiView =  zulinxinxiService.selectView(ew);
		return R.ok("查询租赁信息成功").put("data", zulinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZulinxinxiEntity zulinxinxi = zulinxinxiService.selectById(id);
		zulinxinxi = zulinxinxiService.selectView(new EntityWrapper<ZulinxinxiEntity>().eq("id", id));
        return R.ok().put("data", zulinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZulinxinxiEntity zulinxinxi = zulinxinxiService.selectById(id);
		zulinxinxi = zulinxinxiService.selectView(new EntityWrapper<ZulinxinxiEntity>().eq("id", id));
        return R.ok().put("data", zulinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZulinxinxiEntity zulinxinxi, HttpServletRequest request){
    	zulinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zulinxinxi);
        zulinxinxiService.insert(zulinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZulinxinxiEntity zulinxinxi, HttpServletRequest request){
    	zulinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zulinxinxi);
        zulinxinxiService.insert(zulinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZulinxinxiEntity zulinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zulinxinxi);
        zulinxinxiService.updateById(zulinxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZulinxinxiEntity> list = new ArrayList<ZulinxinxiEntity>();
        for(Long id : ids) {
            ZulinxinxiEntity zulinxinxi = zulinxinxiService.selectById(id);
            zulinxinxi.setSfsh(sfsh);
            zulinxinxi.setShhf(shhf);
            list.add(zulinxinxi);
        }
        zulinxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zulinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
