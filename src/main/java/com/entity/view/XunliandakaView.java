package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XunliandakaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 训练打卡
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xunliandaka")
public class XunliandakaView extends XunliandakaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 训练类型的值
	*/
	@ColumnInfo(comment="训练类型的字典表值",type="varchar(200)")
	private String xunliandakaValue;
	/**
	* 是否打卡的值
	*/
	@ColumnInfo(comment="是否打卡的字典表值",type="varchar(200)")
	private String dakaValue;

	//级联表 教练
							/**
		* 教练姓名
		*/

		@ColumnInfo(comment="教练姓名",type="varchar(200)")
		private String jiaolianName;
		/**
		* 教练手机号
		*/

		@ColumnInfo(comment="教练手机号",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 教练身份证号
		*/

		@ColumnInfo(comment="教练身份证号",type="varchar(200)")
		private String jiaolianIdNumber;
		/**
		* 教练头像
		*/

		@ColumnInfo(comment="教练头像",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 教练邮箱
		*/

		@ColumnInfo(comment="教练邮箱",type="varchar(200)")
		private String jiaolianEmail;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public XunliandakaView() {

	}

	public XunliandakaView(XunliandakaEntity xunliandakaEntity) {
		try {
			BeanUtils.copyProperties(this, xunliandakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 训练类型的值
	*/
	public String getXunliandakaValue() {
		return xunliandakaValue;
	}
	/**
	* 设置： 训练类型的值
	*/
	public void setXunliandakaValue(String xunliandakaValue) {
		this.xunliandakaValue = xunliandakaValue;
	}
	//当前表的
	/**
	* 获取： 是否打卡的值
	*/
	public String getDakaValue() {
		return dakaValue;
	}
	/**
	* 设置： 是否打卡的值
	*/
	public void setDakaValue(String dakaValue) {
		this.dakaValue = dakaValue;
	}


	//级联表的get和set 教练

		/**
		* 获取： 教练姓名
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练姓名
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 教练手机号
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 教练手机号
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 教练身份证号
		*/
		public String getJiaolianIdNumber() {
			return jiaolianIdNumber;
		}
		/**
		* 设置： 教练身份证号
		*/
		public void setJiaolianIdNumber(String jiaolianIdNumber) {
			this.jiaolianIdNumber = jiaolianIdNumber;
		}

		/**
		* 获取： 教练头像
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 教练头像
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}

		/**
		* 获取： 教练邮箱
		*/
		public String getJiaolianEmail() {
			return jiaolianEmail;
		}
		/**
		* 设置： 教练邮箱
		*/
		public void setJiaolianEmail(String jiaolianEmail) {
			this.jiaolianEmail = jiaolianEmail;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "XunliandakaView{" +
			", xunliandakaValue=" + xunliandakaValue +
			", dakaValue=" + dakaValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianIdNumber=" + jiaolianIdNumber +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianEmail=" + jiaolianEmail +
			"} " + super.toString();
	}
}
