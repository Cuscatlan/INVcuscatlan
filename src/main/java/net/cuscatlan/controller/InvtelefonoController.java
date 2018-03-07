package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invtelefono;

import net.cuscatlan.repository.InvtelefonoRepository;
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
public class InvtelefonoController {
    
    @Autowired
    InvtelefonoRepository invtelefonoRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvtelefono")
    public ModelAndView indexInvtelefono(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invtelefono", new Invtelefono());
        mv.setViewName("Invtelefono/Invtelefono.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvtelefono", method = RequestMethod.POST)
    public @ResponseBody String saveInvtelefono(@ModelAttribute("Invtelefono") @Validated Invtelefono invtelefono ) {
         invtelefonoRepository.save(invtelefono);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvtelefono", method = RequestMethod.POST)
    public @ResponseBody String deleteInvtelefono(@ModelAttribute("Invtelefono")  Invtelefono invtelefono ) {
         invtelefonoRepository.delete(invtelefono);
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
    @RequestMapping(value = "/gridInvtelefono", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invtelefono> gridInvtelefono(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invtelefono> list = invtelefonoRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idtelefono") 
            ,JqgridFilter.getField(filters, "numerotelefono") 
            ,JqgridFilter.getField(filters, "tipotelefono") 
            ,JqgridFilter.getField(filters, "invproveedorDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invusuarioDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invclienteDescriptionDelegate") 
        );

       JqgridResponse<Invtelefono> jqgridInvtelefono = new JqgridResponse<Invtelefono>();
       return jqgridInvtelefono.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvtelefono", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvtelefono(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idtelefono"); 
        header.add("numerotelefono"); 
        header.add("tipotelefono"); 
        header.add("invproveedorDescriptionDelegate"); 
        header.add("invusuarioDescriptionDelegate"); 
        header.add("invclienteDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invtelefono", header);
        
        List<Object[]> list = invtelefonoRepository.findByFilters(
           JqgridFilter.getField(filters, "idtelefono") 
            ,JqgridFilter.getField(filters, "numerotelefono") 
            ,JqgridFilter.getField(filters, "tipotelefono") 
            ,JqgridFilter.getField(filters, "invproveedorDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invusuarioDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invclienteDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invtelefono.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

