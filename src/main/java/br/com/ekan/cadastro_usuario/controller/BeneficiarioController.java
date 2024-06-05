package br.com.ekan.cadastro_usuario.controller;


import br.com.ekan.cadastro_usuario.model.Beneficiario;
import br.com.ekan.cadastro_usuario.model.Documento;
import br.com.ekan.cadastro_usuario.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ekan-club")
@Tag(name= "ekan-club")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Lista de beneficiários recuperada com sucesso"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @Operation(summary = "Traz todos os usuários cadastrados no banco", method = "GET")
    @GetMapping("/beneficiarios")
    public ResponseEntity<List<Beneficiario>> getBeneficiarios() {
        try {
            List<Beneficiario> beneficiarios = beneficiarioService.findAll();
            return ResponseEntity.ok(beneficiarios);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @Operation(summary = "Traz os usuários cadastrados  filtrados por ID", method = "GET")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")    })
    @GetMapping("/beneficiarios/{id}")
    public ResponseEntity<Beneficiario> beneficiariosPorID(@PathVariable("id") Long id) {
        try {
            Optional<Beneficiario> beneficiario = beneficiarioService.findById(id);
            if (beneficiario.isPresent()) {
                return ResponseEntity.ok(beneficiario.get());
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @Operation(summary = "Traz os documentos dos usuários  filtrados por ID de usuário", method = "GET")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "Documentos não encontrados"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/beneficiarios/documentos/{beneficiarioId}")
    public ResponseEntity<List<Documento>> listarDocumentos(@PathVariable Long beneficiarioId) {
        try {
            Optional<List<Documento>> documentos = beneficiarioService.findDocumentsById(beneficiarioId);
            if (documentos.isPresent()) {
                return ResponseEntity.ok(documentos.get());
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @Operation(summary = "Atualiza os dados dos usuários cadastrados", method = "PUT")
    @PutMapping("/beneficiarios/update/{beneficiarioID}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long beneficiarioID, @RequestBody Beneficiario updatedBeneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.updateBeneficiario(beneficiarioID, updatedBeneficiario);
        return ResponseEntity.ok(savedBeneficiario);
    }


    @Operation(summary = "Deleta um beneficiário selecionado por ID", method = "DELETE")
    @DeleteMapping("/beneficiarios/delete/{beneficiarioID}")
    public ResponseEntity<Beneficiario> delete(@PathVariable long beneficiarioID){
        beneficiarioService.delete(beneficiarioID);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Adiciona um novo usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Beneficiário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/beneficiarios/save")
    public ResponseEntity<Beneficiario> save(@Valid @RequestBody Beneficiario beneficiario) {
        try {
            Beneficiario beneficiariosalvo = beneficiarioService.save(beneficiario);
            return ResponseEntity.status(HttpStatus.CREATED).body(beneficiariosalvo);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
