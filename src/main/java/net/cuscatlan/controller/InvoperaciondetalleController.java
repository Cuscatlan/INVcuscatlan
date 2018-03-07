package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invoperaciondetalle;

import net.cuscatlan.repository.InvoperaciondetalleRepository;
import net.cuscatlan.poi.LayOutDynamic;
import net.cuscatlan.poi.Writer;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import net.cuscatlan.common.CboFilter;
import java.util.Date;

@Controller
@RequestMapping("/")
public class InvoperaciondetalleController {
    
    @Autowired
    InvoperaciondetalleRepository invoperaciondetalleRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvoperaciondetalle")
    public ModelAndView indexInvoperaciondetalle(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invoperaciondetalle", new Invoperaciondetalle());
        mv.setViewName("Invoperaciondetalle/Invoperaciondetalle.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvoperaciondetalle", method = RequestMethod.POST)
    public @ResponseBody String saveInvoperaciondetalle(@ModelAttribute("Invoperaciondetalle") @Validated Invoperaciondetalle invoperaciondetalle ) {
         invoperaciondetalleRepository.save(invoperaciondetalle);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvoperaciondetalle", method = RequestMethod.POST)
    public @ResponseBody String deleteInvoperaciondetalle(@ModelAttribute("Invoperaciondetalle")  Invoperaciondetalle invoperaciondetalle ) {
         invoperaciondetalleRepository.delete(invoperaciondetalle);
         return null;
     }
    
    /**
    * Controlador para obtener la data y devolverla a un jqgrid Paginado por medio de Ajax
    * @return JqgridResponse lleno con la data paginada
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @Param page la pagina actual del jqgrid
    * @Param rows la cantidad de filas a mostrar en la paginacion
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/gridInvoperaciondetalle", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invoperaciondetalle> gridInvoperaciondetalle(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invoperaciondetalle> list = invoperaciondetalleRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "iddetalle") 
            ,JqgridFilter.getField(filters, "unidadesrecividas") 
            ,JqgridFilter.getField(filters, "fovialoperacion") 
            ,JqgridFilter.getField(filters, "lotedetalle") 
            ,JqgridFilter.getField(filters, "preciocompra") 
            ,JqgridFilter.getField(filters, "precioorigen") 
            ,JqgridFilter.getField(filters, "descuentodetalle") 
            ,JqgridFilter.getField(filters, "unidadesvendidas") 
            ,JqgridFilter.getField(filters, "ivadetalle") 
            ,JqgridFilter.getField(filters, "preciocif") 
            ,JqgridFilter.getField(filters, "preciopromedio") 
            ,JqgridFilter.getField(filters, "ubicacionfisica") 
            ,JqgridFilter.getField(filters, "precioventa") 
            ,JqgridFilter.getField(filters, "exenta") 
            ,JqgridFilter.getField(filters, "gravada") 
            ,JqgridFilter.getField(filters, "unidadesordenadas") 
            ,JqgridFilter.getField(filters, "isr") 
            ,JqgridFilter.getField(filters, "invoperacionDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invproductoDescriptionDelegate") 
        );

       JqgridResponse<Invoperaciondetalle> jqgridInvoperaciondetalle = new JqgridResponse<Invoperaciondetalle>();
       return jqgridInvoperaciondetalle.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvoperaciondetalle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvoperaciondetalle(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("iddetalle"); 
        header.add("unidadesrecividas"); 
        header.add("fovialoperacion"); 
        header.add("lotedetalle"); 
        header.add("preciocompra"); 
        header.add("precioorigen"); 
        header.add("descuentodetalle"); 
        header.add("unidadesvendidas"); 
        header.add("ivadetalle"); 
        header.add("preciocif"); 
        header.add("preciopromedio"); 
        header.add("ubicacionfisica"); 
        header.add("precioventa"); 
        header.add("exenta"); 
        header.add("gravada"); 
        header.add("unidadesordenadas"); 
        header.add("isr"); 
        header.add("invoperacionDescriptionDelegate"); 
        header.add("invproductoDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invoperaciondetalle", header);
        
        List<Object[]> list = invoperaciondetalleRepository.findByFilters(
           JqgridFilter.getField(filters, "iddetalle") 
            ,JqgridFilter.getField(filters, "unidadesrecividas") 
            ,JqgridFilter.getField(filters, "fovialoperacion") 
            ,JqgridFilter.getField(filters, "lotedetalle") 
            ,JqgridFilter.getField(filters, "preciocompra") 
            ,JqgridFilter.getField(filters, "precioorigen") 
            ,JqgridFilter.getField(filters, "descuentodetalle") 
            ,JqgridFilter.getField(filters, "unidadesvendidas") 
            ,JqgridFilter.getField(filters, "ivadetalle") 
            ,JqgridFilter.getField(filters, "preciocif") 
            ,JqgridFilter.getField(filters, "preciopromedio") 
            ,JqgridFilter.getField(filters, "ubicacionfisica") 
            ,JqgridFilter.getField(filters, "precioventa") 
            ,JqgridFilter.getField(filters, "exenta") 
            ,JqgridFilter.getField(filters, "gravada") 
            ,JqgridFilter.getField(filters, "unidadesordenadas") 
            ,JqgridFilter.getField(filters, "isr") 
            ,JqgridFilter.getField(filters, "invoperacionDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invproductoDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invoperaciondetalle.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

