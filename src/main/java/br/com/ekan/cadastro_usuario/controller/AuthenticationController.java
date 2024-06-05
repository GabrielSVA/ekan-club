package br.com.ekan.cadastro_usuario.controller;

import br.com.ekan.cadastro_usuario.dto.AuthenticationDTO;
import br.com.ekan.cadastro_usuario.dto.LoginResponseDTO;
import br.com.ekan.cadastro_usuario.dto.RegisterDTO;
import br.com.ekan.cadastro_usuario.infra.TokenService;
import br.com.ekan.cadastro_usuario.model.Gerente;
import br.com.ekan.cadastro_usuario.repository.GerenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private GerenteRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data){
       var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
       var auth = this.authenticationManager.authenticate(userNamePassword);

       var token = tokenService.generateToken((Gerente) auth.getPrincipal());
       return  ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login())!= null) return ResponseEntity.badRequest().build();
        String ecryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Gerente gerente = new Gerente(data.login(), ecryptedPassword,data.role());

        this.repository.save(gerente);
        return  ResponseEntity.ok().build();

    }


}
