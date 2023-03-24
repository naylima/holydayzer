import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Feriados {
  private Map<Calendar, String> feriados;

  public Feriados() {
    feriados = new HashMap<>();
    
    addFeriado("01/01/2023", "Confraternização mundial");
    addFeriado("21/02/2023", "Carnaval");
    addFeriado("17/04/2023", "Páscoa");
    addFeriado("21/04/2023", "Tiradentes");
    addFeriado("01/05/2023", "Dia do trabalho");
    addFeriado("08/06/2023", "Corpus Christi");
    addFeriado("07/09/2023", "Independência do Brasil");
    addFeriado("12/10/2023", "Nossa Senhora Aparecida");
    addFeriado("02/11/2023", "Finados");
    addFeriado("15/11/2023", "Proclamação da República");
    addFeriado("25/12/2023", "Natal");
  }

  public void verificarFeriado(String data) {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date date = format.parse(data);
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);

        if (feriados.containsKey(calendario)) {
            System.out.println("O feriado em " + data + " é: " + feriados.get(calendario));
        } else {
            System.out.println("Não existe feriado na data " + data);
        }
    } catch (ParseException e) {
        System.out.println("Data inválida!");
    }
  }

  public List<String> getFeriados() {
    List<String> listaFeriados = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    for (Map.Entry<Calendar, String> entry : feriados.entrySet()) {
        String data = dateFormat.format(entry.getKey().getTime());
        String nomeFeriado = entry.getValue();
        listaFeriados.add(data + " - " + nomeFeriado);
    }

    return listaFeriados;
}

  private void addFeriado(String data, String nomeFeriado) {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(data));

        feriados.put(calendar, nomeFeriado);
    } catch (Exception e) {
        System.out.println("Data inválida: " + data);
    }
  }
}
