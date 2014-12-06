del ..\Catan.war

del .\WEB-INF\classes\*.class

javac WEB-INF\classes\* -classpath ..\lib\*
# PAUSE

jar cvf ..\Catan.war .
PAUSE