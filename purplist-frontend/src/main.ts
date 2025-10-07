import './assets/main.css'
import 'vuetify/styles'
import 'unfonts.css'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import { createVuetify } from 'vuetify'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'

const vuetify = createVuetify({
  components,
  directives,
})

import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(vuetify)

app.mount('#app')
