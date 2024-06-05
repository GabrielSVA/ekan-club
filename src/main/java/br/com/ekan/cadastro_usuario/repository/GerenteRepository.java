package br.com.ekan.cadastro_usuario.repository;

import br.com.ekan.cadastro_usuario.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente,String> {
    UserDetails findByLogin(String login);

}
