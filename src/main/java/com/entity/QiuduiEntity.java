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
 * 球队
 *
 * @author 
 * @email
 */
@TableName("qiudui")
public class QiuduiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiuduiEntity() {

	}

	public QiuduiEntity(T t) {
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
     * 球队名称
     */
    @ColumnInfo(comment="球队名称",type="varchar(200)")
    @TableField(value = "qiudui_name")

    private String qiuduiName;


    /**
     * 球队编号
     */
    @ColumnInfo(comment="球队编号",type="varchar(200)")
    @TableField(value = "qiudui_uuid_number")

    private String qiuduiUuidNumber;


    /**
     * 球队照片
     */
    @ColumnInfo(comment="球队照片",type="varchar(200)")
    @TableField(value = "qiudui_photo")

    private String qiuduiPhoto;


    /**
     * 主场
     */
    @ColumnInfo(comment="主场",type="varchar(200)")
    @TableField(value = "qiudui_address")

    private String qiuduiAddress;


    /**
     * 球队类型
     */
    @ColumnInfo(comment="球队类型",type="int(11)")
    @TableField(value = "qiudui_types")

    private Integer qiuduiTypes;


    /**
     * 分区
     */
    @ColumnInfo(comment="分区",type="int(11)")
    @TableField(value = "fenqu_types")

    private Integer fenquTypes;


    /**
     * 球队热度
     */
    @ColumnInfo(comment="球队热度",type="int(11)")
    @TableField(value = "qiudui_clicknum")

    private Integer qiuduiClicknum;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 球队介绍
     */
    @ColumnInfo(comment="球队介绍",type="longtext")
    @TableField(value = "qiudui_content")

    private String qiuduiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "qiudui_delete")

    private Integer qiuduiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：球队名称
	 */
    public String getQiuduiName() {
        return qiuduiName;
    }
    /**
	 * 设置：球队名称
	 */

    public void setQiuduiName(String qiuduiName) {
        this.qiuduiName = qiuduiName;
    }
    /**
	 * 获取：球队编号
	 */
    public String getQiuduiUuidNumber() {
        return qiuduiUuidNumber;
    }
    /**
	 * 设置：球队编号
	 */

    public void setQiuduiUuidNumber(String qiuduiUuidNumber) {
        this.qiuduiUuidNumber = qiuduiUuidNumber;
    }
    /**
	 * 获取：球队照片
	 */
    public String getQiuduiPhoto() {
        return qiuduiPhoto;
    }
    /**
	 * 设置：球队照片
	 */

    public void setQiuduiPhoto(String qiuduiPhoto) {
        this.qiuduiPhoto = qiuduiPhoto;
    }
    /**
	 * 获取：主场
	 */
    public String getQiuduiAddress() {
        return qiuduiAddress;
    }
    /**
	 * 设置：主场
	 */

    public void setQiuduiAddress(String qiuduiAddress) {
        this.qiuduiAddress = qiuduiAddress;
    }
    /**
	 * 获取：球队类型
	 */
    public Integer getQiuduiTypes() {
        return qiuduiTypes;
    }
    /**
	 * 设置：球队类型
	 */

    public void setQiuduiTypes(Integer qiuduiTypes) {
        this.qiuduiTypes = qiuduiTypes;
    }
    /**
	 * 获取：分区
	 */
    public Integer getFenquTypes() {
        return fenquTypes;
    }
    /**
	 * 设置：分区
	 */

    public void setFenquTypes(Integer fenquTypes) {
        this.fenquTypes = fenquTypes;
    }
    /**
	 * 获取：球队热度
	 */
    public Integer getQiuduiClicknum() {
        return qiuduiClicknum;
    }
    /**
	 * 设置：球队热度
	 */

    public void setQiuduiClicknum(Integer qiuduiClicknum) {
        this.qiuduiClicknum = qiuduiClicknum;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：球队介绍
	 */
    public String getQiuduiContent() {
        return qiuduiContent;
    }
    /**
	 * 设置：球队介绍
	 */

    public void setQiuduiContent(String qiuduiContent) {
        this.qiuduiContent = qiuduiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQiuduiDelete() {
        return qiuduiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setQiuduiDelete(Integer qiuduiDelete) {
        this.qiuduiDelete = qiuduiDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qiudui{" +
            ", id=" + id +
            ", qiuduiName=" + qiuduiName +
            ", qiuduiUuidNumber=" + qiuduiUuidNumber +
            ", qiuduiPhoto=" + qiuduiPhoto +
            ", qiuduiAddress=" + qiuduiAddress +
            ", qiuduiTypes=" + qiuduiTypes +
            ", fenquTypes=" + fenquTypes +
            ", qiuduiClicknum=" + qiuduiClicknum +
            ", caiNumber=" + caiNumber +
            ", zanNumber=" + zanNumber +
            ", qiuduiContent=" + qiuduiContent +
            ", qiuduiDelete=" + qiuduiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
