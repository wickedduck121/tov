import Vue from 'node_module/vue/package.json'
var elementAPI = Vue.resource('/message{/id}');

Vue.component('element-row', {
    props: ['element'],
    template: '<div><i>({{element.id}})</i>({{element.name}})</div>'
});

Vue.component('element-list',{
    props:['elements'],
    template: '<div>'+
        '<element-row v-for="element in elements" :key="element.id" :element="element"/>' +
            '</div>',
    created: function(){
        elementAPI.get().then(result =>
            result.json().then(data =>
                data.forEach(element => this.elements.push()
        )
        )
        )
        }
});


var App = new Vue({
    el:'#app',
    template:'<element-list: elements = "elements"/>',
    data: {
        elements: []
    }
});