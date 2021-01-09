package bank.models;

import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Client {

    private @Id @GeneratedValue Long id;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 40)
    private String name;

    @Column(unique=true)
    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Column(unique=true)
    @NotBlank(message = "CPF obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Data de nascimento obrigatória")
    private String dateOfBirth;

    public Client() {}

    public Client(String name, String email, String cpf, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(cpf, client.cpf) && Objects.equals(dateOfBirth, client.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + cpf + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}