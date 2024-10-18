
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
 * 场地
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/changdi")
public class ChangdiController {
    private static final Logger logger = LoggerFactory.getLogger(ChangdiController.class);

    private static final String TABLE_NAME = "changdi";

    @Autowired
    private ChangdiService changdiService;


    @Autowired
    private TokenService tokenService;

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
    private XunliandakaService xunliandakaService;//训练打卡
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
        params.put("changdiDeleteStart",1);params.put("changdiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = changdiService.queryPage(params);

        //字典表数据转换
        List<ChangdiView> list =(List<ChangdiView>)page.getList();
        for(ChangdiView c:list){
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
        ChangdiEntity changdi = changdiService.selectById(id);
        if(changdi !=null){
            //entity转view
            ChangdiView view = new ChangdiView();
            BeanUtils.copyProperties( changdi , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChangdiEntity changdi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,changdi:{}",this.getClass().getName(),changdi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChangdiEntity> queryWrapper = new EntityWrapper<ChangdiEntity>()
            .eq("changdi_name", changdi.getChangdiName())
            .eq("changdi_address", changdi.getChangdiAddress())
            .eq("changdi_types", changdi.getChangdiTypes())
            .eq("shangxia_types", changdi.getShangxiaTypes())
            .eq("changdi_delete", changdi.getChangdiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChangdiEntity changdiEntity = changdiService.selectOne(queryWrapper);
        if(changdiEntity==null){
            changdi.setChangdiClicknum(1);
            changdi.setShangxiaTypes(1);
            changdi.setChangdiDelete(1);
            changdi.setInsertTime(new Date());
            changdi.setCreateTime(new Date());
            changdiService.insert(changdi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChangdiEntity changdi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,changdi:{}",this.getClass().getName(),changdi.toString());
        ChangdiEntity oldChangdiEntity = changdiService.selectById(changdi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(changdi.getChangdiPhoto()) || "null".equals(changdi.getChangdiPhoto())){
                changdi.setChangdiPhoto(null);
        }

            changdiService.updateById(changdi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChangdiEntity> oldChangdiList =changdiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChangdiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChangdiEntity changdiEntity = new ChangdiEntity();
            changdiEntity.setId(id);
            changdiEntity.setChangdiDelete(2);
            list.add(changdiEntity);
        }
        if(list != null && list.size() >0){
            changdiService.updateBatchById(list);
        }

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
            List<ChangdiEntity> changdiList = new ArrayList<>();//上传的东西
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
                            ChangdiEntity changdiEntity = new ChangdiEntity();
//                            changdiEntity.setChangdiName(data.get(0));                    //场地名称 要改的
//                            changdiEntity.setChangdiUuidNumber(data.get(0));                    //场地编号 要改的
//                            changdiEntity.setChangdiPhoto("");//详情和图片
//                            changdiEntity.setChangdiAddress(data.get(0));                    //场地位置 要改的
//                            changdiEntity.setChangdiTypes(Integer.valueOf(data.get(0)));   //场地类型 要改的
//                            changdiEntity.setChangdiClicknum(Integer.valueOf(data.get(0)));   //场地热度 要改的
//                            changdiEntity.setChangdiContent("");//详情和图片
//                            changdiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            changdiEntity.setChangdiDelete(1);//逻辑删除字段
//                            changdiEntity.setInsertTime(date);//时间
//                            changdiEntity.setCreateTime(date);//时间
                            changdiList.add(changdiEntity);


                            //把要查询是否重复的字段放入map中
                                //场地编号
                                if(seachFields.containsKey("changdiUuidNumber")){
                                    List<String> changdiUuidNumber = seachFields.get("changdiUuidNumber");
                                    changdiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> changdiUuidNumber = new ArrayList<>();
                                    changdiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("changdiUuidNumber",changdiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //场地编号
                        List<ChangdiEntity> changdiEntities_changdiUuidNumber = changdiService.selectList(new EntityWrapper<ChangdiEntity>().in("changdi_uuid_number", seachFields.get("changdiUuidNumber")).eq("changdi_delete", 1));
                        if(changdiEntities_changdiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChangdiEntity s:changdiEntities_changdiUuidNumber){
                                repeatFields.add(s.getChangdiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [场地编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        changdiService.insertBatch(changdiList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChangdiView> returnChangdiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = changdiCollectionService.queryPage(params1);
        List<ChangdiCollectionView> collectionViewsList =(List<ChangdiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChangdiCollectionView collectionView:collectionViewsList){
            Integer changdiTypes = collectionView.getChangdiTypes();
            if(typeMap.containsKey(changdiTypes)){
                typeMap.put(changdiTypes,typeMap.get(changdiTypes)+1);
            }else{
                typeMap.put(changdiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("changdiTypes",type);
            PageUtils pageUtils1 = changdiService.queryPage(params2);
            List<ChangdiView> changdiViewList =(List<ChangdiView>)pageUtils1.getList();
            returnChangdiViewList.addAll(changdiViewList);
            if(returnChangdiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = changdiService.queryPage(params);
        if(returnChangdiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChangdiViewList.size();//要添加的数量
            List<ChangdiView> changdiViewList =(List<ChangdiView>)page.getList();
            for(ChangdiView changdiView:changdiViewList){
                Boolean addFlag = true;
                for(ChangdiView returnChangdiView:returnChangdiViewList){
                    if(returnChangdiView.getId().intValue() ==changdiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChangdiViewList.add(changdiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChangdiViewList = returnChangdiViewList.subList(0, limit);
        }

        for(ChangdiView c:returnChangdiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChangdiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = changdiService.queryPage(params);

        //字典表数据转换
        List<ChangdiView> list =(List<ChangdiView>)page.getList();
        for(ChangdiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChangdiEntity changdi = changdiService.selectById(id);
            if(changdi !=null){

                //点击数量加1
                changdi.setChangdiClicknum(changdi.getChangdiClicknum()+1);
                changdiService.updateById(changdi);

                //entity转view
                ChangdiView view = new ChangdiView();
                BeanUtils.copyProperties( changdi , view );//把实体数据重构到view中

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
    public R add(@RequestBody ChangdiEntity changdi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,changdi:{}",this.getClass().getName(),changdi.toString());
        Wrapper<ChangdiEntity> queryWrapper = new EntityWrapper<ChangdiEntity>()
            .eq("changdi_name", changdi.getChangdiName())
            .eq("changdi_uuid_number", changdi.getChangdiUuidNumber())
            .eq("changdi_address", changdi.getChangdiAddress())
            .eq("changdi_types", changdi.getChangdiTypes())
            .eq("changdi_clicknum", changdi.getChangdiClicknum())
            .eq("shangxia_types", changdi.getShangxiaTypes())
            .eq("changdi_delete", changdi.getChangdiDelete())
//            .notIn("changdi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChangdiEntity changdiEntity = changdiService.selectOne(queryWrapper);
        if(changdiEntity==null){
            changdi.setChangdiClicknum(1);
            changdi.setChangdiDelete(1);
            changdi.setInsertTime(new Date());
            changdi.setCreateTime(new Date());
        changdiService.insert(changdi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

