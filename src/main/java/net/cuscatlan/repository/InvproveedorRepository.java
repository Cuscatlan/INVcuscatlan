package net.cuscatlan.repository;

import net.cuscatlan.domain.Invproveedor;
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

public interface InvproveedorRepository extends JpaRepository <Invproveedor,    Integer >,PagingAndSortingRepository<Invproveedor,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invproveedor x "
            + "WHERE"  
            + "  (:idproveedor is null or :idproveedor = x.idproveedor )   "
            + " and (:nombreproveedor is null or x.nombreproveedor = :nombreproveedor ) "
            + " and (:contactoproveedor is null or x.contactoproveedor = :contactoproveedor ) "
            + " and (:registroproveedor is null or x.registroproveedor = :registroproveedor ) "
            + " and (:espersonaproveedor is null or x.espersonaproveedor = :espersonaproveedor ) "
            + " and (:giroproveedor is null or x.giroproveedor = :giroproveedor ) "
            + " and (:nitproveedor is null or x.nitproveedor = :nitproveedor ) "
            + " and (:tipocontribuyenteproveedor is null or x.tipocontribuyenteproveedor = :tipocontribuyenteproveedor ) "
            + " and (:duiproveedor is null or x.duiproveedor = :duiproveedor ) "
            + " ORDER BY x.idproveedor ASC ")
     Page<Invproveedor> findByFilters(Pageable page  ,@Param("idproveedor")  String idproveedor ,@Param("nombreproveedor")  String nombreproveedor ,@Param("contactoproveedor")  String contactoproveedor ,@Param("registroproveedor")  String registroproveedor ,@Param("espersonaproveedor")  String espersonaproveedor ,@Param("giroproveedor")  String giroproveedor ,@Param("nitproveedor")  String nitproveedor ,@Param("tipocontribuyenteproveedor")  String tipocontribuyenteproveedor ,@Param("duiproveedor")  String duiproveedor);

    @Query(value ="SELECT  x.IDPROVEEDOR  ,  x.NOMBREPROVEEDOR  ,  x.CONTACTOPROVEEDOR  ,  x.REGISTROPROVEEDOR  ,  x.ESPERSONAPROVEEDOR  ,  x.GIROPROVEEDOR  ,  x.NITPROVEEDOR  ,  x.TIPOCONTRIBUYENTEPROVEEDOR  ,  x.DUIPROVEEDOR  "
            + " FROM INVPROVEEDOR x "
            + "WHERE"  
            + "  (:idproveedor is null or :idproveedor = x.IDPROVEEDOR )   "
            + " and (:nombreproveedor is null or x.NOMBREPROVEEDOR = :nombreproveedor ) "
            + " and (:contactoproveedor is null or x.CONTACTOPROVEEDOR = :contactoproveedor ) "
            + " and (:registroproveedor is null or x.REGISTROPROVEEDOR = :registroproveedor ) "
            + " and (:espersonaproveedor is null or x.ESPERSONAPROVEEDOR = :espersonaproveedor ) "
            + " and (:giroproveedor is null or x.GIROPROVEEDOR = :giroproveedor ) "
            + " and (:nitproveedor is null or x.NITPROVEEDOR = :nitproveedor ) "
            + " and (:tipocontribuyenteproveedor is null or x.TIPOCONTRIBUYENTEPROVEEDOR = :tipocontribuyenteproveedor ) "
            + " and (:duiproveedor is null or x.DUIPROVEEDOR = :duiproveedor ) "
            + " ORDER BY x.IDPROVEEDOR ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idproveedor")  String idproveedor ,@Param("nombreproveedor")  String nombreproveedor ,@Param("contactoproveedor")  String contactoproveedor ,@Param("registroproveedor")  String registroproveedor ,@Param("espersonaproveedor")  String espersonaproveedor ,@Param("giroproveedor")  String giroproveedor ,@Param("nitproveedor")  String nitproveedor ,@Param("tipocontribuyenteproveedor")  String tipocontribuyenteproveedor ,@Param("duiproveedor")  String duiproveedor);

}

