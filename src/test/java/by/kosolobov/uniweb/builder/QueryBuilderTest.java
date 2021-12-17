package by.kosolobov.uniweb.builder;

import org.junit.jupiter.api.Test;

import static by.kosolobov.uniweb.container.DataBaseStringContainer.*;
import static org.junit.jupiter.api.Assertions.*;

class QueryBuilderTest {
    // it is so weird because I'm waiting for String.format() specific syntax
    private static final String EXPECTED = "SELECT *%nFROM barbers%nJOIN users%nON barbers.user_id = users.user_id%n;".formatted();

    @Test
    void build() {
        QueryBuilder builder = new QueryBuilder();

        String query = builder.select(ALL)
                .from(BARBER_TABLE)
                .join(USER_TABLE)
                .on(BARBER_TABLE + ".user_id", USER_TABLE + ".user_id")
                .build();

        assertEquals(EXPECTED, query);
    }
}