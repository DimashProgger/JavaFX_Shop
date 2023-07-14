package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;


public class Shake {
    private TranslateTransition tt;

//    Node - любой объект в окне, например кнопка - node, текстовое поле - node, надпись - node.
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);

        tt.setCycleCount(3);
        tt.setAutoReverse(true);
//        setAutoReverse(true) - отвечает за то, чтобы объект возвращался назад
    }

    public void playAnim() {
        tt.playFromStart();
//        playFromStart - проигрывание анимации

    }

}
