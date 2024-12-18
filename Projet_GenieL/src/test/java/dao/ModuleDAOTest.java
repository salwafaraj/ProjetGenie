package dao;

import model.Module;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ModuleDAOTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private Statement mockStatement;

    private ModuleDAOImpl moduleDAO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        moduleDAO = new ModuleDAOImpl(mockConnection);
    }

    @Test
    public void testCreate() throws Exception {
        // Arrange
        Module module = new Module(1, "Mathematics", 101, 1);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.create(module);

        // Assert
        verify(mockPreparedStatement, times(1)).setInt(1, module.getIdModule());
        verify(mockPreparedStatement, times(1)).setString(2, module.getNom());
        verify(mockPreparedStatement, times(1)).setInt(3, module.getIdFiliere());
        verify(mockPreparedStatement, times(1)).setInt(4, module.getIdSemestre());
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testFindById() throws Exception {
        // Arrange
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id_module")).thenReturn(1);
        when(mockResultSet.getString("nom")).thenReturn("Mathematics");
        when(mockResultSet.getInt("id_filiere")).thenReturn(101);
        when(mockResultSet.getInt("id_semestre")).thenReturn(1);

        // Act
        Module module = moduleDAO.findById(1);

        // Assert
        assertNotNull(module);
        assertEquals(1, module.getIdModule());
        assertEquals("Mathematics", module.getNom());
        assertEquals(101, module.getIdFiliere());
        assertEquals(1, module.getIdSemestre());
    }

    @Test
    public void testFindAll() throws Exception {
        // Arrange
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows
        when(mockResultSet.getInt("id_module")).thenReturn(1, 2);
        when(mockResultSet.getString("nom")).thenReturn("Mathematics", "Physics");
        when(mockResultSet.getInt("id_filiere")).thenReturn(101, 102);
        when(mockResultSet.getInt("id_semestre")).thenReturn(1, 2);

        // Act
        List<Module> modules = moduleDAO.findAll();

        // Assert
        assertNotNull(modules);
        assertEquals(2, modules.size());
        assertEquals("Mathematics", modules.get(0).getNom());
        assertEquals("Physics", modules.get(1).getNom());
    }

    @Test
    public void testUpdate() throws Exception {
        // Arrange
        Module module = new Module(1, "Advanced Mathematics", 101, 1);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.update(module);

        // Assert
        verify(mockPreparedStatement, times(1)).setString(1, module.getNom());
        verify(mockPreparedStatement, times(1)).setInt(2, module.getIdFiliere());
        verify(mockPreparedStatement, times(1)).setInt(3, module.getIdSemestre());
        verify(mockPreparedStatement, times(1)).setInt(4, module.getIdModule());
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDelete() throws Exception {
        // Arrange
        int idModule = 1;
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.delete(idModule);

        // Assert
        verify(mockPreparedStatement, times(1)).setInt(1, idModule);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
