import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CalcUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("计算器");
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        //设置布局外边距
        root.setPadding(new Insets(10));
        //设置布局内控件水平和垂直间距
        root.setHgap(10);
        root.setVgap(10);
        TextField textField = new TextField("0");
        //禁止捕获鼠标事件
        textField.setMouseTransparent(true);
        Button button_1 = new Button("1");
        button_1.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.ONE)));
        Button button_2 = new Button("2");
        button_2.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.TWO)));
        Button button_3 = new Button("3");
        button_3.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.THREE)));
        Button button_add = new Button("＋");
        button_add.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.ADD)));
        Button button_4 = new Button("4");
        button_4.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.FOUR)));
        Button button_5 = new Button("5");
        button_5.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.FIVE)));
        Button button_6 = new Button("6");
        button_6.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.SIX)));
        Button button_subtract = new Button("－");
        button_subtract.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.SUBTRACT)));
        Button button_7 = new Button("7");
        button_7.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.SEVEN)));
        Button button_8 = new Button("8");
        button_8.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.EIGHT)));
        Button button_9 = new Button("9");
        button_9.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.NINE)));
        Button button_multiply = new Button("×");
        button_multiply.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.MULTIPLY)));
        Button button_dot = new Button("·");
        button_dot.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.DOT)));
        Button button_0 = new Button("0");
        button_0.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.ZERO)));
        Button button_all_clear = new Button("AC");
        button_all_clear.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.RESET)));
        Button button_divide = new Button("÷");
        button_divide.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.DIVIDE)));
        Button button_equal = new Button("＝");
        button_equal.setOnAction((ae) -> textField.setText(CalcAlgorithm.calculate(CalcButton.EQUAL)));
        //设置控件位于第1列第1行，且跨4列1行
        GridPane.setConstraints(textField, 0, 0, 4, 1);
        root.getChildren().add(textField);
        root.add(button_1, 0, 1);
        root.add(button_2, 1, 1);
        root.add(button_3, 2, 1);
        root.add(button_add, 3, 1);
        root.add(button_4, 0, 2);
        root.add(button_5, 1, 2);
        root.add(button_6, 2, 2);
        root.add(button_subtract, 3, 2);
        root.add(button_7, 0, 3);
        root.add(button_8, 1, 3);
        root.add(button_9, 2, 3);
        root.add(button_multiply, 3, 3);
        root.add(button_dot, 0, 4);
        root.add(button_0, 1, 4);
        root.add(button_all_clear, 2, 4);
        root.add(button_divide, 3, 4);
        GridPane.setConstraints(button_equal, 0, 5, 4, 1);
        root.getChildren().add(button_equal);
        for (Node node : root.getChildren()) {
            //禁用控件焦点
            node.setFocusTraversable(false);
            //将控件尺寸与布局的尺寸绑定
            Region region = (Region) node;
            region.prefWidthProperty().bind(root.widthProperty());
            region.prefHeightProperty().bind(root.heightProperty());
            //设置控件字体、粗细和字号
            Font font = Font.font("SimHei", FontWeight.BOLD, 20);
            if (node instanceof TextField) {
                TextField tmp = (TextField) node;
                tmp.setFont(font);
            } else if (node instanceof Button) {
                Button tmp = (Button) node;
                tmp.setFont(font);
            }
        }
        //设置行高和列宽，百分比总和如果超过100%会自动折算
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(20);
        root.getRowConstraints().setAll(rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(25);
        root.getColumnConstraints().setAll(columnConstraints, columnConstraints, columnConstraints, columnConstraints);
        stage.show();
    }

}
