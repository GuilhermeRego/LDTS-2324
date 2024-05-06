package GuilhermeRego.hero;

import java.util.Random;

public class Monster extends Element{
    Monster(Position position) {
        super(position);
    }

    public Position move() {
        Random random = new Random();
        int dx = random.nextInt(3);
        int dy = random.nextInt(3);
        int newX = position.getX() + dx;
        int newY = position.getY() + dy;
        Position pos = new Position(newX, newY);
        return pos;
    }
}
