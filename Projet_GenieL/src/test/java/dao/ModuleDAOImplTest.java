package dao ;
import dao.ModuleDAOImpl;
import model.Module;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.List;

import static org.mockito.Mockito.*;

public class ModuleDAOImplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private ModuleDAOImpl moduleDAO;

    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() throws SQLException {
        // Arrange
        Module module = new Module(1, "Mathematics", 101, 2);
        String sql = "INSERT INTO module (id_module, nom, id_filiere, id_semestre) VALUES (?, ?, ?, ?)";
        when(mockConnection.prepareStatement(sql)).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.create(module);

        // Assert
        verify(mockPreparedStatement).setInt(1, 1);
        verify(mockPreparedStatement).setString(2, "Mathematics");
        verify(mockPreparedStatement).setInt(3, 101);
        verify(mockPreparedStatement).setInt(4, 2);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testFindById() throws SQLException {
        // Arrange
        int idModule = 1;
        String sql = "SELECT * FROM module WHERE id_module = ?";
        when(mockConnection.prepareStatement(sql)).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id_module")).thenReturn(1);
        when(mockResultSet.getString("nom")).thenReturn("Mathematics");
        when(mockResultSet.getInt("id_filiere")).thenReturn(101);
        when(mockResultSet.getInt("id_semestre")).thenReturn(2);

        // Act
        Module module = moduleDAO.findById(idModule);

        // Assert
        assert module != null;
        assert module.getIdModule() == 1;
        assert module.getNom().equals("Mathematics");
    }

    @Test
    public void testFindAll() throws SQLException {
        // Arrange
        String sql = "SELECT * FROM module";
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(sql)).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Simulate one record
        when(mockResultSet.getInt("id_module")).thenReturn(1);
        when(mockResultSet.getString("nom")).thenReturn("Mathematics");
        when(mockResultSet.getInt("id_filiere")).thenReturn(101);
        when(mockResultSet.getInt("id_semestre")).thenReturn(2);

        // Act
        List<Module> modules = moduleDAO.findAll();

        // Assert
        assert modules.size() == 1;
        assert modules.get(0).getNom().equals("Mathematics");
    }

    @Test
    public void testUpdate() throws SQLException {
        // Arrange
        Module module = new Module(1, "Mathematics Updated", 101, 2);
        String sql = "UPDATE module SET nom = ?, id_filiere = ?, id_semestre = ? WHERE id_module = ?";
        when(mockConnection.prepareStatement(sql)).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.update(module);

        // Assert
        verify(mockPreparedStatement).setString(1, "Mathematics Updated");
        verify(mockPreparedStatement).setInt(2, 101);
        verify(mockPreparedStatement).setInt(3, 2);
        verify(mockPreparedStatement).setInt(4, 1);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testDelete() throws SQLException {
        // Arrange
        int idModule = 1;
        String sql = "DELETE FROM module WHERE id_module = ?";
        when(mockConnection.prepareStatement(sql)).thenReturn(mockPreparedStatement);

        // Act
        moduleDAO.delete(idModule);

        // Assert
        verify(mockPreparedStatement).setInt(1, 1);
        verify(mockPreparedStatement).executeUpdate();
    }
}
