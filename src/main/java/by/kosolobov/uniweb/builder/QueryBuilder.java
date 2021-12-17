package by.kosolobov.uniweb.builder;

public class QueryBuilder {
    private StringBuilder query = new StringBuilder();

    public QueryBuilder select(String select) {
        query.append("SELECT %s%n".formatted(select));
        return this;
    }

    public QueryBuilder from(String table) {
        query.append("FROM %s%n".formatted(table));
        return this;
    }

    public QueryBuilder where(String firstColumn, String secondColumn) {
        query.append("WHERE %s = %s%n".formatted(firstColumn, secondColumn));
        return this;
    }

    public QueryBuilder join(String table) {
        query.append("JOIN %s%n".formatted(table));
        return this;
    }

    public QueryBuilder leftJoin(String table) {
        query.append("LEFT JOIN %s%n".formatted(table));
        return this;
    }

    public QueryBuilder rightJoin(String table) {
        query.append("RIGHT JOIN %s%n".formatted(table));
        return this;
    }

    public QueryBuilder on(String firstColumn, String secondColumn) {
        query.append("ON %s = %s%n".formatted(firstColumn, secondColumn));
        return this;
    }

    /**
     * Initializing new StringBuilder after building a query.
     * That means you need to reuse all the previous methods to build a similar one
     * @return String. Use it in executeQuery(String sql) of your statement
     */
    public String build() {
        String resultQuery = query.append(";").toString();
        query = new StringBuilder();
        return resultQuery;
    }
}
