<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Our Categories</h4>
        <router-link id="add-category" :to="{name : 'AddCategory'}" v-show="$route.name=='ListCategory'">
          <button class="btn">Add Category</button>
        </router-link>
      </div>
         </div>
    <div class="row">
      <!-- <div>{{categories}}</div> -->
      <div v-for="category of categories" :key="category.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
        <CategoryBox :category="category">
        </CategoryBox>
      </div>
    </div>
  </div>
</template>

<script>
import CategoryBox from '../../components/Category/CategoryBox';
// import axios from 'axios'
export default {
  components:{CategoryBox},
 data() {
  return{
    // url: this.baseURL+"category/",
    // categories:[]
  };
 },
 props : ["baseURL", "categories"],
 methods:{
    async getCategories()
    {
      // await axios.get(this.url).
      // then(res => this.categories = res.data).catch(err => console.log(err))
    }
 },

  created(){
    
     if (this.$route.name=='ListCategory' && !localStorage.getItem('token')) {
       this.$router.push({name : 'Signin'});
     }
  }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}

#add-category {
  float: right;
  font-weight: 500;
}
</style>
