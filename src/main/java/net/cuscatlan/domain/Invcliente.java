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
import net.cuscatlan.domain.Invtipocliente;
import net.cuscatlan.domain.Invdireccion;
import net.cuscatlan.domain.Invoperacion;
import net.cuscatlan.domain.Invtelefono;

@Entity
@Setter
@Getter
@Table(name = "INVCLIENTE")
public class Invcliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDCLIENTE", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVCLIENTE")
    @SequenceGenerator(name="SEQ_INVCLIENTE",sequenceName="SEQ_INVCLIENTE")
    Integer idcliente;



    @Column(name = "NOMBRECLIENTE",length =100, nullable = true)
    @JsonView
    String nombrecliente;


    @Column(name = "DUICLIENTE",length =10, nullable = true)
    @JsonView
    String duicliente;


    @Column(name = "NITCLIENTE",length =17, nullable = true)
    @JsonView
    String nitcliente;


    @Column(name = "ESPERSONACLIENTE", nullable = true)
    @JsonView
    Integer espersonacliente;


    @Column(name = "GIROCLIENTE",length =100, nullable = true)
    @JsonView
    String girocliente;


    @Column(name = "CREDITOCLIENTE",scale = 2, precision = 8, nullable = true)
    @JsonView
    BigDecimal creditocliente;


    @Column(name = "REGISTROCLIENTE",length =25, nullable = true)
    @JsonView
    String registrocliente;


    @Column(name = "DIASCREDITOCLIENTE", nullable = true)
    @JsonView
    Integer diascreditocliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "IDTIPOCLIENTE", referencedColumnName = "IDTIPOCLIENTE")})
    Invtipocliente invtipocliente;

    @OneToMany(mappedBy = "invcliente", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invdireccion> invdireccions;

    @OneToMany(mappedBy = "invcliente", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invoperacion> invoperacions;

    @OneToMany(mappedBy = "invcliente", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invtelefono> invtelefonos;


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

