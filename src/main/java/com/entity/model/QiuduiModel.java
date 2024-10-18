package com.entity.model;

import com.entity.QiuduiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 球队
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiuduiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 球队名称
     */
    private String qiuduiName;


    /**
     * 球队编号
     */
    private String qiuduiUuidNumber;


    /**
     * 球队照片
     */
    private String qiuduiPhoto;


    /**
     * 主场
     */
    private String qiuduiAddress;


    /**
     * 球队类型
     */
    private Integer qiuduiTypes;


    /**
     * 分区
     */
    private Integer fenquTypes;


    /**
     * 球队热度
     */
    private Integer qiuduiClicknum;


    /**
     * 球队介绍
     */
    private String qiuduiContent;


    /**
     * 逻辑删除
     */
    private Integer qiuduiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
