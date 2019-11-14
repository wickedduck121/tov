<template>
  <div id="block">
  <el-input v-model="nick" class="inp" id="text1" placeholder="Nickname" ></el-input>
  <el-input v-model="pass" class="inp" id="text2" placeholder="Password" type="password" ></el-input>
  <el-button type="primary" @click="sendlogin(nick,pass)"></el-button>
  </div>
</template>

<style scoped lang="scss">

</style>

<script>
  import {login} from "./api";

  export default {
        name: "Register",
        data () {
            return {
                radio1: '1',
                nick:'',
                pass:''
            };
        },
        methods:{
            sendlogin(nick_local,pass_local){
            login(nick_local,pass_local);
            this.$cookies.set('username', nick_local);
            }
        }
    }
</script>
