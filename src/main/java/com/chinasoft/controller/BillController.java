package com.chinasoft.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chinasoft.mapper.BillMapper;
import com.chinasoft.domain.Bill;
import com.chinasoft.util.DateFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BillController {

    @Resource
    private BillMapper billMapper;

    @RequestMapping("/bill")
    public Object loadAllBills(@RequestParam Map<String, String> map){
        Page<Bill> billPage = new Page<>(Long.parseLong(map.get("curr")),10);
        HashMap<String, Object> map1 = new HashMap<>();
        Page<Bill> page = billMapper.selectPage(billPage, null);

        map1.put("Result",page.getRecords());
        map1.put("Total",page.getTotal());
        return map1;
    }

    @RequestMapping("/rearch")
    public Object rearch(@RequestParam Map<String,String> map){
        /*Page<Bill> page = new Page<>(1,5);*/

        QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();


        System.out.println(map);
        queryWrapper.eq(!map.get("goodType").equals("")&&!map.get("goodType").equals("不限"),"type",map.get("goodType"));
        queryWrapper.ge(!map.get("beginTime").equals(""),"bill_time", map.get("beginTime"));
        queryWrapper.le(!map.get("aendTime").equals(""),"bill_time",map.get("aendTime"));

        Page<Bill> billPage = new Page<>(Long.parseLong(map.get("curr")),10);
        HashMap<String, Object> map1 = new HashMap<>();
        Page<Bill> page = billMapper.selectPage(billPage, queryWrapper);

        map1.put("Result",page.getRecords());
        map1.put("Total",page.getTotal());


        return map1;
    }

    @RequestMapping("/toIn")
    public String toIn(@RequestParam Map<String,Object> map){
        /*Page<Bill> page = new Page<>(1,5);*/
        DateFormat dateFormat=new DateFormat();
        Date billTime = DateFormat.parseDate(map.get("billTime"));
        System.out.println(billTime +">>>>>>>>>>>>>");

        Bill bill = new Bill();
        bill.setTitle((String) map.get("title"));
        bill.setBillTime(billTime);
        bill.setType((String) map.get("type"));
        bill.setPrice(Double.parseDouble((String) map.get("price")));
        bill.setExplains((String) map.get("explains"));
        billMapper.insert(bill);
        return "ok";
    }
}
