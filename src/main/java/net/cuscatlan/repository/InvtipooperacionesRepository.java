package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtipooperaciones;
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

public interface InvtipooperacionesRepository extends JpaRepository <Invtipooperaciones,    Integer >,PagingAndSortingRepository<Invtipooperaciones,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtipooperaciones x "
            + "WHERE"  
            + "  (:idtipooperaciones is null or :idtipooperaciones = x.idtipooperaciones )   "
            + " and (:mostrarreportes is null or x.mostrarreportes = :mostrarreportes ) "
            + " and (:impresortipo is null or x.impresortipo = :impresortipo ) "
            + " and (:sumatipo is null or x.sumatipo = :sumatipo ) "
            + " and (:nombretipooperacion is null or x.nombretipooperacion = :nombretipooperacion ) "
            + " and (:siglastipooperacion is null or x.siglastipooperacion = :siglastipooperacion ) "
            + " and (:iventariotipooperacion is null or x.iventariotipooperacion = :iventariotipooperacion ) "
            + " and (:tipooperacion is null or x.tipooperacion = :tipooperacion ) "
            + " ORDER BY x.idtipooperaciones ASC ")
     Page<Invtipooperaciones> findByFilters(Pageable page  ,@Param("idtipooperaciones")  String idtipooperaciones ,@Param("mostrarreportes")  String mostrarreportes ,@Param("impresortipo")  String impresortipo ,@Param("sumatipo")  String sumatipo ,@Param("nombretipooperacion")  String nombretipooperacion ,@Param("siglastipooperacion")  String siglastipooperacion ,@Param("iventariotipooperacion")  String iventariotipooperacion ,@Param("tipooperacion")  String tipooperacion);

    @Query(value ="SELECT  x.IDTIPOOPERACIONES  ,  x.MOSTRARREPORTES  ,  x.IMPRESORTIPO  ,  x.SUMATIPO  ,  x.NOMBRETIPOOPERACION  ,  x.SIGLASTIPOOPERACION  ,  x.IVENTARIOTIPOOPERACION  ,  x.TIPOOPERACION  "
            + " FROM INVTIPOOPERACIONES x "
            + "WHERE"  
            + "  (:idtipooperaciones is null or :idtipooperaciones = x.IDTIPOOPERACIONES )   "
            + " and (:mostrarreportes is null or x.MOSTRARREPORTES = :mostrarreportes ) "
            + " and (:impresortipo is null or x.IMPRESORTIPO = :impresortipo ) "
            + " and (:sumatipo is null or x.SUMATIPO = :sumatipo ) "
            + " and (:nombretipooperacion is null or x.NOMBRETIPOOPERACION = :nombretipooperacion ) "
            + " and (:siglastipooperacion is null or x.SIGLASTIPOOPERACION = :siglastipooperacion ) "
            + " and (:iventariotipooperacion is null or x.IVENTARIOTIPOOPERACION = :iventariotipooperacion ) "
            + " and (:tipooperacion is null or x.TIPOOPERACION = :tipooperacion ) "
            + " ORDER BY x.IDTIPOOPERACIONES ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idtipooperaciones")  String idtipooperaciones ,@Param("mostrarreportes")  String mostrarreportes ,@Param("impresortipo")  String impresortipo ,@Param("sumatipo")  String sumatipo ,@Param("nombretipooperacion")  String nombretipooperacion ,@Param("siglastipooperacion")  String siglastipooperacion ,@Param("iventariotipooperacion")  String iventariotipooperacion ,@Param("tipooperacion")  String tipooperacion);

}

