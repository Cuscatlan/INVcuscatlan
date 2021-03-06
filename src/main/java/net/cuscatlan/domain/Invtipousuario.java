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
import net.cuscatlan.domain.Invusuario;

@Entity
@Setter
@Getter
@Table(name = "INVTIPOUSUARIO")
public class Invtipousuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IDTIPOUSUARIO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_INVTIPOUSUARIO")
    @SequenceGenerator(name="SEQ_INVTIPOUSUARIO",sequenceName="SEQ_INVTIPOUSUARIO")
    Integer idtipousuario;



    @Column(name = "ROLLUSUARIO",length =25, nullable = true)
    @JsonView
    String rollusuario;


    @OneToMany(mappedBy = "invtipousuario", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<Invusuario> invusuarios;



}

