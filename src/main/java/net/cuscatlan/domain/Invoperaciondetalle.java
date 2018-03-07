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
import net.cuscatlan.domain.Invoperacion;
import net.cuscatlan.domain.Invproducto;

@Entity
@Setter
@Getter
@Table(name = "INVOPERACIONDETALLE")
public class Invoperaciondetalle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDDETALLE", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVOPERACIONDETALLE")
    @SequenceGenerator(name="SEQ_INVOPERACIONDETALLE",sequenceName="SEQ_INVOPERACIONDETALLE")
    Integer iddetalle;



    @Column(name = "UNIDADESRECIVIDAS", nullable = true)
    @JsonView
    String unidadesrecividas;


    @Column(name = "FOVIALOPERACION", nullable = true)
    @JsonView
    String fovialoperacion;


    @Column(name = "LOTEDETALLE",length =25, nullable = true)
    @JsonView
    String lotedetalle;


    @Column(name = "PRECIOCOMPRA", nullable = true)
    @JsonView
    String preciocompra;


    @Column(name = "PRECIOORIGEN", nullable = true)
    @JsonView
    String precioorigen;


    @Column(name = "DESCUENTODETALLE", nullable = true)
    @JsonView
    String descuentodetalle;


    @Column(name = "UNIDADESVENDIDAS", nullable = true)
    @JsonView
    String unidadesvendidas;


    @Column(name = "IVADETALLE", nullable = true)
    @JsonView
    String ivadetalle;


    @Column(name = "PRECIOCIF", nullable = true)
    @JsonView
    String preciocif;


    @Column(name = "PRECIOPROMEDIO", nullable = true)
    @JsonView
    String preciopromedio;


    @Column(name = "UBICACIONFISICA",length =100, nullable = true)
    @JsonView
    String ubicacionfisica;


    @Column(name = "PRECIOVENTA", nullable = true)
    @JsonView
    String precioventa;


    @Column(name = "EXENTA", nullable = true)
    @JsonView
    String exenta;


    @Column(name = "GRAVADA", nullable = true)
    @JsonView
    String gravada;


    @Column(name = "UNIDADESORDENADAS", nullable = true)
    @JsonView
    String unidadesordenadas;


    @Column(name = "ISR", nullable = true)
    @JsonView
    String isr;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDOPERACION", referencedColumnName = "IDOPERACION")})
    Invoperacion invoperacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")})
    Invproducto invproducto;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvoperacionDelegate(){
        return (this.invoperacion== null) ? null : this.invoperacion.getIdoperacion();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvoperacionDescriptionDelegate(){
        return (this.invoperacion== null) ? null : this.invoperacion.getIdoperacion();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvoperacionDelegate(    Integer  idoperacion){
        if (idoperacion == null) {
             this.invoperacion = null;
        }else {
             this.invoperacion = new Invoperacion();
             this.invoperacion.setIdoperacion(idoperacion);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvproductoDelegate(){
        return (this.invproducto== null) ? null : this.invproducto.getIdproducto();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvproductoDescriptionDelegate(){
        return (this.invproducto== null) ? null : this.invproducto.getIdproducto();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvproductoDelegate(    Integer  idproducto){
        if (idproducto == null) {
             this.invproducto = null;
        }else {
             this.invproducto = new Invproducto();
             this.invproducto.setIdproducto(idproducto);
         }
    }


}

