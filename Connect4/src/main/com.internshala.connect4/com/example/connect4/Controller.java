package com.example.connect4;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller implements Initializable {
    private static final int COLOUMNS=7;
    private static final int ROWS=6;
    private static final int CIRCLE_DAIAMETER=80;
    private static final String discColor1="#24303E";
    private static final String discColor2="#4CAA88";
    private static String PLAYER_ONE="Player One";
    private static String PLAYER_TWO="Player Two";
    private boolean isPlayerOneTurn=true;

    private Disc[][] insertDiscsArray=new Disc[ROWS][COLOUMNS];//FOR STRUCTURAL CHANFGES





    @FXML
    public GridPane rootGridPane;
    @FXML
    public Pane insertedDiscPane;
    @FXML
    public Label playerNameLabel;
    @FXML
    public TextField playerOneName;
    @FXML
    public TextField playerTwoName;
    @FXML
    public Button setNamesButton;
    private boolean isAllowedToInsert=true;  //Flag to avoid the same colour disc being added
    public void createPlayground(){

        Shape rectangleWithHole= createGameStructuralGrid();

        rootGridPane.add(rectangleWithHole,0,1);
        List<Rectangle> rectangleList=createClickableColumns();
        for (Rectangle rectangle:rectangleList ){
            rootGridPane.add(rectangle,0,1);

        }
    }

    private Shape createGameStructuralGrid(){
        Shape rectangleWithHole= new Rectangle((COLOUMNS+1)*CIRCLE_DAIAMETER,(ROWS+1)*CIRCLE_DAIAMETER);
        for(int row=0;row<ROWS;row++){
            for (int col=-0;col<COLOUMNS;col++){
                Circle circle = new Circle();
                circle.setRadius((CIRCLE_DAIAMETER/2));
                circle.setCenterX(CIRCLE_DAIAMETER/2);
                circle.setCenterY(CIRCLE_DAIAMETER/2);
                circle.setSmooth(true);
                circle.setTranslateX(col*(CIRCLE_DAIAMETER+5)+CIRCLE_DAIAMETER/4);
                circle.setTranslateY(row*(CIRCLE_DAIAMETER+5)+CIRCLE_DAIAMETER/4);
                rectangleWithHole=Shape.subtract(rectangleWithHole,circle);

            }
        }
        rectangleWithHole.setFill(Color.WHITE);
        return rectangleWithHole;
    }
    private List<Rectangle> createClickableColumns() {
        List<Rectangle> rectangleList = new ArrayList<>();
        for (int col = 0; col < COLOUMNS; col++) {
            Rectangle rectangle = new Rectangle(CIRCLE_DAIAMETER, (ROWS + 1) * CIRCLE_DAIAMETER);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setTranslateX(col * (CIRCLE_DAIAMETER + 5) + CIRCLE_DAIAMETER / 4);
            rectangle.setOnMouseEntered(event -> rectangle.setFill(Color.valueOf("#eeeeee26")));
            rectangle.setOnMouseExited(event -> rectangle.setFill(Color.TRANSPARENT));
            final int column=col;
            rectangle.setOnMouseClicked(event -> {

                if(isAllowedToInsert) {
                    isAllowedToInsert = false; //when disc is beinh dropped then no more disc

                    insertDisc(new Disc(isPlayerOneTurn), column);
                }
            });
            rectangleList.add(rectangle);

        }
        return rectangleList;
    }
    private  void insertDisc(Disc disc ,int column){
        int row =ROWS-1;
        while(row>=0){
            if (getDiscIfPresent(row,column)==null)
                break;
            row--;
        }
        if(row<0)     //If it is fill , we cannot insert anymore disc
            return;
        insertDiscsArray[row][column]=disc;  //For structural changes :For Developer
        insertedDiscPane.getChildren().add(disc);

        disc.setTranslateX(column*(CIRCLE_DAIAMETER+5)+CIRCLE_DAIAMETER/4);
        int currentRow=row;
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),disc);
        translateTransition.setToY(row*(CIRCLE_DAIAMETER+5)+CIRCLE_DAIAMETER/4);
        translateTransition.setOnFinished(event->{
            isAllowedToInsert=true;
               if(gameEnded(currentRow,column)){
                    gameOver();
                    return;
                }
            isPlayerOneTurn=!isPlayerOneTurn;

            playerNameLabel.setText(isPlayerOneTurn?PLAYER_ONE:PLAYER_TWO);


        });
        translateTransition.play();



    }

    private boolean  gameEnded(int row, int column) {
        // Vertical points .A small EXample :Player has insterted his last disc at row =2.column=3;


    List<Point2D>verticalPoints=    IntStream.rangeClosed(row-3,row+3) //range of row value =0,1,2,3;
                .mapToObj(r->new Point2D(r,column))
            .collect(Collectors.toList());  //index of each elemnts presents in coloumn [row][column]: 0,3 1,3 2,3 3,3 4,3 ,5,3--->Point2D class x,y

        List<Point2D>horizontalPoints=    IntStream.rangeClosed(column-3,column+3)
                .mapToObj(col->new Point2D(row,col))
                .collect(Collectors.toList());
        Point2D startPoint1=new Point2D(row-3,column+3);
        List<Point2D>diagonal1Points=IntStream.rangeClosed(0,6)
                .mapToObj(i->startPoint1.add(i,-i))
                .collect(Collectors.toList());
        Point2D startPoint2=new Point2D(row-3,column-3);
        List<Point2D>diagonal2Points=IntStream.rangeClosed(0,6)
                .mapToObj(i->startPoint2.add(i,i))
                .collect(Collectors.toList());
        boolean isEnded=checkCombinations(verticalPoints)||checkCombinations(horizontalPoints)
                ||checkCombinations(diagonal1Points)||checkCombinations(diagonal2Points);
       return isEnded;
    }

    private boolean checkCombinations(List<Point2D> points) {
        int chain=0;
        for (Point2D point:points){

            int rowIndexForArray= (int) point.getX();
            int columnIndexForArray= (int) point.getY();
            Disc disc=getDiscIfPresent(rowIndexForArray,columnIndexForArray);
            if(disc !=null && disc.isPlayerOneMove==isPlayerOneTurn){
                chain++;
                if(chain==4){
                    return true;
                }
            }else{
                chain=0;
            }
        }
              return false;

        }

        private Disc getDiscIfPresent(int row, int column){  //To prevent index out of bound exception
        if (row>=ROWS|| row<0|| column>=COLOUMNS||column<0)
            return null;
        //else
        return insertDiscsArray[row][column];
        }

    private void gameOver(){
String winner =isPlayerOneTurn?PLAYER_ONE:PLAYER_ONE;
        System.out.println("Winner is " +winner);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Connect Four");
        alert.setHeaderText("The Winner is "+winner);
        alert.setContentText("Want to play again ");
        ButtonType yesBtn= new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No , Exit");
        alert.getButtonTypes().setAll(yesBtn,noBtn);

Platform.runLater(()->{
    Optional<ButtonType> btnClicked=alert.showAndWait();
    if(btnClicked.isPresent() &&btnClicked.get()==yesBtn){
        resetGame();

    }else{
        Platform.exit();
        System.exit(0);
    }
        });

}

    public void resetGame() {
        insertedDiscPane.getChildren().clear();
        for (int row=0; row< insertDiscsArray.length;row++){
            for (int col=0;col<insertDiscsArray[row].length;col++){
                insertDiscsArray[row][col]=null;
            }
        }
        isPlayerOneTurn=true;
        playerNameLabel.setText(PLAYER_ONE);
        createPlayground();//prepare fresh playground
    }

    private static class Disc extends Circle{
        private final boolean isPlayerOneMove;

        public Disc(boolean isPlayerOneMove) {

            this.isPlayerOneMove = isPlayerOneMove;
            setRadius(CIRCLE_DAIAMETER/2);
            setFill(isPlayerOneMove?Color.valueOf(discColor1):Color.valueOf(discColor2));
            setCenterX(CIRCLE_DAIAMETER/2);
            setCenterY(CIRCLE_DAIAMETER/2);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
setNamesButton.setOnAction(event->{
    String input1=playerOneName.getText();
    String input2=playerTwoName.getText();
    PLAYER_ONE=input1+"'s";
    PLAYER_TWO=input2+"'s";
    if(input1.isEmpty())
        PLAYER_ONE="Player One's";
    if(input2.isEmpty())
        PLAYER_TWO="Player Two's";
    playerNameLabel.setText((isPlayerOneTurn?PLAYER_ONE:PLAYER_TWO));
});
    }
}
