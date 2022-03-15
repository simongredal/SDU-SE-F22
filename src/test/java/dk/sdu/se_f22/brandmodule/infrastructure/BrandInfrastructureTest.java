package dk.sdu.se_f22.brandmodule.infrastructure;

import dk.sdu.se_f22.sharedlibrary.models.Brand;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BrandInfrastructureTest extends BrandInfrastructure {
    BrandInfrastructure brandInfrastructure;

    @BeforeEach
    void setup(){
        brandInfrastructure = new BrandInfrastructure();

    }

    @Test
    void testTokenizationParameters() {
        brandInfrastructure.setTokenizationParameters(",",".");
        brandInfrastructure = new BrandInfrastructure();
        TokenizationParameters tokenizationParameters = brandInfrastructure.tokenizationParameters;
        assertEquals(",", tokenizationParameters.delimiterRegex);
        assertEquals(".", tokenizationParameters.ignoreRegex);
    }


    @RepeatedTest(1000)
    void testTokenizationParametersAtRandom(){
        Random r = new Random();
        char c1 = (char)(r.nextInt(26) + 'a');
        char c2 = (char)(r.nextInt(26) + 'a');

        brandInfrastructure.setTokenizationParameters(Character.toString(c1),Character.toString(c2));
        brandInfrastructure = new BrandInfrastructure();
        TokenizationParameters tokenizationParameters = brandInfrastructure.tokenizationParameters;
        assertEquals(Character.toString(c1), tokenizationParameters.delimiterRegex);
        assertEquals(Character.toString(c2), tokenizationParameters.ignoreRegex);

    }

    @Test
    void testTokenizeString(){
        String s = "Lorem, ipsum. dolor, sit amet";
        String reg = "[,\\.]";
        String del = " ";
        brandInfrastructure.setTokenizationParameters(del,reg);
        List<String> expected = List.of("Lorem","ipsum","dolor","sit","amet");
        List<String> received = brandInfrastructure.tokenizeString(s);
        assertEquals(expected,received);
    }

    @Test
    void testTokenizeBrand(){
        Brand brand = new Brand(0,"Lorem","","","", new ArrayList<>());
    }

}