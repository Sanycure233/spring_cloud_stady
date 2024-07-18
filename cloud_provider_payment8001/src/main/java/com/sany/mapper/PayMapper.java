package com.sany.mapper;

import com.sany.pojo.Pay;

import java.util.List;

public interface PayMapper {
    List<Pay> selectAll();
    int deleteByPrimaryKey(Integer id);

    int insert(Pay row);

    int insertSelective(Pay row);

    Pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pay row);

    int updateByPrimaryKey(Pay row);
}