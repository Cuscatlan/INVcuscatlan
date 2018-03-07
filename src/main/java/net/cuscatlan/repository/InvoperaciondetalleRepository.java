package net.cuscatlan.repository;

import net.cuscatlan.domain.Invoperaciondetalle;
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

public interface InvoperaciondetalleRepository extends JpaRepository <Invoperaciondetalle,    Integer >,PagingAndSortingRepository<Invoperaciondetalle,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM Invoperaciondetalle x "
            + "WHERE"  
            + "  (:iddetalle is null or :iddetalle = x.iddetalle )   "
            + " and (:unidadesrecividas is null or x.unidadesrecividas = :unidadesrecividas ) "
            + " and (:fovialoperacion is null or x.fovialoperacion = :fovialoperacion ) "
            + " and (:lotedetalle is null or x.lotedetalle = :lotedetalle ) "
            + " and (:preciocompra is null or x.preciocompra = :preciocompra ) "
            + " and (:precioorigen is null or x.precioorigen = :precioorigen ) "
            + " and (:descuentodetalle is null or x.descuentodetalle = :descuentodetalle ) "
            + " and (:unidadesvendidas is null or x.unidadesvendidas = :unidadesvendidas ) "
            + " and (:ivadetalle is null or x.ivadetalle = :ivadetalle ) "
            + " and (:preciocif is null or x.preciocif = :preciocif ) "
            + " and (:preciopromedio is null or x.preciopromedio = :preciopromedio ) "
            + " and (:ubicacionfisica is null or x.ubicacionfisica = :ubicacionfisica ) "
            + " and (:precioventa is null or x.precioventa = :precioventa ) "
            + " and (:exenta is null or x.exenta = :exenta ) "
            + " and (:gravada is null or x.gravada = :gravada ) "
            + " and (:unidadesordenadas is null or x.unidadesordenadas = :unidadesordenadas ) "
            + " and (:isr is null or x.isr = :isr ) "
            + " and  (:fkidoperacioninvoperacion is null or :fkidoperacioninvoperacion = x.invoperacion.idoperacion) "
            + " and  (:fkidproductoinvproducto is null or :fkidproductoinvproducto = x.invproducto.idproducto) "
            + " ORDER BY x.iddetalle ASC ")
     Page<Invoperaciondetalle> findByFilters(Pageable page  ,@Param("iddetalle")  String iddetalle ,@Param("unidadesrecividas")  String unidadesrecividas ,@Param("fovialoperacion")  String fovialoperacion ,@Param("lotedetalle")  String lotedetalle ,@Param("preciocompra")  String preciocompra ,@Param("precioorigen")  String precioorigen ,@Param("descuentodetalle")  String descuentodetalle ,@Param("unidadesvendidas")  String unidadesvendidas ,@Param("ivadetalle")  String ivadetalle ,@Param("preciocif")  String preciocif ,@Param("preciopromedio")  String preciopromedio ,@Param("ubicacionfisica")  String ubicacionfisica ,@Param("precioventa")  String precioventa ,@Param("exenta")  String exenta ,@Param("gravada")  String gravada ,@Param("unidadesordenadas")  String unidadesordenadas ,@Param("isr")  String isr ,@Param("fkidoperacioninvoperacion")  String fkidoperacioninvoperacion ,@Param("fkidproductoinvproducto")  String fkidproductoinvproducto);

    @Query(value ="SELECT  x.IDDETALLE  ,  x.UNIDADESRECIVIDAS  ,  x.FOVIALOPERACION  ,  x.LOTEDETALLE  ,  x.PRECIOCOMPRA  ,  x.PRECIOORIGEN  ,  x.DESCUENTODETALLE  ,  x.UNIDADESVENDIDAS  ,  x.IVADETALLE  ,  x.PRECIOCIF  ,  x.PRECIOPROMEDIO  ,  x.UBICACIONFISICA  ,  x.PRECIOVENTA  ,  x.EXENTA  ,  x.GRAVADA  ,  x.UNIDADESORDENADAS  ,  x.ISR  ,  x.IDOPERACION  ,  x.IDPRODUCTO  "
            + " FROM INVOPERACIONDETALLE x "
            + "WHERE"  
            + "  (:iddetalle is null or :iddetalle = x.IDDETALLE )   "
            + " and (:unidadesrecividas is null or x.UNIDADESRECIVIDAS = :unidadesrecividas ) "
            + " and (:fovialoperacion is null or x.FOVIALOPERACION = :fovialoperacion ) "
            + " and (:lotedetalle is null or x.LOTEDETALLE = :lotedetalle ) "
            + " and (:preciocompra is null or x.PRECIOCOMPRA = :preciocompra ) "
            + " and (:precioorigen is null or x.PRECIOORIGEN = :precioorigen ) "
            + " and (:descuentodetalle is null or x.DESCUENTODETALLE = :descuentodetalle ) "
            + " and (:unidadesvendidas is null or x.UNIDADESVENDIDAS = :unidadesvendidas ) "
            + " and (:ivadetalle is null or x.IVADETALLE = :ivadetalle ) "
            + " and (:preciocif is null or x.PRECIOCIF = :preciocif ) "
            + " and (:preciopromedio is null or x.PRECIOPROMEDIO = :preciopromedio ) "
            + " and (:ubicacionfisica is null or x.UBICACIONFISICA = :ubicacionfisica ) "
            + " and (:precioventa is null or x.PRECIOVENTA = :precioventa ) "
            + " and (:exenta is null or x.EXENTA = :exenta ) "
            + " and (:gravada is null or x.GRAVADA = :gravada ) "
            + " and (:unidadesordenadas is null or x.UNIDADESORDENADAS = :unidadesordenadas ) "
            + " and (:isr is null or x.ISR = :isr ) "
            + " and  (:fkidoperacioninvoperacion is null or :fkidoperacioninvoperacion = x.IDOPERACION) "
            + " and  (:fkidproductoinvproducto is null or :fkidproductoinvproducto = x.IDPRODUCTO) "
            + " ORDER BY x.IDDETALLE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("iddetalle")  String iddetalle ,@Param("unidadesrecividas")  String unidadesrecividas ,@Param("fovialoperacion")  String fovialoperacion ,@Param("lotedetalle")  String lotedetalle ,@Param("preciocompra")  String preciocompra ,@Param("precioorigen")  String precioorigen ,@Param("descuentodetalle")  String descuentodetalle ,@Param("unidadesvendidas")  String unidadesvendidas ,@Param("ivadetalle")  String ivadetalle ,@Param("preciocif")  String preciocif ,@Param("preciopromedio")  String preciopromedio ,@Param("ubicacionfisica")  String ubicacionfisica ,@Param("precioventa")  String precioventa ,@Param("exenta")  String exenta ,@Param("gravada")  String gravada ,@Param("unidadesordenadas")  String unidadesordenadas ,@Param("isr")  String isr ,@Param("fkidoperacioninvoperacion")  String fkidoperacioninvoperacion ,@Param("fkidproductoinvproducto")  String fkidproductoinvproducto);

}

