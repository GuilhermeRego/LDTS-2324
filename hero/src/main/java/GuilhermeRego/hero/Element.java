package GuilhermeRego.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    protected Arena arena;

    Element(int x, int y){
        position = new Position(x, y);
    }

    Element(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(new TerminalPosition(position.getX(), position.getY()), TextCharacter.fromCharacter('X')[0]);
    }
}
