import Vue from 'vue';
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUi from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import GoogleAuth from 'vue-google-oauth'
import * as VueGoogleMaps from 'vue2-google-maps'


Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyDrPipaoGhlL4m1IlkX6BQTDbgYIJKuJGE',
    libraries: 'places,drawing,geocoder'
  },
});

Vue.use(ElementUi);
Vue.use(GoogleAuth, { client_id: '119838100754-v0klbsjrnas8efa4gqkjds4soa1t5t41.apps.googleusercontent.com' });
Vue.googleAuth().load();

new Vue({
  el:'#app',
  render: h=>h(App)
});
