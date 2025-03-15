# Use Node.js for building the app
FROM alpine:3.21
ENV NODE_VERSION 22.14.0

WORKDIR /ecomui
COPY ecomui/package.json ecomui/package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Use Nginx for serving the app
FROM nginx:1.26.3-alpine-slim
COPY --from=build /ecomui/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
