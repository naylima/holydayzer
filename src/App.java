public class App {
    public static void main(String[] args) throws Exception {
        Feriados feriados = new Feriados();

        feriados.verificarFeriado("01/01/2023");        

        System.out.println(feriados.getFeriados());
    }
}
