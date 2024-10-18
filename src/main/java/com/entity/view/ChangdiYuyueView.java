package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChangdiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 场地预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("changdi_yuyue")
public class ChangdiYuyueView extends ChangdiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 预约状态的值
	*/
	@ColumnInfo(comment="预约状态的字典表值",type="varchar(200)")
	private String changdiYuyueYesnoValue;

	//级联表 场地
		/**
		* 场地名称
		*/

		@ColumnInfo(comment="场地名称",type="varchar(200)")
		private String changdiName;
		/**
		* 场地编号
		*/

		@ColumnInfo(comment="场地编号",type="varchar(200)")
		private String changdiUuidNumber;
		/**
		* 场地照片
		*/

		@ColumnInfo(comment="场地照片",type="varchar(200)")
		private String changdiPhoto;
		/**
		* 场地位置
		*/

		@ColumnInfo(comment="场地位置",type="varchar(200)")
		private String changdiAddress;
		/**
		* 场地类型
		*/
		@ColumnInfo(comment="场地类型",type="int(11)")
		private Integer changdiTypes;
			/**
			* 场地类型的值
			*/
			@ColumnInfo(comment="场地类型的字典表值",type="varchar(200)")
			private String changdiValue;
		/**
		* 场地热度
		*/

		@ColumnInfo(comment="场地热度",type="int(11)")
		private Integer changdiClicknum;
		/**
		* 场地介绍
		*/

		@ColumnInfo(comment="场地介绍",type="longtext")
		private String changdiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer changdiDelete;
	//级联表 用户
							/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public ChangdiYuyueView() {

	}

	public ChangdiYuyueView(ChangdiYuyueEntity changdiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, changdiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 预约状态的值
	*/
	public String getChangdiYuyueYesnoValue() {
		return changdiYuyueYesnoValue;
	}
	/**
	* 设置： 预约状态的值
	*/
	public void setChangdiYuyueYesnoValue(String changdiYuyueYesnoValue) {
		this.changdiYuyueYesnoValue = changdiYuyueYesnoValue;
	}


	//级联表的get和set 场地

		/**
		* 获取： 场地名称
		*/
		public String getChangdiName() {
			return changdiName;
		}
		/**
		* 设置： 场地名称
		*/
		public void setChangdiName(String changdiName) {
			this.changdiName = changdiName;
		}

		/**
		* 获取： 场地编号
		*/
		public String getChangdiUuidNumber() {
			return changdiUuidNumber;
		}
		/**
		* 设置： 场地编号
		*/
		public void setChangdiUuidNumber(String changdiUuidNumber) {
			this.changdiUuidNumber = changdiUuidNumber;
		}

		/**
		* 获取： 场地照片
		*/
		public String getChangdiPhoto() {
			return changdiPhoto;
		}
		/**
		* 设置： 场地照片
		*/
		public void setChangdiPhoto(String changdiPhoto) {
			this.changdiPhoto = changdiPhoto;
		}

		/**
		* 获取： 场地位置
		*/
		public String getChangdiAddress() {
			return changdiAddress;
		}
		/**
		* 设置： 场地位置
		*/
		public void setChangdiAddress(String changdiAddress) {
			this.changdiAddress = changdiAddress;
		}
		/**
		* 获取： 场地类型
		*/
		public Integer getChangdiTypes() {
			return changdiTypes;
		}
		/**
		* 设置： 场地类型
		*/
		public void setChangdiTypes(Integer changdiTypes) {
			this.changdiTypes = changdiTypes;
		}


			/**
			* 获取： 场地类型的值
			*/
			public String getChangdiValue() {
				return changdiValue;
			}
			/**
			* 设置： 场地类型的值
			*/
			public void setChangdiValue(String changdiValue) {
				this.changdiValue = changdiValue;
			}

		/**
		* 获取： 场地热度
		*/
		public Integer getChangdiClicknum() {
			return changdiClicknum;
		}
		/**
		* 设置： 场地热度
		*/
		public void setChangdiClicknum(Integer changdiClicknum) {
			this.changdiClicknum = changdiClicknum;
		}

		/**
		* 获取： 场地介绍
		*/
		public String getChangdiContent() {
			return changdiContent;
		}
		/**
		* 设置： 场地介绍
		*/
		public void setChangdiContent(String changdiContent) {
			this.changdiContent = changdiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChangdiDelete() {
			return changdiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChangdiDelete(Integer changdiDelete) {
			this.changdiDelete = changdiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "ChangdiYuyueView{" +
			", changdiYuyueYesnoValue=" + changdiYuyueYesnoValue +
			", changdiName=" + changdiName +
			", changdiUuidNumber=" + changdiUuidNumber +
			", changdiPhoto=" + changdiPhoto +
			", changdiAddress=" + changdiAddress +
			", changdiClicknum=" + changdiClicknum +
			", changdiContent=" + changdiContent +
			", changdiDelete=" + changdiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
