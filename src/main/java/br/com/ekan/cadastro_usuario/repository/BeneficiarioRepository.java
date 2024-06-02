package br.com.ekan.cadastro_usuario.repository;

import br.com.ekan.cadastro_usuario.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository <Beneficiario, Long>{

}
