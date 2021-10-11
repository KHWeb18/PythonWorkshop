<template>
  <div>
    <router-link :to="{ name: 'LoginTest' }" 
      class="nav-link" 
      active-class="active">LoginTest
    </router-link>
    <router-link :to="{ name: 'KakaoLogin' }" 
      class="nav-link" 
      active-class="active">KakaoLogin
    </router-link>
    <router-link :to="{ name: 'OrderTest' }" 
      class="nav-link" 
      active-class="active">OrderTest
    </router-link>
    <router-link :to="{ name: 'PythonCrawl' }" 
      class="nav-link" 
      active-class="active">PythonCrawl
    </router-link>
  </div>  
</template>

<script>
 
  export default {
    name: 'Home',

    components: {

    },
  }
</script>
