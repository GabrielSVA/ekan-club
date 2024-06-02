package br.com.ekan.cadastro_usuario.dto;

import java.time.LocalDate;

public record DocumentoDTO( int id,
         String tipoDocumento,
         String descricao,
         LocalDate dataInclusao,
         LocalDate dataAtualizacao
        ) {
}
