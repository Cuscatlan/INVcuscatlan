package net.cuscatlan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import net.cuscatlan.domain.Invtipousuario;
import net.cuscatlan.domain.Invdireccion;
import net.cuscatlan.domain.Invtelefono;

@Entity
@Setter
@Getter
@Table(name = "INVUSUARIO")
public class Invusuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDUSUARIO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVUSUARIO")
    @SequenceGenerator(name="SEQ_INVUSUARIO",sequenceName="SEQ_INVUSUARIO")
    Integer idusuario;



    @Column(name = "NOMBREUSUARIO",length =50, nullable = true)
    @JsonView
    String nombreusuario;


    @Column(name = "DUIUSUARIO",length =10, nullable = true)
    @JsonView
    String duiusuario;


    @Column(name = "CLAVEUSUARIO",length =100, nullable = true)
    @JsonView
    String claveusuario;


    @Column(name = "CORREOUSUARIO",length =50, nullable = true)
    @JsonView
    String correousuario;


    @Column(name = "PROFECIONUSUARIO",length =10, nullable = true)
    @JsonView
    String profecionusuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDTIPOUSUARIO", referencedColumnName = "IDTIPOUSUARIO")})
    Invtipousuario invtipousuario;

    @OneToMany(mappedBy = "invusuario", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invdireccion> invdireccions;

    @OneToMany(mappedBy = "invusuario", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invtelefono> invtelefonos;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipousuarioDelegate(){
        return (this.invtipousuario== null) ? null : this.invtipousuario.getIdtipousuario();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipousuarioDescriptionDelegate(){
        return (this.invtipousuario== null) ? null : this.invtipousuario.getIdtipousuario();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvtipousuarioDelegate(    Integer  idtipousuario){
        if (idtipousuario == null) {
             this.invtipousuario = null;
        }else {
             this.invtipousuario = new Invtipousuario();
             this.invtipousuario.setIdtipousuario(idtipousuario);
         }
    }


}

