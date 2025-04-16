Proyek ini adalah sistem e-commerce berbasis microservices dengan Spring Boot yang di-deploy di Kubernetes. Langkah-langkah untuk menjalankannya.  

⚙️ Prasyarat  

   Docker terinstal
   
   Minikube atau cluster Kubernetes lain
   
   kubectl terkonfigurasi
   
   Maven (untuk build service Java)  

🛠️ Persiapan & Deploy
1.Mulai Minikube Cluster

   minikube start --driver=docker
   
2.Build & Push Docker Image
   
   Lakukan untuk setiap microservice (product, payment, order, customer):

#Build image Docker

  docker build -t <username-dockerhub>/<nama-service>:1.0.0 .  

#Push ke Docker Hub

  docker push <username-dockerhub>/<nama-service>:1.0.0  

3.Deploy ke Kubernetes
   
   Jalankan file Kubernetes secara berurutan:  

#Deploy Eureka (Service Discovery)

  kubectl apply -f eureka-deployment.yaml
  
  kubectl apply -f eureka-service.yaml  

#Deploy Database (MySQL)

  kubectl apply -f mysql-deployment.yaml
  
  kubectl apply -f mysql-service.yaml  

#Deploy Message Broker (RabbitMQ)

  kubectl apply -f rabbitmq-deployment.yaml
  
  kubectl apply -f rabbitmq-service.yaml  

#Deploy Microservices

  kubectl apply -f product-service.yaml
  
  kubectl apply -f payment-service.yaml
  
  kubectl apply -f order-service.yaml
  
  kubectl apply -f customer-service.yaml  

#Deploy API Gateway (Spring Cloud Gateway)

  kubectl apply -f api-gateway.yaml  

4.Verifikasi Deploy
   
  Cek status pod:
  
  kubectl get pods  

🌐 Mengakses Services

   Lewat API Gateway
   
    Product API: http://localhost:8080/api/products
    
    Payment API: http://localhost:8080/api/payments
    
    Order API: http://localhost:8080/api/orders
    
    Customer API: http://localhost:8080/api/customers  

Jika service error:

#Cek log

kubectl logs <nama-pod>  

#Deskripsi masalah pod

kubectl describe pod <nama-pod>  

#Redeploy jika perlu

kubectl delete -f <file-service.yaml>

kubectl apply -f <file-service.yaml>  


📂 Struktur Proyek  

/kubernetes/

  ├── eureka-deployment.yaml
  
  ├── mysql-deployment.yaml
  
  ├── rabbitmq-deployment.yaml
  
  ├── product-service.yaml
  
  ├── payment-service.yaml
  
  ├── order-service.yaml
  
  ├── customer-service.yaml
  
  └── api-gateway.yaml   


  📹 Video Demo  
  
👉 https://drive.google.com/file/d/1S10Dv2oNDiieS_V0g8q69loB2trx0CKF/view?usp=drive_link  
