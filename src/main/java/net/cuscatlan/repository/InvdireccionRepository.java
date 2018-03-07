package net.cuscatlan.repository;

import net.cuscatlan.domain.Invdireccion;
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

public interface InvdireccionRepository extends JpaRepository <Invdireccion,    Integer >,PagingAndSortingRepository<Invdireccion,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invdireccion x "
            + "WHERE"  
            + "  (:iddireccion is null or :iddireccion = x.iddireccion )   "
            + " and (:descripciondireccion is null or x.descripciondireccion = :descripciondireccion ) "
            + " and (:lugardireccion is null or x.lugardireccion = :lugardireccion ) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.invcliente.idcliente) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.invproveedor.idproveedor) "
            + " and  (:fkidusuarioinvusuario is null or :fkidusuarioinvusuario = x.invusuario.idusuario) "
            + " ORDER BY x.iddireccion ASC ")
     Page<Invdireccion> findByFilters(Pageable page  ,@Param("iddireccion")  String iddireccion ,@Param("descripciondireccion")  String descripciondireccion ,@Param("lugardireccion")  String lugardireccion ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidusuarioinvusuario")  String fkidusuarioinvusuario);

    @Query(value ="SELECT  x.IDDIRECCION  ,  x.DESCRIPCIONDIRECCION  ,  x.LUGARDIRECCION  ,  x.IDCLIENTE  ,  x.IDPROVEEDOR  ,  x.IDUSUARIO  "
            + " FROM INVDIRECCION x "
            + "WHERE"  
            + "  (:iddireccion is null or :iddireccion = x.IDDIRECCION )   "
            + " and (:descripciondireccion is null or x.DESCRIPCIONDIRECCION = :descripciondireccion ) "
            + " and (:lugardireccion is null or x.LUGARDIRECCION = :lugardireccion ) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.IDCLIENTE) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.IDPROVEEDOR) "
            + " and  (:fkidusuarioinvusuario is null or :fkidusuarioinvusuario = x.IDUSUARIO) "
            + " ORDER BY x.IDDIRECCION ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("iddireccion")  String iddireccion ,@Param("descripciondireccion")  String descripciondireccion ,@Param("lugardireccion")  String lugardireccion ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidusuarioinvusuario")  String fkidusuarioinvusuario);

}

