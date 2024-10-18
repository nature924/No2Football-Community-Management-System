package com.dao;

import com.entity.XunliandakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XunliandakaView;

/**
 * 训练打卡 Dao 接口
 *
 * @author 
 */
public interface XunliandakaDao extends BaseMapper<XunliandakaEntity> {

   List<XunliandakaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
