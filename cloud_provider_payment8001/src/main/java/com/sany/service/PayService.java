package com.sany.service;

import com.sany.pojo.Pay;

import java.util.List;

/**
 * @author: SanyQAQ
 * @create: 2024-07-17-15:43
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);
    public List<Pay> getAll();
}
