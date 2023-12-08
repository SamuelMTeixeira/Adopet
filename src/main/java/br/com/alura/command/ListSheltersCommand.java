package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.ShelterService;

import java.io.IOException;

public class ListSheltersCommand implements Command {

    @Override
    public void execute() {
        var client = new ClientHttpConfiguration();
        var shelterService = new ShelterService(client);

        try {
            shelterService.listShelter();
        } catch (IOException | InterruptedException exception) {
            System.out.println(exception);
        }
    }
}
