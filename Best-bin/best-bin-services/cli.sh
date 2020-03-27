#!/bin/bash
set -e

# name of your app 
APP_NAME="best-service"
APP_VERSION="v1"
echo "====================================================="; 
echo "Clean Install and Package..";
mvn clean install -DskipTests

mvn clean package -DskipTests
echo "Clean Install and Package Done.";
echo "====================================================="; 
echo "Enable Google Container Registry..";
gcloud services enable containerregistry.googleapis.com
echo "Container Registry Enabled.";  
echo "=====================================================";   
echo "Create the container image and push it to the Container Registry..";  
mvn com.google.cloud.tools:jib-maven-plugin:build \
-Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
echo "Container Created.";  
echo "=====================================================";   
echo "Deployment started..";    
echo "Mongo DB deployment started..";    
kubectl apply -f deployment-mongo.yml
echo "Mongo DB deployment Done.";    
kubectl delete deployment $APP_NAME
echo "Deployed Application Deleted..";    
kubectl create deployment $APP_NAME \
--image=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
echo "Deployment Done.";
echo "=====================================================";
echo "Create Service Load-balancer..";
kubectl delete service  $APP_NAME
kubectl create service loadbalancer $APP_NAME --tcp=8080:8080
echo "Create Service Load-balancer Done. ";
echo "=====================================================";
echo "=====================================================";
echo "wait for sometime and execute 'kubectl get services'";
echo "=====================================================";

