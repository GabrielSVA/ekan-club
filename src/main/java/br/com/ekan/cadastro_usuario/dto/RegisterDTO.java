package br.com.ekan.cadastro_usuario.dto;

import br.com.ekan.cadastro_usuario.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
