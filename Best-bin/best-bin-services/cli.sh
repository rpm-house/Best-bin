#!/bin/bash
set -e

# name of your app 
APP_NAME="best-service"
APP_VERSION="v1"

echo "Clean Install and Package ====";
mvn clean install -DskipTests

mvn clean package -DskipTests

echo "Enable Google Container Registry  ====";
gcloud services enable containerregistry.googleapis.com
  
echo "Create the container image and push it to the Container Registry  ====";  
mvn com.google.cloud.tools:jib-maven-plugin:build \
-Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
  
echo "Re Deploy  ====";    
kubectl delete deployment best-service

kubectl create deployment $APP_NAME \
--image=gcr.io/$GOOGLE_CLOUD_PROJECT/$APP_NAME:$APP_VERSION
  
kubectl create service loadbalancer $APP_NAME --tcp=8080:8080