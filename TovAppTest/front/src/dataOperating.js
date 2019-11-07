//var productApi = Vue.resource();

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
    //метод выделения строки, также добавил получение информации из строки в 3 поля ввода,
    // консоль ругается на прямое присвоение
    changeRow(row){
      this.$refs.tab.setCurrentRow(row);
     this.$refs.ID.value=row.id;
      this.$refs.name.value=row.name;
      this.$refs.price.value=row.price;
    }
  },
  created:
  function () {
    var instance = this;
    instance.$http.get('localhost:8080/message{/id}').then(result =>
      result.json().then(data =>
        data.forEach(dat => this.tableData.push(dat))
    //this.$http.get('/localhost:8080/message{/id}')
      )
    )
  }
  ,
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




