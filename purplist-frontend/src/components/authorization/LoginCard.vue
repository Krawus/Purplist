<template>
  <v-card class="login-card">
    <v-card-title class="text-h5">Login</v-card-title>
    <v-card-text>
      <v-form>
        <v-text-field label="Username" required></v-text-field>
        <v-text-field label="Password" type="password" required></v-text-field>
      </v-form>
    </v-card-text>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn color="secondary">Login</v-btn>
    </v-card-actions>
  </v-card>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'

onMounted(() => {
  console.log('LoginCard mounted')
})
</script>

<style scoped>
.login-card {
  height: 60svh;
  width: 80svw;
  background-color: lightgray;
}
</style>
