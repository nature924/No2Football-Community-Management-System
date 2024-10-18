
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
 * 训练打卡
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xunliandaka")
public class XunliandakaController {
    private static final Logger logger = LoggerFactory.getLogger(XunliandakaController.class);

    private static final String TABLE_NAME = "xunliandaka";

    @Autowired
    private XunliandakaService xunliandakaService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChangdiService changdiService;//场地
    @Autowired
    private ChangdiCollectionService changdiCollectionService;//场地收藏
    @Autowired
    private ChangdiLiuyanService changdiLiuyanService;//场地留言
    @Autowired
    private ChangdiYuyueService changdiYuyueService;//场地预约
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiaolianService jiaolianService;//教练
    @Autowired
    private NewsService newsService;//足球资讯
    @Autowired
    private QiuduiService qiuduiService;//球队
    @Autowired
    private QiuduiCollectionService qiuduiCollectionService;//球队收藏
    @Autowired
    private QiuduiLiuyanService qiuduiLiuyanService;//球队留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


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
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xunliandakaService.queryPage(params);

        //字典表数据转换
        List<XunliandakaView> list =(List<XunliandakaView>)page.getList();
        for(XunliandakaView c:list){
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
        XunliandakaEntity xunliandaka = xunliandakaService.selectById(id);
        if(xunliandaka !=null){
            //entity转view
            XunliandakaView view = new XunliandakaView();
            BeanUtils.copyProperties( xunliandaka , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xunliandaka.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiaolianId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 教练
            //级联表
            JiaolianEntity jiaolian = jiaolianService.selectById(xunliandaka.getJiaolianId());
            if(jiaolian != null){
            BeanUtils.copyProperties( jiaolian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiaolianId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiaolianId(jiaolian.getId());
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
    public R save(@RequestBody XunliandakaEntity xunliandaka, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xunliandaka:{}",this.getClass().getName(),xunliandaka.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教练".equals(role))
            xunliandaka.setJiaolianId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            xunliandaka.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XunliandakaEntity> queryWrapper = new EntityWrapper<XunliandakaEntity>()
            .eq("jiaolian_id", xunliandaka.getJiaolianId())
            .eq("yonghu_id", xunliandaka.getYonghuId())
            .eq("xunliandaka_name", xunliandaka.getXunliandakaName())
            .eq("xunliandaka_address", xunliandaka.getXunliandakaAddress())
            .eq("xunliandaka_types", xunliandaka.getXunliandakaTypes())
            .eq("xunlian_time", new SimpleDateFormat("yyyy-MM-dd").format(xunliandaka.getXunlianTime()))
            .eq("daka_types", xunliandaka.getDakaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XunliandakaEntity xunliandakaEntity = xunliandakaService.selectOne(queryWrapper);
        if(xunliandakaEntity==null){
            xunliandaka.setInsertTime(new Date());
            xunliandaka.setCreateTime(new Date());
            xunliandakaService.insert(xunliandaka);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XunliandakaEntity xunliandaka, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xunliandaka:{}",this.getClass().getName(),xunliandaka.toString());
        XunliandakaEntity oldXunliandakaEntity = xunliandakaService.selectById(xunliandaka.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教练".equals(role))
//            xunliandaka.setJiaolianId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            xunliandaka.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xunliandakaService.updateById(xunliandaka);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XunliandakaEntity> oldXunliandakaList =xunliandakaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xunliandakaService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XunliandakaEntity> xunliandakaList = new ArrayList<>();//上传的东西
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
                            XunliandakaEntity xunliandakaEntity = new XunliandakaEntity();
//                            xunliandakaEntity.setJiaolianId(Integer.valueOf(data.get(0)));   //教练 要改的
//                            xunliandakaEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xunliandakaEntity.setXunliandakaUuidNumber(data.get(0));                    //训练打卡编号 要改的
//                            xunliandakaEntity.setXunliandakaName(data.get(0));                    //训练标题 要改的
//                            xunliandakaEntity.setXunliandakaAddress(data.get(0));                    //训练地点 要改的
//                            xunliandakaEntity.setXunliandakaTypes(Integer.valueOf(data.get(0)));   //训练类型 要改的
//                            xunliandakaEntity.setXunlianTime(sdf.parse(data.get(0)));          //训练日期 要改的
//                            xunliandakaEntity.setXunliandakaContent("");//详情和图片
//                            xunliandakaEntity.setInsertTime(date);//时间
//                            xunliandakaEntity.setDakaTypes(Integer.valueOf(data.get(0)));   //是否打卡 要改的
//                            xunliandakaEntity.setCreateTime(date);//时间
                            xunliandakaList.add(xunliandakaEntity);


                            //把要查询是否重复的字段放入map中
                                //训练打卡编号
                                if(seachFields.containsKey("xunliandakaUuidNumber")){
                                    List<String> xunliandakaUuidNumber = seachFields.get("xunliandakaUuidNumber");
                                    xunliandakaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xunliandakaUuidNumber = new ArrayList<>();
                                    xunliandakaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xunliandakaUuidNumber",xunliandakaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //训练打卡编号
                        List<XunliandakaEntity> xunliandakaEntities_xunliandakaUuidNumber = xunliandakaService.selectList(new EntityWrapper<XunliandakaEntity>().in("xunliandaka_uuid_number", seachFields.get("xunliandakaUuidNumber")));
                        if(xunliandakaEntities_xunliandakaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XunliandakaEntity s:xunliandakaEntities_xunliandakaUuidNumber){
                                repeatFields.add(s.getXunliandakaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [训练打卡编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xunliandakaService.insertBatch(xunliandakaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
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

        CommonUtil.checkMap(params);
        PageUtils page = xunliandakaService.queryPage(params);

        //字典表数据转换
        List<XunliandakaView> list =(List<XunliandakaView>)page.getList();
        for(XunliandakaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XunliandakaEntity xunliandaka = xunliandakaService.selectById(id);
            if(xunliandaka !=null){


                //entity转view
                XunliandakaView view = new XunliandakaView();
                BeanUtils.copyProperties( xunliandaka , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xunliandaka.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    JiaolianEntity jiaolian = jiaolianService.selectById(xunliandaka.getJiaolianId());
                if(jiaolian != null){
                    BeanUtils.copyProperties( jiaolian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaolianId(jiaolian.getId());
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
    public R add(@RequestBody XunliandakaEntity xunliandaka, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xunliandaka:{}",this.getClass().getName(),xunliandaka.toString());
        Wrapper<XunliandakaEntity> queryWrapper = new EntityWrapper<XunliandakaEntity>()
            .eq("jiaolian_id", xunliandaka.getJiaolianId())
            .eq("yonghu_id", xunliandaka.getYonghuId())
            .eq("xunliandaka_uuid_number", xunliandaka.getXunliandakaUuidNumber())
            .eq("xunliandaka_name", xunliandaka.getXunliandakaName())
            .eq("xunliandaka_address", xunliandaka.getXunliandakaAddress())
            .eq("xunliandaka_types", xunliandaka.getXunliandakaTypes())
            .eq("daka_types", xunliandaka.getDakaTypes())
//            .notIn("xunliandaka_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XunliandakaEntity xunliandakaEntity = xunliandakaService.selectOne(queryWrapper);
        if(xunliandakaEntity==null){
            xunliandaka.setInsertTime(new Date());
            xunliandaka.setCreateTime(new Date());
        xunliandakaService.insert(xunliandaka);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

