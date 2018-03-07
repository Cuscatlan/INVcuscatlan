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
@Table(name = "INVTIPOPRODUCTO")
public class Invtipoproducto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDTIPOPRODUCTO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVTIPOPRODUCTO")
    @SequenceGenerator(name="SEQ_INVTIPOPRODUCTO",sequenceName="SEQ_INVTIPOPRODUCTO")
    Integer idtipoproducto;



    @Column(name = "ESTADOTIPOPRODUCTO",length =1, nullable = true)
    @JsonView
    String estadotipoproducto;


    @Column(name = "NOMBRETIPOPRODUCTO",length =15, nullable = true)
    @JsonView
    String nombretipoproducto;


    @OneToMany(mappedBy = "invtipoproducto", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invproducto> invproductos;



}

