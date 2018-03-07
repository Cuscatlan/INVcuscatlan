package net.cuscatlan.repository;

import net.cuscatlan.domain.Invproducto;
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

public interface InvproductoRepository extends JpaRepository <Invproducto,    Integer >,PagingAndSortingRepository<Invproducto,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invproducto x "
            + "WHERE"  
            + "  (:idproducto is null or :idproducto = x.idproducto )   "
            + " and (:porcentaje1 is null or x.porcentaje1 = :porcentaje1 ) "
            + " and (:nombreproducto is null or x.nombreproducto = :nombreproducto ) "
            + " and (:precioventa3 is null or x.precioventa3 = :precioventa3 ) "
            + " and (:gravado is null or x.gravado = :gravado ) "
            + " and (:imagen is null or x.imagen = :imagen ) "
            + " and (:codigoproducto is null or x.codigoproducto = :codigoproducto ) "
            + " and (:precioventa4 is null or x.precioventa4 = :precioventa4 ) "
            + " and (:preciocosto is null or x.preciocosto = :preciocosto ) "
            + " and (:porcentaje2 is null or x.porcentaje2 = :porcentaje2 ) "
            + " and (:presentacion is null or x.presentacion = :presentacion ) "
            + " and (:porcentaje is null or x.porcentaje = :porcentaje ) "
            + " and (:preciopromedio is null or x.preciopromedio = :preciopromedio ) "
            + " and (:descuento is null or x.descuento = :descuento ) "
            + " and (:porcentaje4 is null or x.porcentaje4 = :porcentaje4 ) "
            + " and (:ubicacionfisica is null or x.ubicacionfisica = :ubicacionfisica ) "
            + " and (:costo is null or x.costo = :costo ) "
            + " and (:porcentaje3 is null or x.porcentaje3 = :porcentaje3 ) "
            + " and (:precioventa2 is null or x.precioventa2 = :precioventa2 ) "
            + " and (:precioventa1 is null or x.precioventa1 = :precioventa1 ) "
            + " and  (:fkidfamiliaproductoinvfamiliaproducto is null or :fkidfamiliaproductoinvfamiliaproducto = x.invfamiliaproducto.idfamiliaproducto) "
            + " and  (:fkidtipoproductoinvtipoproducto is null or :fkidtipoproductoinvtipoproducto = x.invtipoproducto.idtipoproducto) "
            + " ORDER BY x.idproducto ASC ")
     Page<Invproducto> findByFilters(Pageable page  ,@Param("idproducto")  String idproducto ,@Param("porcentaje1")  String porcentaje1 ,@Param("nombreproducto")  String nombreproducto ,@Param("precioventa3")  String precioventa3 ,@Param("gravado")  String gravado ,@Param("imagen")  String imagen ,@Param("codigoproducto")  String codigoproducto ,@Param("precioventa4")  String precioventa4 ,@Param("preciocosto")  String preciocosto ,@Param("porcentaje2")  String porcentaje2 ,@Param("presentacion")  String presentacion ,@Param("porcentaje")  String porcentaje ,@Param("preciopromedio")  String preciopromedio ,@Param("descuento")  String descuento ,@Param("porcentaje4")  String porcentaje4 ,@Param("ubicacionfisica")  String ubicacionfisica ,@Param("costo")  String costo ,@Param("porcentaje3")  String porcentaje3 ,@Param("precioventa2")  String precioventa2 ,@Param("precioventa1")  String precioventa1 ,@Param("fkidfamiliaproductoinvfamiliaproducto")  String fkidfamiliaproductoinvfamiliaproducto ,@Param("fkidtipoproductoinvtipoproducto")  String fkidtipoproductoinvtipoproducto);

    @Query(value ="SELECT  x.IDPRODUCTO  ,  x.PORCENTAJE1  ,  x.NOMBREPRODUCTO  ,  x.PRECIOVENTA3  ,  x.GRAVADO  ,  x.IMAGEN  ,  x.CODIGOPRODUCTO  ,  x.PRECIOVENTA4  ,  x.PRECIOCOSTO  ,  x.PORCENTAJE2  ,  x.PRESENTACION  ,  x.PORCENTAJE  ,  x.PRECIOPROMEDIO  ,  x.DESCUENTO  ,  x.PORCENTAJE4  ,  x.UBICACIONFISICA  ,  x.COSTO  ,  x.PORCENTAJE3  ,  x.PRECIOVENTA2  ,  x.PRECIOVENTA1  ,  x.IDFAMILIAPRODUCTO  ,  x.IDTIPOPRODUCTO  "
            + " FROM INVPRODUCTO x "
            + "WHERE"  
            + "  (:idproducto is null or :idproducto = x.IDPRODUCTO )   "
            + " and (:porcentaje1 is null or x.PORCENTAJE1 = :porcentaje1 ) "
            + " and (:nombreproducto is null or x.NOMBREPRODUCTO = :nombreproducto ) "
            + " and (:precioventa3 is null or x.PRECIOVENTA3 = :precioventa3 ) "
            + " and (:gravado is null or x.GRAVADO = :gravado ) "
            + " and (:imagen is null or x.IMAGEN = :imagen ) "
            + " and (:codigoproducto is null or x.CODIGOPRODUCTO = :codigoproducto ) "
            + " and (:precioventa4 is null or x.PRECIOVENTA4 = :precioventa4 ) "
            + " and (:preciocosto is null or x.PRECIOCOSTO = :preciocosto ) "
            + " and (:porcentaje2 is null or x.PORCENTAJE2 = :porcentaje2 ) "
            + " and (:presentacion is null or x.PRESENTACION = :presentacion ) "
            + " and (:porcentaje is null or x.PORCENTAJE = :porcentaje ) "
            + " and (:preciopromedio is null or x.PRECIOPROMEDIO = :preciopromedio ) "
            + " and (:descuento is null or x.DESCUENTO = :descuento ) "
            + " and (:porcentaje4 is null or x.PORCENTAJE4 = :porcentaje4 ) "
            + " and (:ubicacionfisica is null or x.UBICACIONFISICA = :ubicacionfisica ) "
            + " and (:costo is null or x.COSTO = :costo ) "
            + " and (:porcentaje3 is null or x.PORCENTAJE3 = :porcentaje3 ) "
            + " and (:precioventa2 is null or x.PRECIOVENTA2 = :precioventa2 ) "
            + " and (:precioventa1 is null or x.PRECIOVENTA1 = :precioventa1 ) "
            + " and  (:fkidfamiliaproductoinvfamiliaproducto is null or :fkidfamiliaproductoinvfamiliaproducto = x.IDFAMILIAPRODUCTO) "
            + " and  (:fkidtipoproductoinvtipoproducto is null or :fkidtipoproductoinvtipoproducto = x.IDTIPOPRODUCTO) "
            + " ORDER BY x.IDPRODUCTO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idproducto")  String idproducto ,@Param("porcentaje1")  String porcentaje1 ,@Param("nombreproducto")  String nombreproducto ,@Param("precioventa3")  String precioventa3 ,@Param("gravado")  String gravado ,@Param("imagen")  String imagen ,@Param("codigoproducto")  String codigoproducto ,@Param("precioventa4")  String precioventa4 ,@Param("preciocosto")  String preciocosto ,@Param("porcentaje2")  String porcentaje2 ,@Param("presentacion")  String presentacion ,@Param("porcentaje")  String porcentaje ,@Param("preciopromedio")  String preciopromedio ,@Param("descuento")  String descuento ,@Param("porcentaje4")  String porcentaje4 ,@Param("ubicacionfisica")  String ubicacionfisica ,@Param("costo")  String costo ,@Param("porcentaje3")  String porcentaje3 ,@Param("precioventa2")  String precioventa2 ,@Param("precioventa1")  String precioventa1 ,@Param("fkidfamiliaproductoinvfamiliaproducto")  String fkidfamiliaproductoinvfamiliaproducto ,@Param("fkidtipoproductoinvtipoproducto")  String fkidtipoproductoinvtipoproducto);

}

