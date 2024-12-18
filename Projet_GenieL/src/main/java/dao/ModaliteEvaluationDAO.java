package dao;

import model.ModaliteEvaluation;

import java.util.List;

public interface ModaliteEvaluationDAO {

    // Méthode pour créer une nouvelle ModaliteEvaluation
    void create(ModaliteEvaluation modaliteEvaluation);

    // Méthode pour trouver une ModaliteEvaluation par son id
    ModaliteEvaluation findById(int idElementModule);

    // Méthode pour récupérer toutes les ModaliteEvaluations
    List<ModaliteEvaluation> findAll();

    // Méthode pour mettre à jour une ModaliteEvaluation
    void update(ModaliteEvaluation modaliteEvaluation);

    // Méthode pour supprimer une ModaliteEvaluation par son id
    void delete(int idElementModule);
}
