package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ImportPetsCommand implements Command {
    @Override
    public void execute() {
        var client = new ClientHttpConfiguration();
        var petService = new PetService(client);

        try {
            petService.importPetsFromShelter();
        } catch (IOException | InterruptedException exception) {
            System.out.println(exception);
        }
    }
}
