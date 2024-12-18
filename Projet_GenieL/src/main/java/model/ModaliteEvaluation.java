package model;

import java.util.List;

public class ModaliteEvaluation {
    private int id_modalite;              
    private String type;                  
    private double coefficient;        
    private int id_element_module;        
    private List<ModaliteEvaluation> modalitesEvaluations; 

    // Constructeur complet
    public ModaliteEvaluation(int id_modalite, String type, double coefficient, int id_element_module, List<ModaliteEvaluation> modalitesEvaluations) {
        this.id_modalite = id_modalite;
        this.type = type;
        this.coefficient = coefficient;
        this.id_element_module = id_element_module;
        this.modalitesEvaluations = modalitesEvaluations;
    }

    // Constructeur simplifié sans la liste des modalités
    public ModaliteEvaluation(int id_modalite, String type, double coefficient, int id_element_module) {
        this.id_modalite = id_modalite;
        this.type = type;
        this.coefficient = coefficient;
        this.id_element_module = id_element_module;
        this.modalitesEvaluations = null; // Par défaut, la liste est null
    }

    // Getters et Setters
    public int getIdModalite() {
        return id_modalite;
    }

    public void setIdModalite(int id_modalite) {
        this.id_modalite = id_modalite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getIdElementModule() {
        return id_element_module;
    }

    public void setIdElementModule(int id_element_module) {
        this.id_element_module = id_element_module;
    }

    public List<ModaliteEvaluation> getModalitesEvaluations() {
        return modalitesEvaluations;
    }

    public void setModalitesEvaluations(List<ModaliteEvaluation> modalitesEvaluations) {
        this.modalitesEvaluations = modalitesEvaluations;
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "ModaliteEvaluation{" +
               "id_modalite=" + id_modalite +
               ", type='" + type + '\'' +
               ", coefficient=" + coefficient +
               ", id_element_module=" + id_element_module +
               ", modalitesEvaluations=" + modalitesEvaluations +
               '}';
    }
}
