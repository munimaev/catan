# git pull upstream master

del ..\Catan.war

del .\WEB-INF\classes\*.class

javac WEB-INF\classes\* -classpath ..\lib\*

jar cvf ..\Catan.war .

copy ..\Catan.war "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps"
PAUSE