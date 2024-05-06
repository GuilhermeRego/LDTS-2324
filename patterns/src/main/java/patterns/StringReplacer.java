package patterns;

public class StringReplacer implements StringTransformer {

    private Character oldChar;
    private Character newChar;
    public StringReplacer(Character oldString, Character newString) {
        this.oldChar = oldString;
        this.newChar = newString;
    }
    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        String newText = "";
        Character c;
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == oldChar) {
                newText += newChar;
            }
            else {
                newText += c;
            }
        }
        drink.setText(newText);
    }
}
