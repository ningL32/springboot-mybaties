package com.ningl.mybaties.controller;

import com.ningl.mybaties.entity.PlayIdiom;
import com.ningl.mybaties.service.IdiomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 *@program: mybaties
 *@description: 控制层返回json数据
 *@author: ningl
 *@create: 2019.2.26-0.00
 */
@RestController
public class JsonController {
    @Autowired
    private IdiomService idiomService;

    /**
     * 获取所有成语
     * @return
     */
    @GetMapping("/idioms.json")
    public HashMap<String,Object> getAllIdiom(){

        HashMap<String,Object> map = new HashMap<>();
        List<PlayIdiom> idioms = idiomService.findIdioms();
        map.put("data",idioms);
        return map;
    }

    /**
     * 增加成语
     * @param idiom 多个使用 , 拼接 ，例如 鹏程万里,惊鸿一瞥
     * @return
     */
    @GetMapping("/addIdiom.json")
    public HashMap<String,Object> addIdiom(@RequestParam(value = "idiom",required = false,defaultValue = "hellOJAVA")String idiom){
        HashMap<String,Object> map = new HashMap<>();
        try {

            if(idiomService.addIdom(idiom)){
                map.put("code",200);
                map.put("msg","success");
            }else {
                map.put("code",401);
                map.put("msg","failed");
            }
        }catch (Exception e){
            map.put("code",200);
            map.put("msg",e.getMessage()+"\\r"+e.getCause());
            return map;
        }
        return map;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @GetMapping("/deletes.json")
    public HashMap<String,Object> deletes(@RequestParam(value = "ids",required = true)String ids){
        HashMap<String,Object> map = new HashMap<>();
        //最好先验证 删除的实体类是否存在
        try {

            if(idiomService.delteIdioms(ids)){
                map.put("code",200);
                map.put("msg","success");
            }else {
                map.put("code",401);
                map.put("msg","failed");
            }
        }catch (Exception e){
            map.put("code",200);
            map.put("msg",e.getMessage()+"\\r"+e.getCause());
            return map;
        }
        return map;
    }


}
