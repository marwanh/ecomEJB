#!/bin/sh

# install docker on Ubuntu xenial (16.04)
apt-get -y update &&  apt-get -y install apt-transport-https ca-certificates
apt-key adv --keyserver hkp://ha.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
echo "deb https://apt.dockerproject.org/repo ubuntu-xenial main" | sudo tee /etc/apt/sources.list.d/docker.list
apt-get -y update && apt-get -y install docker-engine
service docker start
