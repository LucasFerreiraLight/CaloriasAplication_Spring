package br.com.fiap.calorias.repository;

import br.com.fiap.calorias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByNome(String nome);

    //Busca Por Email
    public  Optional<Usuario> findByEmail(String email);

    public List<Usuario> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
