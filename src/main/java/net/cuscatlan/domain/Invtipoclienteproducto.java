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
import net.cuscatlan.domain.Invproducto;
import net.cuscatlan.domain.Invtipocliente;

@Entity
@Setter
@Getter
@Table(name = "INVTIPOCLIENTEPRODUCTO")
public class Invtipoclienteproducto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDCLIENTEPRODUCTO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVTIPOCLIENTEPRODUCTO")
    @SequenceGenerator(name="SEQ_INVTIPOCLIENTEPRODUCTO",sequenceName="SEQ_INVTIPOCLIENTEPRODUCTO")
    Integer idclienteproducto;



    @Column(name = "DESCUENTOCLIENTEPRODUCTO", nullable = true)
    @JsonView
    String descuentoclienteproducto;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")})
    Invproducto invproducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDTIPOCLIENTE", referencedColumnName = "IDTIPOCLIENTE")})
    Invtipocliente invtipocliente;


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

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipoclienteDelegate(){
        return (this.invtipocliente== null) ? null : this.invtipocliente.getIdtipocliente();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipoclienteDescriptionDelegate(){
        return (this.invtipocliente== null) ? null : this.invtipocliente.getIdtipocliente();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvtipoclienteDelegate(    Integer  idtipocliente){
        if (idtipocliente == null) {
             this.invtipocliente = null;
        }else {
             this.invtipocliente = new Invtipocliente();
             this.invtipocliente.setIdtipocliente(idtipocliente);
         }
    }


}

