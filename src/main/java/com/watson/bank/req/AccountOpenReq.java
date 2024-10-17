package com.watson.bank.req;

import lombok.Data;

/**
 * 新增账户/开卡请求实体类
 */
@Data
public class AccountOpenReq {

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 关联原始卡片id
     */
    private Integer cardId;

}
