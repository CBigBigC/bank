package com.watson.bank.controller;

import com.watson.bank.req.CreditOperateReq;
import com.watson.bank.service.credit.CreditService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 信用卡额度控制
 * 增加额度，扣减额度
 */
@RestController
@RequestMapping("/credit")
public class CreditController {

    @Resource
    private CreditService creditService;

    /**
     * 额度调整，支持初始化、增加、扣减、重置等
     * 详情参考 #CreditOperationEnum
     */
    @ApiOperation("调整额度")
    @RequestMapping("/adjust")
    public Boolean adjustCredit(@RequestBody CreditOperateReq creditOperateReq){
        return creditService.adjustCredit(creditOperateReq);
    }

}
