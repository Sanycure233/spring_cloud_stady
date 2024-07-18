package com.sany.controller;

import com.sany.pojo.Pay;
import com.sany.pojo.PayDTO;
import com.sany.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: SanyQAQ
 * @create: 2024-07-18-14:59
 *
 */
//访问前端的媒介
//为了访问到8001端口的数据
@RestController
@RequestMapping("/consumer")
public class OrderController {
    //写死的访问地址
    private static final String Payment_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    //添加操作
    @PostMapping("/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        //这个方法会再访问一次地址
        //需要提供三个参数——访问地址，传给的参数，接收得到的参数类型
        //postForObject表示以post请求发送，所以还能用get，delete，put请求
        return restTemplate.postForObject(Payment_URL+"/pay/add",payDTO,ResultData.class);
    }

    //关于删除和修改都没有返回值
    @GetMapping("/pay/delete/{id}")
    public void deletePayOrder(@PathVariable("id")Integer id){

        restTemplate.delete(Payment_URL+"/pay/delete/"+id);
    }

    @PostMapping("/pay/update")
    public void updatePayOrder(@RequestBody PayDTO payDTO){
        restTemplate.put(Payment_URL+"/pay/update",payDTO);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        //注意get发送方式的参数顺序有些不一样
        return restTemplate.getForObject(Payment_URL+"/pay/get/"+id,ResultData.class);
    }

    @GetMapping("/pay/get/all")
    public ResultData<List<Pay>> getAllOrder(){
        return restTemplate.getForObject(Payment_URL+"/pay/get/all",ResultData.class);
    }

}
