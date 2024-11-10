package ziua_48;

public class Clasa_AutomFrame_S1 {

    public static void main(String[] args) {
        System.out.println("Automation Framework");
        System.out.println("In astfel de cazuri se realizeaza o structura pe mai multe foldere pt a face usoara intretinerea");
        System.out.println("Avem foldere pentru TEST CASE - clasa separat; avem folder pentru UTILITY - clasa separat " +
                           "avem folder pentru fiserele |Excel - clasa separat ; avem folder poentru SCREEN SHOT - clasa separat");
        System.out.println("Deci avem structura divizata in foldere numita - FRAMEWORK");
        System.out.println("Astfel avem avantajul pentru - RREUSABILITY ; MAINTAINABILITY ; READABILITY");

/*
    O sa organizam proiectul de automation in structura predefinita

    Obiectivele acestei structuri sunt
    1)  reutilizarea claselor in functie de unde si cum avem nevoie
    2)  mentenanta, intretinerea lor se face usor in functie de fiecare clasa sau folder unde a fost definit
    3)  lizibilitatea - este usor de citit , verificat, inteles

----------------------------------------------
    Tipuri de framework-uri
    1)  Incorporate (Built-in)
        de forma : testng, jumit, cucumber, robot, etc ...

    2)  realizate dupa nevoile noastre (customized / use defined)
        de forma freamwork-urilor modulare, data driven, keywork driven, hybrid driven, etc ...

----------------------------------------------
    Fazele / etapele

    1)  Analizarea AUTOMATION a structurii
     - numar de clase
     - care sunt toate elementele / cum / tipurile
     - ce se automatizeaza / ce nu putem sa automatizam prin aplicatia browserului


    2)  Cum alegem test case-urile pentru automatizare. Ce criterii folosim - anumite teste nu se pot automatiza

    Daca avem 100 de test case-uri, se poate sa le automatizam pe toate? In general NU.
    Ce parte se poate sa automatizam si ce parte nu se poate? O sa avem 90 de teste care se pot automatiza dar 10 nu se pot.
    Prima data o sa avem TESTARE MANUALA si apoi in fucntie de ce se obtine acolo se paote sa automatizam anumite TC-uri.

    Avem urmatoarele tipuri de TC:
    A)  sanity test case                    - P1 ( este o testare rapida de functionare care trebuie sa treaca ca sa
                                                   consideram aplicatia valida pentru alte tipuri de teste )
    B)  data driven test cases / re-tests   - P2 ( este testare software efectuata pentru a verifica dacă defectele
                                                   raportate anterior au fost corectate după ce dezvoltatorii au făcut
                                                   modificările necesare
    C)  regression test cases               - P3 ( este testare software efectuata pentru a asigura că modificările
                                                   recente în cod - cum ar fi bug fixuri, îmbunătățiri sau noi funcționalități -
                                                   nu au introdus noi defecte în părțile existente ale aplicației.
    D)  alte tipuri de cazuri               - P4

    Primele 3 tipuri de testare se pot automatiza - A, B, C.
    Acestea 3 pot sa acopere 70-90% din partea de testare pentru automatizare. Ele sunt obligatorii.


    3)  Desenarea/generarea si dezvoltarea framework-urilor

    4)  Executia test case-urilor este - local , remotely
    In IDE putem sa facem o executie locala - IntellijIDE, Eclipse, etc.
    Remotely se poate realiza din alt loc, din alta aplicatie, din alt program. Jerkins este o aplicatie remot.

    5)  Intretinerea / mentenanta - se genereaza diverse clase, diverse logari, diverse repository-uri.

    Multe dintre automatizarile pe care putem sa le facem sunt pe E-COMMERCE DOMAIN.
    Aici avem aplicatii bazate pe "features"
    Fiecare tip de aplicatie are caracteristicile ei:
    e-commerce are un tip
    e-banking are un tip
    e-services are un tip

    Deci fiecare aplicatie este dedicata pentru un anumit tip de aplicarie.
    Fiecare operatie are urmatoarele mecanisme:
    - front-end (cele la care au loc clientii programului)                      - Frontend oper (customers/users)
    - back-end (cele la care au acces cei care genereaza si intretin aplicatia) -

    Operatiile care sunt gestionate  de fiecare grup sunt definite ca:

   - Frontend operations (customers / users / frontend tester)
        - register an account
        - login
        - search for the product
        - add/edit/ delete products from card or basket
        - order products
        - reviews
        - etc.

    - Backend operations (admin / backend teams / backend tester)
        - products info
        - customer info
        - order info
        - store info
        - etc.

    IN GNERAL SE AUTOMATIZEAZA APLICATILE DE FRONTEND.
    Avem si aplicatii de backend care se automatizeaza dar acestea sunt mult mai putine comparativ cu frontend.

    Un model de elemente de frontend ce se paote utiliza pt testare este :
    https://www.opencart.com/index.php?route=cms/demo
    - frontend application
    - admin / backend application

    Acest site este pentru testare dar nu permite automatizarea propceselor
    Se va utiliza pentru testare automata site-ul:
    https://tutorialsninja.com/demo/
    XAMPP va ofera cele 3 componente APPACHE SERVER, PHP, MySQL pentru a rula programul de pe local

    Download-am toate componenetele de pe site-ul opencart.com
    https://www.opencart.com/index.php?route=cms/download

 */


    }

}
