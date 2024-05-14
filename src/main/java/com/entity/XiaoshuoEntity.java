package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 文学信息
 *
 * @author 
 * @email
 */
@TableName("xiaoshuo")
public class XiaoshuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoshuoEntity() {

	}

	public XiaoshuoEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 作者
     */
    @TableField(value = "zuozhe_id")

    private Integer zuozheId;


    /**
     * 文学信息名称
     */
    @TableField(value = "xiaoshuo_name")

    private String xiaoshuoName;


    /**
     * 文学信息照片
     */
    @TableField(value = "xiaoshuo_photo")

    private String xiaoshuoPhoto;


    /**
     * 文学信息类型
     */
    @TableField(value = "xiaoshuo_types")

    private Integer xiaoshuoTypes;


    /**
     * 文学信息原价
     */
    @TableField(value = "xiaoshuo_old_money")

    private Double xiaoshuoOldMoney;


    /**
     * 现价/积分
     */
    @TableField(value = "xiaoshuo_new_money")

    private Double xiaoshuoNewMoney;


    /**
     * 点击次数
     */
    @TableField(value = "xiaoshuo_clicknum")

    private Integer xiaoshuoClicknum;


    /**
     * 赞数量
     */
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩数量
     */
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 文学信息介绍
     */
    @TableField(value = "xiaoshuo_content")

    private String xiaoshuoContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "xiaoshuo_delete")

    private Integer xiaoshuoDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：作者
	 */
    public Integer getZuozheId() {
        return zuozheId;
    }


    /**
	 * 获取：作者
	 */

    public void setZuozheId(Integer zuozheId) {
        this.zuozheId = zuozheId;
    }
    /**
	 * 设置：文学信息名称
	 */
    public String getXiaoshuoName() {
        return xiaoshuoName;
    }


    /**
	 * 获取：文学信息名称
	 */

    public void setXiaoshuoName(String xiaoshuoName) {
        this.xiaoshuoName = xiaoshuoName;
    }
    /**
	 * 设置：文学信息照片
	 */
    public String getXiaoshuoPhoto() {
        return xiaoshuoPhoto;
    }


    /**
	 * 获取：文学信息照片
	 */

    public void setXiaoshuoPhoto(String xiaoshuoPhoto) {
        this.xiaoshuoPhoto = xiaoshuoPhoto;
    }
    /**
	 * 设置：文学信息类型
	 */
    public Integer getXiaoshuoTypes() {
        return xiaoshuoTypes;
    }


    /**
	 * 获取：文学信息类型
	 */

    public void setXiaoshuoTypes(Integer xiaoshuoTypes) {
        this.xiaoshuoTypes = xiaoshuoTypes;
    }
    /**
	 * 设置：文学信息原价
	 */
    public Double getXiaoshuoOldMoney() {
        return xiaoshuoOldMoney;
    }


    /**
	 * 获取：文学信息原价
	 */

    public void setXiaoshuoOldMoney(Double xiaoshuoOldMoney) {
        this.xiaoshuoOldMoney = xiaoshuoOldMoney;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getXiaoshuoNewMoney() {
        return xiaoshuoNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setXiaoshuoNewMoney(Double xiaoshuoNewMoney) {
        this.xiaoshuoNewMoney = xiaoshuoNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getXiaoshuoClicknum() {
        return xiaoshuoClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setXiaoshuoClicknum(Integer xiaoshuoClicknum) {
        this.xiaoshuoClicknum = xiaoshuoClicknum;
    }
    /**
	 * 设置：赞数量
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞数量
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩数量
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩数量
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：文学信息介绍
	 */
    public String getXiaoshuoContent() {
        return xiaoshuoContent;
    }


    /**
	 * 获取：文学信息介绍
	 */

    public void setXiaoshuoContent(String xiaoshuoContent) {
        this.xiaoshuoContent = xiaoshuoContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXiaoshuoDelete() {
        return xiaoshuoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXiaoshuoDelete(Integer xiaoshuoDelete) {
        this.xiaoshuoDelete = xiaoshuoDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xiaoshuo{" +
            "id=" + id +
            ", zuozheId=" + zuozheId +
            ", xiaoshuoName=" + xiaoshuoName +
            ", xiaoshuoPhoto=" + xiaoshuoPhoto +
            ", xiaoshuoTypes=" + xiaoshuoTypes +
            ", xiaoshuoOldMoney=" + xiaoshuoOldMoney +
            ", xiaoshuoNewMoney=" + xiaoshuoNewMoney +
            ", xiaoshuoClicknum=" + xiaoshuoClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", xiaoshuoContent=" + xiaoshuoContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xiaoshuoDelete=" + xiaoshuoDelete +
            ", createTime=" + createTime +
        "}";
    }
}
