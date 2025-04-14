package tests_méthodes;

import fr.afpa.exercices.NiveauUn;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class IsAdultTest {


    @Test
    public void isMajor() {
        NiveauUn checker = new NiveauUn();
        int currentYear = Year.now().getValue();
        assertTrue(checker.isAdult(currentYear - 19));
    }
}
