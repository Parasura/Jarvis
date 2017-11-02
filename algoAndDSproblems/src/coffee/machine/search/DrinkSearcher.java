package coffee.machine.search;

import coffee.machine.inventory.Drink;

import java.util.Collection;

/**
 * Created by parasuram on 23/10/17
 */
public class DrinkSearcher extends Searcher<String, Drink> {
    public DrinkSearcher(final Collection<? extends Drink> drinks) {
        super(Drink::getName, drinks);
    }
}
