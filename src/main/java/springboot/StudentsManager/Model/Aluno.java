package springboot.StudentsManager.Model;
// classe para criar a entidade alunos no banco de dados
// Um aluno nesse sistema vai ter os dados: id,matricula,nome.email,telefone e curso.Todos obrigatorios na criação.

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "alunos")
public class Aluno {

    //Id da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "nome é um dado obrigatorio")
    private String nome;

    @NotBlank (message = "email é um dado obrigatorio")
    private String email;

    @NotBlank (message = "Curso é um dado obrigatorio")
    private String curso;

    @NotBlank (message = "telefone é um dado obrigatorio")
    private String telefone;


    @NotBlank (message = "matricula é um dado obrigatorio")
    private String matricula;




}
