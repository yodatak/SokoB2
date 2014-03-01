/**
 * la classe

Menu
        current_level
        player_name_store()
        choisir_lvl()
        get_curr_lvl()
        set_curr_lvl()
 */
import javax.swing.JFrame;
        import javax.swing.JLabel;
import java.util.Scanner;


public class menu {

    //setter de nom
    public void setNom(String nom) {
        System.out.println("Veuillez saisir votre nom :");
        Scanner sc = new Scanner(System.in);
         this.Nom = sc.nextLine();
    }
    //getter de nom
    public String getNom() {
        return Nom;
    }

    private String Nom;

    //setter de level
    public void setLevel(int level) {
        System.out.println("Veuillez saisir le level :");
        Scanner sc = new Scanner(System.in);
        this.Level = sc.nextInt();
    }
    //getter de level
    public int getLevel() {
        return Level;
    }

    private int Level;













/*
        // on crée une fenêtre dont le titre est "Hello World!"
        JFrame frame = new JFrame("Hello World!");
        // la fenêtre doit se fermer quand on clique sur la croix rouge
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // on ajoute le texte "Hello, World!" dans la fenêtre
        frame.getContentPane().add((new JLabel("Hello, World!")));

        // on demande d'attribuer une taille minimale à la fenêtre
        //  (juste assez pour voir tous les composants)
        frame.pack();
        // on centre la fenêtre
        frame.setLocationRelativeTo(null);
        // on rend la fenêtre visible
        frame.setVisible(true);

*/
}