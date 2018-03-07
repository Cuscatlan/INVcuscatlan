package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtipocliente;
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

public interface InvtipoclienteRepository extends JpaRepository <Invtipocliente,    Integer >,PagingAndSortingRepository<Invtipocliente,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtipocliente x "
            + "WHERE"  
            + "  (:idtipocliente is null or :idtipocliente = x.idtipocliente )   "
            + " and (:descripcion is null or x.descripcion = :descripcion ) "
            + " ORDER BY x.idtipocliente ASC ")
     Page<Invtipocliente> findByFilters(Pageable page  ,@Param("idtipocliente")  String idtipocliente ,@Param("descripcion")  String descripcion);

    @Query(value ="SELECT  x.IDTIPOCLIENTE  ,  x.DESCRIPCION  "
            + " FROM INVTIPOCLIENTE x "
            + "WHERE"  
            + "  (:idtipocliente is null or :idtipocliente = x.IDTIPOCLIENTE )   "
            + " and (:descripcion is null or x.DESCRIPCION = :descripcion ) "
            + " ORDER BY x.IDTIPOCLIENTE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idtipocliente")  String idtipocliente ,@Param("descripcion")  String descripcion);

}

