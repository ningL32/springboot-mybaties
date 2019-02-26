package com.ningl.mybaties.dao;

import com.ningl.mybaties.entity.PlayIdiom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**@Author ningl
 * @Description IdiomDao 类
 * @Date 2019/2/26 20:44
 **/
@Mapper
public interface IdiomDao {

    List<PlayIdiom> findIdioms();

    int addIdiom(@Param("idiom") String idiom);

    int delteIdioms(HashMap<String, Object> map);
}
