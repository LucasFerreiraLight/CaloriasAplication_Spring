package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController{

    @Autowired
    private UsuarioService service;

    //save
    @PostMapping("/usuario/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario gravar(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }

    //buscar todos os Usuarios
    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarTodosOsUsuarios(){
        return service.ListarTodosOsUsuarios();
    }

    //Delete
    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Por padrão já é esse, mas você pode deixar explicito igual está ai
    public void excluir(@PathVariable Long id){
        service.excluir(id);

    }


    // Update
    @PutMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return service.atualizar(usuario);
    }

    //--------------------------------------------------------------
    // Buscar pelo Nome
    @GetMapping("/usuario/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPeloNome(@PathVariable String nome){
        return service.buscarPeloNome(nome);
    }

    //--------------------------------------------------------------
    // Buscar pelo Email
    @GetMapping("/usuario/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPeloEmail(@PathVariable String email){
        return service.buscarPeloNome(email);
    }

    //--------------------------------------------------------------
    // Buscar por Data De Nascimento

    @GetMapping("usuario/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> mostrarAniversariantes(@PathVariable LocalDate dataInicial,
                                                @PathVariable LocalDate dataFinal) {

        return service.mostrarAniversariantes(dataInicial, dataFinal);
    }


}
