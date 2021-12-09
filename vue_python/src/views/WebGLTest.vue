<template>
  <div id="app"></div>
</template>


<script>
import * as THREE from 'three'

export default {
  data() {
    return {
      renderer: null,
      camera: null,
      scene: null,
      cube: null,
      step: 0
    }
  },
  methods: {
    init () {
      // 그림 그릴 화면 생성
      this.scene = new THREE.Scene()
      // View Frustum: 시야각을 관장하는 객체(잘린 사각뿔), 절두체
      // PerspectiveCamera: 컴퓨터의 눈
      // 75: 시야각, width/height: 종횡비(aspect ratio), 화면의 사이즈에 따라 실제 비율 조절
      // 0.1: near plane, 1000: far plane
      this.camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
      // 그래픽 카드(그림을 그리는 화가)
      this.renderer = new THREE.WebGLRenderer()

      // 배경색 변경
      this.renderer.setClearColor(new THREE.Color(0xEEEEEE))
      // 배경 사이즈 변경
      this.renderer.setSize(window.innerWidth, window.innerHeight)

      // 캔버스 생성
      const canvas = document.getElementsByClassName('container')[0].lastElementChild
      canvas.appendChild(this.renderer.domElement)

      // 물체의 형태, 1cm, 1cm, 1cm의 정육면체
      const geometry = new THREE.BoxGeometry(1, 1, 1)
      // 물체의 재질, 색상
      const meterial = new THREE.MeshBasicMaterial({color: 0xff0000})

      // 물체의 형태와 재질 정보를 가지고 생성
      this.cube = new THREE.Mesh(geometry, meterial)
      this.scene.add(this.cube)

      // 상: +y, 하: -y, 좌: +x, 우: -x, 전진: -z, 후진: z
      this.camera.position.z = 10
      this.camera.position.y = 5
      this.camera.position.x = 5

      this.cube.position.y = 5

      console.log('cos(x) = ', Math.cos(90))
      console.log('cos(90 degree) = cos(pi / 2) = ', Math.cos(Math.PI / 2))
      console.log('cos(90 degree) = cos(pi / 2) = ', Math.cos(Math.PI / 2).toFixed(10))
      console.log('cos(30 degree) = cos(pi / 6) = ', Math.cos(Math.PI / 6))
      console.log('sqrt(3) / 2 = ', Math.sqrt(3) / 2.0)
    },
    animate () {
      requestAnimationFrame(this.animate)
      // sin웨이브의 궤적 만들기
      // y = sin(x), x = wt
      // T = 1/f, f = 1, w = 2 * pi * f = 2 * pi
      this.step += 0.01
      this.cube.position.x = this.step
      this.cube.position.y = this.cube.position.y = Math.sin(2 * Math.PI * this.step)

      this.cube.rotation.y += 0.1

      this.renderer.render(this.scene, this.camera)
    }
  },
  mounted () {
    this.init()
    this.animate()
  },
  beforeDestroy () {
    document.getElementsByClassName('container')[0].lastElementChild.removeChild(this.renderer.domElement)
  }
}
</script>