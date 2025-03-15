# Use Node.js for building the app
FROM node:22.11.0-alpine
WORKDIR /ecomui
COPY ecomui/package.json ecomui/package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Use Nginx for serving the app
FROM nginx:alpine
COPY --from=build /ecomui/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
