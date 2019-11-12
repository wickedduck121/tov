<template>
  <div>
<div id="block" v-show="show1">
  <el-input v-model="inp1" class="inp" id="text1" placeholder="Nickname" ></el-input>
  <el-input v-model="inp2" class="inp" id="text2" placeholder="Password" type="password" ></el-input>
  <el-input v-model="inp3" class="inp" id="text3" placeholder="email" ></el-input>
  <el-radio v-model="radio1" label="1">Male</el-radio>
  <el-radio v-model="radio1" label="2">Female</el-radio>
  <el-button type="primary" @click="adduser(inp1,inp2,inp3,radio1)"></el-button>
</div>

  </div>

</template>

<script>
    import { addUser, findUserName, findUserEmail} from '../api.js';
    import {findUser} from "../api";
    export default {
        name: "Register",
        data () {
            return {
                show1: false,
                radio1: '1',
                inp1:'',
                inp2:'',
                inp3:''
            };
        },
        methods:{

            adduser(name_local,pass_local,email_local,gender_local){
                var flag=0;
               var el=this;
               findUserName(name_local).then(response =>{
                   if (response.data===''){
                       findUserEmail(email_local).then(response1 =>{
                           if (response1.data===''){
                               var gender;
                               if (gender_local==='1') gender='male';
                               else gender='female';
                               addUser(name_local,pass_local,email_local,gender);
                           }
                           else{
                               alert('Email is already registered');
                           }
                       })
                   }
                   else{
                       alert('Nickname is already registered');
                   }

                   }

               );
           /*allUsers().then(response=>{response.data.forEach(
                dat=>{

                    if (dat.name===name_local){ el.flag=1;}
                }
            )});
           console.log(flag);*/

            }
        }
    }
</script>

<style scoped>
  .inp{

    padding-top: 10px;
  }
#block{
  border-radius: 10px;
  position: fixed;
  left:30%;
  top:20px;
  width: 40%;
  height: 90%;
  background: aliceblue;
}
</style>
