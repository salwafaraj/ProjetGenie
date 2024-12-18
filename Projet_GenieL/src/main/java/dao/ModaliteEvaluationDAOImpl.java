package dao;

import model.ModaliteEvaluation;
import utils.dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModaliteEvaluationDAOImpl implements ModaliteEvaluationDAO {

    private Connection connection;

    // Constructeur pour établir la connexion
    public ModaliteEvaluationDAOImpl(Connection connection2) {
        try {
            this.connection = dbutil.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(ModaliteEvaluation modaliteEvaluation) {
        // Liste des types valides pour l'ENUM (version compatible Java 7 et plus)
        List<String> validTypes = new ArrayList<>();
        validTypes.add("CC");
        validTypes.add("TP");
        validTypes.add("Projet");
        validTypes.add("Presentation");
        
        // Vérifier si le type est valide
        if (!validTypes.contains(modaliteEvaluation.getType())) {
            throw new IllegalArgumentException("Type invalide: " + modaliteEvaluation.getType());
        }

        String sql = "INSERT INTO modalite_evaluation (id_modalite, type, coefficient, id_element_module) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Assigner les valeurs aux paramètres de la requête préparée
            statement.setInt(1, modaliteEvaluation.getIdModalite());    // id_modalite
            statement.setString(2, modaliteEvaluation.getType());        // type
            statement.setDouble(3, modaliteEvaluation.getCoefficient()); // coefficient
            statement.setInt(4, modaliteEvaluation.getIdElementModule()); // id_element_module
            // Exécuter la requête d'insertion
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModaliteEvaluation findById(int idModalite) {
        String sql = "SELECT * FROM modalite_evaluation WHERE id_modalite = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idModalite);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new ModaliteEvaluation(
                        resultSet.getInt("id_modalite"),
                        resultSet.getString("type"),
                        resultSet.getDouble("coefficient"),
                        resultSet.getInt("id_element_module")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ModaliteEvaluation> findAll() {
        List<ModaliteEvaluation> modalitesEvaluations = new ArrayList<>();
        String sql = "SELECT * FROM modalite_evaluation";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                modalitesEvaluations.add(new ModaliteEvaluation(
                        resultSet.getInt("id_modalite"),
                        resultSet.getString("type"),
                        resultSet.getDouble("coefficient"),
                        resultSet.getInt("id_element_module")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modalitesEvaluations;
    }

    @Override
    public void update(ModaliteEvaluation modaliteEvaluation) {
        String sql = "UPDATE modalite_evaluation SET type = ?, coefficient = ?, id_element_module = ? WHERE id_modalite = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, modaliteEvaluation.getType());
            statement.setDouble(2, modaliteEvaluation.getCoefficient());
            statement.setInt(3, modaliteEvaluation.getIdElementModule());
            statement.setInt(4, modaliteEvaluation.getIdModalite());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int idModalite) {
        String sql = "DELETE FROM modalite_evaluation WHERE id_modalite = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idModalite);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
