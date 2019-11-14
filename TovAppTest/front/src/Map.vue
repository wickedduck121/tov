<template>
  <div>
    <div>
      <h2>Search and add a pin</h2>
      <label>
        <gmap-autocomplete v-bind:types="tps"  style="width: 50%" v-bind:componentRestrictions="cr"
          @place_changed="setPlace">
        </gmap-autocomplete>
        <button @click="addMarker">Add marker</button>
        <button @click="getShop">Register shop</button>
      </label>
      <br/>

    </div>
  <GmapMap v-bind:center="jn"
    :zoom="7"
    map-type-id="terrain"
    style="width: 95%; height: 300px"
  >
    <gmap-info-window :options="infoOptions" :position="infoPosition" :opened="infoOpened" @closeclick="infoOpened=false">
      {{infoContent}}
    </gmap-info-window>
    <gmap-marker v-for="(item, key) in markers" :key="key" :position="item.position" :clickable="true" @click="toggleInfo(item, key)" />

  </GmapMap>
  </div>
</template>

<script>
    import {findUserName, addShop} from './api.js';
    import {gmapApi} from 'vue2-google-maps';
    //import geoCoder from 'https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyDrPipaoGhlL4m1IlkX6BQTDbgYIJKuJGE'

    export default {
        computed: {
            google: gmapApi},

        name: "Map",

        data() {
            return {
                user: 0,
                cr:{
                    country:'de'
                },
                bns:[
                    {lat: 50,lng: 30},
                    {lat:45, lng:25}
                ],
                tps:['establishment'],
                jn:{lat:10, lng:10},
                places: [],
                markers: [],
                infoPosition: null,
                infoContent: null,
                infoOpened: false,
                infoCurrentKey: null,
                infoOptions: {
                    pixelOffset: {
                        width: 0,
                        height: -35
                    },
                    currentPlace: null
                },


            }
        },
        mounted(){
           // this.geolocate();
         var name = this.$cookies.get('username');
        findUserName(name).then(result=>{this.user=result.data.id});
            console.log(this.$cookies.keys());

            console.log(this.user);
        },
        methods:{
            getShop(){
                if (this.currentPlace) {
                    var name = this.$cookies.get('username');
                    console.log("username: "+name);
                    findUserName(name).then(result=>{addShop(this.currentPlace.name, result.data.name)});

                }
            },
            setPlace(place) {
                this.currentPlace = place;
            },
            addMarker() {
                if (this.currentPlace) {
                    const marker = {
                        lat: this.currentPlace.geometry.location.lat(),
                        lng: this.currentPlace.geometry.location.lng()
                    };
                    this.markers.push({ position: marker, full_name: this.currentPlace.name });
                    this.places.push(this.currentPlace);
                    this.center = marker;
                    this.currentPlace = null;
                    this.jn=marker;
                }
            },
         /*   geolocate: function() {
                let geocoder = new geoCoder.GeoCoder();
                navigator.geolocation.getCurrentPosition(position => {
                    geocoder.geocode({'latLng':{latitude: position.coords.latitude, longitude: position.coords.longitude}},function(results, status) {
                        if (status === this.google.GeocoderStatus.OK) {
                            if (results[0]) {
                                this.cr = getCountry(results);
                            }
                        }
                    });
                    this.jn = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    };
                });
                function getCountry(results) {
                    for (var i = 0; i < results[0].address_components.length; i++)
                    {
                        var shortname = results[0].address_components[i].short_name;
                        var longname = results[0].address_components[i].long_name;
                        var type = results[0].address_components[i].types;
                        if (type.indexOf("country") !== -1)
                        {
                                return shortname;
                        }
                    }

                }


            },
            toggleInfo: function(marker, key) {
                this.infoPosition = marker.position;
                this.infoContent = marker.full_name;
                if (this.infoCurrentKey === key) {
                    this.infoOpened = !this.infoOpened
                } else {
                    this.infoOpened = true;
                    this.infoCurrentKey = key
                }
            }*/
        }
    }
</script>

<style scoped>

</style>
