FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /Users/sergiu.bahrim/seleniumGrid

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar              selenium-docker.jar
ADD target/selenium-docker-tests.jar        selenium-docker-tests.jar
ADD target/libs                             libs

# in case of any other dependencies like .csv / .json / .xls
# please add this as well
# ADD suites files
ADD search-demo.xml                         search-demo.xml
ADD coface_tests.xml                        coface_tests.xml

#ADD healthcheck script
ADD healthcheck.sh                          healthcheck.sh


# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
#JAVA CLASS IS IN healthcheck.sh file