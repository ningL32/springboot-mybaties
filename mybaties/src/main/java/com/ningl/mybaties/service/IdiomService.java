package com.ningl.mybaties.service;

import com.ningl.mybaties.entity.PlayIdiom;

import java.util.List;

/**
 *@program: mybaties
 *@description: 成语接口
 *@author: ningl
 *@create: 2019.2.26-0.00
 */
public interface IdiomService  {

    List<PlayIdiom> findIdioms();

    boolean addIdom(String idiom);

    boolean delteIdioms(String ids);
}
