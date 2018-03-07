package net.cuscatlan.repository;

import net.cuscatlan.domain.Invoperacion;
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

public interface InvoperacionRepository extends JpaRepository <Invoperacion,    Integer >,PagingAndSortingRepository<Invoperacion,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invoperacion x "
            + "WHERE"  
            + "  (:idoperacion is null or :idoperacion = x.idoperacion )   "
            + " and (:fechaentrega is null or x.fechaentrega = :fechaentrega ) "
            + " and (:numeroenvioorden is null or x.numeroenvioorden = :numeroenvioorden ) "
            + " and (:recervadooperacion is null or x.recervadooperacion = :recervadooperacion ) "
            + " and (:numeroordencompra is null or x.numeroordencompra = :numeroordencompra ) "
            + " and (:fechaoperacion is null or x.fechaoperacion = :fechaoperacion ) "
            + " and (:numerodocumento is null or x.numerodocumento = :numerodocumento ) "
            + " and (:ordenentregada is null or x.ordenentregada = :ordenentregada ) "
            + " and (:estadooperacion is null or x.estadooperacion = :estadooperacion ) "
            + " and (:fechacontableoperacion is null or x.fechacontableoperacion = :fechacontableoperacion ) "
            + " and (:diascreditooperacion is null or x.diascreditooperacion = :diascreditooperacion ) "
            + " and (:comentariosoperacion is null or x.comentariosoperacion = :comentariosoperacion ) "
            + " and (:fechaivaoperacion is null or x.fechaivaoperacion = :fechaivaoperacion ) "
            + " and (:ordenrecibida is null or x.ordenrecibida = :ordenrecibida ) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.invproveedor.idproveedor) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.invcliente.idcliente) "
            + " and  (:fkidtipooperacionesinvtipooperaciones is null or :fkidtipooperacionesinvtipooperaciones = x.invtipooperaciones.idtipooperaciones) "
            + " ORDER BY x.idoperacion ASC ")
     Page<Invoperacion> findByFilters(Pageable page  ,@Param("idoperacion")  String idoperacion ,@Param("fechaentrega")  String fechaentrega ,@Param("numeroenvioorden")  String numeroenvioorden ,@Param("recervadooperacion")  String recervadooperacion ,@Param("numeroordencompra")  String numeroordencompra ,@Param("fechaoperacion")  String fechaoperacion ,@Param("numerodocumento")  String numerodocumento ,@Param("ordenentregada")  String ordenentregada ,@Param("estadooperacion")  String estadooperacion ,@Param("fechacontableoperacion")  String fechacontableoperacion ,@Param("diascreditooperacion")  String diascreditooperacion ,@Param("comentariosoperacion")  String comentariosoperacion ,@Param("fechaivaoperacion")  String fechaivaoperacion ,@Param("ordenrecibida")  String ordenrecibida ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente ,@Param("fkidtipooperacionesinvtipooperaciones")  String fkidtipooperacionesinvtipooperaciones);

    @Query(value ="SELECT  x.IDOPERACION  ,  x.FECHAENTREGA  ,  x.NUMEROENVIOORDEN  ,  x.RECERVADOOPERACION  ,  x.NUMEROORDENCOMPRA  ,  x.FECHAOPERACION  ,  x.NUMERODOCUMENTO  ,  x.ORDENENTREGADA  ,  x.ESTADOOPERACION  ,  x.FECHACONTABLEOPERACION  ,  x.DIASCREDITOOPERACION  ,  x.COMENTARIOSOPERACION  ,  x.FECHAIVAOPERACION  ,  x.ORDENRECIBIDA  ,  x.IDPROVEEDOR  ,  x.IDCLIENTE  ,  x.IDTIPOOPERACIONES  "
            + " FROM INVOPERACION x "
            + "WHERE"  
            + "  (:idoperacion is null or :idoperacion = x.IDOPERACION )   "
            + " and (:fechaentrega is null or x.FECHAENTREGA = :fechaentrega ) "
            + " and (:numeroenvioorden is null or x.NUMEROENVIOORDEN = :numeroenvioorden ) "
            + " and (:recervadooperacion is null or x.RECERVADOOPERACION = :recervadooperacion ) "
            + " and (:numeroordencompra is null or x.NUMEROORDENCOMPRA = :numeroordencompra ) "
            + " and (:fechaoperacion is null or x.FECHAOPERACION = :fechaoperacion ) "
            + " and (:numerodocumento is null or x.NUMERODOCUMENTO = :numerodocumento ) "
            + " and (:ordenentregada is null or x.ORDENENTREGADA = :ordenentregada ) "
            + " and (:estadooperacion is null or x.ESTADOOPERACION = :estadooperacion ) "
            + " and (:fechacontableoperacion is null or x.FECHACONTABLEOPERACION = :fechacontableoperacion ) "
            + " and (:diascreditooperacion is null or x.DIASCREDITOOPERACION = :diascreditooperacion ) "
            + " and (:comentariosoperacion is null or x.COMENTARIOSOPERACION = :comentariosoperacion ) "
            + " and (:fechaivaoperacion is null or x.FECHAIVAOPERACION = :fechaivaoperacion ) "
            + " and (:ordenrecibida is null or x.ORDENRECIBIDA = :ordenrecibida ) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.IDPROVEEDOR) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.IDCLIENTE) "
            + " and  (:fkidtipooperacionesinvtipooperaciones is null or :fkidtipooperacionesinvtipooperaciones = x.IDTIPOOPERACIONES) "
            + " ORDER BY x.IDOPERACION ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idoperacion")  String idoperacion ,@Param("fechaentrega")  String fechaentrega ,@Param("numeroenvioorden")  String numeroenvioorden ,@Param("recervadooperacion")  String recervadooperacion ,@Param("numeroordencompra")  String numeroordencompra ,@Param("fechaoperacion")  String fechaoperacion ,@Param("numerodocumento")  String numerodocumento ,@Param("ordenentregada")  String ordenentregada ,@Param("estadooperacion")  String estadooperacion ,@Param("fechacontableoperacion")  String fechacontableoperacion ,@Param("diascreditooperacion")  String diascreditooperacion ,@Param("comentariosoperacion")  String comentariosoperacion ,@Param("fechaivaoperacion")  String fechaivaoperacion ,@Param("ordenrecibida")  String ordenrecibida ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente ,@Param("fkidtipooperacionesinvtipooperaciones")  String fkidtipooperacionesinvtipooperaciones);

}

