var Main1 = {
  data () {
    return {
      radio: '1'
    };
  }
};
var Ctor1 = Vue.extend(Main1);
new Ctor1().$mount('#app');



var Main = {
  methods:{
    Click(rows, id_local, name_local, price_local) {
      var element={id:id_local,name:name_local,price:price_local}
      rows.push(element);
    }
  },
  data() {
    return {
      tableData: [{
        id: '1',
        name: 'Product1',
        price: '1.10'
      }, {
        id: '2',
        name: 'Product2',
        price: '9.10'
      }, {
        id: '3',
        name: 'Product3',
        price: '10.70'
      }, {
        id: '4',
        name: 'Product4',
        price: '20.00'
      }],
      input1: '',
      input2: '',
      input3: ''
    }
  }
};
var Ctor3 = Vue.extend(Main);
new Ctor3().$mount('#table');
