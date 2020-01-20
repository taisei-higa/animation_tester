

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("pachimon");
        primaryStage.setScene(new Scene(root, 300, 275));

        Group host = new Group();
        Scene theScene = new Scene(host);
        primaryStage.setScene(theScene);


        Canvas canvas = new Canvas(1000, 1000);
        host.getChildren().add(canvas);


        GraphicsContext gc = canvas.getGraphicsContext2D();

        player player = new player();
        player.player_Animation(gc);


        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}




class player{
    public GraphicsContext player_Animation(GraphicsContext gc){
        Image kusa = new Image("design_img_f_1555168_s.png", 10, 0, true, false);
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                /*
                現在はy(t)=Math.sin(t)となっている
                xはx(t)=Math.sin(t)となっている
                 */

                double x = 500 + 250 * Math.cos(t);
                double y = 500 + 250 * Math.sin(t);

                // Clear the canvas
                gc.clearRect(0, 0, 10000,10000);
                // background image clears canvas
                gc.drawImage( kusa, x, y );
            }
        }.start();
        return gc;
    }

}

