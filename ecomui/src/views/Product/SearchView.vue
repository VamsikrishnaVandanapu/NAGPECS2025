<template>
<div class="container">
    <div class="row">
    <div v-for="product of products" :key="product.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
          <ProductBox :product="product">
          </ProductBox>
        </div>
    </div>
    </div>
</template>
<script>
import ProductBox from '../../components/Product/ProductBox';
import axios from 'axios'
export default {
data(){
    return {
      products : null,
      keyword:null
    }
  },

  components : {ProductBox},
  name:"SearchView",
  props : [ "baseURL"],
  methods: {
    async fetchData() {
      // fetch products
      await axios            
        .get( `${this.baseURL}product/search?keyword=${this.keyword}`)
        .then((res) => (this.products = res.data))
        .catch((err) => console.log(err));
    }
  },
  created(){
    if(this.$route.params.keyword){
        console.log("keyword==",this.$route.params.keyword)
        this.keyword = this.$route.params.keyword;
    }
    
    this.fetchData();
  },
  beforeRouteUpdate(to, from, next) {
    // Call the API query method when the URL changes
    this.keyword = to.params.keyword;
    this.fetchData()
    //this.getContent(to.params.keyword)
    next()
  }
};
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}

#add-product {
  float: right;
  font-weight: 500;
}
</style>
