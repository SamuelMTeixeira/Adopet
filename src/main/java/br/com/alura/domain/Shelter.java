package br.com.alura.domain;

public class Shelter {

    private String nome, telefone, email;
    private long id;
    private Pet[] pets;

    public Pet[] getPets() {
        return pets;
    }

    public Shelter() {
    }

    public Shelter(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return """
                "id":%s,"nome":"%s","telefone":"%s","email":"%s"
                """.formatted(this.id, this.nome, this.telefone, this.email);
    }

}
