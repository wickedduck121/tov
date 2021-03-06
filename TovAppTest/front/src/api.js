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
  //alert (JSON.stringify(element));
  return axios.put(url+id_local,{id: id_local, name: element.name, price: element.price});
}

export function addUser(name,pass,email,gender) {
return axios.post('/api/user',{name,pass,email,gender})
}

export function allUsers() {
 return axios.get('/api/user');
}

export function findUserName(name) {
  return axios.get('/api/user/name/'+name)
}

export function findUserEmail(email) {
  return axios.get('/api/user/email/'+email)
}

export function  login(name_loc,pass_loc) {
  axios.post('/api/login',{},{params:{username:name_loc,password:pass_loc}});

}

export function addShop(name_loc,lat_loc,lng_loc,name_user){
  console.log("loc name: "+name_loc+" username: "+name_user);
  axios.post('/api/shops/'+name_user,{name:name_loc, lat:lat_loc, lng:lng_loc});
}

export function getShopsByUsername(username) {
  return axios.get('/api/shops/usershops/'+username);
}
