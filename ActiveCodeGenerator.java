public class ActiveCodeGenerator {
    public static void main(String[] args) {
        String filename = args[0];
        //String language = args[1];
        RunAppTerminal appRunner = new RunAppTerminal(filename);
        appRunner.run();
    }

}