<template>
  <h2 @click="clickHandle">{{products}}</h2>
</template>

<script>

  import { allProduct, addProduct } from './api.js';

  export default {
      name: "TestModule",
      data() {
          return {
              products: '',
          }
      },
      props: {
          text: {
              type: String
          }
      },
      mounted() {
          allProduct().then(response => {
              this.products = response.data
          })
      },
      methods: {
          clickHandle() {
              addProduct('Булка', 10).then(r => {
                  console.log(r)
              });
          }
      }
  }
</script>
