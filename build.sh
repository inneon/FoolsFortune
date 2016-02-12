echo Cleaning
rm -rf bin/*

echo Building
javac -d bin com/program.java

dx --dex --no-strict --output=foolsfortune.dex.jar com
