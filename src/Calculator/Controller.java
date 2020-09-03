package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    TextArea log;
    @FXML
    Label result;
    static StringBuilder sb;
    static Double res = 0.0;
    static String action = "";

    public void onAction(ActionEvent actionEvent) {
        if (sb == null) {
            sb = new StringBuilder();
        }

        switch (action) {
            case ("+"): {
                res += Double.parseDouble(sb.toString());
                break;
            }
            case ("-"): {
                res -= Double.parseDouble(sb.toString());
                break;
            }
            case ("*"): {
                res *= Double.parseDouble(sb.toString());
                break;
            }
            case ("/"): {
                res /= Double.parseDouble(sb.toString());
                break;
            }
            case (""): {
                res = Double.parseDouble(sb.toString());
            }
        }
        sb.setLength(0);
        action = ((Button) actionEvent.getSource()).getText();
        result.setText(res.toString());
        log.appendText(action);
    }

    public void onActionNumeric(ActionEvent actionEvent) {
        if (sb == null) {
            sb = new StringBuilder();
        }
        sb.append(((Button) actionEvent.getSource()).getText());
        log.appendText(((Button) actionEvent.getSource()).getText());
    }

    public void onActionNull() {
        if (sb == null) {
            sb = new StringBuilder();
        }
        sb.setLength(0);
        res = 0.0;
        action = "";
        result.setText("");
        log.setText("");
    }

    public void onActionSpes(ActionEvent actionEvent) {
        if (sb == null) {
            sb = new StringBuilder();
        }

        switch (action) {
            case ("+"): {
                res += Double.parseDouble(sb.toString());
                break;
            }
            case ("-"): {
                res -= Double.parseDouble(sb.toString());
                break;
            }
            case ("*"): {
                res *= Double.parseDouble(sb.toString());
                break;
            }
            case ("/"): {
                res /= Double.parseDouble(sb.toString());
                break;
            }
            case (""): {
                res = Double.parseDouble(sb.toString());
            }
        }
        sb.setLength(0);
        log.appendText(((Button) actionEvent.getSource()).getText());

        switch (((Button) actionEvent.getSource()).getText()) {
            case "√": {
                sb.append(Math.sqrt(res));
                break;
            }
            case "%": {
                sb.append(res / 100);
                break;
            }
            case "=": {
                sb.append(res);
                break;
            }
        }
        res = 0.0;

        action = "";
        result.setText(sb.toString());

    }
}
