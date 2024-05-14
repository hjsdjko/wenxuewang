package com.entity.model;

import com.entity.YuedujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 阅读记录管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuedujiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 文学信息
     */
    private Integer xiaoshuoId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 详情
     */
    private String yuedujiluContent;


    /**
     * 阅读时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：文学信息
	 */
    public Integer getXiaoshuoId() {
        return xiaoshuoId;
    }


    /**
	 * 设置：文学信息
	 */
    public void setXiaoshuoId(Integer xiaoshuoId) {
        this.xiaoshuoId = xiaoshuoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：详情
	 */
    public String getYuedujiluContent() {
        return yuedujiluContent;
    }


    /**
	 * 设置：详情
	 */
    public void setYuedujiluContent(String yuedujiluContent) {
        this.yuedujiluContent = yuedujiluContent;
    }
    /**
	 * 获取：阅读时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：阅读时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
