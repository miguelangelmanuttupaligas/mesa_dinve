package dinve.mesa.model.formulario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dinve.mesa.model.Formulario;
import dinve.mesa.model.alineamiento_brecha_prioritaria.AlineamientoBrechaServiciosPublicosBrechaIdentificada;
import dinve.mesa.model.descripcion_agregada_ioarr.ResponsabilidadFuncionalDescripcionIOARR;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formulario5b")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formulario5B implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String nombre_idea;
    private String funcional_division;
    private String funcional_funcion;
    private String funcional_sector;
    private String funcional_grupo;
    private String uf_sector;
    private String uf_entidad;
    private String uf_nombre;
    private String uf_responsable;
    private String ufi_sector;
    private String ufi_entidad;
    private String ufi_nombre;
    private String ufi_responsable;
    private String ufp_sector;
    private String ufp_entidad;
    private String ufp_nombre;
    private String naturaleza_intervencion;
    private String localizacion_geografica;
    private int modalidad_ejecucion;
    private int fuente_financiamiento;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formulario")
    //@MapsId
    private Formulario formulario;

    @OneToMany(mappedBy = "formulario5b",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ResponsabilidadFuncionalDescripcionIOARR> ListaResponsabilidadFuncionalDescripcionIOARR = new ArrayList<>();
    @OneToMany(mappedBy = "formulario5b",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AlineamientoBrechaServiciosPublicosBrechaIdentificada> ListaAlineamientoBrechaServiciosPublicosBrechaIdentificada = new ArrayList<>();
    @OneToMany(mappedBy = "formulario5b",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Adjunto> ListaAdjunto = new ArrayList<>();

    public void addResponsabilidadFuncionalDescripcionIOARR(ResponsabilidadFuncionalDescripcionIOARR responsabilidadFuncionalDescripcionIOARR){
        ListaResponsabilidadFuncionalDescripcionIOARR.add(responsabilidadFuncionalDescripcionIOARR);
        responsabilidadFuncionalDescripcionIOARR.setFormulario5b(this);
    }
    public void addALineamientoBrechaServiciosPublicosBrechaIdentificada(AlineamientoBrechaServiciosPublicosBrechaIdentificada aLineamientoBrechaServiciosPublicosBrechaIdentificada){
        ListaAlineamientoBrechaServiciosPublicosBrechaIdentificada.add(aLineamientoBrechaServiciosPublicosBrechaIdentificada);
        aLineamientoBrechaServiciosPublicosBrechaIdentificada.setFormulario5b(this);
    }
    public void addAdjunto(Adjunto adjunto){
        ListaAdjunto.add(adjunto);
        adjunto.setFormulario5b(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario5B)) return false;
        return id != null && id.equals(((Formulario5B) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
