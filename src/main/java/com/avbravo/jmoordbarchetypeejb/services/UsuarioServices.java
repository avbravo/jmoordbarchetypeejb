/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.jmoordbarchetypeejb.services;

import com.avbravo.jmoordbarchetypeejb.entity.Usuario;
import com.avbravo.jmoordbarchetypeejb.repository.UsuarioRepository;
import com.avbravo.jmoordbutils.JsfUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @authoravbravo
 */
@Stateless
public class UsuarioServices {

    @Inject
    UsuarioRepository repository;
    
       
     List<Usuario> usuarioList = new ArrayList<>();
     public List<Usuario> complete(String query) {
        List<Usuario> suggestions = new ArrayList<>();
         try {
          suggestions=repository.complete(query);
        } catch (Exception e) {
            JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
        }

           return suggestions;
    }
      public List<Usuario> getUsuarioList() {
          try {
          usuarioList= repository.findAll(new Document("username",1));
        } catch (Exception e) {
              JsfUtil.errorMessage("getUsuarioList() " + e.getLocalizedMessage());
        }

        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
    
        // <editor-fold defaultstate="collapsed" desc="isDeleted(Usuario usuario)">
  
    public Boolean isDeleted(Usuario usuario){
        Boolean found=false;
        try {
//            Document doc = new Document("usuario.username",usuario.getUsername());
//            Integer count = solicitudRepository.count(doc);
//            if (count > 0){
//                return false;
//            }
            
        } catch (Exception e) {
             JsfUtil.errorMessage("isDeleted() " + e.getLocalizedMessage());
        }
        return true;
    }  // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="findById(String id)">

    public Usuario findById(String id){
           Usuario usuario = new Usuario();
        try {
         
            usuario.setUsername(id);
            Optional<Usuario> optional = repository.findById(usuario);
            if (optional.isPresent()) {
               return optional.get();
            } 
        } catch (Exception e) {
             JsfUtil.errorMessage("findById() " + e.getLocalizedMessage());
        }
      
      return usuario;
    }
    // </editor-fold>
}
