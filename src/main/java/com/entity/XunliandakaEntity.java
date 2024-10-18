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
 * 训练打卡
 *
 * @author 
 * @email
 */
@TableName("xunliandaka")
public class XunliandakaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XunliandakaEntity() {

	}

	public XunliandakaEntity(T t) {
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
     * 教练
     */
    @ColumnInfo(comment="教练",type="int(11)")
    @TableField(value = "jiaolian_id")

    private Integer jiaolianId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 训练打卡编号
     */
    @ColumnInfo(comment="训练打卡编号",type="varchar(200)")
    @TableField(value = "xunliandaka_uuid_number")

    private String xunliandakaUuidNumber;


    /**
     * 训练标题
     */
    @ColumnInfo(comment="训练标题",type="varchar(200)")
    @TableField(value = "xunliandaka_name")

    private String xunliandakaName;


    /**
     * 训练地点
     */
    @ColumnInfo(comment="训练地点",type="varchar(200)")
    @TableField(value = "xunliandaka_address")

    private String xunliandakaAddress;


    /**
     * 训练类型
     */
    @ColumnInfo(comment="训练类型",type="int(11)")
    @TableField(value = "xunliandaka_types")

    private Integer xunliandakaTypes;


    /**
     * 训练日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="训练日期",type="date")
    @TableField(value = "xunlian_time")

    private Date xunlianTime;


    /**
     * 训练内容
     */
    @ColumnInfo(comment="训练内容",type="longtext")
    @TableField(value = "xunliandaka_content")

    private String xunliandakaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 是否打卡
     */
    @ColumnInfo(comment="是否打卡",type="int(11)")
    @TableField(value = "daka_types")

    private Integer dakaTypes;


    /**
     * 创建时间   listShow
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
	 * 获取：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }
    /**
	 * 设置：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
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
	 * 获取：训练打卡编号
	 */
    public String getXunliandakaUuidNumber() {
        return xunliandakaUuidNumber;
    }
    /**
	 * 设置：训练打卡编号
	 */

    public void setXunliandakaUuidNumber(String xunliandakaUuidNumber) {
        this.xunliandakaUuidNumber = xunliandakaUuidNumber;
    }
    /**
	 * 获取：训练标题
	 */
    public String getXunliandakaName() {
        return xunliandakaName;
    }
    /**
	 * 设置：训练标题
	 */

    public void setXunliandakaName(String xunliandakaName) {
        this.xunliandakaName = xunliandakaName;
    }
    /**
	 * 获取：训练地点
	 */
    public String getXunliandakaAddress() {
        return xunliandakaAddress;
    }
    /**
	 * 设置：训练地点
	 */

    public void setXunliandakaAddress(String xunliandakaAddress) {
        this.xunliandakaAddress = xunliandakaAddress;
    }
    /**
	 * 获取：训练类型
	 */
    public Integer getXunliandakaTypes() {
        return xunliandakaTypes;
    }
    /**
	 * 设置：训练类型
	 */

    public void setXunliandakaTypes(Integer xunliandakaTypes) {
        this.xunliandakaTypes = xunliandakaTypes;
    }
    /**
	 * 获取：训练日期
	 */
    public Date getXunlianTime() {
        return xunlianTime;
    }
    /**
	 * 设置：训练日期
	 */

    public void setXunlianTime(Date xunlianTime) {
        this.xunlianTime = xunlianTime;
    }
    /**
	 * 获取：训练内容
	 */
    public String getXunliandakaContent() {
        return xunliandakaContent;
    }
    /**
	 * 设置：训练内容
	 */

    public void setXunliandakaContent(String xunliandakaContent) {
        this.xunliandakaContent = xunliandakaContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：是否打卡
	 */
    public Integer getDakaTypes() {
        return dakaTypes;
    }
    /**
	 * 设置：是否打卡
	 */

    public void setDakaTypes(Integer dakaTypes) {
        this.dakaTypes = dakaTypes;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xunliandaka{" +
            ", id=" + id +
            ", jiaolianId=" + jiaolianId +
            ", yonghuId=" + yonghuId +
            ", xunliandakaUuidNumber=" + xunliandakaUuidNumber +
            ", xunliandakaName=" + xunliandakaName +
            ", xunliandakaAddress=" + xunliandakaAddress +
            ", xunliandakaTypes=" + xunliandakaTypes +
            ", xunlianTime=" + DateUtil.convertString(xunlianTime,"yyyy-MM-dd") +
            ", xunliandakaContent=" + xunliandakaContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", dakaTypes=" + dakaTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
