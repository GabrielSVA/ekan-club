package br.com.ekan.cadastro_usuario.controller;


import br.com.ekan.cadastro_usuario.model.Beneficiario;
import br.com.ekan.cadastro_usuario.model.Documento;
import br.com.ekan.cadastro_usuario.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Operation(summary = "Traz todos os usuários cadastrados no banco", method = "GET")
    @GetMapping("/beneficiarios")
    private List<Beneficiario> beneficiarios() {
        return beneficiarioService.findAll();
    }

    @Operation(summary = "Traz os usuários cadastrados  filtrados por ID", method = "GET")
    @GetMapping("/beneficiarios/{id}")
    private Optional<Beneficiario> beneficiariosPorID(@PathVariable("id") Long id) {
        return beneficiarioService.findById(id);
    }


    @Operation(summary = "Traz os documentos dos usuários  filtrados por ID de usuário", method = "GET")
    @GetMapping("/beneficiarios/documentos/{beneficiarioId}")
     public Optional<List<Documento>> listarDocumentos(@PathVariable Long beneficiarioId) {
        return beneficiarioService.findDocumentsById(beneficiarioId);
    }

    @Operation(summary = "Atualiza os dados dos usuários cadastrados", method = "PUT")
    @PutMapping("/beneficiarios/update/{beneficiarioID}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long beneficiarioID, @RequestBody Beneficiario updatedBeneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.updateBeneficiario(beneficiarioID, updatedBeneficiario);
        return ResponseEntity.ok(savedBeneficiario);
    }


    @Operation(summary = "Deleta um beneficiário selecionado por ID", method = "DELETE")
    @DeleteMapping("/beneficiarios/{beneficiarioID}")
    public ResponseEntity<Beneficiario> delete(@PathVariable long beneficiarioID){
        beneficiarioService.delete(beneficiarioID);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Adiciona um novo usuário", method = "POST")
    @PostMapping("/beneficiarios/save")
    public ResponseEntity<Beneficiario> save(@RequestBody Beneficiario beneficiario) {
        Beneficiario beneficiariosalvo = beneficiarioService.save(beneficiario);
        return ResponseEntity.ok(beneficiariosalvo);
    }


}
