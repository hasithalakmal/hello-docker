#!/bin/sh
dockerImageTag=$1

mvn clean package -DskipTests

sudo docker build -t hasithagamage/hello-docker:$dockerImageTag .

sudo docker push hasithagamage/hello-docker:$dockerImageTag

existingContainer=$(sudo docker ps | grep hasithagamage/hello-docker | awk '{print $1}')

if [ -z "$existingContainer" ]
then
	echo "No containers found"

else
	sudo docker stop $existingContainer
	sudo docker rm $existingContainer
fi

sudo docker run  -itd -p 8101:8080  hasithagamage/hello-docker:$dockerImageTag
