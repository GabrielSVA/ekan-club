package br.com.ekan.cadastro_usuario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documentos")
public class Documento {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
       private String tipoDocumento;
       private String descricao;
       private LocalDate dataInclusao;
       private LocalDate dataAtualizacao;


    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    @JsonBackReference
    private Beneficiario beneficiario;


    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

}
