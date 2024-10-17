package com.watson.bank.controller;

import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.req.CreditOperateDto;
import com.watson.bank.service.credit.CreditService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 信用卡额度控制
 * 增加额度，扣减额度
 */
@Slf4j
@RestController
@RequestMapping("/credit")
public class CreditController {

    @Resource
    private CreditService creditService;

    /**
     * 增加额度
     */
    @ApiOperation("增加额度")
    @RequestMapping("/increase")
    public Boolean increaseCredit(@RequestBody CreditOperateDto creditOperateDto){
        if (!Objects.equals(CreditOperationEnum.INCREASE, creditOperateDto.getOperation())){
            return false;
        }
        return creditService.adjustCredit(creditOperateDto);
    }

    /**
     * 扣减额度
     */
    @ApiOperation("扣减额度")
    @RequestMapping("/decrease")
    public Boolean decreaseCredit(@RequestBody CreditOperateDto creditOperateDto){
        if (!Objects.equals(CreditOperationEnum.DECREASE, creditOperateDto.getOperation())){
            return false;
        }
        return creditService.adjustCredit(creditOperateDto);
    }

    /**
     * 额度重置
     */
    @ApiOperation("重置额度")
    @RequestMapping("/reset")
    public Boolean resetCredit(@RequestBody CreditOperateDto creditOperateDto){
        if (!Objects.equals(CreditOperationEnum.RESET, creditOperateDto.getOperation())){
            return false;
        }
        return creditService.adjustCredit(creditOperateDto);
    }

}
