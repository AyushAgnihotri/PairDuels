package newproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main_Screen {
    
    public static Pane root_main = new Pane();
    
    public Parent createContent_new() {
        Game_Screen.pick = new Media(getClass().getResource("/newproject/Audio/MainScreen/audio.mp3").toExternalForm());
        Game_Screen.player = new MediaPlayer(Game_Screen.pick);
        Game_Screen.player.play();
        
        root_main.setPrefSize(1366.0, 692.0);
        settext();
        createText1();
        createText2();
        
        createInstructionButton();
        
        createRadioButton1();
        createRadioButton2();
        return root_main;
    }
  
    void settext() {
        Text title = new Text("Pair Duels!");
        title.setFont(Font.font("Dancing Script", FontWeight.EXTRA_BOLD, 60));
        title.setTranslateX(550);
        title.setTranslateY(60);
        Text gametype = new Text("The Tile Matching Memory Game");
        gametype.setFont(Font.font("Dancing Script", FontWeight.EXTRA_BOLD, 45));
        gametype.setTranslateX(420);
        gametype.setTranslateY(115);
        Text description = new Text("Train your brain! Play this game every day. Keep your brain in shape!");
        description.setFont(Font.font("Dancing Script", FontWeight.EXTRA_BOLD, 45));
        description.setTranslateX(120);
        description.setTranslateY(180);
        root_main.getChildren().addAll(title, gametype, description);
    }
    
    public static void createText1() {
        Text t1 = new Text("Theme:");
        t1.setTranslateX(250);
        t1.setTranslateY(575);
        t1.setFont(Font.font("Cambria", 24));
        root_main.getChildren().add(t1);
    }
    
    public static void createText2() {
        Text t2 = new Text("Grid Size:");
        t2.setTranslateX(250);
        t2.setTranslateY(650);
        t2.setFont(Font.font("Cambria", 24));
        root_main.getChildren().add(t2);
    }
    
    public void createInstructionButton() {
        Image image = new Image("/newproject/ButtonImages/instructions.jpg",35,35,false,true);
        Button inst = new Button();
        ImageView img = new ImageView(image);
        img.setImage(image);
        inst.setGraphic(img);
        inst.setTranslateX(1250);
        inst.setTranslateY(620);
        
        inst.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Pane root = new Pane();
                Scene scene = new Scene(root, 576.0, 412.0);
                scene.getStylesheets().addAll(this.getClass().getResource("/newproject/background/instructions.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Instructions for Gameplay!");
            }
        });
        root_main.getChildren().add(inst);
    }

    public static void createRadioButton1() {
       final ToggleGroup group = new ToggleGroup();

       RadioButton rb1 = new RadioButton("Mix");
       rb1.setFont(Font.font(null, 16));
       rb1.setToggleGroup(group);
       rb1.setUserData("Mix");

       RadioButton rb2 = new RadioButton("Death Note");
       rb2.setFont(Font.font(null, 16));
       rb2.setToggleGroup(group);
       rb2.setUserData("Death Note");
       
       RadioButton rb3 = new RadioButton("GOT");
       rb3.setFont(Font.font(null, 16));
       rb3.setToggleGroup(group);
       rb3.setUserData("GOT");
       
       RadioButton rb4 = new RadioButton("Looney Tunes");
       rb4.setFont(Font.font(null, 16));
       rb4.setToggleGroup(group);
       rb4.setUserData("Looney Tunes");
       
       RadioButton rb5 = new RadioButton("Naruto");
       rb5.setFont(Font.font(null, 16));
       rb5.setToggleGroup(group);
       rb5.setUserData("Naruto");
       
       RadioButton rb6 = new RadioButton("Pokemon");
       rb6.setFont(Font.font(null, 16));
       rb6.setToggleGroup(group);
       rb6.setUserData("Pokemon");
       
       RadioButton rb7 = new RadioButton("Harry Potter");
       rb7.setFont(Font.font(null, 16));
       rb7.setToggleGroup(group);
       rb7.setUserData("Harry Potter");

       group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
           if (group.getSelectedToggle() != null) {
               Game_Screen.x = group.getSelectedToggle().getUserData().toString();
           }
       });
       
       rb1.setTranslateX(370);
       rb1.setTranslateY(557);
       
       rb2.setTranslateX(445);
       rb2.setTranslateY(557);
       
       rb3.setTranslateX(563);
       rb3.setTranslateY(557);
       
       rb4.setTranslateX(635);
       rb4.setTranslateY(557);
       
       rb5.setTranslateX(767);
       rb5.setTranslateY(557);
       
       rb6.setTranslateX(852);
       rb6.setTranslateY(557);
       
       rb7.setTranslateX(962);
       rb7.setTranslateY(557);
       
       root_main.getChildren().addAll(rb1, rb2, rb3, rb4, rb5, rb6, rb7);
       
       rb1.setSelected(true);
       rb1.requestFocus();
    }
    
    public static void createRadioButton2() {
       final ToggleGroup group = new ToggleGroup();

       RadioButton rb1 = new RadioButton("4 x 4");
       rb1.setFont(Font.font(null, 14));
       rb1.setToggleGroup(group);
       rb1.setUserData("4");

       RadioButton rb2 = new RadioButton("6 x 6");
       rb2.setFont(Font.font(null, 14));
       rb2.setToggleGroup(group);
       rb2.setUserData("6");

       group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
           if (group.getSelectedToggle() != null) {
               Game_Screen.y = group.getSelectedToggle().getUserData().toString();
           }
       });
       
       rb1.setTranslateX(390);
       rb1.setTranslateY(635);
       
       rb2.setTranslateX(465);
       rb2.setTranslateY(635);
       
       root_main.getChildren().addAll(rb1, rb2);
       
       rb1.setSelected(true);
       rb1.requestFocus();
    }
}