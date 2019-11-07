import axios from 'axios'

export function allProduct() {
  return axios.get('/api/products')
}

export function addProduct(name, price) {
  return axios.post('/api/products', { name, price })
}

export function deleteProduct(id) {
  return axios.delete('/api/products', { headers: {id} })
}
