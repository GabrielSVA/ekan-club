package br.com.ekan.cadastro_usuario.service;


import br.com.ekan.cadastro_usuario.model.Beneficiario;
import br.com.ekan.cadastro_usuario.model.Documento;
import br.com.ekan.cadastro_usuario.repository.BeneficiarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;


    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
    }

    public Optional<Beneficiario> findById(Long id) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);
        if (beneficiarioOptional.isPresent()) {
            return beneficiarioOptional;
        }
        return Optional.empty();
    }


    @Transactional
    public Optional<List<Documento>> findDocumentsById(Long id) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);
        if (beneficiarioOptional.isPresent()) {
            return Optional.of(beneficiarioOptional.get().getDocumentos());
        }
        return Optional.empty();
    }


    public Beneficiario save( Beneficiario beneficiario){

        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(beneficiario.getId());
        if (beneficiarioOptional.isPresent()) {
            Beneficiario beneficiarioSalvo = beneficiarioOptional.get();

            // Atualizar os dados do beneficiário
            beneficiarioSalvo.setNome(beneficiario.getNome());
            beneficiarioSalvo.setTelefone(beneficiario.getTelefone());
            beneficiarioSalvo.setDataNascimento(beneficiario.getDataNascimento());
            beneficiarioSalvo.setDataInclusao(beneficiario.getDataInclusao());
            beneficiarioSalvo.setDataAtualizacao(beneficiario.getDataAtualizacao());

            // Atualizar os documentos
            beneficiarioSalvo.getDocumentos().clear();
            beneficiarioSalvo.getDocumentos().addAll(beneficiario.getDocumentos());

            // Associar os documentos ao beneficiário
            for (Documento documento : beneficiarioSalvo.getDocumentos()) {
                documento.setBeneficiario(beneficiarioSalvo);
            }

            return beneficiarioRepository.save(beneficiarioSalvo);
        } else {
            // Se o beneficiário não existe, cria um novo beneficiário e associa os documentos
            for (Documento documento : beneficiario.getDocumentos()) {
                documento.setBeneficiario(beneficiario);
            }
            return beneficiarioRepository.save(beneficiario);
        }
        }




    public Beneficiario updateBeneficiario(Long id, Beneficiario updatedBeneficiario) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);

        if (beneficiarioOptional.isPresent()) {
            Beneficiario beneficiarioExistente = beneficiarioOptional.get();

            // Atualizar os campos do beneficiário
            beneficiarioExistente.setNome(updatedBeneficiario.getNome());
            beneficiarioExistente.setTelefone(updatedBeneficiario.getTelefone());
            beneficiarioExistente.setDataNascimento(updatedBeneficiario.getDataNascimento());
            beneficiarioExistente.setDataInclusao(updatedBeneficiario.getDataInclusao());
            beneficiarioExistente.setDataAtualizacao(updatedBeneficiario.getDataAtualizacao());

            // Atualizar os documentos
            beneficiarioExistente.getDocumentos().clear();
            beneficiarioExistente.getDocumentos().addAll(updatedBeneficiario.getDocumentos());

            // Associar os documentos ao beneficiário
            for (Documento documento : beneficiarioExistente.getDocumentos()) {
                documento.setBeneficiario(beneficiarioExistente);
            }

            return beneficiarioRepository.save(beneficiarioExistente);
        } else {
            throw new EntityNotFoundException("Beneficiario não encontrado " + id);
        }
    }

    public Beneficiario delete(long beneficiarioID) {
        Optional<Beneficiario> beneficiarioCadastrado = findById(beneficiarioID);
        if(beneficiarioCadastrado.isPresent()){
            Beneficiario beneficiario = beneficiarioCadastrado.get();
             beneficiarioRepository.deleteById(beneficiario.getId());
             return beneficiario;
        }{
            return null;
        }
    }
}
