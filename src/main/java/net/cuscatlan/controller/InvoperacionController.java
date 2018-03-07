package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invoperacion;

import net.cuscatlan.repository.InvoperacionRepository;
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
public class InvoperacionController {
    
    @Autowired
    InvoperacionRepository invoperacionRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvoperacion")
    public ModelAndView indexInvoperacion(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invoperacion", new Invoperacion());
        mv.setViewName("Invoperacion/Invoperacion.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvoperacion", method = RequestMethod.POST)
    public @ResponseBody String saveInvoperacion(@ModelAttribute("Invoperacion") @Validated Invoperacion invoperacion ) {
         invoperacionRepository.save(invoperacion);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvoperacion", method = RequestMethod.POST)
    public @ResponseBody String deleteInvoperacion(@ModelAttribute("Invoperacion")  Invoperacion invoperacion ) {
         invoperacionRepository.delete(invoperacion);
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
    @RequestMapping(value = "/gridInvoperacion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invoperacion> gridInvoperacion(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invoperacion> list = invoperacionRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idoperacion") 
            ,JqgridFilter.getField(filters, "fechaentrega") 
            ,JqgridFilter.getField(filters, "numeroenvioorden") 
            ,JqgridFilter.getField(filters, "recervadooperacion") 
            ,JqgridFilter.getField(filters, "numeroordencompra") 
            ,JqgridFilter.getField(filters, "fechaoperacion") 
            ,JqgridFilter.getField(filters, "numerodocumento") 
            ,JqgridFilter.getField(filters, "ordenentregada") 
            ,JqgridFilter.getField(filters, "estadooperacion") 
            ,JqgridFilter.getField(filters, "fechacontableoperacion") 
            ,JqgridFilter.getField(filters, "diascreditooperacion") 
            ,JqgridFilter.getField(filters, "comentariosoperacion") 
            ,JqgridFilter.getField(filters, "fechaivaoperacion") 
            ,JqgridFilter.getField(filters, "ordenrecibida") 
            ,JqgridFilter.getField(filters, "invproveedorDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invclienteDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invtipooperacionesDescriptionDelegate") 
        );

       JqgridResponse<Invoperacion> jqgridInvoperacion = new JqgridResponse<Invoperacion>();
       return jqgridInvoperacion.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvoperacion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvoperacion(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idoperacion"); 
        header.add("fechaentrega"); 
        header.add("numeroenvioorden"); 
        header.add("recervadooperacion"); 
        header.add("numeroordencompra"); 
        header.add("fechaoperacion"); 
        header.add("numerodocumento"); 
        header.add("ordenentregada"); 
        header.add("estadooperacion"); 
        header.add("fechacontableoperacion"); 
        header.add("diascreditooperacion"); 
        header.add("comentariosoperacion"); 
        header.add("fechaivaoperacion"); 
        header.add("ordenrecibida"); 
        header.add("invproveedorDescriptionDelegate"); 
        header.add("invclienteDescriptionDelegate"); 
        header.add("invtipooperacionesDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invoperacion", header);
        
        List<Object[]> list = invoperacionRepository.findByFilters(
           JqgridFilter.getField(filters, "idoperacion") 
            ,JqgridFilter.getField(filters, "fechaentrega") 
            ,JqgridFilter.getField(filters, "numeroenvioorden") 
            ,JqgridFilter.getField(filters, "recervadooperacion") 
            ,JqgridFilter.getField(filters, "numeroordencompra") 
            ,JqgridFilter.getField(filters, "fechaoperacion") 
            ,JqgridFilter.getField(filters, "numerodocumento") 
            ,JqgridFilter.getField(filters, "ordenentregada") 
            ,JqgridFilter.getField(filters, "estadooperacion") 
            ,JqgridFilter.getField(filters, "fechacontableoperacion") 
            ,JqgridFilter.getField(filters, "diascreditooperacion") 
            ,JqgridFilter.getField(filters, "comentariosoperacion") 
            ,JqgridFilter.getField(filters, "fechaivaoperacion") 
            ,JqgridFilter.getField(filters, "ordenrecibida") 
            ,JqgridFilter.getField(filters, "invproveedorDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invclienteDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invtipooperacionesDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invoperacion.xls";
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
    @RequestMapping(value = {"/cbofilterInvoperacion"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvoperacion() {
        List<Invoperacion> list = invoperacionRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdoperacion().toString(), list.get(i).getIdoperacion().toString()));
        }
        return response;
    }
    
}

