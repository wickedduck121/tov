<template>
  <div>
  <el-input id="one" placeholder="ID" v-model="input1" ref="ID"></el-input>
  <el-input id="two" placeholder="Name" v-model="input2" ref="name"></el-input>
    <el-input id="three" placeholder="Price" v-model="input3" ref="price"></el-input>
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
    import { allProduct, addProduct, deleteProduct, updateProduct } from './api.js';
    export default {
        name: "ProductInfo",
        methods:{
            //нажание основной кнопки
            Click(rows, id_local, name_local, price_local) {
                var element={id:id_local,name:name_local,price:price_local};
                addProduct(name_local,price_local);
                rows.push(element);
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
        created:
            function () {
                allProduct().then(response =>
                    response.data.forEach(dat => this.tableData.push(dat))
                )
            }
        ,
        data() {
            return {
                tableData: [],
                input1: '',
                input2: '',
                input3: ''
            }
        }
    }
</script>

<style scoped>

</style>
