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
 * 账户表
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 信用卡id
     */
    private Integer cardId;

    /**
     * 账户最大额度
     */
    private BigDecimal maxCredit;

    /**
     * 账户当前额度
     */
    private BigDecimal currentCredit;

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