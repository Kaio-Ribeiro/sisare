package sisare.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sisare.model.DAO.FuncionarioDAO;
import sisare.model.bean.Funcionario;

public class FXMLHomeAdminController implements Initializable {
    @FXML
    private TableView<Funcionario> tableView;
    
    @FXML
    private TableColumn<Funcionario, String> columnFuncionarioName;
    
    @FXML
    private TableColumn<Funcionario, String> columnFuncionarioRegistration;
    
    private List<Funcionario> listFuncionarios;
    private ObservableList<Funcionario> observableListFuncionarios;
    
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadListFuncionarios();
    }
    
    public void loadListFuncionarios() {
        columnFuncionarioName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnFuncionarioRegistration.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        
        //listFuncionarios = funcionarioDAO.read();
        
        observableListFuncionarios = FXCollections.observableArrayList(funcionarioDAO.read());
        tableView.setItems(observableListFuncionarios);
        tableView.refresh();
        System.out.println(funcionarioDAO.read());
    }
    
}
