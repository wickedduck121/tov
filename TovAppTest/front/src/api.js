import axios from 'axios'

export function allProduct() {
  return axios.get('/api/products')
}

export function addProduct(name, price) {
  return axios.post('/api/products', { name, price })
}

export function deleteProduct(id_local) {
  var url = '/api/products/';
  return axios.delete(url+id_local);
}

export function updateProduct(id_local, element) {
  var url = '/api/products/';
  var el = JSON.stringify(element);
  alert (JSON.stringify(element));
  return axios.put(url+id_local,{id: id_local, name: element.name, price: element.price});
}
