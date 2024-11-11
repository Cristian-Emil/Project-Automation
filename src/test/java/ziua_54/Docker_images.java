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
    Pentru verificare se scrie comanda "docker images" in linia de comanda din CMD si vedem ce images avem

    Din acest moment se va crea un container ce va contine aceste 3 images.

    ATENTIE - urmeaza sa se creeze DOCKER NETWORK GRID. Acestuia ii dam ce nume dorim noi.
        Containerul nostru o sa poarte numele GRID_LOCAL
        Scriem comanda "cls" in linia de "cmd" ca sa avem ecran curat.

        Pentru a genera containerul folosim liniile de comanda de mai jos :
        Se generaza noul NETWORK cu linia de mai jos:
docker network create grid_local

         Creeaza HUB-ul si o images
docker run -d -p 4442-4444:4442-4444 --net grid_local --name selenium-hub selenium/hub
        in "cmd"

        --net grid_local        - este "network nume" pt containerul nostru.
        --name selenium-hub     - este numele "node"-ului nostru
        selenium/hub            - este IMAGES de unde se genereaza containerul
        docker run -d -p 4442   - este containerul nostru
        portul default pentru hub este 4444
        4442-4444:4442-4444 este range-ul pentru port sa evitam conflictul. Avewm triplu 444 cu 2 pana la triplu 444 cu 4

    Deci toate cele de mai sus o sa genereze un DOCKER HUB NODE.

        A DOUA IMAGINE - images
docker run -d --net grid_local -e SE_EVENT_BUS_HOST=selenium-hub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome
        selenium/node-chrome    - este IMAGES de unde se genereaza containerul
        SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 - face referinta la porturile 4442 si 4443

        A TREIA IMAGINE - images
docker run -d --net grid_local -e SE_EVENT_BUS_HOST=selenium-hub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox
        selenium/node-firefox    - este IMAGES de unde se genereaza containerul
        SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 - face referinta la porturile 4442 si 4443

    Prima comanda creaza un network a doau un HUB a treia si a patra cate un NODE, adica 2 node. Deci avem cele 3 images dorite.
    Si aceatea sunt interconectate in network-ul GRID_LOCAL

    Dupo ce generam cele 3 se da coamnda "docker ps"
    Deschidem o pagina de CHROME si in bara scriem : http://localhost:4444/ui/ , ne este afisat cele 2 NODE care ruleaza.

ATENTIE:    Aici avem o cerinta - sa pornim mereu tot timpul HUB si NODE manual.

    Pentru a scapa de aceasta provocare trebuie sa facem un fisier pentru CONFIGURATION DOCKER FILE.
    In FOLDERUL ziua49_50 o sa generam o clasa yaml cu numele  - docker-compose.yaml
    Aceast fisier contine toate "Required config" pentru a porni DOCKER in mod automat.

    Folosin comanda "docker-compose up" ca sa pornim containerul si images ale acesteia - din CMD
    C:\Users\crist\IdeaProjects\Project_Autom_Framework\src\test\java\ziua_49_50>docker-compose up

ATENTIE:

2) Run docker-compose.yaml
docker-compose up
3) To check hub & nodes running state:
http://localhost:4444/grid/console
4) To stop the grid and cleanup the created containers:
docker-compose down


 */




    }
}
