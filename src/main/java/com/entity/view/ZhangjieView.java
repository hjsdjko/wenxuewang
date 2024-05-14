package com.entity.view;

import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 章节
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhangjie")
public class ZhangjieView extends ZhangjieEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 xiaoshuo
			/**
			* 文学信息 的 作者
			*/
			private Integer xiaoshuoZuozheId;
			/**
			* 文学信息名称
			*/
			private String xiaoshuoName;
			/**
			* 文学信息照片
			*/
			private String xiaoshuoPhoto;
			/**
			* 文学信息类型
			*/
			private Integer xiaoshuoTypes;
				/**
				* 文学信息类型的值
				*/
				private String xiaoshuoValue;
			/**
			* 文学信息原价
			*/
			private Double xiaoshuoOldMoney;
			/**
			* 现价/积分
			*/
			private Double xiaoshuoNewMoney;
			/**
			* 点击次数
			*/
			private Integer xiaoshuoClicknum;
			/**
			* 赞数量
			*/
			private Integer zanNumber;
			/**
			* 踩数量
			*/
			private Integer caiNumber;
			/**
			* 文学信息介绍
			*/
			private String xiaoshuoContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer xiaoshuoDelete;

	public ZhangjieView() {

	}

	public ZhangjieView(ZhangjieEntity zhangjieEntity) {
		try {
			BeanUtils.copyProperties(this, zhangjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}









				//级联表的get和set xiaoshuo
					/**
					* 获取：文学信息 的 作者
					*/
					public Integer getXiaoshuoZuozheId() {
						return xiaoshuoZuozheId;
					}
					/**
					* 设置：文学信息 的 作者
					*/
					public void setXiaoshuoZuozheId(Integer xiaoshuoZuozheId) {
						this.xiaoshuoZuozheId = xiaoshuoZuozheId;
					}

					/**
					* 获取： 文学信息名称
					*/
					public String getXiaoshuoName() {
						return xiaoshuoName;
					}
					/**
					* 设置： 文学信息名称
					*/
					public void setXiaoshuoName(String xiaoshuoName) {
						this.xiaoshuoName = xiaoshuoName;
					}
					/**
					* 获取： 文学信息照片
					*/
					public String getXiaoshuoPhoto() {
						return xiaoshuoPhoto;
					}
					/**
					* 设置： 文学信息照片
					*/
					public void setXiaoshuoPhoto(String xiaoshuoPhoto) {
						this.xiaoshuoPhoto = xiaoshuoPhoto;
					}
					/**
					* 获取： 文学信息类型
					*/
					public Integer getXiaoshuoTypes() {
						return xiaoshuoTypes;
					}
					/**
					* 设置： 文学信息类型
					*/
					public void setXiaoshuoTypes(Integer xiaoshuoTypes) {
						this.xiaoshuoTypes = xiaoshuoTypes;
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
					* 获取： 文学信息原价
					*/
					public Double getXiaoshuoOldMoney() {
						return xiaoshuoOldMoney;
					}
					/**
					* 设置： 文学信息原价
					*/
					public void setXiaoshuoOldMoney(Double xiaoshuoOldMoney) {
						this.xiaoshuoOldMoney = xiaoshuoOldMoney;
					}
					/**
					* 获取： 现价/积分
					*/
					public Double getXiaoshuoNewMoney() {
						return xiaoshuoNewMoney;
					}
					/**
					* 设置： 现价/积分
					*/
					public void setXiaoshuoNewMoney(Double xiaoshuoNewMoney) {
						this.xiaoshuoNewMoney = xiaoshuoNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getXiaoshuoClicknum() {
						return xiaoshuoClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setXiaoshuoClicknum(Integer xiaoshuoClicknum) {
						this.xiaoshuoClicknum = xiaoshuoClicknum;
					}
					/**
					* 获取： 赞数量
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞数量
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}
					/**
					* 获取： 踩数量
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩数量
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}
					/**
					* 获取： 文学信息介绍
					*/
					public String getXiaoshuoContent() {
						return xiaoshuoContent;
					}
					/**
					* 设置： 文学信息介绍
					*/
					public void setXiaoshuoContent(String xiaoshuoContent) {
						this.xiaoshuoContent = xiaoshuoContent;
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
					public Integer getXiaoshuoDelete() {
						return xiaoshuoDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXiaoshuoDelete(Integer xiaoshuoDelete) {
						this.xiaoshuoDelete = xiaoshuoDelete;
					}


















}
