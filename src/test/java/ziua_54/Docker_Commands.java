package ziua_54;

public class Docker_Commands {

    public static void main(String[] args) {
        System.out.println("Ca sa folosim DOCKER este necesar sa invatam cateva comenzi de apelare si rukare");
        System.out.println("Toate aceste comenzi se vor rula din COMMAND PROMPT - se scrie in bara de cautare - CMD  ");
        System.out.println("docker version = este pentru a verifica versiunea de docker existenta si server-ul");
        System.out.println("docker -v = utila pentru a verifica versiunea de docker existenta");
        System.out.println("docker info = pentru a vedea toate informatiile despre docker");
        System.out.println("docker --help = pentru a vedea comenzile care ne ajuta - HELP");
        System.out.println("docker login = utilizata pentru a ne loga");

//  comenzi pentru IMAGES
        System.out.println("docker images = utilizata pentru a vedea repository-urile si imaginile existente");
        System.out.println("docker pull imageName = utilizata pentru face pull repository-urile si imaginile existente");
        System.out.println("docker rmi <image id> = utilizata pentru a elimina REMOVE imaginile existente");

//  Comenzi pentru CONTAINER
        System.out.println("docker ps = pentru a vedea ce containere ruleaza  ");
        System.out.println("docker run <id_container> = pentru a rula ");       // sau avem varianta urmatoare
        System.out.println("docker run < nume images > = pentru a rula ");
        System.out.println("docker start <id_container ID/nume_container> = pentru a porni containerul ");
        System.out.println("docker stop <id_container ID/nume_container> = pentru a opri containerul");
        System.out.println("docker rm <id_container/nume_container> = pentru REMOVE CONTAINER ");
/*
    ATENTIE: Pt o IMAGE se pot creea mai multe containere
 */

//  Alte comenzi pentru sistemul CONTAINER
        System.out.println("docker stats = pentru a vedea ce containere sunt in desfasurare, memorie utilizta si alte date");
        System.out.println("docker system df = afiseaza numarul de containere, spatiul utilizat pe disck si alte info.");
        System.out.println("docker system prune -f = opreste sau elimina toate containerele in desfasurare");
    }
}
