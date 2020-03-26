#!/bin/bash
set -e

# name of your app 
APP_NAME="best-service"
APP_VERSION="v1"

echo "Clean Install and Package..";
mvn clean install -DskipTests

mvn clean package -DskipTests
echo "Clean Install and Package Done.";

echo "Enable Google Container Registry..";
gcloud services enable containerregistry.googleapis.com
echo "Container Registry Enabled.";  
  
echo "Create the container image and push it to the Container Registry..";  
mvn com.google.cloud.tools:jib-maven-plugin:build \
-Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
echo "Container Created.";  
  
echo "Deployment started..";    
kubectl delete deployment best-service

kubectl create deployment $APP_NAME \
--image=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
echo "Deployment Done.";   
echo "Create Service Load-balancer..";  
kubectl delete service  $APP_NAME
kubectl create service loadbalancer $APP_NAME --tcp=8080:8080
echo "Create Service Load-balancer Dobectl get servicesne. ";  
echo "wait for sometime and execute 'kubectl get services'";

