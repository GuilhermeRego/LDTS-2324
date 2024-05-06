package patterns;

public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        String newText = "";
        String text = drink.getText();
        Character c;
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                newText += Character.toUpperCase(c);
            }
            else {
                newText += Character.toLowerCase(c);
            }
        }
        drink.setText(newText);
    }
}
