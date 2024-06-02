package br.com.ekan.cadastro_usuario.controller;


import br.com.ekan.cadastro_usuario.dto.BeneficiarioDTO;
import br.com.ekan.cadastro_usuario.model.Beneficiario;
import br.com.ekan.cadastro_usuario.model.Documento;
import br.com.ekan.cadastro_usuario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ekan-club")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    // funcionando
    @GetMapping("/beneficiarios/salvos")
    private List<Beneficiario> beneficiarios() {
        return beneficiarioService.findAll();
    }

    //funcionando
    @GetMapping("/beneficiarios/{id}")
    private Optional<Beneficiario> beneficiariosPorID(@PathVariable("id") Long id) {
        return beneficiarioService.findById(id);
    }


    // funcionando
    @GetMapping("/beneficiarios/documentos/{beneficiarioId}")
     public Optional<List<Documento>> listarDocumentos(@PathVariable Long beneficiarioId) {
        return beneficiarioService.findDocumentsById(beneficiarioId);
    }


    @PutMapping("/beneficiarios/update/{beneficiarioID}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long beneficiarioID, @RequestBody Beneficiario updatedBeneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.updateBeneficiario(beneficiarioID, updatedBeneficiario);
        return ResponseEntity.ok(savedBeneficiario);
    }


    //funcionando
    @DeleteMapping("/beneficiarios/{beneficiarioID}")
    public ResponseEntity<BeneficiarioDTO> delete(@PathVariable long beneficiarioID){
        beneficiarioService.delete(beneficiarioID);
        return ResponseEntity.noContent().build();
    }

    //funcionando
    @PostMapping("/beneficiarios/save")
    public ResponseEntity<Beneficiario> save(@RequestBody Beneficiario beneficiario) {
        Beneficiario beneficiariosalvo = beneficiarioService.save(beneficiario);
        return ResponseEntity.ok(beneficiariosalvo);
    }


}
