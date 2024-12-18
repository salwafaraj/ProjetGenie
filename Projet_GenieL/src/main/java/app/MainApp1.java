package app;

import dao.ModaliteEvaluationDAOImpl;
import dao.ModuleDAOImpl;
import model.ModaliteEvaluation;
import model.Module;
import utils.dbutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp1 {

    private static final int AFFICHER_MODULES = 1;
    private static final int AFFICHER_MODALITES = 2;
    private static final int CREER_MODULE = 3;
    private static final int CREER_MODALITE = 4;
    private static final int METTRE_A_JOUR_MODULE = 5;
    private static final int METTRE_A_JOUR_MODALITE = 6;
    private static final int SUPPRIMER_MODULE = 7;
    private static final int SUPPRIMER_MODALITE = 8;
    private static final int QUITTER = 9;

    public static void main(String[] args) {
        try (Connection connection = dbutil.getInstance().getConnection();
             Scanner scanner = new Scanner(System.in)) {

            // Créer des objets DAO
            final ModuleDAOImpl moduleDAO = new ModuleDAOImpl(connection);
            final ModaliteEvaluationDAOImpl modaliteDAO = new ModaliteEvaluationDAOImpl(connection);

            boolean exit = false;

            while (!exit) {
                afficherMenu();

                if (!scanner.hasNextInt()) {
                    System.out.println("Veuillez entrer un nombre valide.");
                    scanner.next();
                    continue;
                }

                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne

                try {
                    switch (choix) {
                        case AFFICHER_MODULES:
                            afficherModules(moduleDAO);
                            break;
                        case AFFICHER_MODALITES:
                            afficherModalites(modaliteDAO);
                            break;
                        case CREER_MODULE:
                            creerModule(moduleDAO, scanner);
                            break;
                        case CREER_MODALITE:
                            creerModalite(modaliteDAO, scanner);
                            break;
                        case METTRE_A_JOUR_MODULE:
                            mettreAJourModule(moduleDAO, scanner);
                            break;
                        case METTRE_A_JOUR_MODALITE:
                            mettreAJourModalite(modaliteDAO, scanner);
                            break;
                        case SUPPRIMER_MODULE:
                            supprimerModule(moduleDAO, scanner);
                            break;
                        case SUPPRIMER_MODALITE:
                            supprimerModalite(modaliteDAO, scanner);
                            break;
                        case QUITTER:
                            exit = true;
                            System.out.println("Au revoir !");
                            break;
                        default:
                            System.out.println("Choix invalide. Veuillez réessayer.");
                    }
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getMessage());
                } catch (Exception ex) {
                    System.err.println("Erreur inattendue : " + ex.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Impossible d'établir la connexion à la base de données : " + e.getMessage());
        }
    }

    private static void afficherMenu() {
        System.out.println("\n----- MENU PRINCIPAL -----");
        System.out.println("1. Afficher tous les modules");
        System.out.println("2. Afficher toutes les modalités d'évaluation");
        System.out.println("3. Créer un nouveau module");
        System.out.println("4. Créer une nouvelle modalité d'évaluation");
        System.out.println("5. Mettre à jour un module");
        System.out.println("6. Mettre à jour une modalité d'évaluation");
        System.out.println("7. Supprimer un module");
        System.out.println("8. Supprimer une modalité d'évaluation");
        System.out.println("9. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void afficherModules(ModuleDAOImpl moduleDAO) throws SQLException {
        List<Module> modules = moduleDAO.findAll();
        if (modules.isEmpty()) {
            System.out.println("Aucun module trouvé.");
        } else {
            System.out.println("Liste des modules :");
            for (Module module : modules) {
                System.out.println(module);
            }
        }
    }

    private static void afficherModalites(ModaliteEvaluationDAOImpl modaliteDAO) throws SQLException {
        List<ModaliteEvaluation> modalites = modaliteDAO.findAll();
        if (modalites.isEmpty()) {
            System.out.println("Aucune modalité d'évaluation trouvée.");
        } else {
            System.out.println("Liste des modalités d'évaluation :");
            for (ModaliteEvaluation modalite : modalites) {
                System.out.println("ID: " + modalite.getIdElementModule()
                        + ", Type: " + modalite.getType()
                        + ", Coefficient: " + modalite.getCoefficient());
            }
        }
    }

    private static void creerModule(ModuleDAOImpl moduleDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID du module : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Entrez le nom du module : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez l'ID de la filière : ");
        int idFiliere = scanner.nextInt();

        System.out.print("Entrez l'ID du semestre : ");
        int idSemestre = scanner.nextInt();

        Module module = new Module(id, nom, idFiliere, idSemestre);
        moduleDAO.create(module);
        System.out.println("Module créé avec succès !");
    }

    private static void creerModalite(ModaliteEvaluationDAOImpl modaliteDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID de l'élément module : ");
        int idElementModule = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le type de modalité : ");
        String type = scanner.nextLine();

        System.out.print("Entrez le coefficient : ");
        double coefficient = scanner.nextDouble();

        ModaliteEvaluation modalite = new ModaliteEvaluation(0, type, coefficient, idElementModule);
        modaliteDAO.create(modalite);
        System.out.println("Modalité d'évaluation créée avec succès !");
    }

    private static void mettreAJourModule(ModuleDAOImpl moduleDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID du module à mettre à jour : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nouveau nom du module : ");
        String nom = scanner.nextLine();

        Module module = new Module(id, nom, 0, 0);
        moduleDAO.update(module);
        System.out.println("Module mis à jour avec succès !");
    }

    private static void mettreAJourModalite(ModaliteEvaluationDAOImpl modaliteDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID de la modalité à mettre à jour : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nouveau type de modalité : ");
        String type = scanner.nextLine();

        System.out.print("Entrez le nouveau coefficient : ");
        double coefficient = scanner.nextDouble();

        ModaliteEvaluation modalite = new ModaliteEvaluation(id, type, coefficient, 0);
        modaliteDAO.update(modalite);
        System.out.println("Modalité mise à jour avec succès !");
    }

    private static void supprimerModule(ModuleDAOImpl moduleDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID du module à supprimer : ");
        int id = scanner.nextInt();
        moduleDAO.delete(id);
        System.out.println("Module supprimé avec succès !");
    }

    private static void supprimerModalite(ModaliteEvaluationDAOImpl modaliteDAO, Scanner scanner) throws SQLException {
        System.out.print("Entrez l'ID de la modalité à supprimer : ");
        int id = scanner.nextInt();
        modaliteDAO.delete(id);
        System.out.println("Modalité supprimée avec succès !");
    }
}
