package webservers.recipe;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RecipeXmlRunner {
    public static void main(String[] args) throws IOException {
        RecipeXmlRunner recipeXmlRunner = new RecipeXmlRunner();
        //recipeXmlRunner.toXml();
        recipeXmlRunner.fromXml();

    }

    public void toXml() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(
                        new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)),
                3);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/temp/recipe.xml"), recipe);
        String xml = xmlMapper.writeValueAsString(recipe);
    }

    public void fromXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Recipe recipe = xmlMapper
                .readValue(new File("src/test/resources/temp/recipe.xml"), Recipe.class);
        System.out.println(recipe);
    }
}
