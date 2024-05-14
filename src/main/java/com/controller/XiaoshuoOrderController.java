
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 文学信息购买
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoshuoOrder")
public class XiaoshuoOrderController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoshuoOrderController.class);

    @Autowired
    private XiaoshuoOrderService xiaoshuoOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiaoshuoService xiaoshuoService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZuozheService zuozheService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("作者".equals(role))
            params.put("zuozheId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoshuoOrderService.queryPage(params);

        //字典表数据转换
        List<XiaoshuoOrderView> list =(List<XiaoshuoOrderView>)page.getList();
        for(XiaoshuoOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoshuoOrderEntity xiaoshuoOrder = xiaoshuoOrderService.selectById(id);
        if(xiaoshuoOrder !=null){
            //entity转view
            XiaoshuoOrderView view = new XiaoshuoOrderView();
            BeanUtils.copyProperties( xiaoshuoOrder , view );//把实体数据重构到view中

                //级联表
                XiaoshuoEntity xiaoshuo = xiaoshuoService.selectById(xiaoshuoOrder.getXiaoshuoId());
                if(xiaoshuo != null){
                    BeanUtils.copyProperties( xiaoshuo , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoshuoId(xiaoshuo.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xiaoshuoOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshuoOrderEntity xiaoshuoOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoshuoOrder:{}",this.getClass().getName(),xiaoshuoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xiaoshuoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xiaoshuoOrder.setInsertTime(new Date());
        xiaoshuoOrder.setCreateTime(new Date());
        xiaoshuoOrderService.insert(xiaoshuoOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoshuoOrderEntity xiaoshuoOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaoshuoOrder:{}",this.getClass().getName(),xiaoshuoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xiaoshuoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XiaoshuoOrderEntity> queryWrapper = new EntityWrapper<XiaoshuoOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshuoOrderEntity xiaoshuoOrderEntity = xiaoshuoOrderService.selectOne(queryWrapper);
        if(xiaoshuoOrderEntity==null){
            xiaoshuoOrderService.updateById(xiaoshuoOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiaoshuoOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XiaoshuoOrderEntity> xiaoshuoOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiaoshuoOrderEntity xiaoshuoOrderEntity = new XiaoshuoOrderEntity();
//                            xiaoshuoOrderEntity.setXiaoshuoOrderUuidNumber(data.get(0));                    //流水号 要改的
//                            xiaoshuoOrderEntity.setXiaoshuoId(Integer.valueOf(data.get(0)));   //文学信息 要改的
//                            xiaoshuoOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xiaoshuoOrderEntity.setInsertTime(date);//时间
//                            xiaoshuoOrderEntity.setCreateTime(date);//时间
                            xiaoshuoOrderList.add(xiaoshuoOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //流水号
                                if(seachFields.containsKey("xiaoshuoOrderUuidNumber")){
                                    List<String> xiaoshuoOrderUuidNumber = seachFields.get("xiaoshuoOrderUuidNumber");
                                    xiaoshuoOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshuoOrderUuidNumber = new ArrayList<>();
                                    xiaoshuoOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoshuoOrderUuidNumber",xiaoshuoOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //流水号
                        List<XiaoshuoOrderEntity> xiaoshuoOrderEntities_xiaoshuoOrderUuidNumber = xiaoshuoOrderService.selectList(new EntityWrapper<XiaoshuoOrderEntity>().in("xiaoshuo_order_uuid_number", seachFields.get("xiaoshuoOrderUuidNumber")));
                        if(xiaoshuoOrderEntities_xiaoshuoOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshuoOrderEntity s:xiaoshuoOrderEntities_xiaoshuoOrderUuidNumber){
                                repeatFields.add(s.getXiaoshuoOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoshuoOrderService.insertBatch(xiaoshuoOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoshuoOrderService.queryPage(params);

        //字典表数据转换
        List<XiaoshuoOrderView> list =(List<XiaoshuoOrderView>)page.getList();
        for(XiaoshuoOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoshuoOrderEntity xiaoshuoOrder = xiaoshuoOrderService.selectById(id);
            if(xiaoshuoOrder !=null){


                //entity转view
                XiaoshuoOrderView view = new XiaoshuoOrderView();
                BeanUtils.copyProperties( xiaoshuoOrder , view );//把实体数据重构到view中

                //级联表
                    XiaoshuoEntity xiaoshuo = xiaoshuoService.selectById(xiaoshuoOrder.getXiaoshuoId());
                if(xiaoshuo != null){
                    BeanUtils.copyProperties( xiaoshuo , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoshuoId(xiaoshuo.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xiaoshuoOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoshuoOrderEntity xiaoshuoOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xiaoshuoOrder:{}",this.getClass().getName(),xiaoshuoOrder.toString());
            XiaoshuoEntity xiaoshuoEntity = xiaoshuoService.selectById(xiaoshuoOrder.getXiaoshuoId());
            if(xiaoshuoEntity == null){
                return R.error(511,"查不到该文学信息");
            }
            // Double xiaoshuoNewMoney = xiaoshuoEntity.getXiaoshuoNewMoney();

            if(false){
            }
            else if(xiaoshuoEntity.getXiaoshuoNewMoney() == null){
                return R.error(511,"文学信息价格不能为空");
            }

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - xiaoshuoEntity.getXiaoshuoNewMoney();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");


            ZuozheEntity zuozheEntity = zuozheService.selectById(xiaoshuoEntity.getZuozheId());
            if(zuozheEntity == null)
                return R.error("查不到作者");

            xiaoshuoOrder.setYonghuId(userId); //设置订单支付人id
        xiaoshuoOrder.setXiaoshuoOrderUuidNumber(String.valueOf(new Date().getTime()));
            xiaoshuoOrder.setInsertTime(new Date());
            xiaoshuoOrder.setCreateTime(new Date());
                xiaoshuoOrderService.insert(xiaoshuoOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            zuozheEntity.setNewMoney(zuozheEntity.getNewMoney()+xiaoshuoEntity.getXiaoshuoNewMoney());
            zuozheService.updateById(zuozheEntity);

        return R.ok();
    }



}
