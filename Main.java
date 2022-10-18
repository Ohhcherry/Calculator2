package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();
        calc(input);

    }

    public static String calc (String input) throws ScannerException {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(input.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if(actionIndex==-1){
            throw new ScannerException("Некорректное выражение. Введите выражение из двух значений и один из следующих операторов вычисления: \"+\",\"-\",\"*\",\"/\".");
        }
        String[] data = input.split(regexActions[actionIndex]);
        int arrayLength = data.length;
        if (arrayLength >= 3){
            throw new ScannerException("Введите выражение из двух операндов");
        }

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if (a > 10){
                throw new ScannerException("Каждое введенное число должно быть не больше 10 или Х");
            }else if (b > 10){
                throw new ScannerException("Каждое введенное число должно быть не больше 10 или Х");
            }

            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if(isRoman) {
                 System.out.println(converter.intToRoman(result));
            }
            else{
                 System.out.println(result);
           }
        }else{
            throw new ScannerException("Значения должны быть введены в одной системе исчисления: римской, либо арабской.");
        }
    return input;
    }
}

//        !Реализуй класс Main с методом public static String calc(String input).
//        !Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку с результатом их выполнения
//        +Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
//        +Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
//        +Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
//        +Калькулятор умеет работать только с целыми числами.
//        +Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
//        +При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
//        +При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
//        +При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
//        +Результатом операции деления является целое число, остаток отбрасывается.
//        +Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение