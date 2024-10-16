package com.watson.bank.service.card;

import com.watson.bank.domain.Card;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author watson
*/
public interface CardService extends IService<Card> {

    Boolean addCard(Card card);

    List<Card> queryCard(Card card);
}
