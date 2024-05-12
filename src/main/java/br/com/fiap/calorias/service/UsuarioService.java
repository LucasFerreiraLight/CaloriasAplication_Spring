package br.com.fiap.calorias.service;

import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    //------------------------------------------------------------------
    // Salvar Usuario
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //------------------------------------------------------------------
    //Buscar Usuario pelo Id
    public Usuario buscarUsuarioPeloId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Usúario não encontrado!");
        }
    }

    //Listar todos os usuarios
    public List<Usuario> ListarTodosOsUsuarios(){
        return usuarioRepository.findAll();
    }

    //------------------------------------------------------------------
    // Deletar Usuario
    public void excluir(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }
    //------------------------------------------------------------------


    public List<Usuario> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return usuarioRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }


    //------------------------------------------------------------------
    //Atualizar
    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }


    //------------------------------------------------------------------
    //Buscar Pelo Nome

    public Usuario buscarPeloNome(String nome){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(nome);


        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Nome de Usuario não encontrado!");
        }
    }

    //------------------------------------------------------------------
    //Buscar Pelo Email

    public Usuario buscarPeloEmail(String email){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Email não encontrado!");
        }
    }



}
