import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '../views/Category/AddCategory.vue'
 import ListCategory from '../views/Category/ListCategory.vue'
 import AdminView from '../views/Admin/AdminView.vue'
 import ProductView from '../views/Product/ProductView.vue'
 import AddProduct from '../views/Product/AddProduct.vue'
 import EditCategory from '../views/Category/EditCategory.vue'
 import EditProduct from '../views/Product/EditProduct.vue'
 import SignIn from '../views/SignIn.vue'
 import SignUp from '../views/SignUp.vue'
 import ShowDetails from '../views/Product/ShowDetails.vue'
 import CartView from '../views/Cart/CartView.vue'
//  import SearchView from '../views/Product/SearchView.vue'
import SearchView from '../views/Product/SearchView.vue'

 const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/admin/category/add',
    name: 'AddCategory',
    component: AddCategory
  },
  {
    path: '/admin/list/category',
    name: 'ListCategory',
    component: ListCategory
  },
  //Admin routes
  {
    path: '/admin',
    name: 'AdminView',
    component: AdminView
  },

  //products
  {
    path: '/admin/product',
    name: 'AdminProduct',
    component: ProductView
  },
  {
    path: '/admin/product/add',
    name: 'AddProduct',
    component: AddProduct
  },
  {
    path: '/admin/category/:id',
    name: 'EditCategory',
    component: EditCategory
  }
  ,
  {
    path: '/admin/product/:id',
    name: 'EditProduct',
    component: EditProduct,
  },
  
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn
  },
  {
    path : '/product/show/:id',
    name : 'ShowDetails',
    component: ShowDetails
  },
  {
    path : '/cart',
    name : 'CartView',
    component : CartView
    },
    {
      path : '/search/:keyword',
      name : 'SearchView',
      component : SearchView
      
    }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
