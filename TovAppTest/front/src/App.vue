<template>
  <div id="app">
    <product-info />
    <google-auth name="mag_auth" />
  </div>
</template>

<script>
import TestModule from "./test-module";
import ProductInfo from "./ProductInfo";
import GoogleAuth from "./GoogleAuth";

export default {
  name: 'app',
    components: {GoogleAuth, ProductInfo, TestModule},
    data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
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
