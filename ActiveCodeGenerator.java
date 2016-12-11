public class ActiveCodeGenerator {
    public static void main(String[] args) {
        String filename = args[0];
        RunAppTerminal appRunner = new RunAppTerminal(filename);
        appRunner.run();
    }

}