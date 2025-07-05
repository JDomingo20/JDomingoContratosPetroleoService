package com.JDomingoContratosPetroleo.DomingoContratosPetroleo.RestController;

import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.NodoEntrega;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.NodoRecepcion;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Result;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.ResultadoLectura;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Usuario;
import com.JDomingoContratosPetroleo.DomingoContratosPetroleo.JPA.Zona;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/CargaMasiva")
public class PetroleoRestController {

    public ResultadoLectura LecturaArchivo(File archivo) {
        ResultadoLectura resultado = new ResultadoLectura();

        Set<String> ZonaUnica = new HashSet<>();
        List<Zona> listaZonas = new ArrayList<>();
        Set<String> UsuarioUnico = new HashSet<>();
        List<Usuario> listaUsuarios = new ArrayList<>();
        Set<String> NRecepcionUnico = new HashSet<>();
        List<NodoRecepcion> listaNodoRecepcions = new ArrayList<>();
        Set<String> NEntrgaUnico = new HashSet<>();
        List<NodoEntrega> listaNodoEntregas = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(archivo);) {
            for (Sheet listaZona : workbook) {
                for (Row row : listaZona) {
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    //Zonas
                    Zona zona = new Zona();
                    String ZonaInyeccion = row.getCell(7).getStringCellValue();
                    String ZonaExtraccion = row.getCell(8).getStringCellValue();

                    if (!ZonaUnica.contains(ZonaInyeccion)) {
                        ZonaUnica.add(ZonaInyeccion);
                        zona.setDescripcion(ZonaInyeccion);
                        listaZonas.add(zona);
                    } else if (!ZonaUnica.contains(ZonaExtraccion)) {
                        ZonaUnica.add(ZonaExtraccion);
                        zona.setDescripcion(ZonaExtraccion);
                        listaZonas.add(zona);
                    }

                    //Usuarios
                    Usuario usuario = new Usuario();
                    String NombreUsuario = row.getCell(2).getStringCellValue();

                    if (!UsuarioUnico.contains(NombreUsuario)) {
                        UsuarioUnico.add(NombreUsuario);
                        usuario.setNombre(NombreUsuario);
                        listaUsuarios.add(usuario);
                    }

                    //Nodo de recepcion
                    NodoRecepcion nodoRecepcion = new NodoRecepcion();
                    String ClaveRecepcion = row.getCell(3).getStringCellValue();
                    
                    if (!NRecepcionUnico.contains(ClaveRecepcion)) {
                        NRecepcionUnico.add(ClaveRecepcion);
                        nodoRecepcion.setClave(ClaveRecepcion);
                        nodoRecepcion.setDescripcion(row.getCell(4).getStringCellValue());
                        listaNodoRecepcions.add(nodoRecepcion);
                        
                    }
                    
                    //Nodo de Entrega
                    NodoEntrega nodoEntrega = new NodoEntrega();
                    String ClaveEntrega = row.getCell(5).getStringCellValue();
                    
                    if(!NEntrgaUnico.contains(ClaveEntrega)){
                        NEntrgaUnico.add(ClaveEntrega);
                        nodoEntrega.setClave(ClaveEntrega);
                        nodoEntrega.setDescripcion(row.getCell(6).getStringCellValue());
                        listaNodoEntregas.add(nodoEntrega);
                    }
                    
                }
            }

        } catch (Exception ex) {
            System.out.println("Hubo un error quien sabe donde");
            
            listaZonas = null;
        }
        resultado.setZonas(listaZonas);
        resultado.setUsuarios(listaUsuarios);
        resultado.setNrecepciones(listaNodoRecepcions);
        resultado.setNentregas(listaNodoEntregas);
        return resultado;
    }

    @PostMapping
    public ResponseEntity CargaMasiva(MultipartFile archivo) {
        Result result = new Result();
        try {
            if (archivo != null && !archivo.isEmpty()) {
                String tipoArchivo = archivo.getOriginalFilename().split("\\.")[1];

                String root = System.getProperty("user.dir");
                String path = "src/main/resources/static/Archivos";
                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmSS"));
                String absolutePath = root + "/" + path + "/" + fecha + archivo.getOriginalFilename();
                archivo.transferTo(new File(absolutePath));

                //Leer archivo
                ResultadoLectura resultadoLectura = LecturaArchivo(new File(absolutePath));
                List<Zona> listaZonas = resultadoLectura.getZonas();
                List<Usuario> listaUsuarios = resultadoLectura.getUsuarios();
                List<NodoRecepcion> listaNodoRecepcions = resultadoLectura.getNrecepciones();
                List<NodoEntrega> listaNodoEntregas = resultadoLectura.getNentregas();
                System.out.println("");

            }
            result.correct = true;
        } catch (Exception ex) {
            ex.getLocalizedMessage();
            result.correct = false;
        }

        return ResponseEntity.ok().body(result);
    }
}
