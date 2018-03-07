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

@Entity
@Setter
@Getter
@Table(name = "INVFAMILIAPRODUCTO")
public class Invfamiliaproducto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDFAMILIAPRODUCTO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVFAMILIAPRODUCTO")
    @SequenceGenerator(name="SEQ_INVFAMILIAPRODUCTO",sequenceName="SEQ_INVFAMILIAPRODUCTO")
    Integer idfamiliaproducto;



    @Column(name = "ESTADOFAMILIAPRODUCTO",length =2, nullable = true)
    @JsonView
    String estadofamiliaproducto;


    @Column(name = "NOMBREFAMILIAPRODUCTO",length =50, nullable = true)
    @JsonView
    String nombrefamiliaproducto;


    @Column(name = "IDGRUPOPRODUCTO", nullable = true)
    @JsonView
    Integer idgrupoproducto;


    @OneToMany(mappedBy = "invfamiliaproducto", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invproducto> invproductos;



}

