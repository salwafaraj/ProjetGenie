package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ModaliteEvaluationTest {

    private ModaliteEvaluation modaliteEvaluation;

    @Before
    public void setUp() {
        // Initialisation d'une instance de ModaliteEvaluation pour les tests
        modaliteEvaluation = new ModaliteEvaluation(1, "Examen final", 2.5, 101);
    }

    @Test
    public void testConstructorAndGetters() {
        // Test du constructeur et des getters
        assertEquals(1, modaliteEvaluation.getIdModalite());
        assertEquals("Examen final", modaliteEvaluation.getType());
        assertEquals(2.5, modaliteEvaluation.getCoefficient(), 0.01);
        assertEquals(101, modaliteEvaluation.getIdElementModule());
        assertNull(modaliteEvaluation.getModalitesEvaluations()); // La liste est null par défaut
    }

    @Test
    public void testConstructorWithList() {
        // Test du constructeur avec une liste de modalités
        List<ModaliteEvaluation> modalitesList = new ArrayList<>();
        modalitesList.add(new ModaliteEvaluation(2, "Devoir", 1.5, 101));
        modalitesList.add(new ModaliteEvaluation(3, "Projet", 3.0, 101));

        ModaliteEvaluation modaliteWithList = new ModaliteEvaluation(1, "Examen final", 2.5, 101, modalitesList);

        assertEquals(1, modaliteWithList.getIdModalite());
        assertEquals("Examen final", modaliteWithList.getType());
        assertEquals(2.5, modaliteWithList.getCoefficient(), 0.01);
        assertEquals(101, modaliteWithList.getIdElementModule());
        assertEquals(2, modaliteWithList.getModalitesEvaluations().size()); // La liste contient 2 éléments
    }

    @Test
    public void testSetters() {
        // Test des setters
        modaliteEvaluation.setIdModalite(10);
        modaliteEvaluation.setType("Contrôle continu");
        modaliteEvaluation.setCoefficient(3.0);
        modaliteEvaluation.setIdElementModule(202);

        assertEquals(10, modaliteEvaluation.getIdModalite());
        assertEquals("Contrôle continu", modaliteEvaluation.getType());
        assertEquals(3.0, modaliteEvaluation.getCoefficient(), 0.01);
        assertEquals(202, modaliteEvaluation.getIdElementModule());
    }

    @Test
    public void testToString() {
        // Test de la méthode toString
        String expected = "ModaliteEvaluation{" +
                "id_modalite=1, type='Examen final', coefficient=2.5, id_element_module=101, modalitesEvaluations=null" +
                "}";
        assertEquals(expected, modaliteEvaluation.toString());
    }
}
