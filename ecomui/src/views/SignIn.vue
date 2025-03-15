<template>
  <div class="container">
    <!--    Logo Div-->
    <div class="row">
      <div class="col-12 text-center pt-3">
       
      </div>
    </div>

    <div class="row">
      <div class="col-12 justify-content-center d-flex flex-row pt-5">
        <div id="signin-div" class="flex-item border">
          <h2 class="pt-4 pl-4">Sign-In</h2>
          <form @submit="signin" class="pt-4 pl-4 pr-4">
            <div class="form-group">
              <label>Email</label>
              <input
                type="email"
                class="form-control"
                v-model="email"
                required
              />
            </div>
            <div class="form-group">
              <label>Password</label>
              <input
                type="password"
                class="form-control"
                v-model="password"
                required
              />
            </div>
            <small class="form-text text-muted"
              >By continuing, you agree to mcart's Conditions of Use and
              Privacy Notice.</small
            >
            <button type="submit" class="btn btn-primary mt-2 py-0">
              Continue
              <div
                v-if="loading"
                class="spinner-border spinner-border-sm"
                role="status"
              >
                <span class="sr-only">Loading...</span>
              </div>
            </button>
          </form>
          <hr />
          <small class="form-text text-muted pt-2 pl-4 text-center"
            >New to amcart?</small
          >
          <p class="text-center">
            <router-link
              :to="{ name: 'SignUp' }"
              class="btn btn-dark text-center mx-auto px-5 py-1 mb-2"
              >Create Your amcart Account</router-link
            >
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import swal from 'sweetalert2'
export default {
  name: "SignIn",
  props: ["baseURL"],
  data() {
    return {
      email: null,
      password: null,
      loading: null,
    };
  },
  methods: {
    async signin(e) {
      e.preventDefault();
      this.loading = true;

      const user = {
        email: this.email,
        password: this.password,
      };

      await axios
        .post(`${this.baseURL}user/signIn`, user)
        .then((res) => {
          localStorage.setItem("token", res.data.token);
          this.$emit("fetchData");
          this.$router.push({ name: "HomeView" });
        })
        .catch((err) => {
          new swal({
            text: "Unable to Log you in!",
            icon: "error",
            closeOnClickOutside: false,
          });
          console.log(err);
        })
        .finally(() => {
          this.loading = false;
        });
    },
  },
  created() {
    this.loading = false;
  },
};
</script>

<style scoped>
.btn-dark {
  background-color: #e7e9ec;
  color: #000;
  font-size: smaller;
  border-radius: 0;
  border-color: #adb1b8 #a2a6ac #a2a6ac;
}

.btn-primary {
  background-color: #f0c14b;
  color: black;
  border-color: #a88734 #9c7e31 #846a29;
  border-radius: 0;
}

#logo {
  width: 150px;
}

@media only screen and (min-width: 992px) {
  #signin-div {
    width: 40%;
  }
}
</style>
