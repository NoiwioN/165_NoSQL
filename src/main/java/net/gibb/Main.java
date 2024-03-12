package net.gibb;
import net.gibb.model.Climber;
import net.gibb.repository.ClimberRepository;
import org.neo4j.driver.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args)  {


/*        try (var driver = GraphDatabase.driver(DB_URI, AuthTokens.basic(DB_USER, DB_PASSWORD))) {
            var result = driver.executableQuery("MATCH (c:Climber{proficiency:\"Proficient\"}) return c as record, id(c) as id").withConfig(QueryConfig.builder().withDatabase("neo4j").build())
                    .execute();

            var records = result.records();
            records.forEach(r -> {
                System.out.println(r.get("id").toString());  // or r.get("name").asString(
                driver.close();
            });

        }*/

        ClimberRepository climber = new ClimberRepository();
//        Climber c= new Climber("Max Mustermann", 175.5f, 30, "1994-05-15", "Advanced", 165);
//        climber.createClimber(c);
        HashMap<String, Object> valuesToUpdate= new HashMap<>();
        valuesToUpdate.put("name", "Max");
        valuesToUpdate.put("height", 165);
        climber.updateClimber(valuesToUpdate, 50);


    }
}