package com.entity.vo;

import com.entity.ChangdiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 场地预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("changdi_yuyue")
public class ChangdiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约编号
     */

    @TableField(value = "changdi_yuyue_uuid_number")
    private String changdiYuyueUuidNumber;


    /**
     * 场地
     */

    @TableField(value = "changdi_id")
    private Integer changdiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约理由
     */

    @TableField(value = "changdi_yuyue_text")
    private String changdiYuyueText;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "changdi_yuyue_time")
    private Date changdiYuyueTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 预约状态
     */

    @TableField(value = "changdi_yuyue_yesno_types")
    private Integer changdiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "changdi_yuyue_yesno_text")
    private String changdiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "changdi_yuyue_shenhe_time")
    private Date changdiYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：预约编号
	 */
    public String getChangdiYuyueUuidNumber() {
        return changdiYuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setChangdiYuyueUuidNumber(String changdiYuyueUuidNumber) {
        this.changdiYuyueUuidNumber = changdiYuyueUuidNumber;
    }
    /**
	 * 设置：场地
	 */
    public Integer getChangdiId() {
        return changdiId;
    }


    /**
	 * 获取：场地
	 */

    public void setChangdiId(Integer changdiId) {
        this.changdiId = changdiId;
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
	 * 设置：预约理由
	 */
    public String getChangdiYuyueText() {
        return changdiYuyueText;
    }


    /**
	 * 获取：预约理由
	 */

    public void setChangdiYuyueText(String changdiYuyueText) {
        this.changdiYuyueText = changdiYuyueText;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getChangdiYuyueTime() {
        return changdiYuyueTime;
    }


    /**
	 * 获取：预约日期
	 */

    public void setChangdiYuyueTime(Date changdiYuyueTime) {
        this.changdiYuyueTime = changdiYuyueTime;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getChangdiYuyueYesnoTypes() {
        return changdiYuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setChangdiYuyueYesnoTypes(Integer changdiYuyueYesnoTypes) {
        this.changdiYuyueYesnoTypes = changdiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getChangdiYuyueYesnoText() {
        return changdiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setChangdiYuyueYesnoText(String changdiYuyueYesnoText) {
        this.changdiYuyueYesnoText = changdiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getChangdiYuyueShenheTime() {
        return changdiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setChangdiYuyueShenheTime(Date changdiYuyueShenheTime) {
        this.changdiYuyueShenheTime = changdiYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
