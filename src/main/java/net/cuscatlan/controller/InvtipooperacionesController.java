package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invtipooperaciones;

import net.cuscatlan.repository.InvtipooperacionesRepository;
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
public class InvtipooperacionesController {
    
    @Autowired
    InvtipooperacionesRepository invtipooperacionesRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvtipooperaciones")
    public ModelAndView indexInvtipooperaciones(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invtipooperaciones", new Invtipooperaciones());
        mv.setViewName("Invtipooperaciones/Invtipooperaciones.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvtipooperaciones", method = RequestMethod.POST)
    public @ResponseBody String saveInvtipooperaciones(@ModelAttribute("Invtipooperaciones") @Validated Invtipooperaciones invtipooperaciones ) {
         invtipooperacionesRepository.save(invtipooperaciones);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvtipooperaciones", method = RequestMethod.POST)
    public @ResponseBody String deleteInvtipooperaciones(@ModelAttribute("Invtipooperaciones")  Invtipooperaciones invtipooperaciones ) {
         invtipooperacionesRepository.delete(invtipooperaciones);
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
    @RequestMapping(value = "/gridInvtipooperaciones", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invtipooperaciones> gridInvtipooperaciones(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invtipooperaciones> list = invtipooperacionesRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idtipooperaciones") 
            ,JqgridFilter.getField(filters, "mostrarreportes") 
            ,JqgridFilter.getField(filters, "impresortipo") 
            ,JqgridFilter.getField(filters, "sumatipo") 
            ,JqgridFilter.getField(filters, "nombretipooperacion") 
            ,JqgridFilter.getField(filters, "siglastipooperacion") 
            ,JqgridFilter.getField(filters, "iventariotipooperacion") 
            ,JqgridFilter.getField(filters, "tipooperacion") 
        );

       JqgridResponse<Invtipooperaciones> jqgridInvtipooperaciones = new JqgridResponse<Invtipooperaciones>();
       return jqgridInvtipooperaciones.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvtipooperaciones", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvtipooperaciones(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idtipooperaciones"); 
        header.add("mostrarreportes"); 
        header.add("impresortipo"); 
        header.add("sumatipo"); 
        header.add("nombretipooperacion"); 
        header.add("siglastipooperacion"); 
        header.add("iventariotipooperacion"); 
        header.add("tipooperacion"); 
        
        LayOutDynamic.buildReport(worksheet, "Invtipooperaciones", header);
        
        List<Object[]> list = invtipooperacionesRepository.findByFilters(
           JqgridFilter.getField(filters, "idtipooperaciones") 
            ,JqgridFilter.getField(filters, "mostrarreportes") 
            ,JqgridFilter.getField(filters, "impresortipo") 
            ,JqgridFilter.getField(filters, "sumatipo") 
            ,JqgridFilter.getField(filters, "nombretipooperacion") 
            ,JqgridFilter.getField(filters, "siglastipooperacion") 
            ,JqgridFilter.getField(filters, "iventariotipooperacion") 
            ,JqgridFilter.getField(filters, "tipooperacion") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invtipooperaciones.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    /**
    * Controlador para obtener las llaves padres de la entidad
    * @return List<CboFilter> Devuelve una lista de objeto llena con los id y descripcion del padre
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = {"/cbofilterInvtipooperaciones"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvtipooperaciones() {
        List<Invtipooperaciones> list = invtipooperacionesRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdtipooperaciones().toString(), list.get(i).getIdtipooperaciones().toString()));
        }
        return response;
    }
    
}

