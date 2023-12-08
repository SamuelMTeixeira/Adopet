package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ListPetsCommand implements Command{
    @Override
    public void execute() {
        var client = new ClientHttpConfiguration();
        var petService = new PetService(client);

        try {
            petService.listPetsFromShelter();
        } catch (IOException | InterruptedException exception) {
            System.out.println(exception);
        }
    }
}
