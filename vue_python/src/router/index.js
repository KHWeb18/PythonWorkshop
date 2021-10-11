import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import LoginTest from '@/views/LoginTest'
import KakaoLogin from '@/views/KakaoLogin'
import OrderTest from '@/views/OrderTest'
import PythonCrawl from '@/views/PythonCrawl'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'LoginTest',
    component: LoginTest
  },
  {
    path: '/kakaoLogin',
    name: 'KakaoLogin',
    component: KakaoLogin
  },
  {
    path: '/orderTest',
    name: 'OrderTest',
    component: OrderTest
  },
  {
    path: '/pythonCrawl',
    name: 'PythonCrawl',
    component: PythonCrawl
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
