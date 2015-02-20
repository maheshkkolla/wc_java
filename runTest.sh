echo 'cleaning..'
rm -f *.class
echo "compiling..."
javac -cp junit-4.10.jar *.java
if [ $? != 0 ] 
	then exit
fi
echo "running tests.."
echo "----------->    Unit tests   <-----------"
echo ""
java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore WcLibTest
echo "----------->   Integration tests   <-----------"
echo""
java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore WcTest
echo $?