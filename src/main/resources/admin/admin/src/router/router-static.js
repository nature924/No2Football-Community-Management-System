import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import changdi from '@/views/modules/changdi/list'
    import changdiCollection from '@/views/modules/changdiCollection/list'
    import changdiLiuyan from '@/views/modules/changdiLiuyan/list'
    import changdiYuyue from '@/views/modules/changdiYuyue/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import jiaolian from '@/views/modules/jiaolian/list'
    import news from '@/views/modules/news/list'
    import qiudui from '@/views/modules/qiudui/list'
    import qiuduiCollection from '@/views/modules/qiuduiCollection/list'
    import qiuduiLiuyan from '@/views/modules/qiuduiLiuyan/list'
    import xunliandaka from '@/views/modules/xunliandaka/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryChangdi from '@/views/modules/dictionaryChangdi/list'
    import dictionaryChangdiCollection from '@/views/modules/dictionaryChangdiCollection/list'
    import dictionaryChangdiYuyueYesno from '@/views/modules/dictionaryChangdiYuyueYesno/list'
    import dictionaryDaka from '@/views/modules/dictionaryDaka/list'
    import dictionaryFenqu from '@/views/modules/dictionaryFenqu/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryQiudui from '@/views/modules/dictionaryQiudui/list'
    import dictionaryQiuduiCollection from '@/views/modules/dictionaryQiuduiCollection/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryXunliandaka from '@/views/modules/dictionaryXunliandaka/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryChangdi',
        name: '场地类型',
        component: dictionaryChangdi
    }
    ,{
        path: '/dictionaryChangdiCollection',
        name: '收藏表类型',
        component: dictionaryChangdiCollection
    }
    ,{
        path: '/dictionaryChangdiYuyueYesno',
        name: '预约状态',
        component: dictionaryChangdiYuyueYesno
    }
    ,{
        path: '/dictionaryDaka',
        name: '是否打卡',
        component: dictionaryDaka
    }
    ,{
        path: '/dictionaryFenqu',
        name: '分区',
        component: dictionaryFenqu
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryNews',
        name: '资讯类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryQiudui',
        name: '球队类型',
        component: dictionaryQiudui
    }
    ,{
        path: '/dictionaryQiuduiCollection',
        name: '收藏表类型',
        component: dictionaryQiuduiCollection
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryXunliandaka',
        name: '训练类型',
        component: dictionaryXunliandaka
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/changdi',
        name: '场地',
        component: changdi
      }
    ,{
        path: '/changdiCollection',
        name: '场地收藏',
        component: changdiCollection
      }
    ,{
        path: '/changdiLiuyan',
        name: '场地留言',
        component: changdiLiuyan
      }
    ,{
        path: '/changdiYuyue',
        name: '场地预约',
        component: changdiYuyue
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/jiaolian',
        name: '教练',
        component: jiaolian
      }
    ,{
        path: '/news',
        name: '足球资讯',
        component: news
      }
    ,{
        path: '/qiudui',
        name: '球队',
        component: qiudui
      }
    ,{
        path: '/qiuduiCollection',
        name: '球队收藏',
        component: qiuduiCollection
      }
    ,{
        path: '/qiuduiLiuyan',
        name: '球队留言',
        component: qiuduiLiuyan
      }
    ,{
        path: '/xunliandaka',
        name: '训练打卡',
        component: xunliandaka
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
