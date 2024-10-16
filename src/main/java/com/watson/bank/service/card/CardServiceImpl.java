package com.watson.bank.service.card;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.Card;
import com.watson.bank.dao.CardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
*/
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService{

    @Resource
    private CardMapper cardMapper;

    @Override
    public Boolean addCard(Card card) {
        cardMapper.insert(card);
        return Boolean.TRUE;
    }

    @Override
    public List<Card> queryCard(Card card) {
        return cardMapper.commonQuery(card);
    }
}




