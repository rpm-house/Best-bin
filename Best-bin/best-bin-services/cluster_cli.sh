#!/bin/bash
set -e

# name of your app 
CLUSTER_NAME="best-bin-cluster"

echo "====================================================="; 
echo "Enable Compute Service..";
gcloud services enable compute.googleapis.com container.googleapis.com
echo "Create Cluster..";
gcloud container clusters create $CLUSTER_NAME \
  --num-nodes 2 \
  --machine-type n1-standard-1 \
  --zone us-central1-c
echo "====================================================="; 
