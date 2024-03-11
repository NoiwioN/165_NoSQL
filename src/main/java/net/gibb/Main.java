package net.gibb;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.QueryConfig;

public class Main {
    public static void main(String[] args)  {
    final String dbUri = "neo4j://localhost:7687";
    final String dbUser = "test";
    final String dbPassword = "sml12345";

        try (var driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword))) {
            var result = driver.executableQuery("MATCH (c:Climber{proficiency:\"Proficient\"}) return c as record").withConfig(QueryConfig.builder().withDatabase("neo4j").build())
                    .execute();

            var records = result.records();
            records.forEach(r -> {
                System.out.println(r);  // or r.get("name").asString(
            });

        }




    }
}