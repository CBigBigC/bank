package com.watson.bank.dao;

import com.watson.bank.domain.Card;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【card(信用卡实体表)】的数据库操作Mapper
* @createDate 2024-10-15 15:13:48
* @Entity generator.domain.Card
*/
@Mapper
public interface CardMapper extends BaseMapper<Card> {

    List<Card> commonQuery(@Param("query") Card query);

}




