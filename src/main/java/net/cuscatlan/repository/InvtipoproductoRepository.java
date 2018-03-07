package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtipoproducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvtipoproductoRepository extends JpaRepository <Invtipoproducto,    Integer >,PagingAndSortingRepository<Invtipoproducto,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtipoproducto x "
            + "WHERE"  
            + "  (:idtipoproducto is null or :idtipoproducto = x.idtipoproducto )   "
            + " and (:estadotipoproducto is null or x.estadotipoproducto = :estadotipoproducto ) "
            + " and (:nombretipoproducto is null or x.nombretipoproducto = :nombretipoproducto ) "
            + " ORDER BY x.idtipoproducto ASC ")
     Page<Invtipoproducto> findByFilters(Pageable page  ,@Param("idtipoproducto")  String idtipoproducto ,@Param("estadotipoproducto")  String estadotipoproducto ,@Param("nombretipoproducto")  String nombretipoproducto);

    @Query(value ="SELECT  x.IDTIPOPRODUCTO  ,  x.ESTADOTIPOPRODUCTO  ,  x.NOMBRETIPOPRODUCTO  "
            + " FROM INVTIPOPRODUCTO x "
            + "WHERE"  
            + "  (:idtipoproducto is null or :idtipoproducto = x.IDTIPOPRODUCTO )   "
            + " and (:estadotipoproducto is null or x.ESTADOTIPOPRODUCTO = :estadotipoproducto ) "
            + " and (:nombretipoproducto is null or x.NOMBRETIPOPRODUCTO = :nombretipoproducto ) "
            + " ORDER BY x.IDTIPOPRODUCTO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idtipoproducto")  String idtipoproducto ,@Param("estadotipoproducto")  String estadotipoproducto ,@Param("nombretipoproducto")  String nombretipoproducto);

}

