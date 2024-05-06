package patterns;

public class FerengiClient extends AlienClient {

    private ImpatientStrategy strategy;

    @Override
    protected OrderingStrategy createOrderingStrategy() {
        return strategy;
    }
}
