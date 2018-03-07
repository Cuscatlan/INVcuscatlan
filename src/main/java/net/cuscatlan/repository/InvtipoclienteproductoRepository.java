package net.cuscatlan.repository;

import net.cuscatlan.domain.Invtipoclienteproducto;
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

public interface InvtipoclienteproductoRepository extends JpaRepository <Invtipoclienteproducto,    Integer >,PagingAndSortingRepository<Invtipoclienteproducto,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invtipoclienteproducto x "
            + "WHERE"  
            + "  (:idclienteproducto is null or :idclienteproducto = x.idclienteproducto )   "
            + " and (:descuentoclienteproducto is null or x.descuentoclienteproducto = :descuentoclienteproducto ) "
            + " and  (:fkidproductoinvproducto is null or :fkidproductoinvproducto = x.invproducto.idproducto) "
            + " and  (:fkidtipoclienteinvtipocliente is null or :fkidtipoclienteinvtipocliente = x.invtipocliente.idtipocliente) "
            + " ORDER BY x.idclienteproducto ASC ")
     Page<Invtipoclienteproducto> findByFilters(Pageable page  ,@Param("idclienteproducto")  String idclienteproducto ,@Param("descuentoclienteproducto")  String descuentoclienteproducto ,@Param("fkidproductoinvproducto")  String fkidproductoinvproducto ,@Param("fkidtipoclienteinvtipocliente")  String fkidtipoclienteinvtipocliente);

    @Query(value ="SELECT  x.IDCLIENTEPRODUCTO  ,  x.DESCUENTOCLIENTEPRODUCTO  ,  x.IDPRODUCTO  ,  x.IDTIPOCLIENTE  "
            + " FROM INVTIPOCLIENTEPRODUCTO x "
            + "WHERE"  
            + "  (:idclienteproducto is null or :idclienteproducto = x.IDCLIENTEPRODUCTO )   "
            + " and (:descuentoclienteproducto is null or x.DESCUENTOCLIENTEPRODUCTO = :descuentoclienteproducto ) "
            + " and  (:fkidproductoinvproducto is null or :fkidproductoinvproducto = x.IDPRODUCTO) "
            + " and  (:fkidtipoclienteinvtipocliente is null or :fkidtipoclienteinvtipocliente = x.IDTIPOCLIENTE) "
            + " ORDER BY x.IDCLIENTEPRODUCTO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idclienteproducto")  String idclienteproducto ,@Param("descuentoclienteproducto")  String descuentoclienteproducto ,@Param("fkidproductoinvproducto")  String fkidproductoinvproducto ,@Param("fkidtipoclienteinvtipocliente")  String fkidtipoclienteinvtipocliente);

}

