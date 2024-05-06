package patterns;

public class HumanClient implements Client {

    private OrderingStrategy orderingStrategy;

    HumanClient(OrderingStrategy orderingStrategy) {
        this.orderingStrategy = orderingStrategy;
    }

    @Override
    public void happyHourStarted(Bar bar) {
        if (orderingStrategy.getClass() == SmartStrategy.class) {
            orderingStrategy = new ImpatientStrategy();
            orderingStrategy.happyHourStarted((StringBar) bar);
        }
    }

    @Override
    public void happyHourEnded(Bar bar) {
        orderingStrategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        orderingStrategy.wants(drink, recipe, bar);
    }
}
