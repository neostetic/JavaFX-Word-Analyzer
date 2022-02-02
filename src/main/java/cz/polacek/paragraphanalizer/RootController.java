package cz.polacek.paragraphanalizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RootController {

    private static final Set<String> NOT_ALLOWED_STRINGS;

    static {
        NOT_ALLOWED_STRINGS = new HashSet<>();
        NOT_ALLOWED_STRINGS.add(".");
        NOT_ALLOWED_STRINGS.add(".");
    }
    Scanner input = new Scanner(System.in);

    @FXML
    private Button chooseFile;

    @FXML
    private BarChart wordsChart;

    @FXML
    private BarChart lettersChart;

    @FXML
    public void onClickChooseFile(ActionEvent event) throws FileNotFoundException {
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);

        StringBuilder inputString = new StringBuilder();
        input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            inputString.append(line.toLowerCase(Locale.ROOT)).append(" ");
        }

        String completeString = inputString.toString();
        String[] deleteChars = {".", ",", "-", "?", "!", "\"", ":", "(", ")", "/", "[", "]", "{", "}", ";"};
        for (String deleteChar : deleteChars) {
            completeString = completeString.replace(deleteChar, " ");
        }
        String[] words = completeString.split(" ");

        Map<String, Integer> counterWords = new HashMap<>();
        for (String string : words) {
            if (counterWords.containsKey(string)) {
                int value = counterWords.get(string);
                value++;
                counterWords.put(string, value);
            } else {
                counterWords.put(string, 1);
            }
        }

        System.out.println(counterWords.toString());
    }
}