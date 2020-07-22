package com.personal.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统全局配置表
 */
@Data
@TableName(value = "sys_global_config")
public class SysGlobalConfig {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 参数类型id
     */
    @TableField(value = "type_id")
    private Long typeId;

    /**
     * 参数类型名称
     */
    @TableField(value = "type_name")
    private String typeName;

    /**
     * 配置项key值
     */
    @TableField(value = "key")
    private String key;

    /**
     * 配置项value值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 状态 0-正常 1-禁用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 删除标识
     */
    @TableField(value = "delete_flag")
    private Integer deleteFlag;

}