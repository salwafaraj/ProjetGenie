package dao;



import model.Module;

import java.util.List;

public interface ModuleDAO {
    // Créer un nouveau module
    void create(Module module);

    // Récupérer un module par son ID
    Module findById(int idModule);

    // Récupérer tous les modules
    List<Module> findAll();

    // Mettre à jour un module
    void update(Module module);

    // Supprimer un module
    void delete(int idModule);
}
