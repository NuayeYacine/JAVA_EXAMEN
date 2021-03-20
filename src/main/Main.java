package main;

import entities.Client;
import services.ClientImp;
import services.DB;
import services.IClient;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  Exception {
        DB db = new DB();
        Client C = new Client();
        IClient client = new ClientImp();
        Scanner sc = new Scanner(System.in);
        String  num,phone;
        boolean ok2 ;
        boolean ok3 =false ;

       /*
        db.opendb();
        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?)";
        db.initR(sql);
        db.getPreparedStament().setString(1,"Mangala");
        db.getPreparedStament().setString(2,"Yacine");
        db.getPreparedStament().setString(3,"manyasera@gmail.com");
        db.getPreparedStament().setString(4,"785388033");
        int ok  = db.executeUpdate();
        System.out.println(ok);
        */
        System.out.println("------------- GESTIONNAIRE DE CLIENT ---------------");
        System.out.println("1------CREATION DU CLIENT ");
        System.out.println("2------MODIFICATION DU  CLIENT ");
        System.out.println("3------ RECHERCHE UN CLIENT ");
        System.out.println("4------ AFFICHER TOUTS LES CLIENTS ");
        System.out.println("QUE VOULEZ-VOUS ?");
        int choix = Integer.parseInt(sc.nextLine());
        switch (choix)
        {
            case 1:
            System.out.println("-------------CREATION CLIENT-------------");
                   System.out.println("Entrer votre nom");
            C.setNom(sc.nextLine());
                System.out.println("Entrer votre prenom");
                C.setPrenom(sc.nextLine());
                 do {
                     System.out.println("Entrer votre email");
                     String mail = sc.nextLine();
                     String M = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                         if (mail.matches(M))
                         {
                             C.setEmail(mail);
                             ok3= true;
                         }
                         else
                         {
                             System.out.println("INCORRECT");
                         }

                 }while (ok3 == false);


                 ok2 = false;
              do {
                  System.out.println("Entrer votre numéro téléphone");
                  num= sc.nextLine();
                  phone = num.substring(0,2);
                  if(phone.length()==9 && phone.equals("77") || phone.equals("78") || phone.equals("70"))
                  {
                      C.setTel(num);
                      ok2=true;
                  }else
                  {
                      System.out.println("INCORRECT");
                  }

              }while (ok2 == false);
            int ok = client.addClient(C);
            System.out.println(ok);
                break;
            case 2:
                System.out.println("-------------MODIFICATION DU CLIENT-------------");
                System.out.println("Entrer votre ID");
                int id = sc.nextInt();
                System.out.println("Entrer votre nom");
                C.setNom(sc.nextLine());
                System.out.println("Entrer votre prenom");
                C.setPrenom(sc.nextLine());
                System.out.println("Entrer votre email");
                C.setEmail(sc.nextLine());
                  ok2 = false;
                do {
                    System.out.println("Entrer votre numéro téléphone");
                    num= sc.nextLine();
                    phone = num.substring(0,2);
                    if(phone.length()==9 && phone.equals("77") || phone.equals("78") || phone.equals("70"))
                    {
                        C.setTel(num);
                        ok2=true;
                    }else
                    {
                        System.out.println("NULL");
                    }

                }while (ok2 == false);

                int ok1 = client.updateClient(C,id);
                break;
            case 3:
                System.out.println("-------------RECHERCHER UN CLIENT-------------");
                System.out.println("Entrer votre mail");
                client.searchClient(C.setEmail(sc.nextLine()));
                break;
            case 4:
                System.out.println("-------------AFFICHAGE DES CLIENTS-------------");
                List<Client> listC = client.listClient();
                break;
            default:
                System.out.println("NULL");
        }



      /*  System.out.println("-------------CREATION CLIENT-------------");
        System.out.println("Entrer votre nom");
        C.setNom(sc.nextLine());
        System.out.println("Entrer votre prenom");
        C.setPrenom(sc.nextLine());
        System.out.println("Entrer votre email");
        C.setEmail(sc.nextLine());
        System.out.println("Entrer votre numéro téléphone");
        C.setTel(sc.nextLine());
        int ok = client.addClient(C);
        System.out.println(ok);

       */
       /* System.out.println("-------------MODIFICATION DU CLIENT-------------");
        C.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer votre nom");
        C.setNom(sc.nextLine());
        System.out.println("Entrer votre prenom");
        C.setPrenom(sc.nextLine());
        System.out.println("Entrer votre email");
        C.setEmail(sc.nextLine());
        System.out.println("Entrer votre numéro téléphone");
        C.setTel(sc.nextLine());
        int ok = client.updateClient(C);

        */

        /*
           System.out.println("-------------RECHERCHER UN CLIENT-------------");
        System.out.println("Entrer votre mail");
        client.searchClient(C.setEmail(sc.nextLine()));

         */

       /*
          System.out.println("-------------AFFICHAGE DES CLIENTS-------------");
       List<Client> listC = client.listClient();
        */


    }
}
