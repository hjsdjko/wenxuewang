package com.entity.model;

import com.entity.XiaoshuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文学信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoshuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作者
     */
    private Integer zuozheId;


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
     * 逻辑删除
     */
    private Integer xiaoshuoDelete;


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
	 * 获取：作者
	 */
    public Integer getZuozheId() {
        return zuozheId;
    }


    /**
	 * 设置：作者
	 */
    public void setZuozheId(Integer zuozheId) {
        this.zuozheId = zuozheId;
    }
    /**
	 * 获取：文学信息名称
	 */
    public String getXiaoshuoName() {
        return xiaoshuoName;
    }


    /**
	 * 设置：文学信息名称
	 */
    public void setXiaoshuoName(String xiaoshuoName) {
        this.xiaoshuoName = xiaoshuoName;
    }
    /**
	 * 获取：文学信息照片
	 */
    public String getXiaoshuoPhoto() {
        return xiaoshuoPhoto;
    }


    /**
	 * 设置：文学信息照片
	 */
    public void setXiaoshuoPhoto(String xiaoshuoPhoto) {
        this.xiaoshuoPhoto = xiaoshuoPhoto;
    }
    /**
	 * 获取：文学信息类型
	 */
    public Integer getXiaoshuoTypes() {
        return xiaoshuoTypes;
    }


    /**
	 * 设置：文学信息类型
	 */
    public void setXiaoshuoTypes(Integer xiaoshuoTypes) {
        this.xiaoshuoTypes = xiaoshuoTypes;
    }
    /**
	 * 获取：文学信息原价
	 */
    public Double getXiaoshuoOldMoney() {
        return xiaoshuoOldMoney;
    }


    /**
	 * 设置：文学信息原价
	 */
    public void setXiaoshuoOldMoney(Double xiaoshuoOldMoney) {
        this.xiaoshuoOldMoney = xiaoshuoOldMoney;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getXiaoshuoNewMoney() {
        return xiaoshuoNewMoney;
    }


    /**
	 * 设置：现价/积分
	 */
    public void setXiaoshuoNewMoney(Double xiaoshuoNewMoney) {
        this.xiaoshuoNewMoney = xiaoshuoNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getXiaoshuoClicknum() {
        return xiaoshuoClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setXiaoshuoClicknum(Integer xiaoshuoClicknum) {
        this.xiaoshuoClicknum = xiaoshuoClicknum;
    }
    /**
	 * 获取：赞数量
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞数量
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩数量
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩数量
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：文学信息介绍
	 */
    public String getXiaoshuoContent() {
        return xiaoshuoContent;
    }


    /**
	 * 设置：文学信息介绍
	 */
    public void setXiaoshuoContent(String xiaoshuoContent) {
        this.xiaoshuoContent = xiaoshuoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXiaoshuoDelete() {
        return xiaoshuoDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXiaoshuoDelete(Integer xiaoshuoDelete) {
        this.xiaoshuoDelete = xiaoshuoDelete;
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
