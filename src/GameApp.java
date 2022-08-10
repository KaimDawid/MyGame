import Logic.GameLogic;
public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        String gameVersion = "alpha v 0.4.3 hotfix";
        System.out.println(gameVersion);
        GameLogic gameLogic = new GameLogic();
        gameLogic.Game();
    }

    }

