package br.com.ekan.cadastro_usuario.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


// record desenvolvido porém não utilizado por não se fazer necessário para o escopo da aplicação.
public record BeneficiarioDTO(
        Long id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        LocalDate dataInclusao,
        LocalDate dataAtualizacao,
        List<Set<DocumentoDTO>> documentos) {}
