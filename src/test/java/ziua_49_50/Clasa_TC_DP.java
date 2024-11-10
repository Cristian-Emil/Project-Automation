package ziua_49_50;

public class Clasa_TC_DP {
    public static void main(String[] args) {
        System.out.println("Se genereaza primul TC cu structura arborescenta");
        System.out.println("O sa utilizam pentru verificarea paginii respective -URL-ul mai multe tipuri de browser");
        System.out.println("Rularea cu mai multe tipuri de browser - Chrome, Edge, FireFox - se va face in paralel");
        System.out.println("Se vor realiza mai multe TC-uri care se vor rula in serie, unul dupa altul");

    }

/*
    Se genereaza primul Test Case - ce trebuie sa faca si ce trebuie sa verifice acesta
    TC - Test Case

    Ne ducem pe pagina aplicatiei "https://www.opencart.com/" si verificam ce caz de testare se paote face pt automatizare
    Intram pe pagina respectiva, mergem la "My Account" unde cu un click accesam pagina de REGISTER.
    Dupa ce aceasta se deschide se completeaza valorile din box-urile existent si se apasa "CONTINUE"
    Dupa inregistrare primim un mesaj de confirmare.

    Primul nostru TC o sa verifice partea de "Register Account" si primirea mesajului de confirmare pt inrtegistrare.
    Cate "object class" avem nevoie ca sa generam acest TC? Deci o sa avem 2 pagini Object- pagina de Accesare si pagina
    de Register
*/

/*
    Din fisierul EXCEL se folosesc/copiaza datele inserate - parola si email .
    Se genereaza DATA PROVIDER = DP  care are 2 dimensiuni si care este continut/inserat in 1 sau mai multe clase.
    Se genereaza TestCase-ul care contine TEST METER-ul (contorul de teste) ce va utiliza datele din fisierrul DP.
    Se importa datele din EXCEL in DP si din acesta in TC(TM) pentru validarea lui.

    Daca avem mai multe teste de facut o sa avem definite mai multe Data Provider
    DDT1 - DP1
    DDT2 - DP2
    DDT3 - DP3

    Se vor pune toate aceste DP intr-o singura clasa si se pot tuiliza in cate TC-uti dorim, unul sau mai multe.
    Aceste DP se for pune intr-o clasa ce se va localiza in UTILITY.

*/




}
