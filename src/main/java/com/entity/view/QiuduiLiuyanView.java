package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QiuduiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 球队留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiudui_liuyan")
public class QiuduiLiuyanView extends QiuduiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 球队
		/**
		* 球队名称
		*/

		@ColumnInfo(comment="球队名称",type="varchar(200)")
		private String qiuduiName;
		/**
		* 球队编号
		*/

		@ColumnInfo(comment="球队编号",type="varchar(200)")
		private String qiuduiUuidNumber;
		/**
		* 球队照片
		*/

		@ColumnInfo(comment="球队照片",type="varchar(200)")
		private String qiuduiPhoto;
		/**
		* 主场
		*/

		@ColumnInfo(comment="主场",type="varchar(200)")
		private String qiuduiAddress;
		/**
		* 球队类型
		*/
		@ColumnInfo(comment="球队类型",type="int(11)")
		private Integer qiuduiTypes;
			/**
			* 球队类型的值
			*/
			@ColumnInfo(comment="球队类型的字典表值",type="varchar(200)")
			private String qiuduiValue;
		/**
		* 分区
		*/
		@ColumnInfo(comment="分区",type="int(11)")
		private Integer fenquTypes;
			/**
			* 分区的值
			*/
			@ColumnInfo(comment="分区的字典表值",type="varchar(200)")
			private String fenquValue;
		/**
		* 球队热度
		*/

		@ColumnInfo(comment="球队热度",type="int(11)")
		private Integer qiuduiClicknum;
		/**
		* 球队介绍
		*/

		@ColumnInfo(comment="球队介绍",type="longtext")
		private String qiuduiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer qiuduiDelete;
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



	public QiuduiLiuyanView() {

	}

	public QiuduiLiuyanView(QiuduiLiuyanEntity qiuduiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, qiuduiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 球队

		/**
		* 获取： 球队名称
		*/
		public String getQiuduiName() {
			return qiuduiName;
		}
		/**
		* 设置： 球队名称
		*/
		public void setQiuduiName(String qiuduiName) {
			this.qiuduiName = qiuduiName;
		}

		/**
		* 获取： 球队编号
		*/
		public String getQiuduiUuidNumber() {
			return qiuduiUuidNumber;
		}
		/**
		* 设置： 球队编号
		*/
		public void setQiuduiUuidNumber(String qiuduiUuidNumber) {
			this.qiuduiUuidNumber = qiuduiUuidNumber;
		}

		/**
		* 获取： 球队照片
		*/
		public String getQiuduiPhoto() {
			return qiuduiPhoto;
		}
		/**
		* 设置： 球队照片
		*/
		public void setQiuduiPhoto(String qiuduiPhoto) {
			this.qiuduiPhoto = qiuduiPhoto;
		}

		/**
		* 获取： 主场
		*/
		public String getQiuduiAddress() {
			return qiuduiAddress;
		}
		/**
		* 设置： 主场
		*/
		public void setQiuduiAddress(String qiuduiAddress) {
			this.qiuduiAddress = qiuduiAddress;
		}
		/**
		* 获取： 球队类型
		*/
		public Integer getQiuduiTypes() {
			return qiuduiTypes;
		}
		/**
		* 设置： 球队类型
		*/
		public void setQiuduiTypes(Integer qiuduiTypes) {
			this.qiuduiTypes = qiuduiTypes;
		}


			/**
			* 获取： 球队类型的值
			*/
			public String getQiuduiValue() {
				return qiuduiValue;
			}
			/**
			* 设置： 球队类型的值
			*/
			public void setQiuduiValue(String qiuduiValue) {
				this.qiuduiValue = qiuduiValue;
			}
		/**
		* 获取： 分区
		*/
		public Integer getFenquTypes() {
			return fenquTypes;
		}
		/**
		* 设置： 分区
		*/
		public void setFenquTypes(Integer fenquTypes) {
			this.fenquTypes = fenquTypes;
		}


			/**
			* 获取： 分区的值
			*/
			public String getFenquValue() {
				return fenquValue;
			}
			/**
			* 设置： 分区的值
			*/
			public void setFenquValue(String fenquValue) {
				this.fenquValue = fenquValue;
			}

		/**
		* 获取： 球队热度
		*/
		public Integer getQiuduiClicknum() {
			return qiuduiClicknum;
		}
		/**
		* 设置： 球队热度
		*/
		public void setQiuduiClicknum(Integer qiuduiClicknum) {
			this.qiuduiClicknum = qiuduiClicknum;
		}

		/**
		* 获取： 球队介绍
		*/
		public String getQiuduiContent() {
			return qiuduiContent;
		}
		/**
		* 设置： 球队介绍
		*/
		public void setQiuduiContent(String qiuduiContent) {
			this.qiuduiContent = qiuduiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getQiuduiDelete() {
			return qiuduiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setQiuduiDelete(Integer qiuduiDelete) {
			this.qiuduiDelete = qiuduiDelete;
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
		return "QiuduiLiuyanView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", qiuduiName=" + qiuduiName +
			", qiuduiUuidNumber=" + qiuduiUuidNumber +
			", qiuduiPhoto=" + qiuduiPhoto +
			", qiuduiAddress=" + qiuduiAddress +
			", qiuduiClicknum=" + qiuduiClicknum +
			", qiuduiContent=" + qiuduiContent +
			", qiuduiDelete=" + qiuduiDelete +
			"} " + super.toString();
	}
}
