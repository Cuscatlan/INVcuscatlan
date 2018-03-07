package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invcliente;

import net.cuscatlan.repository.InvclienteRepository;
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
public class InvclienteController {
    
    @Autowired
    InvclienteRepository invclienteRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvcliente")
    public ModelAndView indexInvcliente(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invcliente", new Invcliente());
        mv.setViewName("Invcliente/Invcliente.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvcliente", method = RequestMethod.POST)
    public @ResponseBody String saveInvcliente(@ModelAttribute("Invcliente") @Validated Invcliente invcliente ) {
         invclienteRepository.save(invcliente);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvcliente", method = RequestMethod.POST)
    public @ResponseBody String deleteInvcliente(@ModelAttribute("Invcliente")  Invcliente invcliente ) {
         invclienteRepository.delete(invcliente);
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
    @RequestMapping(value = "/gridInvcliente", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invcliente> gridInvcliente(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invcliente> list = invclienteRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idcliente") 
            ,JqgridFilter.getField(filters, "nombrecliente") 
            ,JqgridFilter.getField(filters, "duicliente") 
            ,JqgridFilter.getField(filters, "nitcliente") 
            ,JqgridFilter.getField(filters, "espersonacliente") 
            ,JqgridFilter.getField(filters, "girocliente") 
            ,JqgridFilter.getField(filters, "creditocliente") 
            ,JqgridFilter.getField(filters, "registrocliente") 
            ,JqgridFilter.getField(filters, "diascreditocliente") 
            ,JqgridFilter.getField(filters, "invtipoclienteDescriptionDelegate") 
        );

       JqgridResponse<Invcliente> jqgridInvcliente = new JqgridResponse<Invcliente>();
       return jqgridInvcliente.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvcliente", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvcliente(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idcliente"); 
        header.add("nombrecliente"); 
        header.add("duicliente"); 
        header.add("nitcliente"); 
        header.add("espersonacliente"); 
        header.add("girocliente"); 
        header.add("creditocliente"); 
        header.add("registrocliente"); 
        header.add("diascreditocliente"); 
        header.add("invtipoclienteDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invcliente", header);
        
        List<Object[]> list = invclienteRepository.findByFilters(
           JqgridFilter.getField(filters, "idcliente") 
            ,JqgridFilter.getField(filters, "nombrecliente") 
            ,JqgridFilter.getField(filters, "duicliente") 
            ,JqgridFilter.getField(filters, "nitcliente") 
            ,JqgridFilter.getField(filters, "espersonacliente") 
            ,JqgridFilter.getField(filters, "girocliente") 
            ,JqgridFilter.getField(filters, "creditocliente") 
            ,JqgridFilter.getField(filters, "registrocliente") 
            ,JqgridFilter.getField(filters, "diascreditocliente") 
            ,JqgridFilter.getField(filters, "invtipoclienteDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invcliente.xls";
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
    @RequestMapping(value = {"/cbofilterInvcliente"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvcliente() {
        List<Invcliente> list = invclienteRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdcliente().toString(), list.get(i).getIdcliente().toString()));
        }
        return response;
    }
    
}

