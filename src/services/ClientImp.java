package services;

import entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientImp implements IClient {
    DB db = new DB();
    @Override
    public int addClient(Client client) throws Exception {
        db.opendb();
        String sql = "INSERT INTO client VALUES(NULL, ?,?,?,?)";
        db.initR(sql);
        db.getPreparedStament().setString(1,client.getNom());
        db.getPreparedStament().setString(2,client.getPrenom());
        db.getPreparedStament().setString(3,client.getEmail());
        db.getPreparedStament().setString(4,client.getTel());
        int ok =  db.executeUpdate();
        System.out.println(ok);
        return ok;
    }

    @Override
    public int updateClient(Client client,int id) throws Exception {
        db.opendb();
        String sql = "UPDATE client SET nomC=?,prenomC=?,email=?,tel=? WHERE idC=? ";
        db.initR(sql);
        db.getPreparedStament().setString(1,client.getNom());
        db.getPreparedStament().setString(2,client.getPrenom());
        db.getPreparedStament().setString(3,client.getEmail());
        db.getPreparedStament().setString(4,client.getTel());
        db.getPreparedStament().setInt(5, id);
        int ok = db.executeUpdate();

        return ok;
    }

    @Override
    public Client getClient(int id) throws Exception {

        Client cl = null;
        db.opendb();
        String sql ="SELECT * FROM client WHERE id=?";
        db.initR(sql);
        db.getPreparedStament().setInt(1,id);
        ResultSet rs = db.executeSelect();
        if(rs.next())
        {
            cl = new Client();
            cl.setId(rs.getInt(1));
            cl.setNom(rs.getString(2));
            cl.setPrenom(rs.getString(3));
            cl.setEmail(rs.getString(4));
            cl.setTel(rs.getString(5));
        }
        return cl;
    }

    @Override
    public void searchClient(String emailR) throws Exception {
         db.opendb();
         String sql = "SELECT * FROM client WHERE email =?";
         db.initR(sql);
         ResultSet rs = db.executeSelect();
         int cpt = rs.getRow();
        if(cpt != 0)
        {
            //recuperation des données de la base de donnée
            System.out.println("ID : "+rs.getString("id"));
            System.out.println("NOM : "+rs.getString("nom"));
            System.out.println("PRENOM : "+rs.getString("prenom"));
            System.out.println("EMAIL : "+rs.getString("email"));
            System.out.println("TELEPHONE : "+rs.getString("tel"));
        }else
        {
            System.out.println("Vous n'êtes pas enregistrer dans notre base de donnée !");
        }
    }

    @Override
    public List<Client> listClient() throws Exception {
        List<Client> listClient = new ArrayList<Client>();
        db.opendb();
        String sql = "SELECT * FROM client";
        db.initR(sql);
        ResultSet rs = db.executeSelect();
        while(rs.next())
        {
            Client client = new Client();
            //recuperation des données de la base de données
            client.setId(rs.getInt(1));
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));
            //ajout dans la liste
            listClient.add(client);
        }
        // List<Client>  ListesClient = new ArrayList<Client>();
        for (Client cl: listClient) {
            System.out.println("ID : "+cl.getId());
            System.out.println("NOM : "+cl.getNom());
            System.out.println("PRENOM : "+cl.getPrenom());
            System.out.println("EMAIL : "+cl.getEmail());
            System.out.println("TELEPHONE : "+cl.getTel());
        }
        return listClient;
    }


}
