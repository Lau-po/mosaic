FROM java:8 

ENV IN_DOCKER 'true'
# Install maven
RUN apt-get update  
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml  
RUN ["mvn", "dependency:resolve"]  
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src  
RUN ["mvn", "package"]

 
CMD ["mvn", "clean"]  
CMD ["mvn", "install"]  
CMD ["mvn", "exec:java"]  
