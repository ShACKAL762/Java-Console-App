public class RubFormat {
    protected static String format(double sum) {


        int x = (int) sum % 10;
        return switch (x) {
            case 1 -> "рубль.";
            case 2, 3, 4 -> " рубля.";
            default -> "рублей.";
        };
    }
}
