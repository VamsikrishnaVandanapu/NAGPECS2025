import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import 'bootstrap/dist/css/bootstrap.css'



// import swal from 'sweetalert';
import swal from 'sweetalert2';
window.Swal = swal;

//using axios as a global object
window.axios = require('axios')
createApp(App).use(router).mount('#app')
