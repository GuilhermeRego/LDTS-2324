package GuilhermeRego.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Position position;
    private Hero hero;
    private Terminal terminal;
    private Screen screen;
    private TextGraphics graphics;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(int w, int h) throws IOException {
        width = w;
        height = h;
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();
        monsters = createMonsters();
        walls = createWalls();
        coins = createCoins();
        position = new Position(10, 10);
        hero = new Hero(position);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Position pos = new Position(random.nextInt(Math.max(width - 2, 1)) + 1,
                    random.nextInt(Math.max(width - 2, 1)) + 1);
            coins.add(new Coin(pos));
        }
        return coins;
    }

    public void draw(TextGraphics screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
        for (Wall wall : walls) wall.draw(graphics);
        createCoins();
        retrieveCoins();
    }

    public boolean canHeroMove(Position pos) {
        if (pos.getX() < 0 || pos.getX() >= width || pos.getY() < 0 || pos.getY() >= height) {
            return false;
        }
        for (Wall wall : walls)
            if (wall.getPosition().equals(pos)) return false;
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void retrieveCoins(){
        for (Coin coin : coins) {
            if (hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Position pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            monsters.add(new Monster(pos));
        }
        return monsters;
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position newPosition = monster.move();
            if (canMonsterMove(newPosition)) {
                monster.setPosition(newPosition);
            }
        }
    }

    private boolean canMonsterMove(Position pos) {
        if (pos.getX() < 0 || pos.getX() >= width || pos.getY() < 0 || pos.getY() >= height) {
            return false;
        }
        for (Wall wall : walls) {
            if (wall.getPosition().equals(pos)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(hero.getPosition())) return true;
        }
        return false;
    }

    public void processKey(KeyStroke key){
        System.out.println(key);
        moveMonsters();
        if (verifyMonsterCollisions() || key.getKeyType() == KeyType.Character && key.getCharacter()
                == 'q' || key.getKeyType() == KeyType.EOF) {
            System.out.println("Died");
            System.exit(0);
        }
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
    }
}

