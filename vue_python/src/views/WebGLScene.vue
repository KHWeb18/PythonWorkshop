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
      this.scene = new THREE.Scene()
      this.camera = new THREE.PerspectiveCamera(45, window.innerWidth / window.innerHeight, 0.1, 1000)
      this.renderer = new THREE.WebGLRenderer()

      this.renderer.setClearColor(new THREE.Color(0xEEEEEE))
      this.renderer.setSize(window.innerWidth, window.innerHeight)

      // 평면 바닥 생성
      var planeGeometry = new THREE.PlaneGeometry(60, 20)
      var planeMaterial = new THREE.MeshBasicMaterial({ color: 0x005533 })
      var plane = new THREE.Mesh(planeGeometry, planeMaterial)

      plane.rotation.x = -0.5 * Math.PI
      plane.position.x = 15
      plane.position.y = 0
      plane.position.z = 0
      
      this.scene.add(plane)

      // 구 생성
      var sphereGeometry = new THREE.SphereGeometry(4, 20, 20)
      var sphereMaterial = new THREE.MeshBasicMaterial({ color: 0x7777ff, wireframe: true })
      var sphere = new THREE.Mesh(sphereGeometry, sphereMaterial)

      sphere.position.x = -10
      sphere.position.y = 4
      sphere.position.z = 2
      
      this.scene.add(sphere)

      // 캔버스 생성
      const canvas = document.getElementsByClassName('container')[0].lastElementChild
      canvas.appendChild(this.renderer.domElement)

      const geometry = new THREE.BoxGeometry(3, 3, 3)
      const meterial = new THREE.MeshBasicMaterial({color: 0xff0000})

      this.cube = new THREE.Mesh(geometry, meterial)
      this.scene.add(this.cube)

      this.camera.position.z = 30
      this.camera.position.y = 40
      this.camera.position.x = -30
      this.camera.lookAt(this.scene.position)

      this.cube.position.y = 5

    },
    animate () {
      requestAnimationFrame(this.animate)
      this.step += 0.02
      this.cube.position.x = 10 * this.step
      this.cube.position.y = 5 + 5 * Math.sin(2 * Math.PI * this.step)

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