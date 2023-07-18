package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.containers.Neo4jLabsPlugin;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
public abstract class AbstractIntegrationTest
{

    private static Neo4jContainer<?> neo4jContainer =
            new Neo4jContainer<>(DockerImageName.parse("neo4j:5.9.0"))
                    .withClasspathResourceMapping("/movie-graph.cql",
                    "/data/movie-graph.cql", BindMode.READ_ONLY)
                    .withLabsPlugins(Neo4jLabsPlugin.APOC);
    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        neo4jContainer.start();
        registry.add("spring.neo4j.uri", neo4jContainer::getBoltUrl);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", neo4jContainer::getAdminPassword);
        try {
            runCypherFile("/data/movie-graph.cql");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int runCypherFile(String file) throws IOException, InterruptedException
    {
        var result = neo4jContainer.execInContainer("cypher-shell",
                                                    "-u", "neo4j",
                                                    "-p", neo4jContainer.getAdminPassword(),
                                                    "-d", "neo4j",
                                                    "-f", file);
        return result.getExitCode();
    }


    static int runCommand(String cmd) throws IOException, InterruptedException {
        final String[] cmdArray = cmd.split(" ");
        var result = neo4jContainer.execInContainer(cmdArray);
        System.out.println(result.getStdout());
        System.err.println(result.getStderr());
        return result.getExitCode();
    }

    static int runCypher(String cypher) throws IOException, InterruptedException {
        var result = neo4jContainer.execInContainer("cypher-shell",
                                                    "-u", "neo4j",
                                                    "-p", neo4jContainer.getAdminPassword(),
                                                    "-d", "neo4j",
                                                    ""+cypher+"");
        System.out.println(result.getStdout());
        System.err.println(result.getStderr());
        return result.getExitCode();
    }


}
