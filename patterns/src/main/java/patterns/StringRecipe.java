package patterns;

import java.util.List;

public class StringRecipe {

    private List<StringTransformer> recipe;

    StringRecipe(List<StringTransformer> recipe) {
        this.recipe = recipe;
    }
    public void mix(StringDrink drink) {
        for (StringTransformer stringTransformer : recipe) stringTransformer.execute(drink);
    }
}
