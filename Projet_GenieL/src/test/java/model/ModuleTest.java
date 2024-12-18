package model;




import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuleTest {

    private Module module;

    @Before
    public void setUp() {
        // Initialisation d'une instance de Module pour les tests
        module = new Module(1, "Programmation Java", 2, 3);
    }

    @Test
    public void testConstructorAndGetters() {
        // Test du constructeur et des getters
        assertEquals(1, module.getIdModule());
        assertEquals("Programmation Java", module.getNom());
        assertEquals(2, module.getIdFiliere());
        assertEquals(3, module.getIdSemestre());
    }

    @Test
    public void testSetters() {
        // Test des setters
        module.setIdModule(10);
        module.setNom("Systèmes d'exploitation");
        module.setIdFiliere(4);
        module.setIdSemestre(2);

        assertEquals(10, module.getIdModule());
        assertEquals("Systèmes d'exploitation", module.getNom());
        assertEquals(4, module.getIdFiliere());
        assertEquals(2, module.getIdSemestre());
    }

    @Test
    public void testToString() {
        // Test de la méthode toString
        String expected = "Module{id_module=1, nom='Programmation Java', id_filiere=2, id_semestre=3}";
        assertEquals(expected, module.toString());
    }
}
