<template>
  <div>
  <el-input id="one" placeholder="ID" v-model="input1" ref="ID"></el-input>
  <el-input id="two" placeholder="Name" v-model="input2" ref="name"></el-input>
    <el-input id="three" placeholder="Price" v-model="input3" ref="price"></el-input>

    <el-select
      v-model="value"
      multiple
      filterable
      remote
      reserve-keyword
      placeholder="Please enter a keyword"
      :remote-method="remoteMethod"
      :loading="loading">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>

    <el-button @click.native.prevent="Click(tableData, input1, input2, input3)" type="primary">Add</el-button>
    <el-table :data="tableData" style="width: 100%" ref="tab" highlight-current-row @current-change="changeRow" :default-sort="{prop: 'id', order: 'descending'}">
      <el-table-column prop="id" label="ID" width="180" sortable>
      </el-table-column>
      <el-table-column prop="name" label="Name" width="180">
      </el-table-column>
      <el-table-column prop="price" label="Price">
      </el-table-column>
      <el-table-column fixed="right" label="Operations" width="120">

        <template slot-scope="scope">
          <el-button @click="deleteClick(tableData, scope.$index, scope.row)" type="text" size="small">Delete</el-button>
          <el-button @click="editClick(tableData, scope.$index, scope.row, input2, input3)" type="text" size="small">Edit</el-button>
        </template>
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
    import { allProduct, addProduct, deleteProduct, updateProduct, getShopsByUsername, findUserName } from './api.js';
    export default {
        name: "ProductInfo",
        mounted() {


            this.list = this.states.map(item => {
                return {value: item, label: item};
            });
        },
        methods: {
            remoteMethod(query) {
                if (query !== '') {
                    this.loading = true;
                    setTimeout(() => {
                        this.loading = false;
                        this.options = this.list.filter(item => {
                            return item.label.toLowerCase()
                                .indexOf(query.toLowerCase()) > -1;
                        });
                    }, 200);
                } else {
                    this.options = [];
                }

        },

            //нажание основной кнопки
            Click(rows, id_local, name_local, price_local) {
                var element={id:id_local,name:name_local,price:price_local};
                addProduct(name_local,price_local).then(result=>{
                    rows.push(result.data);
                }).catch((response) => {
                    alert("Error " + response)
                })

            },
            //нажатие кнопки удаления
            deleteClick(rows, index, row){
               var ind=index+1;

                deleteProduct(row.id);
                alert(index);
                rows.splice(row.index,1);

            },
            //кнопка редактирования получает информацию из приведённых 3х полей на странице и закидывает в конец списка
            editClick(rows, index, row, name_local, price_local){
                var element={id:row.id,name:name_local,price:price_local};

                updateProduct(row.id, element).then(response => {console.log(response)});

                rows.splice(index,1);
                rows.push(element);
            },
            //метод выделения строки, также добавил получение информации из строки в 3 поля ввода,
            // консоль ругается на прямое присвоение
            changeRow(row){
                this.$refs.tab.setCurrentRow(row);
                //this.$refs.ID.value=row.id;
                //this.$refs.name.value=row.name;
                //this.$refs.price.value=row.price;
            }
        },
        created() {
                var username = this.$cookies.get('username');
                getShopsByUsername(username).then(result =>{
                    result.data.forEach(el=>{
                        // alert(el.name);
                        this.list.push({value: el.name, label: el.name});
                        });

                    });




                allProduct().then(response =>
                    response.data.forEach(dat => this.tableData.push(dat))
                )
        },
        data(){
            return {
                tableData: [],
                input1: '',
                input2: '',
                input3: '',
                options: [],
                value: [],
                list: [],
                loading: false,
                states: ['hi']
            }
        }
    }
</script>

<style scoped>

</style>
