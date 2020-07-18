package Main;

public class Player {
    private Game game;
    private int score;
    private int coinPos = 0;
    private int carrotPos = 0;


    public int getScore(){
        return this.score;
    }

    public void getApple(){
        if(game.snake.collisionApple()){
            game.coin.XYRandom();
            score += 20;
            game.snake.setLengthOfSnakePlus();
        }
    }
    public void getCarrot(){
        if(game.snake.collisionCarrot()){
            game.carrot.XYRandom();
            score += 10;
            game.snake.setLengthOfSnakeMinus();
        }
    }



    public void getApplePos(){
        if(coinPos == 0){
            game.coin.XYRandom();
            coinPos++;
        }
    }

    public void getCarrotPos(){
        if(carrotPos == 0){
            game.carrot.XYRandom();
            carrotPos++;
        }
    }
    public Player(Game game){
        this.game = game;
    }
}
