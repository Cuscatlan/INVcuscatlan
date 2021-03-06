package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invusuario;

import net.cuscatlan.repository.InvusuarioRepository;
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
public class InvusuarioController {
    
    @Autowired
    InvusuarioRepository invusuarioRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvusuario")
    public ModelAndView indexInvusuario(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invusuario", new Invusuario());
        mv.setViewName("Invusuario/Invusuario.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvusuario", method = RequestMethod.POST)
    public @ResponseBody String saveInvusuario(@ModelAttribute("Invusuario") @Validated Invusuario invusuario ) {
         invusuarioRepository.save(invusuario);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvusuario", method = RequestMethod.POST)
    public @ResponseBody String deleteInvusuario(@ModelAttribute("Invusuario")  Invusuario invusuario ) {
         invusuarioRepository.delete(invusuario);
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
    @RequestMapping(value = "/gridInvusuario", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invusuario> gridInvusuario(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invusuario> list = invusuarioRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idusuario") 
            ,JqgridFilter.getField(filters, "nombreusuario") 
            ,JqgridFilter.getField(filters, "duiusuario") 
            ,JqgridFilter.getField(filters, "claveusuario") 
            ,JqgridFilter.getField(filters, "correousuario") 
            ,JqgridFilter.getField(filters, "profecionusuario") 
            ,JqgridFilter.getField(filters, "invtipousuarioDescriptionDelegate") 
        );

       JqgridResponse<Invusuario> jqgridInvusuario = new JqgridResponse<Invusuario>();
       return jqgridInvusuario.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvusuario", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvusuario(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idusuario"); 
        header.add("nombreusuario"); 
        header.add("duiusuario"); 
        header.add("claveusuario"); 
        header.add("correousuario"); 
        header.add("profecionusuario"); 
        header.add("invtipousuarioDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invusuario", header);
        
        List<Object[]> list = invusuarioRepository.findByFilters(
           JqgridFilter.getField(filters, "idusuario") 
            ,JqgridFilter.getField(filters, "nombreusuario") 
            ,JqgridFilter.getField(filters, "duiusuario") 
            ,JqgridFilter.getField(filters, "claveusuario") 
            ,JqgridFilter.getField(filters, "correousuario") 
            ,JqgridFilter.getField(filters, "profecionusuario") 
            ,JqgridFilter.getField(filters, "invtipousuarioDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invusuario.xls";
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
    @RequestMapping(value = {"/cbofilterInvusuario"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvusuario() {
        List<Invusuario> list = invusuarioRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdusuario().toString(), list.get(i).getIdusuario().toString()));
        }
        return response;
    }
    
}

