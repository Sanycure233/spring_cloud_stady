package com.sany.service.impl;

import com.sany.mapper.PayMapper;
import com.sany.pojo.Pay;
import com.sany.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: SanyQAQ
 * @create: 2024-07-17-15:44
 */
@Service
public class PayServiceImpl implements PayService {
    @Resource
    PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        //这个insertSelective不会封装null属性，而是使用数据库的默认值
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
