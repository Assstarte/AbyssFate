package BLuR.utils;
import BLuR.model.enums.$COLOR;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Texter {
    private static BufferedReader reader;

    public static String getText(TextFlow area){
        StringBuilder sb = new StringBuilder();

            int length = area.getChildren().size();
            for(int i = 0; i < length; i++){
                Text tx = (Text) area.getChildren().get(i); //Получаем i`ый объект класса Text из FLOW
                sb.append(tx.getText());//Добавляем его значение в строку результата
            }


            String txt = sb.toString(); //Преобразуем всю строку результата в готовый текст
        return txt;//Возвращаем,на выхода получается весь текст из FLOW`a

    }



    public static void executeFile() throws IOException {
        try{
            FileInputStream fstream = new FileInputStream("src/resources/acts/Act1.blur");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){

            }
        }catch (IOException e){
            System.out.println("ERROR-302");
        }
    }



    //Установить цвет текста
    public static String setColor($COLOR color){
        if(color == $COLOR.RED) return "-fx-fill: red";
        else if(color == $COLOR.AQUA) return "-fx-fill: aqua";
        else if(color == $COLOR.BLUE) return "-fx-fill: blue";
        else if(color == $COLOR.ICE) return "-fx-fill: #006bce";
        else if(color == $COLOR.FIRE) return "-fx-fill: #f27d0c";
        else if(color == $COLOR.WHITE) return "-fx-fill: #fff";


        return "-fx-fill: #fff";
    }

    public static String initColor(char clr){

             if(clr == 'r')return setColor($COLOR.RED);

             else if(clr == 'b')return setColor($COLOR.BLUE);

             //...
             else return setColor($COLOR.WHITE);


        }

}
