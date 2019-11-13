<template>
  <div id="places">
    <input ref="autocomplete"
           placeholder="Search"
           class="search-location"
           onfocus="value = ''"
           type="text" />
  </div>
</template>

<script>
    import * as VueGoogleMaps from 'vue2-google-maps'
    export default {
        name: "googlePlaces",
        mounted() {
            VueGoogleMaps.PlaceInput()
            var autocomplete = VueGoogleMaps.Autocomplete.constructor((this.$refs.autocomplete),
                {types: ['geocode']});
          //  VueGoogleMaps.Autocomplete(()
    }
    }
</script>

<style scoped>
  *, *::after, *::before {
    margin: 0;
    padding: 0;
    box-sizing: inherit;
  }

  body {
    background-color: #dcdde1;
    color: #2f3640;
    padding: 3rem;
  }

  .search-location {
    display: block;
    width: 60vw;
    margin: 0 auto;
    margin-top: 5vw;
    font-size: 20px;
    font-weight: 400;
    outline: none;
    height: 30px;
    line-height: 30px;
    text-align: center;
    border-radius: 10px;
  }
</style>
