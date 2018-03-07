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
import net.cuscatlan.domain.Invtipoclienteproducto;

@Entity
@Setter
@Getter
@Table(name = "INVTIPOCLIENTE")
public class Invtipocliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDTIPOCLIENTE", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVTIPOCLIENTE")
    @SequenceGenerator(name="SEQ_INVTIPOCLIENTE",sequenceName="SEQ_INVTIPOCLIENTE")
    Integer idtipocliente;



    @Column(name = "DESCRIPCION",length =25, nullable = true)
    @JsonView
    String descripcion;


    @OneToMany(mappedBy = "invtipocliente", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invcliente> invclientes;

    @OneToMany(mappedBy = "invtipocliente", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invtipoclienteproducto> invtipoclienteproductos;



}

