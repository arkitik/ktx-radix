mvn clean install -T 10C
mvn package dokka:javadocJar gpg:sign nexus-staging:deploy