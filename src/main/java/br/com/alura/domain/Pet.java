package br.com.alura.domain;

public class Pet {
    private String tipo, nome, raca, cor;
    private int idade;
    private float peso;
    private long id;

    public Pet() {
    }

    public Pet(String tipo, String nome, String raca, String cor, int idade, float peso) {
        this.tipo = tipo.toUpperCase();
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.idade = idade;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    public float getPeso() {
        return peso;
    }

    public long getId() {
        return id;
    }
}
