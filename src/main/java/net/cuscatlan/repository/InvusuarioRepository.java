package net.cuscatlan.repository;

import net.cuscatlan.domain.Invusuario;
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

public interface InvusuarioRepository extends JpaRepository <Invusuario,    Integer >,PagingAndSortingRepository<Invusuario,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invusuario x "
            + "WHERE"  
            + "  (:idusuario is null or :idusuario = x.idusuario )   "
            + " and (:nombreusuario is null or x.nombreusuario = :nombreusuario ) "
            + " and (:duiusuario is null or x.duiusuario = :duiusuario ) "
            + " and (:claveusuario is null or x.claveusuario = :claveusuario ) "
            + " and (:correousuario is null or x.correousuario = :correousuario ) "
            + " and (:profecionusuario is null or x.profecionusuario = :profecionusuario ) "
            + " and  (:fkidtipousuarioinvtipousuario is null or :fkidtipousuarioinvtipousuario = x.invtipousuario.idtipousuario) "
            + " ORDER BY x.idusuario ASC ")
     Page<Invusuario> findByFilters(Pageable page  ,@Param("idusuario")  String idusuario ,@Param("nombreusuario")  String nombreusuario ,@Param("duiusuario")  String duiusuario ,@Param("claveusuario")  String claveusuario ,@Param("correousuario")  String correousuario ,@Param("profecionusuario")  String profecionusuario ,@Param("fkidtipousuarioinvtipousuario")  String fkidtipousuarioinvtipousuario);

    @Query(value ="SELECT  x.IDUSUARIO  ,  x.NOMBREUSUARIO  ,  x.DUIUSUARIO  ,  x.CLAVEUSUARIO  ,  x.CORREOUSUARIO  ,  x.PROFECIONUSUARIO  ,  x.IDTIPOUSUARIO  "
            + " FROM INVUSUARIO x "
            + "WHERE"  
            + "  (:idusuario is null or :idusuario = x.IDUSUARIO )   "
            + " and (:nombreusuario is null or x.NOMBREUSUARIO = :nombreusuario ) "
            + " and (:duiusuario is null or x.DUIUSUARIO = :duiusuario ) "
            + " and (:claveusuario is null or x.CLAVEUSUARIO = :claveusuario ) "
            + " and (:correousuario is null or x.CORREOUSUARIO = :correousuario ) "
            + " and (:profecionusuario is null or x.PROFECIONUSUARIO = :profecionusuario ) "
            + " and  (:fkidtipousuarioinvtipousuario is null or :fkidtipousuarioinvtipousuario = x.IDTIPOUSUARIO) "
            + " ORDER BY x.IDUSUARIO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idusuario")  String idusuario ,@Param("nombreusuario")  String nombreusuario ,@Param("duiusuario")  String duiusuario ,@Param("claveusuario")  String claveusuario ,@Param("correousuario")  String correousuario ,@Param("profecionusuario")  String profecionusuario ,@Param("fkidtipousuarioinvtipousuario")  String fkidtipousuarioinvtipousuario);
     
    @Query(value ="SELECT * FROM Invusuario WHERE  (:nombreusuario is null or  Invusuario.NOMBREUSUARIO = :nombreusuario )" ,nativeQuery=true)
    Invusuario findBynombre( @Param("nombreusuario")  String nombreusuario );
}

