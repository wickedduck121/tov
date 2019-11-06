import Vue from 'vue';
import ElementUi from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
Vue.use(ElementUi);

new Vue({
  el:'#app',
  render: h=>h(App)
});
