<template>
  <GmapMap
    :center="{lat:10, lng:10}"
    :zoom="7"
    map-type-id="terrain"
    style="width: 95%; height: 300px"
  >
    <gmap-info-window :options="infoOptions" :position="infoPosition" :opened="infoOpened" @closeclick="infoOpened=false">
      {{infoContent}}
    </gmap-info-window>
    <gmap-marker v-for="(item, key) in coordinates" :key="key" :position="getPosition(item)" :clickable="true" @click="toggleInfo(item, key)" />

  </GmapMap>
</template>

<script>
    export default {
        data() {
            return {
                coordinates: {
                    0: {
                        full_name: 'Erich  Kunze',
                        lat: '10.31',
                        lng: '123.89'
                    },
                    1: {
                        full_name: 'Delmer Olson',
                        lat: '10.32',
                        lng: '123.89'
                    }
                },
                infoPosition: null,
                infoContent: null,
                infoOpened: false,
                infoCurrentKey: null,
                infoOptions: {
                    pixelOffset: {
                        width: 0,
                        height: -35
                    }
                },


            }
        },
        methods:{
            getPosition: function(marker) {
                return {
                    lat: parseFloat(marker.lat),
                    lng: parseFloat(marker.lng)
                }
            },
            toggleInfo: function(marker, key) {
                this.infoPosition = this.getPosition(marker)
                this.infoContent = marker.full_name
                if (this.infoCurrentKey == key) {
                    this.infoOpened = !this.infoOpened
                } else {
                    this.infoOpened = true
                    this.infoCurrentKey = key
                }
            }
        }
    }
</script>

<style scoped>

</style>
