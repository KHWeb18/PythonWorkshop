<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw"></td>
        </tr>
      </table>
      <div>
        <button type="submit">로그인</button>
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
      id: null,
      pw: null
    }
  },
  methods: {
    onSubmit () {
      const id = this.id
      const pw = this.pw

      axios.post('http://localhost:5000/login', { id, pw }).then(res => {
        alert('성공!' + JSON.stringify(res.data))
      }).catch(res => {
        alert(res.response.data.message)
      })
    },
  }
}
</script>