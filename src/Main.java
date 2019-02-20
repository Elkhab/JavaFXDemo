import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;





public class Main extends Application  {

   Stage window;
   TableView<Product> table;
   TextField nameInput, authorInput, editionInput, quantityInput;

 public static void main(String [] args){

       launch(args);

   }
@Override
    public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Список книг");

    //Name colomn
    TableColumn<Product, String> nameColumn = new TableColumn<>("Название");
    nameColumn.setMinWidth(300);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    //Author colomn
    TableColumn<Product, String> authorColumn = new TableColumn<>("Автор");
    authorColumn.setMinWidth(200);
    authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

    //Edition colomn
    TableColumn<Product, String> editionColumn = new TableColumn<>("Издание");
    authorColumn.setMinWidth(200);
    authorColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));

    //quantity colomn
    TableColumn<Product, String> quantityColumn = new TableColumn<>("Количество");
    quantityColumn.setMinWidth(100);
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


    //Name input
    nameInput = new TextField();
    nameInput.setPromptText("Name");
    nameInput.setMinWidth(200);

    //Author input
    authorInput = new TextField();
    authorInput.setPromptText("Автор");
    authorInput.setMinWidth(200);

    //Edition input
    editionInput = new TextField();
    editionInput.setPromptText("Издание");
    editionInput.setMinWidth(200);

    //Quantity input
    quantityInput = new TextField();
    quantityInput.setPromptText("Количество");
    quantityInput.setMinWidth(100);

    //Button
    Button addButton = new Button("Добавить");
    addButton.setOnAction(e -> addButtonClicked ());
    Button deleteButton = new Button ("Удалить");
    //deleteButton.setOnAction (e -> deleteButtonClicked());
    HBox hBox = new HBox();
    hBox.setPadding(new Insets(10,10,10,10));
    hBox.setSpacing(10);
    hBox.getChildren().addAll(nameInput, authorInput, editionInput, quantityInput,addButton,deleteButton);




    table = new TableView<>();
    table.setItems(getProduct());
    table.getColumns().addAll(nameColumn, authorColumn, editionColumn, quantityColumn);


    VBox vBox = new VBox();
    vBox.getChildren().addAll(table,hBox);

    Scene scene = new Scene(vBox);
    window.setScene(scene);
    window.show();
}
     //Add button clicked
    public void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setAuthor(authorInput.getText());
        product.setEdition(editionInput.getText());
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        authorInput.clear();
        editionInput.clear();
        quantityInput.clear();
    }

       //Delete button clicked

        public void deleteButtonClicked() {
            ObservableList<Product> productSelected, allProducts;
            allProducts = table.getItems();
            productSelected = table.getSelectionModel().getSelectedItems();
            productSelected.forEach(allProducts::remove);

        }

     public ObservableList<Product> getProduct (){
     ObservableList<Product> products = FXCollections.observableArrayList();
     products.add(new Product("Война и мир", "Толстой", "Нива", 20));
     products.add(new Product("Над пропастью во ржи", "Джером", "Ливия", 5));
     products.add(new Product("Пеппи Длинный чулок", "Лингрен","Орфей", 26));
     products.add(new Product("Путь к звездам", "Циолковский","Нива", 2));
     products.add(new Product("Цветы для Эрджернона", "Киз", "Орфей", 5));
     return products;
     }






}



