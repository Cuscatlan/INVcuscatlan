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

@Entity
@Setter
@Getter
@Table(name = "INVTIPOOPERACIONES")
public class Invtipooperaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDTIPOOPERACIONES", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVTIPOOPERACIONES")
    @SequenceGenerator(name="SEQ_INVTIPOOPERACIONES",sequenceName="SEQ_INVTIPOOPERACIONES")
    Integer idtipooperaciones;



    @Column(name = "MOSTRARREPORTES",length =1, nullable = true)
    @JsonView
    String mostrarreportes;


    @Column(name = "IMPRESORTIPO",length =100, nullable = true)
    @JsonView
    String impresortipo;


    @Column(name = "SUMATIPO",length =2, nullable = true)
    @JsonView
    String sumatipo;


    @Column(name = "NOMBRETIPOOPERACION",length =50, nullable = true)
    @JsonView
    String nombretipooperacion;


    @Column(name = "SIGLASTIPOOPERACION",length =3, nullable = true)
    @JsonView
    String siglastipooperacion;


    @Column(name = "IVENTARIOTIPOOPERACION",length =2, nullable = true)
    @JsonView
    String iventariotipooperacion;


    @Column(name = "TIPOOPERACION",length =2, nullable = true)
    @JsonView
    String tipooperacion;


    @OneToMany(mappedBy = "invtipooperaciones", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invoperacion> invoperacions;



}

