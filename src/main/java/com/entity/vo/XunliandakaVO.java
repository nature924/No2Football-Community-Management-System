package com.entity.vo;

import com.entity.XunliandakaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 训练打卡
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xunliandaka")
public class XunliandakaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教练
     */

    @TableField(value = "jiaolian_id")
    private Integer jiaolianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 训练打卡编号
     */

    @TableField(value = "xunliandaka_uuid_number")
    private String xunliandakaUuidNumber;


    /**
     * 训练标题
     */

    @TableField(value = "xunliandaka_name")
    private String xunliandakaName;


    /**
     * 训练地点
     */

    @TableField(value = "xunliandaka_address")
    private String xunliandakaAddress;


    /**
     * 训练类型
     */

    @TableField(value = "xunliandaka_types")
    private Integer xunliandakaTypes;


    /**
     * 训练日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xunlian_time")
    private Date xunlianTime;


    /**
     * 训练内容
     */

    @TableField(value = "xunliandaka_content")
    private String xunliandakaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 是否打卡
     */

    @TableField(value = "daka_types")
    private Integer dakaTypes;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }


    /**
	 * 获取：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：训练打卡编号
	 */
    public String getXunliandakaUuidNumber() {
        return xunliandakaUuidNumber;
    }


    /**
	 * 获取：训练打卡编号
	 */

    public void setXunliandakaUuidNumber(String xunliandakaUuidNumber) {
        this.xunliandakaUuidNumber = xunliandakaUuidNumber;
    }
    /**
	 * 设置：训练标题
	 */
    public String getXunliandakaName() {
        return xunliandakaName;
    }


    /**
	 * 获取：训练标题
	 */

    public void setXunliandakaName(String xunliandakaName) {
        this.xunliandakaName = xunliandakaName;
    }
    /**
	 * 设置：训练地点
	 */
    public String getXunliandakaAddress() {
        return xunliandakaAddress;
    }


    /**
	 * 获取：训练地点
	 */

    public void setXunliandakaAddress(String xunliandakaAddress) {
        this.xunliandakaAddress = xunliandakaAddress;
    }
    /**
	 * 设置：训练类型
	 */
    public Integer getXunliandakaTypes() {
        return xunliandakaTypes;
    }


    /**
	 * 获取：训练类型
	 */

    public void setXunliandakaTypes(Integer xunliandakaTypes) {
        this.xunliandakaTypes = xunliandakaTypes;
    }
    /**
	 * 设置：训练日期
	 */
    public Date getXunlianTime() {
        return xunlianTime;
    }


    /**
	 * 获取：训练日期
	 */

    public void setXunlianTime(Date xunlianTime) {
        this.xunlianTime = xunlianTime;
    }
    /**
	 * 设置：训练内容
	 */
    public String getXunliandakaContent() {
        return xunliandakaContent;
    }


    /**
	 * 获取：训练内容
	 */

    public void setXunliandakaContent(String xunliandakaContent) {
        this.xunliandakaContent = xunliandakaContent;
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
	 * 设置：是否打卡
	 */
    public Integer getDakaTypes() {
        return dakaTypes;
    }


    /**
	 * 获取：是否打卡
	 */

    public void setDakaTypes(Integer dakaTypes) {
        this.dakaTypes = dakaTypes;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
