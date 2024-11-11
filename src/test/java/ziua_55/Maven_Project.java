package ziua_55;

public class Maven_Project {

    public static void main(String[] args) {
        System.out.println("Pentru a rula TC-urile remote, adica in mediu CI/CD trebuie sa avem dependintele MAVEN ");
        System.out.println("Deci in fisierul pom.xml trebuie sa specificam mai multe dependinte");

/*
    in POM.XML avem :
    dependencies    --->    download required JAR dependency fot project
    plugins         --->    to compile and run the project

    deci in pom.xml avem :
    1) maven compiler plugin        ---> acestea sunt dependinte
    2) maven surefire plugin

    Instalam maven OS level
    https://maven.apache.org/download.cgi
    C:\Program Files\apache-maven-3.9.9\bin     ---> Trebuie sa configuram fisierul

    mvn -version
    java -version



 */

    }

}
