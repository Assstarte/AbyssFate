package BLuR.view;

import BLuR.AbyssFateApp;
import BLuR.model.entities.Hero;
import BLuR.model.enums.$CLASS;
import BLuR.model.enums.$GAME_STATE;
import BLuR.model.enums.$GENDER;
import BLuR.model.enums.$RACE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CharacterCreationScreenController {

    private AbyssFateApp mainApp;

    private Hero Character; //Полученный в результате герой


    //Его характеристики (для передачи в конструктор)
    private String Name;
    private $GENDER Gender;
    private $RACE Race;
    private $CLASS Class;


    //Списки расс и классов для ComboBox`ов
    private ObservableList<String> RaceList = FXCollections.observableArrayList(
            "Человек","Эльф","Демон","Падший Ангел","Скованный из душ"
    );

    private ObservableList<String> ClassList = FXCollections.observableArrayList(
            "Воин","In Dev","In Dev","In Dev","In Dev"
    );



    @FXML
    private TextField Char_Name;

    @FXML
    private RadioButton Char_Male,Char_Female;

    @FXML
    private ComboBox Race_Box,Class_Box;

    @FXML
    private Button Btn_Ready;


    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public CharacterCreationScreenController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {

        Race_Box.setItems(RaceList);
        Class_Box.setItems(ClassList);



    }

    public void setMainApp(AbyssFateApp mainApp) {
        this.mainApp = mainApp;
    }



    //----------------------------------------
    @FXML
    private void executeReady(){
        //----TODO: SAVE CHARACTER TO DB, SET ALL PARAMETERS, TRANSFER ACQUIRED HERO TO MAIN APP

        //Вытягиваем параметры из полей
        Name = Char_Name.getText();
        if (Char_Male.isSelected()) Gender = $GENDER.MALE;
        if (Char_Female.isSelected()) Gender = $GENDER.FEMALE;


        //SETUP RACE
        if(Race_Box.getSelectionModel().getSelectedItem() == "Человек") Race = $RACE.HUMAN;
        if(Race_Box.getSelectionModel().getSelectedItem() == "Эльф") Race = $RACE.ELF;
        if(Race_Box.getSelectionModel().getSelectedItem() == "Демон") Race = $RACE.DEMON;
        if(Race_Box.getSelectionModel().getSelectedItem() == "Падший Ангел") Race = $RACE.FALLEN_ANGEL;
        if(Race_Box.getSelectionModel().getSelectedItem() == "Скованный из душ") Race = $RACE.SOULFORGED;

        //SETUP CLASS
        if(Class_Box.getSelectionModel().getSelectedItem() == "Воин") Class = $CLASS.WARRIOR;


        //CREATING A HERO
        Character = new Hero(Name,Race,Class,Gender);
        mainApp.setHero(Character);




        mainApp.Game_State = $GAME_STATE.GAME_SCREEN;
        mainApp.showGameScreen();
    }



}
