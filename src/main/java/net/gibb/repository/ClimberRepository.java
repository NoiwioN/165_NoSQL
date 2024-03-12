package net.gibb.repository;

import net.gibb.model.Climber;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.QueryConfig;

import java.util.*;

import static net.gibb.config.*;

public class ClimberRepository {
    public Climber findByID(Integer id) {
        try (var driver = GraphDatabase.driver(DB_URI, AuthTokens.basic(DB_USER, DB_PASSWORD))) {
            var result = driver.executableQuery("MATCH (c:Climber) WHERE id(c) = $id return id(c) as id, c.name as name, c.height as height, c.wingspan as wingspan, c.birthday as birthday, c.proficiency as proficiency, c.age as age;").withParameters(Map.of("id", id)).withConfig(QueryConfig.builder().withDatabase("neo4j").build()).execute();

            var records = result.records();
            Climber c = new Climber();
            records.forEach(r -> {
                c.setAge(r.get("age").asInt());
                c.setBirthday(r.get("birthday").asString());
                c.setId(r.get("id").asInt());
                c.setName(r.get("name").asString());
                c.setProficiency(r.get("proficiency").asString());
                c.setWingspan(r.get("wingspan").asFloat());
            });
            driver.close();
            return c;
        }
    }

    public List<Climber> findAll() {
        try (var driver = GraphDatabase.driver(DB_URI, AuthTokens.basic(DB_USER, DB_PASSWORD))) {
            var result = driver.executableQuery("MATCH(c:Climber) return c.id as id").withConfig(QueryConfig.builder().withDatabase("neo4j").build()).execute();

            var records = result.records();
            List<Climber> climbers = new ArrayList<>();
            records.forEach(r -> {

                Climber c = findByID(r.get("id").asInt());
                climbers.add(c);


            });
            driver.close();
            return climbers;
        }
    }

    public void createClimber(Climber climber) {
        try (var driver = GraphDatabase.driver(DB_URI, AuthTokens.basic(DB_USER, DB_PASSWORD))) {
            /*driver.session().run("CREATE (c:Climber{name:$name, proficiency:$proficiency, height:$height, wingspan:$wingspan, age:$age, birthday:$birthday",climber.getClimberAsHasmap());*/
            HashMap<String, Object> properties = climber.getClimberAsHashmap();
            driver.session().run("CREATE (c:Climber{name:$name, proficiency:$proficiency, height:$height,wingspan:$wingspan, age:$age,birthday:$birthday}) RETURN c", properties);
            driver.session().run("MATCH (c:Climber) WHERE c.id IS NULL SET c.id = id(c)");

        }

    }
}
