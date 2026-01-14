package software.ulpgc.aoc.view;

public class ConsoleResultPrinter implements ResultPrinter {
    @Override
    public void showResult(String title, long value) {
        System.out.println(title);
        System.out.println("Resultado: " + value);
    }
}