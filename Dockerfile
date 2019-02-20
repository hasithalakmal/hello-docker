FROM ubuntu:18.04
#MAINTAINER hasithag;
LABEL "maintainer"="hasithag"
LABEL "vender"="smile24es"
LABEL "version"="1.0.0"

# Install prerequisites
RUN apt-get update && apt-get install --no-install-recommends -y \
software-properties-common curl supervisor ntp jq && apt-get update

# Install java8
RUN \
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN add-apt-repository ppa:webupd8team/java

RUN apt-get update && apt-get install --no-install-recommends -y \
oracle-java8-installer && apt-get update

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN mkdir -p /opt/my-app/

COPY target/hello-docker-1.0-SNAPSHOT.jar /opt/my-app/

CMD ["bash", "-c", "java -jar /opt/my-app/hello-docker-1.0-SNAPSHOT.jar"]