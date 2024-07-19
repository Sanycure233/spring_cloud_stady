package com.sany.controller;

import com.sany.pojo.Pay;
import com.sany.pojo.PayDTO;
import com.sany.resp.ResultData;
import com.sany.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: SanyQAQ
 * @create: 2024-07-17-15:53
 */
@RestController
@Slf4j
@RequestMapping("/pay")
public class PayController {//用统一的格式返回数据
    @Resource
    PayService payService;


    @PostMapping("/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay);
        int i=payService.add(pay);
        return ResultData.success("成功插入记录"+i+"条");
    }

    @DeleteMapping("/delete/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        return ResultData.success(payService.delete(id));
    }

    @PutMapping("/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i=payService.update(pay);
        return ResultData.success("成功修改记录"+i+"条");
    }

    @GetMapping("/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id")Integer id){
        if(id<0) throw new RuntimeException("id值为负数");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping("/get/all")
    public ResultData<List<Pay>> getAll(){
        return ResultData.success(payService.getAll());
    }

    @org.springframework.beans.factory.annotation.Value("${server.port}")
    private String port;
    @GetMapping("/get/info")
    public ResultData<String> getInfoByConsul(@Value("${sany.info}") String info){
        return ResultData.success("sanyInfo:"+info+"\t"+"port:"+port);
    }

}
/*@RestController
@Slf4j
@RequestMapping("/pay")
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/add")
    public String addPay(@RequestBody Pay pay){
        System.out.println(pay);
        int i=payService.add(pay);
        return "成功插入记录"+i+"条";
    }

    @DeleteMapping("/delete/{id}")
    public Integer deletePay(@PathVariable("id") Integer id){
        System.out.println("删除成功！！");
        return payService.delete(id);
    }

    @PutMapping("/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i=payService.update(pay);
        return "成功修改记录"+i+"条";
    }

    @GetMapping("/get/{id}")
    public Pay getById(@PathVariable("id")Integer id){
        return payService.getById(id);
    }

    @GetMapping("/get/all")
    public List<Pay> getAll(){
        return payService.getAll();
    }
}*/
