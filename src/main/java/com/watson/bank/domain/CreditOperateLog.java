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
 * 额度操作日志表
 * @TableName credit_operate_log
 */
@TableName(value ="credit_operate_log")
@Data
public class CreditOperateLog implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 操作人
     */
    private Long operatorId;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 调整前额度
     */
    private BigDecimal creditBefore;

    /**
     * 调整后额度
     */
    private BigDecimal creditAfter;

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