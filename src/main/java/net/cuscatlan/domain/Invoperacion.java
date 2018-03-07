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
import net.cuscatlan.domain.Invproveedor;
import net.cuscatlan.domain.Invcliente;
import net.cuscatlan.domain.Invtipooperaciones;
import net.cuscatlan.domain.Invoperaciondetalle;

@Entity
@Setter
@Getter
@Table(name = "INVOPERACION")
public class Invoperacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDOPERACION", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVOPERACION")
    @SequenceGenerator(name="SEQ_INVOPERACION",sequenceName="SEQ_INVOPERACION")
    Integer idoperacion;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "FECHAENTREGA", nullable = true)
    @JsonView
    Date fechaentrega;


    @Column(name = "NUMEROENVIOORDEN",length =10, nullable = true)
    @JsonView
    String numeroenvioorden;


    @Column(name = "RECERVADOOPERACION",length =2, nullable = true)
    @JsonView
    String recervadooperacion;


    @Column(name = "NUMEROORDENCOMPRA",length =10, nullable = true)
    @JsonView
    String numeroordencompra;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "FECHAOPERACION", nullable = true)
    @JsonView
    Date fechaoperacion;


    @Column(name = "NUMERODOCUMENTO",length =10, nullable = true)
    @JsonView
    String numerodocumento;


    @Column(name = "ORDENENTREGADA",length =2, nullable = true)
    @JsonView
    String ordenentregada;


    @Column(name = "ESTADOOPERACION",length =2, nullable = true)
    @JsonView
    String estadooperacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "FECHACONTABLEOPERACION", nullable = true)
    @JsonView
    Date fechacontableoperacion;


    @Column(name = "DIASCREDITOOPERACION", nullable = true)
    @JsonView
    Integer diascreditooperacion;


    @Column(name = "COMENTARIOSOPERACION",length =100, nullable = true)
    @JsonView
    String comentariosoperacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "FECHAIVAOPERACION", nullable = true)
    @JsonView
    Date fechaivaoperacion;


    @Column(name = "ORDENRECIBIDA",length =2, nullable = true)
    @JsonView
    String ordenrecibida;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDPROVEEDOR", referencedColumnName = "IDPROVEEDOR")})
    Invproveedor invproveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")})
    Invcliente invcliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDTIPOOPERACIONES", referencedColumnName = "IDTIPOOPERACIONES")})
    Invtipooperaciones invtipooperaciones;

    @OneToMany(mappedBy = "invoperacion", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invoperaciondetalle> invoperaciondetalles;


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
    public    Integer getInvtipooperacionesDelegate(){
        return (this.invtipooperaciones== null) ? null : this.invtipooperaciones.getIdtipooperaciones();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getInvtipooperacionesDescriptionDelegate(){
        return (this.invtipooperaciones== null) ? null : this.invtipooperaciones.getIdtipooperaciones();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setInvtipooperacionesDelegate(    Integer  idtipooperaciones){
        if (idtipooperaciones == null) {
             this.invtipooperaciones = null;
        }else {
             this.invtipooperaciones = new Invtipooperaciones();
             this.invtipooperaciones.setIdtipooperaciones(idtipooperaciones);
         }
    }


}

