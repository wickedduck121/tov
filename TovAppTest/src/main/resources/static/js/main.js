/*function getIndex(list, id) {
    for (var i=0;i<list.length;i++){
        if (list[i].id === id){
            return i;
        }
    }
    return -1;

}

var elementAPI = Vue.resource('/message{/id}');


//создаю компоненит форм, который не выводится
Vue.component('element-form', {
    props: ['elements'],
    data: function(){
        return{text:''}
    },
    template:
    '<div>'+
        '<input type="text" placeholder="Enter name" v-model="text"/>'+
        '<input type="text" placeholder="Enter price" v-model="price"/>'+
        '<input type="button" value="Save" @click="save"/>'+
        '</div>',
    method:{
        click:function () {
            var element = {name: this.name, price: this.price};

            elementAPI.save({},element.name,element.price).then(result=>
            result.json().then(data=>{
                this.elements.push(data);
            }))
        }
    }

});
//не выводится
Vue.component('element-row', {
    props: ['element'],
    template: '<div><i>({{element.id}})</i>({{element.name}})</div>'
});
//вот тут должен выводиться элемент форм, но в итоге пустота, да и элемент row не выводится
Vue.component('element-list',{
    props:['elements'],
    template: '<div>'+
        '<element-form :elements="elements"/>'+
        '<element-row v-for="element in elements" :key="element.id" :element="element"/>' +
        '</div>',
    created: function(){
        elementAPI.get().then(result =>
        result.json().then(data =>
        data.forEach(element => this.elements.push(element)
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
});*/
function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var messageApi = Vue.resource('/message{/id}');

Vue.component('message-form', {
    props: ['messages'],
    data: function() {
        return {
           name : '',
            id: ''
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="name" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var message = { name: this.name, price: 1.1 };
                messageApi.save({}, message).then(result =>
                    result.json().then(data => {
                        this.messages.push(data);
                        this.name = ''
                    })
                )

        }
    }
});

//строка сообщений состоит из полей id, name и двух кнопок удаления и редактирования
Vue.component('message-row', {
    props: ['message', 'messages'],
    template: '<div>' +
        '<i>({{ message.id }})</i> {{ message.name }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        del: function() {
            messageApi.remove({id: this.message.id}).then(result => {
                if (result.ok) {
                    this.messages.splice(this.messages.indexOf(this.message), 1)
                }
            })
        }
    }
});

//список сообщений состоит из формы и набора строк сообщений
Vue.component('messages-list', {
    props: ['messages'],
    data: function() {
        return {
            message: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<message-form :messages="messages"/>' +
        '<message-row v-for="message in messages" :key="message.id" :message="message" ' +
        ':messages="messages" />' +
        '</div>',
    created: function() {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    }
});
//меняем текст на список сообщений
var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});