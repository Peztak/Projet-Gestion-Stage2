import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Gestion {

    public static void main(String[] args) throws Exception {
        JFrame fenetre = new JFrame("Gestion Stocks");
        fenetre.setSize(1200, 700);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );
        JPanel pannel_onglets = new JPanel();
    
        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
        onglets.setPreferredSize(new Dimension(1200, 700));
        
        //// Création Onglet 1 ////
        JPanel onglet1 = new JPanel();
        onglet1.setLayout( new BorderLayout());
        onglet1.setPreferredSize(new Dimension(1200, 700));

        // Création de texte
        JLabel titre_onglet1 = new JLabel("<html>Gestion Stocks<br></html>", JLabel.CENTER);
        JLabel texte_onglet1 = new JLabel("<html>Ceci est un programme de gestion de vos diff\u00e9rents stocks<br><br>Deux pages sont \u00e0 votre disposition :<br><br>-La page 'Vos mat\u00e9riaux' afin d'ajouter, modifier ou supprimer un mat\u00e9riau de votre choix<br><br>-La page 'Vos outils' afin d'ajouter, modifer ou supprimer un outil de votre choix<br><br>Pour faciliter l'utilisation des informations de ces pages, 3 boutons situ\u00e9s \u00e0 droite vous permettent de d\u00e9couvrir leur fonctionnabilite<br><br>BONNE UTILISATION!</html>", JLabel.CENTER);
        JLabel footer_onglet1 = new JLabel("<html><br>Programme d\u00e9velopp\u00e9 en JAVA par Mr AUBERT Cedric, \u00e0 l'intention de Mr GOMEZ Michel</html>", JLabel.CENTER);

        // Style du texte
        titre_onglet1.setFont( new Font("Arial", Font.BOLD, 44));
        titre_onglet1.setBackground(Color.GREEN);
        titre_onglet1.setOpaque(true);
        texte_onglet1.setFont( new Font("Arial", Font.BOLD, 24));
        footer_onglet1.setFont( new Font("Arial", Font.BOLD,16));

        // Création des boutons
        JPanel bouton_onglet1 = new JPanel( new GridLayout(3,1));

        // Bouton d'explication de l'ajout
        JButton explique_ajout = new JButton("<html>Comment ajouter<br>un mat\u00e9riau/outil ?<html>");
        explique_ajout.setFont(new Font("Arial", Font.BOLD, 20));

        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        explique_ajout.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_ajout = new JFrame();
                fenetre_ajout.setSize(800,600);
                fenetre_ajout.setLocationRelativeTo(null);
                fenetre_ajout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel ajout = new JPanel();
                ajout.setLayout( new BorderLayout());

                JLabel titre_ajout = new JLabel("<html>Comment ajouter un mat\u00e9riau/outil ?</html>", JLabel.CENTER);
                JLabel texte_ajout = new JLabel("<html>Pour ajouter un mat\u00e9riau/outil il vous suffit d'aller sur la page 'Vos Mat\u00e9riaux/Outils' et d'appuyer sur le bouton 'Ajouter un mat\u00e9riau/outil' ensuite vous devez entrer les informations suivantes :<br><br>1-L'identifiant du mat\u00e9riau/outil<br><br>2-Le nom du mat\u00e9riau/outil<br><br>3-Les dimensions de votre m\u00e9teriau (Lxl en cm)<br><br>4-La mati\u00e8re du mat\u00e9riau<br><br>5-La quantit\u00e9 du mat\u00e9riau/outil<br><br>Une fois les informations entr\u00e9es, appuyer sur le bouton 'Valider' pour confirmer l'ajout<html>", JLabel.CENTER);

                // Style du texte
                titre_ajout.setFont( new Font("Arial", Font.BOLD, 44));
                texte_ajout.setFont( new Font("Arial", Font.ITALIC, 20));

                ajout.add(titre_ajout, BorderLayout.NORTH);
                ajout.add(texte_ajout, BorderLayout.CENTER);
                fenetre_ajout.add(ajout);
                fenetre_ajout.setVisible(true);
            }
        }
        );

        // Bouton d'explication de la modification
        JButton explique_modif = new JButton("<html>Comment modifier<br>un mat\u00e9riau/outil ?<html>");
        explique_modif.setFont(new Font("Arial", Font.BOLD, 20));

        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        explique_modif.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_modif = new JFrame();
                fenetre_modif.setSize(800,600);
                fenetre_modif.setLocationRelativeTo(null);
                fenetre_modif.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel modif = new JPanel();
                modif.setLayout( new BorderLayout());

                JLabel titre_modif = new JLabel("<html>Comment modifier un mat\u00e9riau/outil ?</html>", JLabel.CENTER);
                JLabel texte_modif = new JLabel("<html>Pour modifer un mat\u00e9riau/outil il vous suffit d'aller sur la page 'Vos Mat\u00e9riaux/Outils' et d'appuyer sur le bouton 'Modifier un mat\u00e9riau/outil' ensuite vous devez entrer les informations suivantes :<br><br>1-L'identifiant du mat\u00e9riau/outil<br><br>2-Entrer les nouvelles dimensions du mat\u00e9riau si besoin<br><br>3-Entrer la nouvelle quantit\u00e9 de mat\u00e9riau/outil<br><br>Une fois les informations entr\u00e9es, appuyer sur le bouton 'Valider' pour confirmer la modification</html>", JLabel.CENTER);

                // Style du texte
                titre_modif.setFont( new Font("Arial", Font.BOLD, 44));
                texte_modif.setFont( new Font("Arial", Font.ITALIC, 20));

                modif.add(titre_modif, BorderLayout.NORTH);
                modif.add(texte_modif, BorderLayout.CENTER);
                fenetre_modif.add(modif);
                fenetre_modif.setVisible(true);
            }
        }
        );

        // Bouton d'explication de la modification
        JButton explique_supp = new JButton("<html>Comment supprimer<br>un mat\u00e9riau/outil ?<html>");
        explique_supp.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        explique_supp.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_supp = new JFrame();
                fenetre_supp.setSize(800,600);
                fenetre_supp.setLocationRelativeTo(null);
                fenetre_supp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel supp = new JPanel();
                supp.setLayout( new BorderLayout());

                JLabel titre_supp = new JLabel("<html>Comment supprimer un mat\u00e9riau/outil ?</html>", JLabel.CENTER);
                JLabel texte_supp = new JLabel("<html>Pour supprimer un mat\u00e9riau/outil il vous suffit d'aller sur la page 'Vos Mat\u00e9riaux/Outils' et d'appuyer sur le bouton 'Supprimer un mat\u00e9riau/outil' ensuite vous devez juste entrer l'identifiant du mat\u00e9riau/outil que vous voulez supprimer<br><br>Une fois l'identifiant entr\u00e9, appuyer sur le bouton 'Valider' pour confirmer la suppression<html>", JLabel.CENTER);
                
                // Style du texte
                titre_supp.setFont( new Font("Arial", Font.BOLD, 44));
                texte_supp.setFont( new Font("Arial", Font.ITALIC, 20));

                supp.add(titre_supp, BorderLayout.NORTH);
                supp.add(texte_supp, BorderLayout.CENTER);
                fenetre_supp.add(supp);
                fenetre_supp.setVisible(true);
            }
        }
        );

        bouton_onglet1.add( explique_ajout);
        bouton_onglet1.add( explique_modif);
        bouton_onglet1.add( explique_supp);

        // Ajout des éléments dans l'onglet 1
        onglet1.add(titre_onglet1, BorderLayout.NORTH);
        onglet1.add(texte_onglet1, BorderLayout.CENTER);
        onglet1.add(bouton_onglet1, BorderLayout.EAST);
        onglet1.add(footer_onglet1, BorderLayout.SOUTH);

        //  Ajout de l'onglet 1 dans la barre d'onglets
        onglets.addTab("Accueil", onglet1);

        ///////////////////////////
        //// Création Onglet 2 ////
        ///////////////////////////

        JPanel onglet2 = new JPanel();
        onglet2.setLayout( new BorderLayout());
        onglet2.setPreferredSize(new Dimension(1200, 700));
        
        // Création de texte
        JLabel texte_onglet2 = new JLabel("<html>Page concernant vos mat\u00e9riaux<br><br></html>", JLabel.CENTER);
        JLabel footer_onglet2 = new JLabel("<html><br>Programme d\u00e9velopp\u00e9 en JAVA par Mr AUBERT Cedric, \u00e0 l'intention de Mr GOMEZ Michel<br><br></html>", JLabel.CENTER);

        // Style du texte
        texte_onglet2.setFont( new Font("Arial", Font.BOLD, 44));
        footer_onglet2.setFont( new Font("Arial", Font.BOLD,16));

        // Création des boutons
        JPanel boutons_onglet2 = new JPanel( new GridLayout(3,1));

        // Bouton pour ajouter un materiau
        JButton mat_ajout = new JButton("Ajouter un mat\u00e9riau");
        mat_ajout.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        mat_ajout.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_ajout = new JFrame();
                fenetre_ajout.setSize(800,600);
                fenetre_ajout.setLocationRelativeTo(null);
                fenetre_ajout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel ajout = new JPanel();
                ajout.setLayout( new BorderLayout());

                JLabel titre_ajout = new JLabel("<html>Ajouter un mat\u00e9riau</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel ajout_formulaire = new JPanel( new GridLayout(11,1));
                JLabel mat_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField mat_id = new JTextField("Saisir l'identifiant du mat\u00e9riau");
                JLabel mat_nom_texte = new JLabel("NOM :", JLabel.CENTER);
                JTextField mat_nom = new JTextField("Saisir le nom du mat\u00e9riau");
                JLabel mat_taille_texte = new JLabel("DIMENSIONS :", JLabel.CENTER);
                JTextField mat_taille = new JTextField("Saisir les dimensions du mat\u00e9riau");
                JLabel mat_matiere_texte = new JLabel("MATIERE :", JLabel.CENTER);
                JTextField mat_matiere = new JTextField("Saisir la mati\u00e8re du mat\u00e9riau");
                JLabel mat_quantite_texte = new JLabel("QUANTITE :", JLabel.CENTER);
                JTextField mat_quantite = new JTextField("Saisir la quantite du mat\u00e9riau");
                JButton mat_ajout_valide = new JButton("Valider");
                
                
                // ajout des éléments dans un gridlayout
                ajout_formulaire.add(mat_id_texte);
                ajout_formulaire.add(mat_id);
                ajout_formulaire.add(mat_nom_texte);
                ajout_formulaire.add(mat_nom);
                ajout_formulaire.add(mat_taille_texte);
                ajout_formulaire.add(mat_taille);
                ajout_formulaire.add(mat_matiere_texte);
                ajout_formulaire.add(mat_matiere);
                ajout_formulaire.add(mat_quantite_texte);
                ajout_formulaire.add(mat_quantite);
                ajout_formulaire.add(mat_ajout_valide);

                // Style du texte
                titre_ajout.setFont( new Font("Arial", Font.BOLD, 44));
                mat_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_id.setFont(new Font("Serif", Font.BOLD, 20));
                mat_nom_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_nom.setFont(new Font("Serif", Font.BOLD, 20));
                mat_taille_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_taille.setFont(new Font("Serif", Font.BOLD, 20));
                mat_matiere_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_matiere.setFont(new Font("Serif", Font.BOLD, 20));
                mat_quantite_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_quantite.setFont(new Font("Serif", Font.BOLD, 20));
                mat_ajout_valide.setFont(new Font("Arial", Font.BOLD, 24));

                mat_ajout_valide.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try {
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion", "utilisateur_gestion", "programme_java");
                            Statement stmt = conn.createStatement();
                            Integer id = Integer.parseInt(mat_id.getText());
                            String nom = mat_nom.getText();
                            String taille = mat_taille.getText();
                            String matiere = mat_matiere.getText();
                            String quantite = mat_quantite.getText();
                            String requete = "INSERT INTO materiaux VALUES ('"+id+"','"+nom+"','"+taille+"','"+matiere+"','"+quantite+"')";
                            stmt.executeUpdate(requete);
                            JOptionPane.showMessageDialog(null, "Mat\u00e9riau ajout\u00e9 avec succ\u00e8s");

                            conn.close();
                        }
                        catch(Exception error){
                            error.printStackTrace();
                        }
                    }
                });
                // finalisation de la fenetre
                ajout.add(titre_ajout, BorderLayout.NORTH);
                ajout.add(ajout_formulaire, BorderLayout.CENTER);
                fenetre_ajout.add(ajout);
                fenetre_ajout.setVisible(true);
            }
        }
        );

        // Bouton pour modifer un materiau
        JButton mat_modif = new JButton("Modifer un mat\u00e9riau");
        mat_modif.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        mat_modif.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_modif = new JFrame();
                fenetre_modif.setSize(800,600);
                fenetre_modif.setLocationRelativeTo(null);
                fenetre_modif.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel modif = new JPanel();
                modif.setLayout( new BorderLayout());

                JLabel titre_modif = new JLabel("<html>Modifer un mat\u00e9riau</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel modif_formulaire = new JPanel( new GridLayout(9,1));
                JLabel mat_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField mat_id = new JTextField("Saisir l'identifiant du mat\u00e9riau \u00e0 modifier");
                JLabel mat_espace1 = new JLabel("");
                JLabel mat_taille_texte = new JLabel("DIMENSIONS :", JLabel.CENTER);
                JTextField mat_taille = new JTextField("Saisir les dimensions du mat\u00e9riau \u00e0 modifier");
                JLabel mat_espace2 = new JLabel("");
                JLabel mat_quantite_texte = new JLabel("QUANTITE :", JLabel.CENTER);
                JTextField mat_quantite = new JTextField("Saisir la quantit\u00e9 du mat\u00e9riau \u00e0 modifer");
                JButton mat_modif_valide = new JButton("Valider");

                // ajout des éléments dans un gridlayout
                modif_formulaire.add(mat_id_texte);
                modif_formulaire.add(mat_id);
                modif_formulaire.add(mat_espace1);
                modif_formulaire.add(mat_taille_texte);
                modif_formulaire.add(mat_taille);
                modif_formulaire.add(mat_espace2);
                modif_formulaire.add(mat_quantite_texte);
                modif_formulaire.add(mat_quantite);
                modif_formulaire.add(mat_modif_valide);

                // Style du texte
                titre_modif.setFont( new Font("Arial", Font.BOLD, 44));
                mat_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_id.setFont(new Font("Serif", Font.BOLD, 20));
                mat_espace1.setFont(new Font("Serif", Font.BOLD, 20));
                mat_taille_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_taille.setFont(new Font("Serif", Font.BOLD, 20));
                mat_espace2.setFont(new Font("Serif", Font.BOLD, 20));
                mat_quantite_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_quantite.setFont(new Font("Serif", Font.BOLD, 20));
                mat_modif_valide.setFont(new Font("Arial", Font.BOLD, 24));

                modif.add(titre_modif, BorderLayout.NORTH);
                modif.add(modif_formulaire, BorderLayout.CENTER);
                fenetre_modif.add(modif);
                fenetre_modif.setVisible(true);
            }
        }
        );

        // Bouton pour supprimer un materiau
        JButton mat_supp = new JButton("Supprimer un mat\u00e9riau");
        mat_supp.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        mat_supp.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_supp = new JFrame();
                fenetre_supp.setSize(800,600);
                fenetre_supp.setLocationRelativeTo(null);
                fenetre_supp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel supp = new JPanel();
                supp.setLayout( new BorderLayout());

                JLabel titre_supp = new JLabel("<html>Supprimer un mat\u00e9riau</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel supp_formulaire = new JPanel( new GridLayout(7,1));
                JLabel mat_espace1 = new JLabel("");
                JLabel mat_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField mat_id = new JTextField("Saisir l'identifiant du mat\u00e9riau \u00e0 supprimer");
                JLabel mat_espace2 = new JLabel("");
                JLabel mat_espace3 = new JLabel("");
                JLabel mat_espace4 = new JLabel("");
                JButton mat_supp_valide = new JButton("Valider");

                // ajout des éléments dans un gridlayout
                supp_formulaire.add(mat_espace1);
                supp_formulaire.add(mat_id_texte);
                supp_formulaire.add(mat_id);
                supp_formulaire.add(mat_espace2);
                supp_formulaire.add(mat_espace3);
                supp_formulaire.add(mat_espace4);
                supp_formulaire.add(mat_supp_valide);

                // Style du texte
                mat_espace1.setFont(new Font("Serif", Font.BOLD, 20));
                titre_supp.setFont( new Font("Arial", Font.BOLD, 44));
                mat_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                mat_id.setFont(new Font("Serif", Font.BOLD, 20));
                mat_espace2.setFont(new Font("Serif", Font.BOLD, 20));
                mat_espace3.setFont(new Font("Serif", Font.BOLD, 20));
                mat_espace4.setFont(new Font("Serif", Font.BOLD, 20));
                mat_supp_valide.setFont(new Font("Arial", Font.BOLD, 24));

                supp.add(titre_supp, BorderLayout.NORTH);
                supp.add(supp_formulaire, BorderLayout.CENTER);
                fenetre_supp.add(supp);
                fenetre_supp.setVisible(true);
            }
        }
        );

        boutons_onglet2.add(mat_ajout);
        boutons_onglet2.add(mat_modif);
        boutons_onglet2.add(mat_supp);

        // Création du tableau
        // En-têtes du JTable
        String[] column2 = {"ID", "Nom", "Dimension en cm (Lxl)", "Mati\u00e8re", "Quantit\u00e9"};
        
        // Lignes du JTable
        String[][] data2 = {
                {"01", "Carrelage","20x20","C\u00e9ramique", "50"}, 
                {"02", "Contreplaqu\u00e9", "50x120", "Bois", "20"}
        };
        
        // Ajout du JTable dans l'onglet 2
        JTable table2 = new JTable(data2, column2);
        JScrollPane scroll2 = new JScrollPane(table2);

        // Ajout des éléments dans l'onglet n°2
        onglet2.add(texte_onglet2, BorderLayout.NORTH );
        onglet2.add(boutons_onglet2, BorderLayout.EAST );
        onglet2.add(scroll2, BorderLayout.CENTER);
        onglet2.add(footer_onglet2, BorderLayout.SOUTH);

        // Ajout de l'onglet 2 dans la barre d'onglets
        onglets.addTab("Vos Mat\u00e9riaux", onglet2);

        //// Création Onglet 3 ////
        JPanel onglet3 = new JPanel();
        onglet3.setLayout(new BorderLayout());
        onglet3.setPreferredSize(new Dimension(1200, 700));

        // Création de texte
        JLabel texte_onglet3 = new JLabel("<html>Page concernant vos outils<br><br></html>", JLabel.CENTER);
        JLabel footer_onglet3 = new JLabel("<html><br>Programme d\u00e9velopp\u00e9 en JAVA par Mr AUBERT Cedric, \u00e0 l'intention de Mr GOMEZ Michel<br><br></html>", JLabel.CENTER);
        
        // Style du texte
        texte_onglet3.setFont( new Font("Arial", Font.BOLD, 44));
        footer_onglet3.setFont( new Font("Arial", Font.BOLD,16));

        // Création des boutons
        JPanel boutons_onglet3 = new JPanel( new GridLayout(3,1));

        // Bouton pour ajouter un outil
        JButton out_ajout = new JButton("Ajouter un outil");
        out_ajout.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        out_ajout.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_ajout = new JFrame();
                fenetre_ajout.setSize(800,600);
                fenetre_ajout.setLocationRelativeTo(null);
                fenetre_ajout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel ajout = new JPanel();
                ajout.setLayout( new BorderLayout());

                JLabel titre_ajout = new JLabel("<html>Ajouter un outil</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel ajout_formulaire = new JPanel( new GridLayout(7,1));
                JLabel out_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField out_id = new JTextField("Saisir l'identifiant de l'outil");
                JLabel out_nom_texte = new JLabel("NOM :", JLabel.CENTER);
                JTextField out_nom = new JTextField("Saisir le nom de l'outil");
                JLabel out_quantite_texte = new JLabel("QUANTITE :", JLabel.CENTER);
                JTextField out_quantite = new JTextField("Saisir la quantit\u00e9 de l'outil");
                JButton out_ajout_valide = new JButton("Valider");

                // ajout des éléments dans un gridlayout
                ajout_formulaire.add(out_id_texte);
                ajout_formulaire.add(out_id);
                ajout_formulaire.add(out_nom_texte);
                ajout_formulaire.add(out_nom);
                ajout_formulaire.add(out_quantite_texte);
                ajout_formulaire.add(out_quantite);
                ajout_formulaire.add(out_ajout_valide);

                // Style du texte
                titre_ajout.setFont( new Font("Arial", Font.BOLD, 44));
                out_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_id.setFont(new Font("Serif", Font.BOLD, 20));
                out_nom_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_nom.setFont(new Font("Serif", Font.BOLD, 20));
                out_quantite_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_quantite.setFont(new Font("Serif", Font.BOLD, 20));
                out_ajout_valide.setFont(new Font("Arial", Font.BOLD, 24));
            
                ajout.add(titre_ajout, BorderLayout.NORTH);
                ajout.add(ajout_formulaire, BorderLayout.CENTER);
                fenetre_ajout.add(ajout);
                fenetre_ajout.setVisible(true);
            }
        }
        );

        // Bouton pour modifer un outil
        JButton out_modif = new JButton("Modifier un outil");
        out_modif.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        out_modif.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_modif = new JFrame();
                fenetre_modif.setSize(800,600);
                fenetre_modif.setLocationRelativeTo(null);
                fenetre_modif.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel modif = new JPanel();
                modif.setLayout( new BorderLayout());

                JLabel titre_modif = new JLabel("<html>Modifier un outil</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel modif_formulaire = new JPanel( new GridLayout(7,1));
                JLabel out_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField out_id = new JTextField("Saisir l'identifiant de l'outil \u00e0 modifier");
                JLabel out_espace1 = new JLabel("");
                JLabel out_quantite_texte = new JLabel("QUANTITE :", JLabel.CENTER);
                JTextField out_quantite = new JTextField("Saisir la quantit\u00e9 de l'outil \u00e0 modifier");
                JLabel out_espace2 = new JLabel("");
                JButton out_modif_valide = new JButton("Valider");

                // ajout des éléments dans un gridlayout
                modif_formulaire.add(out_id_texte);
                modif_formulaire.add(out_id);
                modif_formulaire.add(out_espace1);
                modif_formulaire.add(out_quantite_texte);
                modif_formulaire.add(out_quantite);
                modif_formulaire.add(out_espace2);
                modif_formulaire.add(out_modif_valide);

                // Style du texte
                titre_modif.setFont( new Font("Arial", Font.BOLD, 44));
                out_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_id.setFont(new Font("Serif", Font.BOLD, 20));
                out_espace1.setFont(new Font("Serif", Font.BOLD, 24));
                out_quantite_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_quantite.setFont(new Font("Serif", Font.BOLD, 20));
                out_espace2.setFont(new Font("Serif", Font.BOLD, 24));
                out_modif_valide.setFont(new Font("Arial", Font.BOLD, 24));

                modif.add(titre_modif, BorderLayout.NORTH);
                modif.add(modif_formulaire, BorderLayout.CENTER);
                fenetre_modif.add(modif);
                fenetre_modif.setVisible(true);
            }
        }
        );

        // Bouton pour supprimer un outil
        JButton out_supp = new JButton("Supprimer un outil");
        out_supp.setFont(new Font("Arial", Font.BOLD, 20));


        // Méthode pour réaliser l'action d'ouverture d'une nouvelle fenêtre
        out_supp.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame fenetre_supp = new JFrame();
                fenetre_supp.setSize(800,600);
                fenetre_supp.setLocationRelativeTo(null);
                fenetre_supp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE );

                JPanel supp = new JPanel();
                supp.setLayout( new BorderLayout());

                JLabel titre_supp = new JLabel("<html>Supprimer un outil</html>", JLabel.CENTER);

                // éléments du formulaire
                JPanel supp_formulaire = new JPanel( new GridLayout(7,1));
                JLabel out_espace1 = new JLabel("");
                JLabel out_id_texte = new JLabel("IDENTIFIANT :", JLabel.CENTER);
                JTextField out_id = new JTextField("Saisir l'identifiant de l'outil \u00e0 supprimer");
                JLabel out_espace2 = new JLabel("");
                JLabel out_espace3 = new JLabel("");
                JLabel out_espace4 = new JLabel("");
                JButton out_supp_valide = new JButton("Valider");

                // ajout des éléments dans un gridlayout
                supp_formulaire.add(out_espace1);
                supp_formulaire.add(out_id_texte);
                supp_formulaire.add(out_id);
                supp_formulaire.add(out_espace2);
                supp_formulaire.add(out_espace3);
                supp_formulaire.add(out_espace4);
                supp_formulaire.add(out_supp_valide);

                // Style du texte
                out_espace1.setFont(new Font("Serif", Font.BOLD, 20));
                titre_supp.setFont( new Font("Arial", Font.BOLD, 44));
                out_id_texte.setFont(new Font("Serif", Font.BOLD, 24));
                out_id.setFont(new Font("Serif", Font.BOLD, 20));
                out_espace2.setFont(new Font("Serif", Font.BOLD, 20));
                out_espace3.setFont(new Font("Serif", Font.BOLD, 20));
                out_espace4.setFont(new Font("Serif", Font.BOLD, 20));
                out_supp_valide.setFont(new Font("Arial", Font.BOLD, 24));

                supp.add(titre_supp, BorderLayout.NORTH);
                supp.add(supp_formulaire, BorderLayout.CENTER);
                fenetre_supp.add(supp);
                fenetre_supp.setVisible(true);
            }
        }
        );
        
        boutons_onglet3.add(out_ajout);
        boutons_onglet3.add(out_modif);
        boutons_onglet3.add(out_supp);

        // Création du tableau
        // En-têtes du JTable
        String[] column3 = {"ID", "Nom", "Quantit\u00e9"};
        
        // Lignes du JTable
        String[][] data3 = {
                {"01", "Tournevis", "5"}, 
                {"02", "Perceuse", "1"}, 
                {"03", "Marteau", "3"}
        };
        
        // Ajout du JTable dans l'onglet 3
        JTable table3 = new JTable(data3, column3);
        JScrollPane scroll3 = new JScrollPane(table3);

        // Ajout des éléments dans l'onglet n°3
        onglet3.add(texte_onglet3, BorderLayout.NORTH );
        onglet3.add(boutons_onglet3, BorderLayout.EAST );
        onglet3.add(scroll3, BorderLayout.CENTER);
        onglet3.add(footer_onglet3, BorderLayout.SOUTH);

        // Ajout de l'onglet 3 dans la barre d'onglets
        onglets.addTab("Vos Outils", onglet3);


        onglets.setOpaque(true);
        pannel_onglets.add(onglets);

        // Affichage de la fenetre avec les onglets
        fenetre.getContentPane().add(pannel_onglets);
        fenetre.setVisible(true);
    }
}
