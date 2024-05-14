package com.entity.model;

import com.entity.ZhangjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 章节
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhangjieModel implements Serializable {
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
     * 章节名称
     */
    private String zhangjieName;


    /**
     * 章节内容
     */
    private String zhangjieContent;


    /**
     * 逻辑删除
     */
    private Integer zhangjieDelete;


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
	 * 获取：章节名称
	 */
    public String getZhangjieName() {
        return zhangjieName;
    }


    /**
	 * 设置：章节名称
	 */
    public void setZhangjieName(String zhangjieName) {
        this.zhangjieName = zhangjieName;
    }
    /**
	 * 获取：章节内容
	 */
    public String getZhangjieContent() {
        return zhangjieContent;
    }


    /**
	 * 设置：章节内容
	 */
    public void setZhangjieContent(String zhangjieContent) {
        this.zhangjieContent = zhangjieContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZhangjieDelete() {
        return zhangjieDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setZhangjieDelete(Integer zhangjieDelete) {
        this.zhangjieDelete = zhangjieDelete;
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
