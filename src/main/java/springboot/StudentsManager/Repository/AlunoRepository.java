package springboot.StudentsManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.StudentsManager.Model.Aluno;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Repository eh a interface que sera usada para lidar com dados do banco
    // metodos a serem chamados para achar um aluno pela matricula e verificar se ele esta na DB .tambem usando a matricula.

    Optional <Aluno> findByMatricula(String matricula);
    boolean existsByMatricula(String matricula);

}
