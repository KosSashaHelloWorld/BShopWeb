package by.kosolobov.uniweb.connector;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static by.kosolobov.uniweb.container.DataBaseStringContainer.BARBER_TABLE;
import static org.junit.jupiter.api.Assertions.*;

class BShopConnectorTest {
    private static final String EXPECTED = "[{user_id=horny, description=0, second_name=Petrovich, ser_name=Kosolobov, first_name=Alex}]";

    @Test
    void getAllEntityFromTableTest() {
        List<Map<String, String>> barberMaps = BShopConnector.getAllEntityFromTable(BARBER_TABLE);
        assertEquals(EXPECTED, barberMaps.toString());
    }
}