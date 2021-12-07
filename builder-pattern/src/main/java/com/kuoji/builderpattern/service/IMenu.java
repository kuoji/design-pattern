package com.kuoji.builderpattern.service;


/**
 * 装修包接口
 * 定义了填充各项物料的方法；吊顶、涂料、地板、地砖，以及最终提供获取全部明细的方法
 */
public interface IMenu {

    /**
     * 吊顶
     */
    IMenu appendCeiling(Matter matter);

    /**
     * 涂料
     */
    IMenu appendCoat(Matter matter);

    /**
     * 地板
     */
    IMenu appendFloor(Matter matter);

    /**
     * 地砖
     */
    IMenu appendTile(Matter matter);

    /**
     * 明细
     */
    String getDetail();
}
