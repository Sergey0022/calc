import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String x = sc.nextLine();
        System.out.println(calc(x));
    }
        public static String calc(String input) throws IOException {

            String[] mas = input.split(" ");
            if (mas.length != 3) {
                throw new IOException();
            }
            String a = mas[0]; //Первое число

            int i = 0;
            int j = 0;
            int rim1 = 0;
            int rim2 = 0;
            int otvet = 0;

            switch (a) { //Проверяю является ли переменная "а" римской цифрой
                case "I":
                    i = 1;
                    break;
                case "II":
                    i = 2;
                    break;
                case "III":
                    i = 3;
                    break;
                case "IV":
                    i = 4;
                    break;
                case "V":
                    i = 5;
                    break;
                case "VI":
                    i = 6;
                    break;
                case "VII":
                    i = 7;
                    break;
                case "VIII":
                    i = 8;
                    break;
                case "IX":
                    i = 9;
                    break;
                case "X":
                    i = 10;
            }

            if (i != 0) { // Если переменна "а" является римским числом то переменная rim1 станет равна единице
                rim1 = rim1 + 1;
            }

            if (i == 0) { // Если переменная "а" не является римским числом то преобразовываем значение переменной "a" в арабское число, если кроме числа есть ещё какие-либо символы, выбрасываем исключение
                try {
                    i = Integer.parseInt(a.trim());
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }

            String b = mas[1];
            String c = mas[2];

            switch (c.trim()) {
                case "I":
                    j = 1;
                    break;
                case "II":
                    j = 2;
                    break;
                case "III":
                    j = 3;
                    break;
                case "IV":
                    j = 4;
                    break;
                case "V":
                    j = 5;
                    break;
                case "VI":
                    j = 6;
                    break;
                case "VII":
                    j = 7;
                    break;
                case "VIII":
                    j = 8;
                    break;
                case "IX":
                    j = 9;
                    break;
                case "X":
                    j = 10;
            }

            if (j != 0) {
                rim2 = rim2 + 1;
            }

            if (j == 0) {
                try {
                    j = Integer.parseInt(c.trim());
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }

            if (i < 1 || i > 10 || j < 1 || j > 10) {
                throw new IOException();
            }

            String plus = "+";
            String minus = "-";
            String delenie = "/";
            String umnogenie = "*";

            if (0 == b.compareTo(plus)) { // Проверяем является ли переменна "b" символами: /, *, +, -. Если не является выбрасываем исключение.
                otvet = i + j;
            } else if (0 == b.compareTo(minus)) {
                otvet = i - j;
            } else if (0 == b.compareTo(umnogenie)) {
                otvet = i * j;
            } else if (0 == b.compareTo(delenie)) {
                otvet = i / j;
            } else {
                throw new IOException();
            }

            if (rim1 == 1 && rim2 == 1 && otvet > 0) { // Если на вход подавались римские числа, то конвертируем результат вычисления в римское число.
                String otv = "Ответ: " + IntegerConverter.intToRoman(otvet);
                return otv;
            } else if (rim1 == 0 && rim2 == 0) { // Если на вход подавались арабские числа то в ответ выводим арабское число.
                String otv = "Ответ: " + String.valueOf(otvet);
                return otv;
            } else { // В остальных случаях выбрасываем исключение.
                throw new IOException();
            }

        }
    }
