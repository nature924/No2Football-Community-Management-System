<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                   <!--<el-col :span="12" v-if="flag=='jiaolian'">
            <el-form-item class="select" label="球队" prop="qiuduiId">
                <el-select v-model="ruleForm.qiuduiId" filterable placeholder="请选择球队" @change="qiuduiChange">
                    <el-option
                            v-for="(item,index) in qiuduiOptions"
                            v-bind:key="item.id"
                                            :label="item.qiuduiName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>-->
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='球队名称' prop="qiuduiName">
                 <el-input v-model="qiuduiForm.qiuduiName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='球队编号' prop="qiuduiUuidNumber">
                 <el-input v-model="qiuduiForm.qiuduiUuidNumber" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='球队照片' prop="qiuduiPhoto">
                 <el-image
                     style="width: 100px; height: 100px"
                     :src="qiuduiForm.qiuduiPhoto?$base.url+qiuduiForm.qiuduiPhoto:''"
                     :fit="fit">
                 </el-image>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='主场' prop="qiuduiAddress">
                 <el-input v-model="qiuduiForm.qiuduiAddress" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='球队类型' prop="qiuduiTypes">
                 <el-input v-model="qiuduiForm.qiuduiValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='分区' prop="fenquTypes">
                 <el-input v-model="qiuduiForm.fenquValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='球队热度' prop="qiuduiClicknum">
                 <el-input v-model="qiuduiForm.qiuduiClicknum" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='逻辑删除' prop="qiuduiDelete">
                 <el-input v-model="qiuduiForm.qiuduiDelete" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='jiaolian'"  label='教练姓名' prop="jiaolianName">
               <el-input v-model="ruleForm.jiaolianName"  placeholder='教练姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaolian'"  label='教练手机号' prop="jiaolianPhone">
               <el-input v-model="ruleForm.jiaolianPhone"  placeholder='教练手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaolian'"  label='教练身份证号' prop="jiaolianIdNumber">
               <el-input v-model="ruleForm.jiaolianIdNumber"  placeholder='教练身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='jiaolian'" label='教练头像' prop="jiaolianPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.jiaolianPhoto?$base.url+ruleForm.jiaolianPhoto:''"
                         @change="jiaolianPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='jiaolian'"  label='教练邮箱' prop="jiaolianEmail">
               <el-input v-model="ruleForm.jiaolianEmail"  placeholder='教练邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

        <!--<el-col :span="12" v-if="flag=='yonghu'">
            <el-form-item class="select" label="球队" prop="qiuduiId">
                <el-select v-model="ruleForm.qiuduiId" filterable placeholder="请选择球队" @change="qiuduiChange">
                    <el-option
                            v-for="(item,index) in qiuduiOptions"
                            v-bind:key="item.id"
                                            :label="item.qiuduiName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>-->
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='球队名称' prop="qiuduiName">
                 <el-input v-model="qiuduiForm.qiuduiName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='球队编号' prop="qiuduiUuidNumber">
                 <el-input v-model="qiuduiForm.qiuduiUuidNumber" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='球队照片' prop="qiuduiPhoto">
                 <el-image
                     style="width: 100px; height: 100px"
                     :src="qiuduiForm.qiuduiPhoto?$base.url+qiuduiForm.qiuduiPhoto:''"
                     :fit="fit">
                 </el-image>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='主场' prop="qiuduiAddress">
                 <el-input v-model="qiuduiForm.qiuduiAddress" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='球队类型' prop="qiuduiTypes">
                 <el-input v-model="qiuduiForm.qiuduiValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='分区' prop="fenquTypes">
                 <el-input v-model="qiuduiForm.fenquValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='球队热度' prop="qiuduiClicknum">
                 <el-input v-model="qiuduiForm.qiuduiClicknum" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='逻辑删除' prop="qiuduiDelete">
                 <el-input v-model="qiuduiForm.qiuduiDelete" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='用户姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='用户手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='用户身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='用户头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='用户邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu'
|| flag=='jiaolian')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 用户
    // 注册的类型字段 用户
        // 性别
        sexTypesOptions : [],
    // 注册的级联表 用户
        // 球队列表
        qiuduiOptions : [],
        qiuduiForm:{},
// 注册表 教练
    // 注册的类型字段 教练
        // 性别
        sexTypesOptions : [],
    // 注册的级联表 教练
        // 球队列表
        qiuduiOptions : [],
        qiuduiForm:{},
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 用户
    // 注册的级联表 用户
        if(table == 'yonghu'){
            this.qiuduiChange(this.ruleForm.qiuduiId);
        }
// 注册表 教练
    // 注册的级联表 教练
        if(table == 'jiaolian'){
            this.qiuduiChange(this.ruleForm.qiuduiId);
        }
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 用户 的级联表
    // 注册的级联表 用户
        // 球队列表
    this.$http({
        url: `qiudui/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.qiuduiOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });
// 注册表 教练 的级联表
    // 注册的级联表 教练
        // 球队列表
    this.$http({
        url: `qiudui/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.qiuduiOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    jiaolianPhotoUploadChange(fileUrls) {
        this.ruleForm.jiaolianPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },
// 注册表的级联表
    qiuduiChange(id){
        this.$http({
            url: `qiudui/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.qiuduiForm = data.data;
            }
        });
    },
// 注册表的级联表
    qiuduiChange(id){
        this.$http({
            url: `qiudui/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.qiuduiForm = data.data;
            }
        });
    },


    onUpdateHandler() {
                         if((!this.ruleForm.qiuduiId)&& 'jiaolian'==this.flag){
                             this.$message.error('球队不能为空');
                             return
                         }

                         if((!this.ruleForm.jiaolianName)&& 'jiaolian'==this.flag){
                             this.$message.error('教练姓名不能为空');
                             return
                         }

                             if( 'jiaolian' ==this.flag && this.ruleForm.jiaolianPhone&&(!isMobile(this.ruleForm.jiaolianPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.jiaolianIdNumber)&& 'jiaolian'==this.flag){
                             this.$message.error('教练身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.jiaolianPhoto)&& 'jiaolian'==this.flag){
                             this.$message.error('教练头像不能为空');
                             return
                         }

                             if( 'jiaolian' ==this.flag && this.ruleForm.jiaolianEmail&&(!isEmail(this.ruleForm.jiaolianEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.qiuduiId)&& 'yonghu'==this.flag){
                             this.$message.error('球队不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('用户姓名不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('用户头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu'
|| this.flag=='jiaolian')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
