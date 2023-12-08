package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Shelter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShelterService {

    private ClientHttpConfiguration client;

    public ShelterService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void listShelter() throws IOException, InterruptedException {
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = this.client.makeGetRequest(uri);
        String responseBody = response.body();

        Shelter[] shelters = new ObjectMapper().readValue(responseBody, Shelter[].class);
        List<Shelter> sheltersList =  Arrays.stream(shelters).toList();

        System.out.println("Abrigos cadastrados:");
        for (Shelter shelter : sheltersList) {
            long id = shelter.getId();
            String nome = shelter.getNome();
            System.out.println(id + " - " + nome);
        }
    }

    public void registerShelter() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        var shelter = new Shelter(nome, telefone, email);

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = this.client.makePostRequest(uri, shelter);
        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }


}
