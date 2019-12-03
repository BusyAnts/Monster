package com.cimc.common.core.domain;

import lombok.Data;

/**
 * Tree基类
 *
 * @author chenz
 */
@Data
public class TreeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 父名称
     */
    private String parentName;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 祖级列表
     */
    private String ancestors;

}