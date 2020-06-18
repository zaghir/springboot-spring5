create a project with maven 
maven mvn archetype:generate -DgroupId=com.zaghir.project.todo -DartifactId=todo 
	-Dversion=0.0.1-SNAPSHOT -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-webapp -->

Create a package 
====================
mvn clean package


http://localhost:8080/todo/

reponse as json format 
http://localhost:8080/todo/toDos