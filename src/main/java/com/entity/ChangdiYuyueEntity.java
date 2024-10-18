package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 场地预约
 *
 * @author 
 * @email
 */
@TableName("changdi_yuyue")
public class ChangdiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChangdiYuyueEntity() {

	}

	public ChangdiYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "changdi_yuyue_uuid_number")

    private String changdiYuyueUuidNumber;


    /**
     * 场地
     */
    @ColumnInfo(comment="场地",type="int(11)")
    @TableField(value = "changdi_id")

    private Integer changdiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约理由
     */
    @ColumnInfo(comment="预约理由",type="longtext")
    @TableField(value = "changdi_yuyue_text")

    private String changdiYuyueText;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预约日期",type="date")
    @TableField(value = "changdi_yuyue_time")

    private Date changdiYuyueTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "changdi_yuyue_yesno_types")

    private Integer changdiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "changdi_yuyue_yesno_text")

    private String changdiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "changdi_yuyue_shenhe_time")

    private Date changdiYuyueShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：预约编号
	 */
    public String getChangdiYuyueUuidNumber() {
        return changdiYuyueUuidNumber;
    }
    /**
	 * 设置：预约编号
	 */

    public void setChangdiYuyueUuidNumber(String changdiYuyueUuidNumber) {
        this.changdiYuyueUuidNumber = changdiYuyueUuidNumber;
    }
    /**
	 * 获取：场地
	 */
    public Integer getChangdiId() {
        return changdiId;
    }
    /**
	 * 设置：场地
	 */

    public void setChangdiId(Integer changdiId) {
        this.changdiId = changdiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约理由
	 */
    public String getChangdiYuyueText() {
        return changdiYuyueText;
    }
    /**
	 * 设置：预约理由
	 */

    public void setChangdiYuyueText(String changdiYuyueText) {
        this.changdiYuyueText = changdiYuyueText;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getChangdiYuyueTime() {
        return changdiYuyueTime;
    }
    /**
	 * 设置：预约日期
	 */

    public void setChangdiYuyueTime(Date changdiYuyueTime) {
        this.changdiYuyueTime = changdiYuyueTime;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getChangdiYuyueYesnoTypes() {
        return changdiYuyueYesnoTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setChangdiYuyueYesnoTypes(Integer changdiYuyueYesnoTypes) {
        this.changdiYuyueYesnoTypes = changdiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getChangdiYuyueYesnoText() {
        return changdiYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setChangdiYuyueYesnoText(String changdiYuyueYesnoText) {
        this.changdiYuyueYesnoText = changdiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getChangdiYuyueShenheTime() {
        return changdiYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setChangdiYuyueShenheTime(Date changdiYuyueShenheTime) {
        this.changdiYuyueShenheTime = changdiYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChangdiYuyue{" +
            ", id=" + id +
            ", changdiYuyueUuidNumber=" + changdiYuyueUuidNumber +
            ", changdiId=" + changdiId +
            ", yonghuId=" + yonghuId +
            ", changdiYuyueText=" + changdiYuyueText +
            ", changdiYuyueTime=" + DateUtil.convertString(changdiYuyueTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", changdiYuyueYesnoTypes=" + changdiYuyueYesnoTypes +
            ", changdiYuyueYesnoText=" + changdiYuyueYesnoText +
            ", changdiYuyueShenheTime=" + DateUtil.convertString(changdiYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
