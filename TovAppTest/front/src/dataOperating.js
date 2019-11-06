var Main = {
  methods:{
    //нажание основной кнопки
    Click(rows, id_local, name_local, price_local) {
      var element={id:id_local,name:name_local,price:price_local};
      rows.push(element);
    },
    //нажатие кнопки удаления
    deleteClick(rows, index){
      rows.splice(index,1);
    },
    //кнопка редактирования получает информацию из приведённых 3х полей на странице и закидывает в конец списка
    editClick(rows, index, id_local, name_local, price_local){
      var element={id:id_local,name:name_local,price:price_local};
      rows.splice(index,1);
      rows.push(element);
    },
    //метод выделения строки, также хотел добавить получение информации из строки в 3 поля ввода, но не получилось
    //нашел только, как записать сообщение по ссылке
    changeRow(row){
      this.$refs.tab.setCurrentRow(row);
      //this.$refs.ID.value=this.$refs.tab.$data.id;
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
