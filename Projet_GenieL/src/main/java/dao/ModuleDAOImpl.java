package dao;

import model.Module;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAOImpl implements ModuleDAO {
    private Connection connection;

    // Constructeur avec la connexion à la base de données
    public ModuleDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Module module) {
        String sql = "INSERT INTO module (id_module, nom, id_filiere, id_semestre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, module.getIdModule());
            statement.setString(2, module.getNom());
            statement.setInt(3, module.getIdFiliere());
            statement.setInt(4, module.getIdSemestre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Module findById(int id_module) {
        String sql = "SELECT * FROM module WHERE id_module = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_module);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Module(
                        resultSet.getInt("id_module"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_filiere"),
                        resultSet.getInt("id_semestre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Module> findAll() {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM module";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                modules.add(new Module(
                        resultSet.getInt("id_module"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_filiere"),
                        resultSet.getInt("id_semestre")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modules;
    }

    @Override
    public void update(Module module) {
        String sql = "UPDATE module SET nom = ?, id_filiere = ?, id_semestre = ? WHERE id_module = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, module.getNom());
            statement.setInt(2, module.getIdFiliere());
            statement.setInt(3, module.getIdSemestre());
            statement.setInt(4, module.getIdModule());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_module) {
        String sql = "DELETE FROM module WHERE id_module = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_module);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
