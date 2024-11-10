package ziua_54;

import java.sql.SQLOutput;

public class Class_Docker {

    public static void main(String[] args) {
        System.out.println("Ce este DOCKER?");
        System.out.println("Docker este o metoda de containerizare a datelor utilizata pentru a creea, desfasura si rula diverse clase/aplicatii.");
        System.out.println("Un container este o unitate standard de software care ambalează codul aplicației și toate bibliotecile și " +
                "dependințele necesare pentru a rula aplicația într-un mod consecvent, indiferent de mediul în care este desfășurată. " +
                "Docker este foarte popular datorită capacității sale de a asigura portabilitatea aplicațiilor și de a facilita " +
                "gestionarea resurselor în mod eficient");

/*
        Avantajele folosirii Docker pentru Selenium Grid:
    Ușurința de instalare și configurare: Poți folosi imagini Docker predefinite pentru Selenium Hub și noduri, ceea ce
    înseamnă că nu trebuie să configurezi manual fiecare componentă.
    Scalabilitate simplă: Poți adăuga sau elimina noduri (de exemplu, browser-e) foarte ușor, doar pornind sau oprind
    containere suplimentare.
    Compatibilitate între medii: Fiecare componentă a rețelei Selenium Grid poate rula într-un container izolat, eliminând
    problemele de compatibilitate.
    Automatizare și CI/CD: Docker poate fi integrat în pipeline-urile de CI/CD (Continuous Integration/Continuous Deployment),
    ceea ce face ca testele să fie automatizate și să ruleze pe diverse sisteme de operare și medii.

    Pentru a utiliza DOCKER se parcurg urmatorii pasi:
    1.  Descarcă și instalează Docker pe mașina ta (Linux, Windows sau macOS)
    2.  Pregătește imagini Docker pentru Selenium Grid: Selenium oferă imagini oficiale pe DockerHub.
        Principalele componente sunt:
        Selenium Hub: Coordonatorul principal care gestionează nodurile (browser-ele) care rulează testele.
        Selenium Nodes: Mașini care rulează instanțe de browser (cum ar fi Chrome sau Firefox).

    Comenzi de bază pentru a descărca și rula aceste imagini:
        docker pull selenium/hub
        docker pull selenium/node-chrome
        docker pull selenium/node-firefox


ATENTIE:
    Pentru a putea rula o sa avem un singur mediu in care o sa rulam mai multe view-uri / imagini
    Mediul/sistemul de baza se numetse HOST OPERATING SYSTEM
    Restul de sub-medii saview-uri se numest operating system si pot avea la randul lor alte subsisteme sau sisteme virtuale
        de genul Linu, V=Windows, MAC. Toate o sa lucrezi sub acelasi HOST


    Deci GRID CONCEPT avem un ONE HUB NOODE si colecrteaza multiple NODES, avem un ONE HUB SERVER si colecrteaza multiple NODES
    si avem un BROWSER care testeaza  sisteme de operare.
    Pentru a seta grid process noi trebuie multiple HUB si multiple NODES
    Casa inlocuim acest proces folosim CONTAINERAZATION
    - avem un container unde facem acest proces
    DOCKER este cel care ne ofera CONTAINERIZAREA

    Deci avem un DOCKER HUB - care este un repozitori , el mentine/intretine o multitudine de imagini docker.
    In acest repozitori se fac PULL si PUSH.



 */
    }

}
