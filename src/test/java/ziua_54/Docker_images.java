package ziua_54;

public class Docker_images {

    public static void main(String[] args) {

        System.out.println("1) hub" +
                "2) linux -firefox" +
                "3) linix-chrome");

/*
    Se vor genera 3 docker containers :
        docker pull selenium/hub
        docker pull selenium/node-firefox
        docker pull selenium/node-chrome

    Dupa verificarea celor 3 imagini se va verifica containerul.

    Pasul 1 - ne ducem pe dockerhus si bifam IMAGES ( https://hub.docker.com/search?type=image ) unde selectam in search:
        selenium/node-chrome ( https://hub.docker.com/r/selenium/node-chrome )

    Pasul 2 - in CMD scriem in linia de comanda : docker pull selenium/hub
        Astfel facem PULL la prima imagine - HUB

    Pasul 3 - in CMD scriem in linia de comanda : docker pull selenium/node-chrome
        Astfel facem PULL la a doua imagine - NODE-CHROME

    Pasul 3 - in CMD scriem in linia de comanda : docker pull selenium/node-firefox
        Astfel facem PULL la a doua imagine - NODE-CHROME

    Au fost download-ate toate elementele necesare
    Pentru verificare se scrie comanda "docker images" in linia de comanda din CMD

    Din acest moment se va crea un container ce va contine aceste 3 images.



 */




    }
}
