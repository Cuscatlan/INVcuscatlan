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
import net.cuscatlan.domain.Invcliente;
import net.cuscatlan.domain.Invproveedor;
import net.cuscatlan.domain.Invusuario;

@Entity
@Setter
@Getter
@Table(name = "INVDIRECCION")
public class Invdireccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDDIRECCION", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVDIRECCION")
    @SequenceGenerator(name="SEQ_INVDIRECCION",sequenceName="SEQ_INVDIRECCION")
    Integer iddireccion;



    @Column(name = "DESCRIPCIONDIRECCION",length =100, nullable = true)
    @JsonView
    String descripciondireccion;


    @Column(name = "LUGARDIRECCION",length =25, nullable = true)
    @JsonView
    String lugardireccion;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")})
    Invcliente invcliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDPROVEEDOR", referencedColumnName = "IDPROVEEDOR")})
    Invproveedor invproveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")})
    Invusuario invusuario;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvclienteDelegate(){
        return (this.invcliente== null) ? null : this.invcliente.getIdcliente();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvclienteDescriptionDelegate(){
        return (this.invcliente== null) ? null : this.invcliente.getIdcliente();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvclienteDelegate(    Integer  idcliente){
        if (idcliente == null) {
             this.invcliente = null;
        }else {
             this.invcliente = new Invcliente();
             this.invcliente.setIdcliente(idcliente);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvproveedorDelegate(){
        return (this.invproveedor== null) ? null : this.invproveedor.getIdproveedor();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvproveedorDescriptionDelegate(){
        return (this.invproveedor== null) ? null : this.invproveedor.getIdproveedor();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvproveedorDelegate(    Integer  idproveedor){
        if (idproveedor == null) {
             this.invproveedor = null;
        }else {
             this.invproveedor = new Invproveedor();
             this.invproveedor.setIdproveedor(idproveedor);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvusuarioDelegate(){
        return (this.invusuario== null) ? null : this.invusuario.getIdusuario();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvusuarioDescriptionDelegate(){
        return (this.invusuario== null) ? null : this.invusuario.getIdusuario();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvusuarioDelegate(    Integer  idusuario){
        if (idusuario == null) {
             this.invusuario = null;
        }else {
             this.invusuario = new Invusuario();
             this.invusuario.setIdusuario(idusuario);
         }
    }


}

