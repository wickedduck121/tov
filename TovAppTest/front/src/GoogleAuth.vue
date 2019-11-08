<template>
  <div>
    <div>{{nm}}</div>
<el-button type="primary" @click="login">login by google</el-button>
    <el-button type="primary" @click="logout">log-out</el-button>

  </div>
</template>

<script>
  var user;
    import Vue from 'vue';
    export default {
        name: "GoogleAuth",
        data(){
            return{
                nm: ''
            }
        },
        mounted(){
            this.nm = 'Please login';
        },
        methods:
            {
                login(){
                    var k=this;

                    Vue.googleAuth().directAccess();

                    Vue.googleAuth().signIn(function (googleUser) {
                        var user = JSON.parse(JSON.stringify(googleUser.w3));
                        //var currentUser= JSON.stringify(user.w3);
                        console.log(user);
                        k.user = user;
                        k.nm="Hello,My name is "+user.ig;
                    }, function (error) {
                        console.log(error);
                    });

                },
                logout(){
                    var k1= this;
                    Vue.googleAuth().signOut(function () {
                        k1.nm = "Good bye "+ k1.user.ig;
                    }, function (error) {
                        alert("something gone wrong");
                        console.log(error);
                    })
                }
            }
    }
</script>

<style scoped>

</style>
