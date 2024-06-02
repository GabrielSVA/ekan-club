package br.com.ekan.cadastro_usuario.service;

import br.com.ekan.cadastro_usuario.model.Documento;
import br.com.ekan.cadastro_usuario.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DocumentoService {


    private DocumentoRepository documentoRepository;

    // @Transactional(rollbackFor = Exception.class)
    public List<Documento> save(List<Documento> documentos) {
        return documentoRepository.saveAll(documentos);
    }
}
