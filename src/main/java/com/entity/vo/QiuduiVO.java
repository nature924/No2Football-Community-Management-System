package com.entity.vo;

import com.entity.QiuduiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 球队
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiudui")
public class QiuduiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 球队名称
     */

    @TableField(value = "qiudui_name")
    private String qiuduiName;


    /**
     * 球队编号
     */

    @TableField(value = "qiudui_uuid_number")
    private String qiuduiUuidNumber;


    /**
     * 球队照片
     */

    @TableField(value = "qiudui_photo")
    private String qiuduiPhoto;


    /**
     * 主场
     */

    @TableField(value = "qiudui_address")
    private String qiuduiAddress;


    /**
     * 球队类型
     */

    @TableField(value = "qiudui_types")
    private Integer qiuduiTypes;


    /**
     * 分区
     */

    @TableField(value = "fenqu_types")
    private Integer fenquTypes;


    /**
     * 球队热度
     */

    @TableField(value = "qiudui_clicknum")
    private Integer qiuduiClicknum;


    /**
     * 球队介绍
     */

    @TableField(value = "qiudui_content")
    private String qiuduiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "qiudui_delete")
    private Integer qiuduiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：球队名称
	 */
    public String getQiuduiName() {
        return qiuduiName;
    }


    /**
	 * 获取：球队名称
	 */

    public void setQiuduiName(String qiuduiName) {
        this.qiuduiName = qiuduiName;
    }
    /**
	 * 设置：球队编号
	 */
    public String getQiuduiUuidNumber() {
        return qiuduiUuidNumber;
    }


    /**
	 * 获取：球队编号
	 */

    public void setQiuduiUuidNumber(String qiuduiUuidNumber) {
        this.qiuduiUuidNumber = qiuduiUuidNumber;
    }
    /**
	 * 设置：球队照片
	 */
    public String getQiuduiPhoto() {
        return qiuduiPhoto;
    }


    /**
	 * 获取：球队照片
	 */

    public void setQiuduiPhoto(String qiuduiPhoto) {
        this.qiuduiPhoto = qiuduiPhoto;
    }
    /**
	 * 设置：主场
	 */
    public String getQiuduiAddress() {
        return qiuduiAddress;
    }


    /**
	 * 获取：主场
	 */

    public void setQiuduiAddress(String qiuduiAddress) {
        this.qiuduiAddress = qiuduiAddress;
    }
    /**
	 * 设置：球队类型
	 */
    public Integer getQiuduiTypes() {
        return qiuduiTypes;
    }


    /**
	 * 获取：球队类型
	 */

    public void setQiuduiTypes(Integer qiuduiTypes) {
        this.qiuduiTypes = qiuduiTypes;
    }
    /**
	 * 设置：分区
	 */
    public Integer getFenquTypes() {
        return fenquTypes;
    }


    /**
	 * 获取：分区
	 */

    public void setFenquTypes(Integer fenquTypes) {
        this.fenquTypes = fenquTypes;
    }
    /**
	 * 设置：球队热度
	 */
    public Integer getQiuduiClicknum() {
        return qiuduiClicknum;
    }


    /**
	 * 获取：球队热度
	 */

    public void setQiuduiClicknum(Integer qiuduiClicknum) {
        this.qiuduiClicknum = qiuduiClicknum;
    }
    /**
	 * 设置：球队介绍
	 */
    public String getQiuduiContent() {
        return qiuduiContent;
    }


    /**
	 * 获取：球队介绍
	 */

    public void setQiuduiContent(String qiuduiContent) {
        this.qiuduiContent = qiuduiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getQiuduiDelete() {
        return qiuduiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setQiuduiDelete(Integer qiuduiDelete) {
        this.qiuduiDelete = qiuduiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
