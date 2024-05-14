package com.entity.view;

import com.entity.XiaoshuoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 文学信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaoshuo")
public class XiaoshuoView extends XiaoshuoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 文学信息类型的值
		*/
		private String xiaoshuoValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 zuozhe
			/**
			* 作者姓名
			*/
			private String zuozheName;
			/**
			* 作者手机号
			*/
			private String zuozhePhone;
			/**
			* 作者头像
			*/
			private String zuozhePhoto;
			/**
			* 电子邮箱
			*/
			private String zuozheEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public XiaoshuoView() {

	}

	public XiaoshuoView(XiaoshuoEntity xiaoshuoEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoshuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 文学信息类型的值
			*/
			public String getXiaoshuoValue() {
				return xiaoshuoValue;
			}
			/**
			* 设置： 文学信息类型的值
			*/
			public void setXiaoshuoValue(String xiaoshuoValue) {
				this.xiaoshuoValue = xiaoshuoValue;
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






















				//级联表的get和set zuozhe
					/**
					* 获取： 作者姓名
					*/
					public String getZuozheName() {
						return zuozheName;
					}
					/**
					* 设置： 作者姓名
					*/
					public void setZuozheName(String zuozheName) {
						this.zuozheName = zuozheName;
					}
					/**
					* 获取： 作者手机号
					*/
					public String getZuozhePhone() {
						return zuozhePhone;
					}
					/**
					* 设置： 作者手机号
					*/
					public void setZuozhePhone(String zuozhePhone) {
						this.zuozhePhone = zuozhePhone;
					}
					/**
					* 获取： 作者头像
					*/
					public String getZuozhePhoto() {
						return zuozhePhoto;
					}
					/**
					* 设置： 作者头像
					*/
					public void setZuozhePhoto(String zuozhePhoto) {
						this.zuozhePhoto = zuozhePhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getZuozheEmail() {
						return zuozheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZuozheEmail(String zuozheEmail) {
						this.zuozheEmail = zuozheEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}


}
