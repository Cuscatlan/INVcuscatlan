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
import net.cuscatlan.domain.Invdireccion;
import net.cuscatlan.domain.Invoperacion;
import net.cuscatlan.domain.Invtelefono;

@Entity
@Setter
@Getter
@Table(name = "INVPROVEEDOR")
public class Invproveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDPROVEEDOR", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVPROVEEDOR")
    @SequenceGenerator(name="SEQ_INVPROVEEDOR",sequenceName="SEQ_INVPROVEEDOR")
    Integer idproveedor;



    @Column(name = "NOMBREPROVEEDOR",length =50, nullable = true)
    @JsonView
    String nombreproveedor;


    @Column(name = "CONTACTOPROVEEDOR",length =50, nullable = true)
    @JsonView
    String contactoproveedor;


    @Column(name = "REGISTROPROVEEDOR",length =25, nullable = true)
    @JsonView
    String registroproveedor;


    @Column(name = "ESPERSONAPROVEEDOR", nullable = true)
    @JsonView
    Integer espersonaproveedor;


    @Column(name = "GIROPROVEEDOR",length =100, nullable = true)
    @JsonView
    String giroproveedor;


    @Column(name = "NITPROVEEDOR",length =17, nullable = true)
    @JsonView
    String nitproveedor;


    @Column(name = "TIPOCONTRIBUYENTEPROVEEDOR",length =10, nullable = true)
    @JsonView
    String tipocontribuyenteproveedor;


    @Column(name = "DUIPROVEEDOR",length =10, nullable = true)
    @JsonView
    String duiproveedor;


    @OneToMany(mappedBy = "invproveedor", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invdireccion> invdireccions;

    @OneToMany(mappedBy = "invproveedor", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invoperacion> invoperacions;

    @OneToMany(mappedBy = "invproveedor", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invtelefono> invtelefonos;



}

