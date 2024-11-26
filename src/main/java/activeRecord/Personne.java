package activeRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Personne {
    private int id;
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id=-1;
    }

    public static ArrayList<Personne> findAll() throws SQLException {
        ArrayList<Personne> personnes=new ArrayList<Personne>();
        Connection connect=DBConnection.getConnection();
        Statement stmt=connect.createStatement();
        stmt.execute("select * from personne");
        ResultSet rs=stmt.getResultSet();
        while(rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Personne personne=new Personne(nom,prenom);
            personne.setId(rs.getInt("id"));
            personnes.add(personne);
        }
        return personnes;
    }

    private void setId(int id) {
        this.id = id;
    }

    private static Personne findById(int id) throws SQLException {
        Connection connect=DBConnection.getConnection();
        Statement stmt=connect.createStatement();
        String sql="select * from personne where id="+id;
        stmt.executeQuery(sql);
        ResultSet rs=stmt.getResultSet();
        rs.next();
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        Personne personne=new Personne(nom,prenom);
        personne.setId(rs.getInt("id"));
        return personne;
    }

    private static ArrayList<Personne> findByName(String name) throws SQLException {
        ArrayList<Personne> personnes=new ArrayList<Personne>();
        Connection connect=DBConnection.getConnection();
        Statement stmt=connect.createStatement();
        stmt.execute("select * from personne where nom like '"+name+"'");
        ResultSet rs=stmt.getResultSet();
        while(rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Personne personne=new Personne(nom,prenom);
            personne.setId(rs.getInt("id"));
            personnes.add(personne);
        }
        return personnes;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
