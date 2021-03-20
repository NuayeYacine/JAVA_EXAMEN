package services;

import entities.Client;

import java.util.List;

public interface IClient {

    public  int addClient(Client client) throws Exception;
    public  int updateClient(Client client,int id) throws Exception;
    public  Client getClient(int id) throws Exception;
    public  void searchClient(String emailR) throws Exception;
    public List<Client> listClient() throws  Exception;
}
