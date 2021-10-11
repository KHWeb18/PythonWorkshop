<template>
  <v-container>
    <v-text-field label="검색" v-model="search" @keypress.enter="getPyCrawl"></v-text-field>

    <table v-if="pyList" border="1">
      <tr>
        <th>제목</th>
      </tr>
      <tr v-for="list in pyList" :key="list">
        <td>{{ list }}</td>
      </tr>
    </table>
  </v-container>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      search: null,
      pyList: null
    }
  },
  methods: {
    getPyCrawl () {
      const search = this.search
      console.log(search)
      axios.post('http://localhost:5000/pythonCrawl', { search }).then(res => {
        alert(search + ' 검색 완료')

        this.pyList = res.data
      })
    }
  }
}
</script>