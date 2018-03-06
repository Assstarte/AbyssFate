package BLuR.utils;

import BLuR.model.enums.$COLOR;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;

import static java.lang.Thread.sleep;

public class DelayedPrinter {

    public Timeline timeline;

    public boolean isPrinted = false;
    private boolean firstStart = true;
    public Dragboard dgb;
    private DragEvent eventActivate = new DragEvent(DragEvent.DRAG_OVER,null,1,1,1,1,null,null,null,null);
    private DragEvent eventDisable = new DragEvent(DragEvent.DRAG_DONE,null,1,1,1,1,null,null,null,null);
    FileInputStream fstream;
    BufferedReader reader;

    public DelayedPrinter(){
    }

/*
    //Выведет текст,предварительно очистив экран
    public void printStage(TextArea area, String text){
        if(isPrinted || firstStart) {
            firstStart = false;
            isPrinted = false;
            int end = text.length();
            char[] textarr = text.toCharArray();
            String s = String.valueOf(textarr[0]);
            area.setText("");
            area.clear();
            area.setText(s);
            final int[] counter = {0};


            final IntegerProperty i = new SimpleIntegerProperty(0);
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(50),
                            event -> {
                                counter[0]++;
                                String sr = String.valueOf(textarr[counter[0]]);
                                i.set(i.get() + 50);
                                area.appendText(sr);
                                if (area.getText().equals(text)) { //Если вывод текста окончен
                                    isPrinted = true;
                                    area.fireEvent(eventActivate); //Триггернуть эффект onDragOver,который активирует кнопку
                                }
                            }
                    )
            );
            timeline.setCycleCount(end - 1);
            timeline.play();
            area.fireEvent(eventDisable); //Триггернуть эффект onDragDone,который деактивирует кнопку



        }
//

    }


    //Добавит к предыдущему тексту еще,не очищая экран
    public void addToStage(TextArea area,String text){

        if(isPrinted || firstStart) {
            firstStart = false;
            isPrinted = false;
            area.appendText("\n\n");

            int end = text.length();
            char[] textarr = text.toCharArray();
            String s = String.valueOf(textarr[0]);
            area.appendText(s);
            final int[] counter = {0};


            final IntegerProperty i = new SimpleIntegerProperty(0);
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(50),
                            event -> {
                                counter[0]++;
                                String sr = String.valueOf(textarr[counter[0]]);
                                i.set(i.get() + 50);
                                area.appendText(sr);
                                if (area.getText().equals(text)) { //Если вывод текста окончен
                                    isPrinted = true;
                                    area.fireEvent(eventActivate); //Триггернуть эффект onDragOver,который активирует кнопку
                                }
                            }
                    )
            );
            timeline.setCycleCount(end - 1);
            timeline.play();
            area.fireEvent(eventDisable); //Триггернуть эффект onDragDone,который деактивирует кнопку
        }



    }*/





    //FOR FLOWS
    public void printText(TextFlow area, String text, $COLOR color) {
        if(isPrinted || firstStart) {
            firstStart = false;
            isPrinted = false;
            String textColor; //Строка CSS-правила,в которую запишем цвет
            textColor = Texter.setColor(color); // Записываем CSS-правила для указанного цвета
            int end = text.length();
            area.getChildren().clear(); //Очищаем
            char[] textarr = text.toCharArray();
            String s = String.valueOf(textarr[0]);
            Text firstCharacter = new Text(); //Делаем объект текста для первой буквы
            firstCharacter.setText("\n\n" +s); //Записываем первую букву в текст
            firstCharacter.setStyle(textColor);
            area.getChildren().add(firstCharacter); //Выводим на FLOW
            final int[] counter = {0};


            final IntegerProperty i = new SimpleIntegerProperty(0);
            timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(50),
                            event -> {
                                counter[0]++;
                                String sr = String.valueOf(textarr[counter[0]]);
                                i.set(i.get() + 50);
                                Text letter = new Text(sr);

                                letter.setStyle(textColor);
                                area.getChildren().add(letter);
                                if ((counter[0]+1) == end) { //Если вывод текста окончен (+1 т.к первый символ выводится по другому)
                                    isPrinted = true;
                                    area.fireEvent(eventActivate); //Триггернуть эффект onDragOver,который активирует кнопку
                                }
                            }
                    )
            );
            timeline.setCycleCount(end - 1);
            timeline.play();
            area.fireEvent(eventDisable); //Триггернуть эффект onDragDone,который деактивирует кнопку



        }



    }






        //Добавляем текст к FLOW
    public void addText(TextFlow area, String text, $COLOR color){
        if(isPrinted || firstStart) {
            firstStart = false;
            isPrinted = false;
            String textColor; //Строка CSS-правила,в которую запишем цвет
            textColor = Texter.setColor(color); // Записываем CSS-правила для указанного цвета
            int end = text.length();
            char[] textarr = text.toCharArray();
            String s = String.valueOf(textarr[0]);
            Text firstCharacter = new Text(); //Делаем объект текста для первой буквы
            firstCharacter.setText("\n\n" +s); //Записываем первую букву в текст
            firstCharacter.setStyle(textColor);
            area.getChildren().add(firstCharacter); //Выводим на FLOW
            final int[] counter = {0};


            final IntegerProperty i = new SimpleIntegerProperty(0);
            timeline = new Timeline(
                    new KeyFrame(
                            Duration.millis(50),
                            event -> {
                                counter[0]++;
                                String sr = String.valueOf(textarr[counter[0]]);
                                i.set(i.get() + 50);
                                Text letter = new Text(sr);

                                letter.setStyle(textColor);
                                area.getChildren().add(letter);
                                if ((counter[0]+1) == end) { //Если вывод текста окончен (+1 т.к первый символ выводится по другому)
                                    isPrinted = true;
                                    area.fireEvent(eventActivate); //Триггернуть эффект onDragOver,который активирует кнопку
                                }
                            }
                    )
            );
            timeline.setCycleCount(end - 1);
            timeline.play();
            area.fireEvent(eventDisable); //Триггернуть эффект onDragDone,который деактивирует кнопку



        }


    }
}
