package net.cuscatlan.repository;

import net.cuscatlan.domain.Invfamiliaproducto;
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

public interface InvfamiliaproductoRepository extends JpaRepository <Invfamiliaproducto,    Integer >,PagingAndSortingRepository<Invfamiliaproducto,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invfamiliaproducto x "
            + "WHERE"  
            + "  (:idfamiliaproducto is null or :idfamiliaproducto = x.idfamiliaproducto )   "
            + " and (:estadofamiliaproducto is null or x.estadofamiliaproducto = :estadofamiliaproducto ) "
            + " and (:nombrefamiliaproducto is null or x.nombrefamiliaproducto = :nombrefamiliaproducto ) "
            + " and (:idgrupoproducto is null or x.idgrupoproducto = :idgrupoproducto ) "
            + " ORDER BY x.idfamiliaproducto ASC ")
     Page<Invfamiliaproducto> findByFilters(Pageable page  ,@Param("idfamiliaproducto")  String idfamiliaproducto ,@Param("estadofamiliaproducto")  String estadofamiliaproducto ,@Param("nombrefamiliaproducto")  String nombrefamiliaproducto ,@Param("idgrupoproducto")  String idgrupoproducto);

    @Query(value ="SELECT  x.IDFAMILIAPRODUCTO  ,  x.ESTADOFAMILIAPRODUCTO  ,  x.NOMBREFAMILIAPRODUCTO  ,  x.IDGRUPOPRODUCTO  "
            + " FROM INVFAMILIAPRODUCTO x "
            + "WHERE"  
            + "  (:idfamiliaproducto is null or :idfamiliaproducto = x.IDFAMILIAPRODUCTO )   "
            + " and (:estadofamiliaproducto is null or x.ESTADOFAMILIAPRODUCTO = :estadofamiliaproducto ) "
            + " and (:nombrefamiliaproducto is null or x.NOMBREFAMILIAPRODUCTO = :nombrefamiliaproducto ) "
            + " and (:idgrupoproducto is null or x.IDGRUPOPRODUCTO = :idgrupoproducto ) "
            + " ORDER BY x.IDFAMILIAPRODUCTO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idfamiliaproducto")  String idfamiliaproducto ,@Param("estadofamiliaproducto")  String estadofamiliaproducto ,@Param("nombrefamiliaproducto")  String nombrefamiliaproducto ,@Param("idgrupoproducto")  String idgrupoproducto);

}

