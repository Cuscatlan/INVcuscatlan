package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtelefono;
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

public interface InvtelefonoRepository extends JpaRepository <Invtelefono,    Integer >,PagingAndSortingRepository<Invtelefono,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtelefono x "
            + "WHERE"  
            + "  (:idtelefono is null or :idtelefono = x.idtelefono )   "
            + " and (:numerotelefono is null or x.numerotelefono = :numerotelefono ) "
            + " and (:tipotelefono is null or x.tipotelefono = :tipotelefono ) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.invproveedor.idproveedor) "
            + " and  (:fkidusuarioinvusuario is null or :fkidusuarioinvusuario = x.invusuario.idusuario) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.invcliente.idcliente) "
            + " ORDER BY x.idtelefono ASC ")
     Page<Invtelefono> findByFilters(Pageable page  ,@Param("idtelefono")  String idtelefono ,@Param("numerotelefono")  String numerotelefono ,@Param("tipotelefono")  String tipotelefono ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidusuarioinvusuario")  String fkidusuarioinvusuario ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente);

    @Query(value ="SELECT  x.IDTELEFONO  ,  x.NUMEROTELEFONO  ,  x.TIPOTELEFONO  ,  x.IDPROVEEDOR  ,  x.IDUSUARIO  ,  x.IDCLIENTE  "
            + " FROM INVTELEFONO x "
            + "WHERE"  
            + "  (:idtelefono is null or :idtelefono = x.IDTELEFONO )   "
            + " and (:numerotelefono is null or x.NUMEROTELEFONO = :numerotelefono ) "
            + " and (:tipotelefono is null or x.TIPOTELEFONO = :tipotelefono ) "
            + " and  (:fkidproveedorinvproveedor is null or :fkidproveedorinvproveedor = x.IDPROVEEDOR) "
            + " and  (:fkidusuarioinvusuario is null or :fkidusuarioinvusuario = x.IDUSUARIO) "
            + " and  (:fkidclienteinvcliente is null or :fkidclienteinvcliente = x.IDCLIENTE) "
            + " ORDER BY x.IDTELEFONO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idtelefono")  String idtelefono ,@Param("numerotelefono")  String numerotelefono ,@Param("tipotelefono")  String tipotelefono ,@Param("fkidproveedorinvproveedor")  String fkidproveedorinvproveedor ,@Param("fkidusuarioinvusuario")  String fkidusuarioinvusuario ,@Param("fkidclienteinvcliente")  String fkidclienteinvcliente);

}

