package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtipousuario;
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

public interface InvtipousuarioRepository extends JpaRepository <Invtipousuario,    Integer >,PagingAndSortingRepository<Invtipousuario,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtipousuario x "
            + "WHERE"  
            + "  (:idtipousuario is null or :idtipousuario = x.idtipousuario )   "
            + " and (:rollusuario is null or x.rollusuario = :rollusuario ) "
            + " ORDER BY x.idtipousuario ASC ")
     Page<Invtipousuario> findByFilters(Pageable page  ,@Param("idtipousuario")  String idtipousuario ,@Param("rollusuario")  String rollusuario);

    @Query(value ="SELECT  x.IDTIPOUSUARIO  ,  x.ROLLUSUARIO  "
            + " FROM INVTIPOUSUARIO x "
            + "WHERE"  
            + "  (:idtipousuario is null or :idtipousuario = x.IDTIPOUSUARIO )   "
            + " and (:rollusuario is null or x.ROLLUSUARIO = :rollusuario ) "
            + " ORDER BY x.IDTIPOUSUARIO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idtipousuario")  String idtipousuario ,@Param("rollusuario")  String rollusuario);

}

