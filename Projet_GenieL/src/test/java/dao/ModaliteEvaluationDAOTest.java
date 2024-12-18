package dao;

import model.ModaliteEvaluation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ModaliteEvaluationDAOTest {

    private ModaliteEvaluationDAO modaliteEvaluationDAO;  // L'interface à tester
    private ModaliteEvaluation modaliteEvaluation;

    @Before
    public void setUp() {
        // Création du mock pour l'interface ModaliteEvaluationDAO
        modaliteEvaluationDAO = mock(ModaliteEvaluationDAO.class);

        // Création d'une instance de ModaliteEvaluation pour les tests
        modaliteEvaluation = new ModaliteEvaluation(1, "Examen final", 2.5, 101);
    }

    @Test
    public void testCreate() {
        // Test de la méthode create
        modaliteEvaluationDAO.create(modaliteEvaluation);

        // Vérification que la méthode create a bien été appelée une fois avec l'objet modaliteEvaluation
        verify(modaliteEvaluationDAO, times(1)).create(modaliteEvaluation);
    }

    @Test
    public void testFindById() {
        // Comportement simulé pour la méthode findById
        when(modaliteEvaluationDAO.findById(101)).thenReturn(modaliteEvaluation);

        // Test de la méthode findById
        ModaliteEvaluation result = modaliteEvaluationDAO.findById(101);

        // Vérification que l'objet retourné est celui attendu
        assertNotNull(result);
        assertEquals(modaliteEvaluation.getIdModalite(), result.getIdModalite());
        assertEquals(modaliteEvaluation.getType(), result.getType());
    }

    @Test
    public void testFindAll() {
        // Comportement simulé pour la méthode findAll
        List<ModaliteEvaluation> modalitesList = new ArrayList<>();
        modalitesList.add(modaliteEvaluation);
        when(modaliteEvaluationDAO.findAll()).thenReturn(modalitesList);

        // Test de la méthode findAll
        List<ModaliteEvaluation> result = modaliteEvaluationDAO.findAll();

        // Vérification que la liste retournée contient bien l'objet modaliteEvaluation
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(modaliteEvaluation.getIdModalite(), result.get(0).getIdModalite());
    }

    @Test
    public void testUpdate() {
        // Test de la méthode update
        modaliteEvaluation.setType("Contrôle continu");
        modaliteEvaluationDAO.update(modaliteEvaluation);

        // Vérification que la méthode update a bien été appelée avec l'objet modifié
        verify(modaliteEvaluationDAO, times(1)).update(modaliteEvaluation);
    }

    @Test
    public void testDelete() {
        // Test de la méthode delete
        modaliteEvaluationDAO.delete(101);

        // Vérification que la méthode delete a bien été appelée une fois avec l'id 101
        verify(modaliteEvaluationDAO, times(1)).delete(101);
    }
}
