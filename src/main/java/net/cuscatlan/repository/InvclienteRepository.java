package net.cuscatlan.repository;

import net.cuscatlan.domain.Invcliente;
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

public interface InvclienteRepository extends JpaRepository <Invcliente,    Integer >,PagingAndSortingRepository<Invcliente,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invcliente x "
            + "WHERE"  
            + "  (:idcliente is null or :idcliente = x.idcliente )   "
            + " and (:nombrecliente is null or x.nombrecliente = :nombrecliente ) "
            + " and (:duicliente is null or x.duicliente = :duicliente ) "
            + " and (:nitcliente is null or x.nitcliente = :nitcliente ) "
            + " and (:espersonacliente is null or x.espersonacliente = :espersonacliente ) "
            + " and (:girocliente is null or x.girocliente = :girocliente ) "
            + " and (:creditocliente is null or x.creditocliente = :creditocliente ) "
            + " and (:registrocliente is null or x.registrocliente = :registrocliente ) "
            + " and (:diascreditocliente is null or x.diascreditocliente = :diascreditocliente ) "
            + " and  (:fkidtipoclienteinvtipocliente is null or :fkidtipoclienteinvtipocliente = x.invtipocliente.idtipocliente) "
            + " ORDER BY x.idcliente ASC ")
     Page<Invcliente> findByFilters(Pageable page  ,@Param("idcliente")  String idcliente ,@Param("nombrecliente")  String nombrecliente ,@Param("duicliente")  String duicliente ,@Param("nitcliente")  String nitcliente ,@Param("espersonacliente")  String espersonacliente ,@Param("girocliente")  String girocliente ,@Param("creditocliente")  String creditocliente ,@Param("registrocliente")  String registrocliente ,@Param("diascreditocliente")  String diascreditocliente ,@Param("fkidtipoclienteinvtipocliente")  String fkidtipoclienteinvtipocliente);

    @Query(value ="SELECT  x.IDCLIENTE  ,  x.NOMBRECLIENTE  ,  x.DUICLIENTE  ,  x.NITCLIENTE  ,  x.ESPERSONACLIENTE  ,  x.GIROCLIENTE  ,  x.CREDITOCLIENTE  ,  x.REGISTROCLIENTE  ,  x.DIASCREDITOCLIENTE  ,  x.IDTIPOCLIENTE  "
            + " FROM INVCLIENTE x "
            + "WHERE"  
            + "  (:idcliente is null or :idcliente = x.IDCLIENTE )   "
            + " and (:nombrecliente is null or x.NOMBRECLIENTE = :nombrecliente ) "
            + " and (:duicliente is null or x.DUICLIENTE = :duicliente ) "
            + " and (:nitcliente is null or x.NITCLIENTE = :nitcliente ) "
            + " and (:espersonacliente is null or x.ESPERSONACLIENTE = :espersonacliente ) "
            + " and (:girocliente is null or x.GIROCLIENTE = :girocliente ) "
            + " and (:creditocliente is null or x.CREDITOCLIENTE = :creditocliente ) "
            + " and (:registrocliente is null or x.REGISTROCLIENTE = :registrocliente ) "
            + " and (:diascreditocliente is null or x.DIASCREDITOCLIENTE = :diascreditocliente ) "
            + " and  (:fkidtipoclienteinvtipocliente is null or :fkidtipoclienteinvtipocliente = x.IDTIPOCLIENTE) "
            + " ORDER BY x.IDCLIENTE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idcliente")  String idcliente ,@Param("nombrecliente")  String nombrecliente ,@Param("duicliente")  String duicliente ,@Param("nitcliente")  String nitcliente ,@Param("espersonacliente")  String espersonacliente ,@Param("girocliente")  String girocliente ,@Param("creditocliente")  String creditocliente ,@Param("registrocliente")  String registrocliente ,@Param("diascreditocliente")  String diascreditocliente ,@Param("fkidtipoclienteinvtipocliente")  String fkidtipoclienteinvtipocliente);

}

