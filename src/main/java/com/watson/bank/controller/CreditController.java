package com.watson.bank.controller;

import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.exception.BankErrorCodeEnum;
import com.watson.bank.exception.BusinessException;
import com.watson.bank.req.CreditOperateDto;
import com.watson.bank.service.credit.CreditService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

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
     * 调整额度
     */
    @ApiOperation("调整额度")
    @RequestMapping("/adjust")
    public Boolean adjustCredit(@RequestBody CreditOperateDto creditOperateDto) {
        if (Arrays.stream(CreditOperationEnum.values()).anyMatch(a -> a.equals(creditOperateDto.getOperation()))) {
            log.error("参数非法：{}", creditOperateDto.getOperation());
            throw new BusinessException(BankErrorCodeEnum.ILLEGAL_PARAM);
        }
        return creditService.adjustCredit(creditOperateDto);
    }

}
