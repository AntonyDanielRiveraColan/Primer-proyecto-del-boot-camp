package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.Service.IParent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apiparent/v1")
@Api(value = "Servicio Rest para los Parents")
public class ParentController {
   private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

   @Autowired
   private IParent parentDAO;

   @ApiOperation("Retorna una lista de Parents")
   @GetMapping("/read")
   @ResponseStatus(HttpStatus.OK)
    public List<Parent> findAllParents(){
      LOG.info("com.ejemplo2.ejemplo2.Controller - findAllParents");
      return parentDAO.getAllParents();
   }

   @PostMapping("/create")
   @ResponseStatus(HttpStatus.CREATED)
    public void addParent(@RequestBody Parent obj){
      LOG.info("com.ejemplo2.ejemplo2.Controller - addParent");
       parentDAO.addParent(obj);
   }

   @PutMapping("/update")
   @ResponseStatus(HttpStatus.OK)
    public void updateParent(@RequestBody Parent obj){
      LOG.info("com.ejemplo2.ejemplo2.Controller - updateParent");
      parentDAO.updateParent(obj);
   }

   @DeleteMapping("/delete/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void deleteParent(@PathVariable("id") Integer id){
      LOG.info("com.ejemplo2.ejemplo2.Controller - deleteParent");
      parentDAO.deleteParent(id);
   }
}
