package com.ningl.mybaties.entity;

import lombok.Data;

/**
 *@program: mybaties
 *@description: 成语库 实体类
 *@author: ningl
 *@create: 2019.2.26-0.00
 */
public @Data class PlayIdiom {

    /**
     * id
     */
    private Integer id;
    /**
     * 成语
     */
    private String idiom;
}
