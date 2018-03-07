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
import net.cuscatlan.domain.Invfamiliaproducto;
import net.cuscatlan.domain.Invtipoproducto;
import net.cuscatlan.domain.Invoperaciondetalle;
import net.cuscatlan.domain.Invtipoclienteproducto;

@Entity
@Setter
@Getter
@Table(name = "INVPRODUCTO")
public class Invproducto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDPRODUCTO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVPRODUCTO")
    @SequenceGenerator(name="SEQ_INVPRODUCTO",sequenceName="SEQ_INVPRODUCTO")
    Integer idproducto;



    @Column(name = "PORCENTAJE1", nullable = true)
    @JsonView
    String porcentaje1;


    @Column(name = "NOMBREPRODUCTO",length =100, nullable = true)
    @JsonView
    String nombreproducto;


    @Column(name = "PRECIOVENTA3", nullable = true)
    @JsonView
    String precioventa3;


    @Column(name = "GRAVADO", nullable = true)
    @JsonView
    String gravado;


    @Column(name = "IMAGEN", nullable = true)
    @JsonView
    Byte[] imagen;


    @Column(name = "CODIGOPRODUCTO",length =100, nullable = true)
    @JsonView
    String codigoproducto;


    @Column(name = "PRECIOVENTA4", nullable = true)
    @JsonView
    String precioventa4;


    @Column(name = "PRECIOCOSTO", nullable = true)
    @JsonView
    String preciocosto;


    @Column(name = "PORCENTAJE2", nullable = true)
    @JsonView
    String porcentaje2;


    @Column(name = "PRESENTACION", nullable = true)
    @JsonView
    String presentacion;


    @Column(name = "PORCENTAJE", nullable = true)
    @JsonView
    String porcentaje;


    @Column(name = "PRECIOPROMEDIO", nullable = true)
    @JsonView
    String preciopromedio;


    @Column(name = "DESCUENTO", nullable = true)
    @JsonView
    String descuento;


    @Column(name = "PORCENTAJE4", nullable = true)
    @JsonView
    String porcentaje4;


    @Column(name = "UBICACIONFISICA",length =100, nullable = true)
    @JsonView
    String ubicacionfisica;


    @Column(name = "COSTO", nullable = true)
    @JsonView
    String costo;


    @Column(name = "PORCENTAJE3", nullable = true)
    @JsonView
    String porcentaje3;


    @Column(name = "PRECIOVENTA2", nullable = true)
    @JsonView
    String precioventa2;


    @Column(name = "PRECIOVENTA1", nullable = true)
    @JsonView
    String precioventa1;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDFAMILIAPRODUCTO", referencedColumnName = "IDFAMILIAPRODUCTO")})
    Invfamiliaproducto invfamiliaproducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDTIPOPRODUCTO", referencedColumnName = "IDTIPOPRODUCTO")})
    Invtipoproducto invtipoproducto;

    @OneToMany(mappedBy = "invproducto", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invoperaciondetalle> invoperaciondetalles;

    @OneToMany(mappedBy = "invproducto", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invtipoclienteproducto> invtipoclienteproductos;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvfamiliaproductoDelegate(){
        return (this.invfamiliaproducto== null) ? null : this.invfamiliaproducto.getIdfamiliaproducto();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvfamiliaproductoDescriptionDelegate(){
        return (this.invfamiliaproducto== null) ? null : this.invfamiliaproducto.getIdfamiliaproducto();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvfamiliaproductoDelegate(    Integer  idfamiliaproducto){
        if (idfamiliaproducto == null) {
             this.invfamiliaproducto = null;
        }else {
             this.invfamiliaproducto = new Invfamiliaproducto();
             this.invfamiliaproducto.setIdfamiliaproducto(idfamiliaproducto);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipoproductoDelegate(){
        return (this.invtipoproducto== null) ? null : this.invtipoproducto.getIdtipoproducto();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipoproductoDescriptionDelegate(){
        return (this.invtipoproducto== null) ? null : this.invtipoproducto.getIdtipoproducto();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvtipoproductoDelegate(    Integer  idtipoproducto){
        if (idtipoproducto == null) {
             this.invtipoproducto = null;
        }else {
             this.invtipoproducto = new Invtipoproducto();
             this.invtipoproducto.setIdtipoproducto(idtipoproducto);
         }
    }


}

