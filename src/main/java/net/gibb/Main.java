package net.gibb;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;

public class Main {
    public static void main(String[] args)  {
    final String dbUri = "neo4j://localhost:7687";
    final String dbUser = "neo4j";
    final String dbPassword = "12345678";

        try (var driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword))) {
            driver.verifyConnectivity();
        }


    }
}