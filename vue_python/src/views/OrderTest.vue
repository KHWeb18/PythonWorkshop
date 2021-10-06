<template>
  <v-container>
    <table border="1">
      <tr v-for="(board, idx) in boards" v-bind:key="idx">
        <td align="center">
          <img :src="require(`@/assets/img/${board.img}`)" width="400">
        </td>
      </tr>
    </table>
    <form @submit.prevent="onSubmit">
      <h3>구매 양식</h3>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name"></td>
        </tr>
        <tr>
          <td>가격</td>
          <td><input type="number" v-model="cost"></td>
        </tr>
      </table>
      <div>
        <button type="submit">구매</button>
        <router-link :to="{ name: 'Home'}">
          취소
        </router-link>
      </div>
    </form>
  </v-container>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      info: 'Spyder.jpg',
      boards: [
        {img: 'Beagle.jpg'},
        {img: 'Chihuahua.jpg'},
      ],
      name: null,
      cost: 200000
    }
  },
  methods: {
    onSubmit () {
      const { name, cost } = this

      axios.post('http://localhost:7777/order', { name, cost }).then(() => {
        alert('주문 성공')
      }).catch(res => {
        alert(res.response.data.message)
      })
    },
  }
}
</script>