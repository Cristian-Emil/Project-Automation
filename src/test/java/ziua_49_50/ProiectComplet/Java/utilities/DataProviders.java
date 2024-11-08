package ziua_49_50.ProiectComplet.Java.utilities;

/*
    daca DP1 este definit in DDT1 si se utilizeaza la TC1
    daca DP2 este definit in DDT2 si se utilizeaza la TC2
    atunci n-o sa mia putam sa-l utilizam pe DP1 la TC1
    la fel si daca DDT1 si DDT2 sunt folosite la TC1 atunci nici unul din DP1 & DP2 nu se vor putea utiliza la TC2

    Pentru acest motiv se pun DP1 & DP2 & DPn in cadrul unei clase separate care se va utiliza la mai multe TC-uri.
    Aceasta e o alta parte a UTILITY - deci in directorul "utilities" se scriu DP1 - DPn

 */


import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvider 1

    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
        String path=".src/test/java/ziua_49_50/ProiectComplet/testData/Opencart_LoginData.xlsx";     //taking exl file from testData

        ExcelUtility exlutil=new ExcelUtility(path);//creating an object for XLUtility

        int totalrows=exlutil.getRowCount("Sheet1");
        int totalcols=exlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
//  In bucla - LOOP - avem numarul de randuri si de coloane citite cu conditioanala IF. Atentie , numarul de randuri incepe cu ZERO

            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j]= exlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array
/*
    pentru ca trebuie sa avem acelasi numar de linii si coloane in DP ca si in EXCEL FILES, se extrag din excel numerele
    acestora si ele se vor insera in spatiul cu 2 dimensiuni ale DP.
    Deci generam 2 dimensiuni area
 */
    }






    //DataProvider 2

    //DataProvider 3

    //DataProvider 4
}
