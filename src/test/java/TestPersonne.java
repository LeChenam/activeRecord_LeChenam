import activeRecord.Personne;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonne {
    @Test
    public void testFindAll() {
        ArrayList<Personne> res = new ArrayList<>();
        res.add(new Personne("Spielberg", "Steven"));
        res.add(new Personne("Scott", "Ridley"));
        res.add(new Personne("Kubrick", "Stanley"));
        res.add(new Personne("Fincher", "David"));
        ArrayList<Personne> personnes;
        try {
            personnes = Personne.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(res.size(), personnes.size());
        if(res.size() == personnes.size()) {
            int i = 0;
            for (Personne p : personnes) {
                assertEquals(p.getNom(), res.get(i).getNom());
                assertEquals(p.getPrenom(), res.get(i).getPrenom());
                i++;
            }
        }

    }
}
