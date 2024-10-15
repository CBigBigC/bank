package com.watson.bank.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 信用卡实体表
 * @TableName card
 */
@TableName(value ="card")
@Data
public class Card implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 卡名（eg：龙年金卡）
     */
    private String cardName;

    /**
     * 信用卡默认额度
     */
    private BigDecimal defaultCredit;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 删除标识
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}