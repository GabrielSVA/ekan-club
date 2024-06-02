package br.com.ekan.cadastro_usuario.repository;

import br.com.ekan.cadastro_usuario.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository  extends JpaRepository<Documento, Long> {
}
