package Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class QueryProcessor {
    String query;
    List<String> parameters;
    QueryType type;
    Connection connection;

    public QueryProcessor(Connection connection, String query, List<String> parameters, QueryType type) {
        this.connection = connection;
        this.query = query;
        this.parameters = parameters;
        this.type = type;
    }

    public ResultSet execute() {
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            for (int i = 0; i < parameters.size(); i++) {
                preparedStmt.setString(i + 1, parameters.get(i));
            }
            preparedStmt.execute();

            if (type == QueryType.SELECT) {
                ResultSet res = preparedStmt.getResultSet();
                return res;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error has occured while processing the sql query");
            return null;
        }

    }
    }