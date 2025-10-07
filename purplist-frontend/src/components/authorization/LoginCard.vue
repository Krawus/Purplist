<template>
  <v-card class="login-card">
    <v-card-title class="text-h5">Login</v-card-title>
    <v-card-text>
      <v-form>
        <v-text-field label="Username" required v-model="username" />
        <v-text-field label="Password" type="password" required v-model="password" />
      </v-form>
    </v-card-text>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn color="secondary" @click="handleLogin">Login</v-btn>
    </v-card-actions>
  </v-card>
</template>
<script setup lang="ts">
import { ref } from 'vue'

const username = ref<string>('')
const password = ref<string>('')

function handleLogin() {
  console.log('Logging in with', username.value, password.value)
  // Add actual login logic here
}
</script>

<style scoped>
.login-card {
  height: 60svh;
  width: 80svw;
  background-color: lightgray;
}
</style>
