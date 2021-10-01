<template>
  <v-container>
    <v-btn @click="kakaoLogin">
      <a href="javascript:void(0)"></a>
      카카오로그인
    </v-btn>
  </v-container>
</template>

<script>

export default {
  data () {
    return {

    }
  },
  created () {
    window.Kakao.init('')
    alert('kakao init: ' + window.Kakao.isInitialized())
  },
  methods: {
    kakaoLogin () {
      window.Kakao.Auth.login({
        success: (res) => {
          window.Kakao.API.request({
            url: '/v2/user/me',
            success: (res) => {
              console.log(res)
            },
            fail: (err) => {
              console.log(err)
            }
          })
          console.log(res)
        },
        fail: (err) => {
          console.log(err)
        }
      })
    }
  }
}
</script>