<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <!--    Logo-->
    

    <!--    Burger Button-->
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!--      Search Bar-->
      <form class="form-inline ml-auto mr-auto">
        <div class="input-group">
         <div class="form-group">
          <input
            size="100"
            type="text"
            class="form-control"
            placeholder="Search Items"
            aria-label="Username"
            v-model="keyword"
            aria-describedby="basic-addon1"
          />
          </div>
       <button type="button" class="btn btn-primary" @click="searchProduct">Search</button>
       
        </div>
      </form>

      <!--      DropDowns-->
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a
            class="nav-link text-light dropdown-toggle"
            href="#"
            id="navbarDropdown"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Browse
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <router-link class="dropdown-item" :to="{ name: 'HomeView' }"
              >Home</router-link
            >
            <router-link class="dropdown-item" :to="{ name: 'AdminProduct' }"
              >Product</router-link
            >
            <router-link class="dropdown-item" :to="{ name: 'ListCategory' }"
              >Category</router-link
            >
          </div>
        </li>

        <li class="nav-item dropdown">
          <a
            class="nav-link text-light dropdown-toggle"
            href="#"
            id="navbarDropdown"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Accounts
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        
           
            <router-link class="dropdown-item" :to="{ name: 'AdminView' }"
              >Admin</router-link
            >
            <router-link
              class="dropdown-item"
              v-if="!token"
              :to="{ name: 'SignIn' }"
              >Log In</router-link
            >
            <router-link
              class="dropdown-item"
              v-if="!token"
              :to="{ name: 'SignUp' }"
              >Sign Up</router-link
            >
            <a class="dropdown-item" v-if="token" href="#" @click="signout"
              >Sign Out</a
            >
          </div>
        </li>

        <li class="nav-item">
         
        </li>
        <li class="nav-item">
          <div id="cart">
            <span id="nav-cart-count">{{ cartCount }}</span>
            
          </div>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import swal from 'sweetalert2';
export default {
  name: "NavbarView",
  props: ["cartCount"],
  data() {
    return {
      token: null,
      keyword : null,
    };
  },
  methods: {
    signout() {
      localStorage.removeItem("token");
      this.token = null;
      this.$emit("resetCartCount");
      this.$router.push({ name: "HomeView" });
      new swal({
        text: "Logged you out. Visit Again",
        icon: "success",
        closeOnClickOutside: false,
      });
    },

    searchProduct(){
      console.log("test====")
       //this.$router.push({ path: "search" , params: { keyword: this.keyword } });
       //this.router.push({ path: '/search', query: { keyword: JSON.stringify(this.keyword) }})
       this.$router.push({
        name: "SearchView",
        params: { keyword: this.keyword }
      });
       
    },
    
  },
  created() {
    this.token = localStorage.getItem("token");
  },
};
</script>

<style scoped>
#logo {
  width: 150px;
  margin-left: 20px;
  margin-right: 20px;
}

.nav-link {
  color: rgba(255, 255, 255);
}

#search-button-navbar {
  background-color: #febd69;
  border-color: #febd69;
  border-top-right-radius: 2px;
  border-bottom-right-radius: 2px;
}
#nav-cart-count {
  background-color: red;
  color: white;
  border-radius: 50%;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 15px;
  height: 15px;
  font-size: 15px;
  margin-left: 10px;
}
#cart {
  position: relative;
}
</style>
