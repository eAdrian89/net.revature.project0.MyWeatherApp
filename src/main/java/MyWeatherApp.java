import frontend.UserInterface;

import java.io.IOException;
import java.net.URISyntaxException;


public class MyWeatherApp {
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {
        UserInterface userInterface = new UserInterface();
        userInterface.ui();
    }

}
