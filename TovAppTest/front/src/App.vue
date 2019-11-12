<template>
  <div id="app">
    <transition name="el-fade-in-linear">
    <div v-show="show1">
    <product-info />
    <google-auth name="mag_auth" />
    </div>
    </transition>
    <register />
    <Login />
  </div>

</template>

<script>
import TestModule from "./test-module";
import ProductInfo from "./ProductInfo";
import GoogleAuth from "./GoogleAuth";
import Register from "./Register/Register";
import Login from "./Login"
import Reg from './Registration.vue';
import Vue from 'vue';
export default {
  name: 'app',
    components: {Register, GoogleAuth, ProductInfo, TestModule, Login},
    data () {
    return {
      msg: 'Welcome to Your Vue.js App',
        show1: true
    }
  },
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
