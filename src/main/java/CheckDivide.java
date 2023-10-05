import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckDivide {
    public CheckDivide(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        order(bufferedReader, members(bufferedReader));
    }

    private static int members(BufferedReader bufferedReader) {

        int members;

        System.out.println("Введите количество человек за столом?");
        while (true) {
            try {

                members = Integer.parseInt(bufferedReader.readLine().trim());
                if (members < 2)
                    System.out.println("Error: Слишком маленькое количество, попробуй снова. =)");
                else {
                    System.out.println(members + " человек за столом.");
                    break;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("Error: Это не число, либо оно не нормальное, попробуй снова. =)");
            }
        }
        return members;
    }
    private static void order(BufferedReader bufferedReader, int member){

        double sum = 0;
        StringBuilder check = new StringBuilder("Добавленные товары: ");
        String inputLine;
        String[] buffer;

        System.out.println("Что хотите заказать? Введите в формате: \"Помидор 10.50\" без кавычек.");
        while (true){
            try {

                inputLine = bufferedReader.readLine();
                if (inputLine.trim().equalsIgnoreCase("завершить")){
                    System.out.println(check);
                    System.out.println(
                            "Общая сумма: " +
                                    String.format("%.2f",sum).replace(",",".") +
                                    RubFormat.format(sum));
                    System.out.println(
                            "С каждого по: " +
                                    String.format("%.2f ",sum/member).replace(",",".") +
                                    RubFormat.format(sum/member));
                    break;
                }

                buffer = inputLine.replace(",", ".").split(" ");

                if(buffer.length == 2){
                    buffer[1] = String.format("%.2f", Double.parseDouble(buffer[1])).replace(",",".");
                    if (Double.parseDouble(buffer[1]) <0.01)
                        throw new NumberFormatException();
                    sum = sum + Double.parseDouble(buffer[1]);
                    check.append("\n").append(buffer[0]).append(" ").append(buffer[1]);
                    System.out.println("Товар добавлен успешно!");
                    System.out.println("Хотите заказать, что то еще? Если хотите закрыть чек введите: \"Завершить\"");

                }else System.out.println("Error: Неверный формат, попробуй снова. =)");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }catch (NumberFormatException e){
                System.out.println("Error: Не верная стоимость, попробуй снова. =)");
            }
        }
    }

}


