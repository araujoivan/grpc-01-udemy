# grpc-01-udemy

A basic example of a GRPC Unary Client/Server

1) PROTO PLUGINS are available in 
   https://github.com/grpc/grpc-java
   
2) The code generator didn't work as expected as a maven pom project so..everytime I want to debug | execute the server|client I 
   need to comment the plugin in pom.xml
   For generating stubs, uncomment the pom plugin pieace and runs > ```mvn clean install -U```  by command line
