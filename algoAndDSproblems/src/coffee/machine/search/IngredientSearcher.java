package coffee.machine.search;

import coffee.machine.inventory.Ingredient;

import java.util.Collection;

/**
 * Created by parasuram on 23/10/17
 */
public class IngredientSearcher extends Searcher<String, Ingredient> {
    public IngredientSearcher(final Collection<? extends Ingredient> ingredients) {
        super(Ingredient::getName, ingredients);
    }
}
