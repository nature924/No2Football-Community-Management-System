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
 * 场地
 *
 * @author 
 * @email
 */
@TableName("changdi")
public class ChangdiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChangdiEntity() {

	}

	public ChangdiEntity(T t) {
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
     * 场地名称
     */
    @ColumnInfo(comment="场地名称",type="varchar(200)")
    @TableField(value = "changdi_name")

    private String changdiName;


    /**
     * 场地编号
     */
    @ColumnInfo(comment="场地编号",type="varchar(200)")
    @TableField(value = "changdi_uuid_number")

    private String changdiUuidNumber;


    /**
     * 场地照片
     */
    @ColumnInfo(comment="场地照片",type="varchar(200)")
    @TableField(value = "changdi_photo")

    private String changdiPhoto;


    /**
     * 场地位置
     */
    @ColumnInfo(comment="场地位置",type="varchar(200)")
    @TableField(value = "changdi_address")

    private String changdiAddress;


    /**
     * 场地类型
     */
    @ColumnInfo(comment="场地类型",type="int(11)")
    @TableField(value = "changdi_types")

    private Integer changdiTypes;


    /**
     * 场地热度
     */
    @ColumnInfo(comment="场地热度",type="int(11)")
    @TableField(value = "changdi_clicknum")

    private Integer changdiClicknum;


    /**
     * 场地介绍
     */
    @ColumnInfo(comment="场地介绍",type="longtext")
    @TableField(value = "changdi_content")

    private String changdiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "changdi_delete")

    private Integer changdiDelete;


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
	 * 获取：场地名称
	 */
    public String getChangdiName() {
        return changdiName;
    }
    /**
	 * 设置：场地名称
	 */

    public void setChangdiName(String changdiName) {
        this.changdiName = changdiName;
    }
    /**
	 * 获取：场地编号
	 */
    public String getChangdiUuidNumber() {
        return changdiUuidNumber;
    }
    /**
	 * 设置：场地编号
	 */

    public void setChangdiUuidNumber(String changdiUuidNumber) {
        this.changdiUuidNumber = changdiUuidNumber;
    }
    /**
	 * 获取：场地照片
	 */
    public String getChangdiPhoto() {
        return changdiPhoto;
    }
    /**
	 * 设置：场地照片
	 */

    public void setChangdiPhoto(String changdiPhoto) {
        this.changdiPhoto = changdiPhoto;
    }
    /**
	 * 获取：场地位置
	 */
    public String getChangdiAddress() {
        return changdiAddress;
    }
    /**
	 * 设置：场地位置
	 */

    public void setChangdiAddress(String changdiAddress) {
        this.changdiAddress = changdiAddress;
    }
    /**
	 * 获取：场地类型
	 */
    public Integer getChangdiTypes() {
        return changdiTypes;
    }
    /**
	 * 设置：场地类型
	 */

    public void setChangdiTypes(Integer changdiTypes) {
        this.changdiTypes = changdiTypes;
    }
    /**
	 * 获取：场地热度
	 */
    public Integer getChangdiClicknum() {
        return changdiClicknum;
    }
    /**
	 * 设置：场地热度
	 */

    public void setChangdiClicknum(Integer changdiClicknum) {
        this.changdiClicknum = changdiClicknum;
    }
    /**
	 * 获取：场地介绍
	 */
    public String getChangdiContent() {
        return changdiContent;
    }
    /**
	 * 设置：场地介绍
	 */

    public void setChangdiContent(String changdiContent) {
        this.changdiContent = changdiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChangdiDelete() {
        return changdiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChangdiDelete(Integer changdiDelete) {
        this.changdiDelete = changdiDelete;
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
        return "Changdi{" +
            ", id=" + id +
            ", changdiName=" + changdiName +
            ", changdiUuidNumber=" + changdiUuidNumber +
            ", changdiPhoto=" + changdiPhoto +
            ", changdiAddress=" + changdiAddress +
            ", changdiTypes=" + changdiTypes +
            ", changdiClicknum=" + changdiClicknum +
            ", changdiContent=" + changdiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", changdiDelete=" + changdiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
