package springboot.StudentsManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.StudentsManager.Model.Aluno;
import springboot.StudentsManager.Repository.AlunoRepository;

import java.util.List;
import java.util.Optional;
// Service eh a logica de negocio por tras da aplicação  -- Lista,busca,deleta,salva e atualiza
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodosOsAlunos (){
        // metodo findAll é herdado da classe JPArepository e retorna todas as entidades de uma tabela. --- Sempre retorna em uma lista? (Sim)

        return alunoRepository.findAll();
    }

    public Optional<Aluno> encontrarAlunoPelaId(Long id){
        return alunoRepository.findById(id);
    }


    public Aluno salvarAluno(Aluno aluno){
        if (alunoRepository.existsByMatricula(aluno.getMatricula())){
            throw new RuntimeException("MAtricula ja existe no banco bb. Ta achando que eh bagunçado?");
        }
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Aluno aluno, Long id){
        // n pode att uma id de um aluno se ele n ta no banco
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno nao existe no banco de dados");

        }

        aluno.setId(id);
        return alunoRepository.save(aluno);

    }


    public void deletarAluno(Long id){
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno nao existe no banco de dados");
        }

        alunoRepository.deleteById(id);

    }







}
