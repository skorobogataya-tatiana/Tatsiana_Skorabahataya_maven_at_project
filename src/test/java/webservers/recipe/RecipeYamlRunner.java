package webservers.recipe;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RecipeYamlRunner {
    public static void main(String[] args) throws IOException {
        RecipeYamlRunner recipeYamlRunner = new RecipeYamlRunner();
        recipeYamlRunner.toYaml();
        recipeYamlRunner.fromYaml();
    }

    public void toYaml() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(
                        new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)),
                3);
        YAMLMapper xmlMapper = new YAMLMapper();
        xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/temp/recipe.yaml"), recipe);
        String xml = xmlMapper.writeValueAsString(recipe);
    }

    public void fromYaml() throws IOException {
        YAMLMapper xmlMapper = new YAMLMapper();
        Recipe recipe = xmlMapper
                .readValue(new File("src/test/resources/temp/recipe.yaml"), Recipe.class);
        System.out.println(recipe);
    }
}
