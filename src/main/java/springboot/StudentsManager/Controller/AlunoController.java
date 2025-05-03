package springboot.StudentsManager.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.StudentsManager.Model.Aluno;
import springboot.StudentsManager.Service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("api/alunos")
public class AlunoController {

// obs: Sobre a classe ResponseEnt: o metodo .ok retorna 200 . Enquanto o Http status retorna 201. Enquanto o 200 representa que a busca foi ok, o 201 diz que um item foi adicionado no banco
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> RetornaAlunos(){
        return ResponseEntity.ok(alunoService.listarTodosOsAlunos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Aluno> BuscaAlunoPelaID(@PathVariable Long id){
        return alunoService.encontrarAlunoPelaId(id)

                // como defini no repo que o metodo encontrar aluno pela id vai retornar um objeto do tipo Optional. Vou usar .map para transformar ele em um ResponseEntity
                //Caso ele n encontre nada ele vai chamar o .notFound e encerrar (.build)
                .map (ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno (@Valid @RequestBody Aluno aluno){
        // uso o service para salvar o aluno que esta sendo passao no parametro
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        // depois retorno a resposta do servidor
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);

    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> atualizarAluno (@PathVariable Long id, @Valid @RequestBody Aluno aluno){
        try {
            Aluno alunoAtualizado = alunoService.atualizarAluno(aluno, id);
            return ResponseEntity.ok(alunoAtualizado);
        }

        // vai tentar pegar qualquer tipo de RunTime Exception.
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarAluno (@PathVariable Long id){
        try {
            alunoService.deletarAluno(id);
            return ResponseEntity.noContent().build();
        }

        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }



    }





}
