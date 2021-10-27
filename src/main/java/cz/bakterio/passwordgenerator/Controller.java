package cz.bakterio.passwordgenerator;

import cz.bakterio.passwordgenerator.generator.Generator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable { // For slider.
    @FXML
    TextField password;
    @FXML
    CheckBox lower;
    @FXML
    CheckBox upper;
    @FXML
    CheckBox numbers;
    @FXML
    CheckBox special;
    @FXML
    Slider slider;

    public void onGenerateButtonPressed(ActionEvent e) {
        System.out.println("lower.isSelected() = " + lower.isSelected());
        System.out.println("upper.isSelected() = " + upper.isSelected());
        System.out.println("numbers.isSelected() = " + numbers.isSelected());
        System.out.println("special.isSelected() = " + special.isSelected());
        generate();
    }

    private String pass = null;
    public void generate() {
        Generator g = new Generator();
        g.setLength(slider.valueProperty().intValue());
        g.setLowerCase(lower.isSelected());
        g.setUpperCase(upper.isSelected());
        g.setNumbers(numbers.isSelected());
        g.setSpecial(special.isSelected());

        g.generate();
        pass = g.getStringPassword();
        password.setText(pass);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                generate();
            }
        });
    }

    public void copy() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        content.putString(pass);
        clipboard.setContent(content);
    }
}
