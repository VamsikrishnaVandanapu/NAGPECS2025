<template>
<NavbarView/>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view v-if="categories && products"
      
      :baseURL="baseURL"
      :products="products"
      :categories="categories"
      @fetchData="fetchData"
    >
    </router-view>
    <FooterView/>
</template>
<script>
 import axios from 'axios'
 import NavbarView from './components/NavbarView.vue';
 import FooterView from './components/FooterView.vue'
export default {
  data() {
    return {
      //baseURL: 'https://limitless-lake-55070.herokuapp.com/',
      baseURL: "http://localhost:8080/",
      products: null,
      categories: null,
      key: 0,
      token: null,
      cartCount: 0,
    };
  },

  components: {  FooterView,NavbarView },
 
   methods: {
    async fetchData() {
      // fetch products
      await axios
        .get(this.baseURL + 'product/')
        .then((res) => (this.products = res.data))
        .catch((err) => console.log(err));

      //fetch categories
      await axios
        .get(this.baseURL + 'category/')
        .then((res) => (this.categories = res.data))
        .catch((err) => console.log(err));

      //fetch cart items
      if (this.token) {
        await axios.get(`${this.baseURL}cart/?token=${this.token}`).then(
          (response) => {
            if (response.status == 200) {
              // update cart
              this.cartCount = Object.keys(response.data.cartItems).length;
            }
          },
          (error) => {
            console.log(error);
          }
        );
      }
    },
    resetCartCount() {
      this.cartCount = 0;
    },
  },
  created() {
    this.token = localStorage.getItem('token');
    this.fetchData();
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
