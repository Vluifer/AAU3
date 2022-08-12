package com.aau3.docente.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aau3.docente.Dao.DocenteDao;
import com.aau3.docente.Models.Docente;

// Para que sprintBoot La reconozca como una clase de servicio
@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteDao docenteDao;

    @Override
     // Dependiendo del tipo de meotodo es el tipo de transaccion que vamos a realizar
    // en este como slo vamos a leer datos ponemos transactional
    @Transactional(readOnly = true)
    public List<Docente> ListarDocente() {
        // Como el metodo findAll regresa un tipo objeto lo casteamos
        // para que nos regrese una lista
        return  (List<Docente>) docenteDao.findAll();
    }

   @Override
   // En el caso de guardar como va modifacar en la base datos si debe hacer commit o rollback
    // se deja solo transactional
    @Transactional
    public void guardar(Docente docente) {
        docenteDao.save(docente);
    }

    @Override
    public void eliminar(Docente docente) {
        docenteDao.delete(docente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Docente buscarid(Docente docente) {
         // Debemos poner el orElse por si no encuentra lo que esta buscando le mandamos null
        return docenteDao.findById(docente.getId()).orElse(null);
    }
}
