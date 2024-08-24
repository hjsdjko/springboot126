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

import com.cl.entity.YujuxinxiEntity;
import com.cl.entity.view.YujuxinxiView;

import com.cl.service.YujuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 渔具信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-27 20:53:58
 */
@RestController
@RequestMapping("/yujuxinxi")
public class YujuxinxiController {
    @Autowired
    private YujuxinxiService yujuxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YujuxinxiEntity yujuxinxi,
		HttpServletRequest request){
        EntityWrapper<YujuxinxiEntity> ew = new EntityWrapper<YujuxinxiEntity>();

		PageUtils page = yujuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YujuxinxiEntity yujuxinxi, 
		HttpServletRequest request){
        EntityWrapper<YujuxinxiEntity> ew = new EntityWrapper<YujuxinxiEntity>();

		PageUtils page = yujuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YujuxinxiEntity yujuxinxi){
       	EntityWrapper<YujuxinxiEntity> ew = new EntityWrapper<YujuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yujuxinxi, "yujuxinxi")); 
        return R.ok().put("data", yujuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YujuxinxiEntity yujuxinxi){
        EntityWrapper< YujuxinxiEntity> ew = new EntityWrapper< YujuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yujuxinxi, "yujuxinxi")); 
		YujuxinxiView yujuxinxiView =  yujuxinxiService.selectView(ew);
		return R.ok("查询渔具信息成功").put("data", yujuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YujuxinxiEntity yujuxinxi = yujuxinxiService.selectById(id);
		yujuxinxi.setClicktime(new Date());
		yujuxinxiService.updateById(yujuxinxi);
		yujuxinxi = yujuxinxiService.selectView(new EntityWrapper<YujuxinxiEntity>().eq("id", id));
        return R.ok().put("data", yujuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YujuxinxiEntity yujuxinxi = yujuxinxiService.selectById(id);
		yujuxinxi.setClicktime(new Date());
		yujuxinxiService.updateById(yujuxinxi);
		yujuxinxi = yujuxinxiService.selectView(new EntityWrapper<YujuxinxiEntity>().eq("id", id));
        return R.ok().put("data", yujuxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YujuxinxiEntity yujuxinxi = yujuxinxiService.selectById(id);
        if(type.equals("1")) {
        	yujuxinxi.setThumbsupnum(yujuxinxi.getThumbsupnum()+1);
        } else {
        	yujuxinxi.setCrazilynum(yujuxinxi.getCrazilynum()+1);
        }
        yujuxinxiService.updateById(yujuxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YujuxinxiEntity yujuxinxi, HttpServletRequest request){
    	yujuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yujuxinxi);
        yujuxinxiService.insert(yujuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YujuxinxiEntity yujuxinxi, HttpServletRequest request){
    	yujuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yujuxinxi);
        yujuxinxiService.insert(yujuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YujuxinxiEntity yujuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yujuxinxi);
        yujuxinxiService.updateById(yujuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yujuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YujuxinxiEntity yujuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<YujuxinxiEntity> ew = new EntityWrapper<YujuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = yujuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujuxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YujuxinxiEntity yujuxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yujumingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "yujuxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YujuxinxiEntity> yujuxinxiList = new ArrayList<YujuxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                yujuxinxiList.addAll(yujuxinxiService.selectList(new EntityWrapper<YujuxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YujuxinxiEntity> ew = new EntityWrapper<YujuxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = yujuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yujuxinxi), params), params));
        List<YujuxinxiEntity> pageList = (List<YujuxinxiEntity>)page.getList();
        if(yujuxinxiList.size()<limit) {
            int toAddNum = (limit-yujuxinxiList.size())<=pageList.size()?(limit-yujuxinxiList.size()):pageList.size();
            for(YujuxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(YujuxinxiEntity o2 : yujuxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    yujuxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(yujuxinxiList.size()>limit) {
            yujuxinxiList = yujuxinxiList.subList(0, limit);
        }
        page.setList(yujuxinxiList);
        return R.ok().put("data", page);
    }







}
