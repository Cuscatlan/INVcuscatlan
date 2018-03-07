package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invfamiliaproducto;

import net.cuscatlan.repository.InvfamiliaproductoRepository;
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
public class InvfamiliaproductoController {
    
    @Autowired
    InvfamiliaproductoRepository invfamiliaproductoRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvfamiliaproducto")
    public ModelAndView indexInvfamiliaproducto(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invfamiliaproducto", new Invfamiliaproducto());
        mv.setViewName("Invfamiliaproducto/Invfamiliaproducto.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvfamiliaproducto", method = RequestMethod.POST)
    public @ResponseBody String saveInvfamiliaproducto(@ModelAttribute("Invfamiliaproducto") @Validated Invfamiliaproducto invfamiliaproducto ) {
         invfamiliaproductoRepository.save(invfamiliaproducto);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvfamiliaproducto", method = RequestMethod.POST)
    public @ResponseBody String deleteInvfamiliaproducto(@ModelAttribute("Invfamiliaproducto")  Invfamiliaproducto invfamiliaproducto ) {
         invfamiliaproductoRepository.delete(invfamiliaproducto);
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
    @RequestMapping(value = "/gridInvfamiliaproducto", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invfamiliaproducto> gridInvfamiliaproducto(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invfamiliaproducto> list = invfamiliaproductoRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idfamiliaproducto") 
            ,JqgridFilter.getField(filters, "estadofamiliaproducto") 
            ,JqgridFilter.getField(filters, "nombrefamiliaproducto") 
            ,JqgridFilter.getField(filters, "idgrupoproducto") 
        );

       JqgridResponse<Invfamiliaproducto> jqgridInvfamiliaproducto = new JqgridResponse<Invfamiliaproducto>();
       return jqgridInvfamiliaproducto.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvfamiliaproducto", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvfamiliaproducto(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idfamiliaproducto"); 
        header.add("estadofamiliaproducto"); 
        header.add("nombrefamiliaproducto"); 
        header.add("idgrupoproducto"); 
        
        LayOutDynamic.buildReport(worksheet, "Invfamiliaproducto", header);
        
        List<Object[]> list = invfamiliaproductoRepository.findByFilters(
           JqgridFilter.getField(filters, "idfamiliaproducto") 
            ,JqgridFilter.getField(filters, "estadofamiliaproducto") 
            ,JqgridFilter.getField(filters, "nombrefamiliaproducto") 
            ,JqgridFilter.getField(filters, "idgrupoproducto") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invfamiliaproducto.xls";
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
    @RequestMapping(value = {"/cbofilterInvfamiliaproducto"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvfamiliaproducto() {
        List<Invfamiliaproducto> list = invfamiliaproductoRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdfamiliaproducto().toString(), list.get(i).getIdfamiliaproducto().toString()));
        }
        return response;
    }
    
}

