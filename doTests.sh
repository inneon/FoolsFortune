echo Cleaning
rm -rf bin/*

echo Building
javac -d bin tests/test.java

echo Running
java -cp bin tests.test


