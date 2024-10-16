package com.watson.bank.controller;

import com.watson.bank.domain.Card;
import com.watson.bank.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 信用卡信息维护
 * 增删改查
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @Resource
    private CardService cardService;

    @ApiOperation("新增卡片")
    @RequestMapping("/addCard")
    public Boolean addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    @ApiOperation("查询卡片")
    @RequestMapping("/listCard")
    public List<Card> matchCard(@RequestBody Card card) {
        return cardService.queryCard(card);
    }
}
