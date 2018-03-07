package net.cuscatlan.controller;

import java.util.List;
import net.cuscatlan.common.ObjectUtils;
import net.cuscatlan.common.JqgridFilter;
import net.cuscatlan.common.JqgridResponse;
import net.cuscatlan.domain.Invproducto;

import net.cuscatlan.repository.InvproductoRepository;
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
public class InvproductoController {
    
    @Autowired
    InvproductoRepository invproductoRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexInvproducto")
    public ModelAndView indexInvproducto(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("invproducto", new Invproducto());
        mv.setViewName("Invproducto/Invproducto.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveInvproducto", method = RequestMethod.POST)
    public @ResponseBody String saveInvproducto(@ModelAttribute("Invproducto") @Validated Invproducto invproducto ) {
         invproductoRepository.save(invproducto);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteInvproducto", method = RequestMethod.POST)
    public @ResponseBody String deleteInvproducto(@ModelAttribute("Invproducto")  Invproducto invproducto ) {
         invproductoRepository.delete(invproducto);
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
    @RequestMapping(value = "/gridInvproducto", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<Invproducto> gridInvproducto(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<Invproducto> list = invproductoRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idproducto") 
            ,JqgridFilter.getField(filters, "porcentaje1") 
            ,JqgridFilter.getField(filters, "nombreproducto") 
            ,JqgridFilter.getField(filters, "precioventa3") 
            ,JqgridFilter.getField(filters, "gravado") 
            ,JqgridFilter.getField(filters, "imagen") 
            ,JqgridFilter.getField(filters, "codigoproducto") 
            ,JqgridFilter.getField(filters, "precioventa4") 
            ,JqgridFilter.getField(filters, "preciocosto") 
            ,JqgridFilter.getField(filters, "porcentaje2") 
            ,JqgridFilter.getField(filters, "presentacion") 
            ,JqgridFilter.getField(filters, "porcentaje") 
            ,JqgridFilter.getField(filters, "preciopromedio") 
            ,JqgridFilter.getField(filters, "descuento") 
            ,JqgridFilter.getField(filters, "porcentaje4") 
            ,JqgridFilter.getField(filters, "ubicacionfisica") 
            ,JqgridFilter.getField(filters, "costo") 
            ,JqgridFilter.getField(filters, "porcentaje3") 
            ,JqgridFilter.getField(filters, "precioventa2") 
            ,JqgridFilter.getField(filters, "precioventa1") 
            ,JqgridFilter.getField(filters, "invfamiliaproductoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invtipoproductoDescriptionDelegate") 
        );

       JqgridResponse<Invproducto> jqgridInvproducto = new JqgridResponse<Invproducto>();
       return jqgridInvproducto.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportInvproducto", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportInvproducto(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idproducto"); 
        header.add("porcentaje1"); 
        header.add("nombreproducto"); 
        header.add("precioventa3"); 
        header.add("gravado"); 
        header.add("imagen"); 
        header.add("codigoproducto"); 
        header.add("precioventa4"); 
        header.add("preciocosto"); 
        header.add("porcentaje2"); 
        header.add("presentacion"); 
        header.add("porcentaje"); 
        header.add("preciopromedio"); 
        header.add("descuento"); 
        header.add("porcentaje4"); 
        header.add("ubicacionfisica"); 
        header.add("costo"); 
        header.add("porcentaje3"); 
        header.add("precioventa2"); 
        header.add("precioventa1"); 
        header.add("invfamiliaproductoDescriptionDelegate"); 
        header.add("invtipoproductoDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "Invproducto", header);
        
        List<Object[]> list = invproductoRepository.findByFilters(
           JqgridFilter.getField(filters, "idproducto") 
            ,JqgridFilter.getField(filters, "porcentaje1") 
            ,JqgridFilter.getField(filters, "nombreproducto") 
            ,JqgridFilter.getField(filters, "precioventa3") 
            ,JqgridFilter.getField(filters, "gravado") 
            ,JqgridFilter.getField(filters, "imagen") 
            ,JqgridFilter.getField(filters, "codigoproducto") 
            ,JqgridFilter.getField(filters, "precioventa4") 
            ,JqgridFilter.getField(filters, "preciocosto") 
            ,JqgridFilter.getField(filters, "porcentaje2") 
            ,JqgridFilter.getField(filters, "presentacion") 
            ,JqgridFilter.getField(filters, "porcentaje") 
            ,JqgridFilter.getField(filters, "preciopromedio") 
            ,JqgridFilter.getField(filters, "descuento") 
            ,JqgridFilter.getField(filters, "porcentaje4") 
            ,JqgridFilter.getField(filters, "ubicacionfisica") 
            ,JqgridFilter.getField(filters, "costo") 
            ,JqgridFilter.getField(filters, "porcentaje3") 
            ,JqgridFilter.getField(filters, "precioventa2") 
            ,JqgridFilter.getField(filters, "precioventa1") 
            ,JqgridFilter.getField(filters, "invfamiliaproductoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "invtipoproductoDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "Invproducto.xls";
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
    @RequestMapping(value = {"/cbofilterInvproducto"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterInvproducto() {
        List<Invproducto> list = invproductoRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdproducto().toString(), list.get(i).getIdproducto().toString()));
        }
        return response;
    }
    
}

