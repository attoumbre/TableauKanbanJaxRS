mvn dependency:copy-dependencies
cd data
java -cp ../target/dependency/hsqldb-2.5.1.jar org.hsqldb.Server
