package com.ningl.mybaties.service.impl;

import com.ningl.mybaties.dao.IdiomDao;
import com.ningl.mybaties.entity.PlayIdiom;
import com.ningl.mybaties.service.IdiomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@program: mybaties
 *@description: 成语实现层
 *@author: ningl
 *@create: 2019.2.26-0.00
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class IdiomServiceImpl implements IdiomService {


    @Resource
    private IdiomDao idiomDao;

    /**
     * 获取所有的成语
     * @return
     */
    @Override
    public List<PlayIdiom> findIdioms() {
        return idiomDao.findIdioms();
    }

    /**
     * 新增成语
     * @param idiom
     * @return
     */
    @Override
    public boolean addIdom(String idiom) {

        int flag = 0;
        String rgx = ",";
        if(idiom.indexOf(rgx) == -1){
            flag = idiomDao.addIdiom(idiom);
        }else {
            String[] arr = idiom.split(idiom);
            for (int i=0;i<arr.length;i++) {
                flag = idiomDao.addIdiom(idiom);
            }
        }
        return flag > 0? true:false;
    }

    /**
     * 删除成语
     * @param ids
     * @return
     */
    @Override
    public boolean delteIdioms(String ids) {
        int flag = 0;
        String rgx = ",";
        HashMap<String,Object> map = new HashMap<>();
        List list = new ArrayList();
        if(ids.indexOf(rgx) == -1){
            list.add(ids);
        }else{
            String[] arr = ids.split(rgx);
            for (String str:arr) {
                list.add(str);
            }
        }
        map.put("ids",list);
        return idiomDao.delteIdioms(map) > 0 ? true:false;
    }
}
