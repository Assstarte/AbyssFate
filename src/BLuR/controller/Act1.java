package BLuR.controller;

import BLuR.AbyssFateApp;
import BLuR.model.enums.$COLOR;
import BLuR.utils.DelayedPrinter;
import BLuR.utils.Texter;
import BLuR.view.GameScreenController;
import org.fxmisc.richtext.StyledTextArea;

public class Act1 {

//    private GameScreenController controller = new GameScreenController();

    private DelayedPrinter printer = new DelayedPrinter();
    private GameScreenController controller;
    private boolean sceneFound;

    public static boolean printFinished = false;

    private int scene = 0;
    public String getActScene(int Button){

        controller = ActLogic.getController(); // Получаем контроллер для управления окном
        String res =""; // На всякий случай результат сделаем 0


        //Цикл акта
        while(true){
            sceneFound = false;
            if(Button == 4 && scene == 0) {
                printFinished = false;
                sceneFound = true;
                res = "\t\t\t\t\t\t\t\t\t\t\t /rАкт 1\n \t\t\t /sПробуждение";
                controller.printActText(res);
                controller.editButton4("Далее");
                printFinished = true;

                break;
            }

            if(Button == 4 && scene == 1){
                printFinished = false;
                sceneFound = true;
                res = "Черный холод витал вокруг...\nЕдва открыв глаза вы почувствовали сильную боль в области ребер\nПодняв мантию и обнажив торс,вы обнаружили рану с синеватыми оттенками.";
                controller.printActText(res);
                printFinished = true;

                break;
            }

            if(Button == 4 && scene == 2){
                printFinished = false;
                sceneFound = true;
                res = "К вам подошел лучник и представился как Лилиан.\nПо его внешнему виду было понятно, что он эльф\nНемного подождав вы решили идти на крайние меры\nТестовая строка...";
                controller.addActText(res);
                printFinished = true;

                break;
            }

            if(Button == 4 && scene == 3){
                printFinished = false;
                sceneFound = true;

                controller.addActText("Холод ");
                controller.addActText("становился все сильнее... ");
                controller.addActText("Немного прищурившись вы заметили");
                controller.addActText("костер");
                controller.addActText("неподалеку\n");
                printFinished = true;
                System.out.println();
                controller.cls();

                break;
            }









            //Безопасный выход из цикла на случай если сцена не найдена
            if(!sceneFound) break;

        }


















        scene++;
        return(res);
    }
}
