import Vue from 'vue';
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUi from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';


Vue.use(ElementUi);
//Vue.prototype.$http = Axios;

new Vue({
  el:'#app',
  render: h=>h(App)
});
