package Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;

public class MagicDiceGame {

    private static int playerCount;
    private static boolean[] players;
    private static int score = 25;

    private static Map<Integer, Integer> map = new HashMap<>();

    private boolean isSix(int index, int dice) {

        if( dice==6 )
        {
            if( !players[index] )
                players[index] = true;
            System.out.println("Player "+ index + " got 6, Roll Dice Again");
        }
        return dice==6;
    }

    MagicDiceGame(int playerCount)
    {
        this.playerCount = playerCount;
    }

    public int getPlayerCount()
    {
        return this.playerCount;
    }

    public boolean fourRollAfterSix(int index, int followedSix)
    {
        if(followedSix > 0 )
        {
            players[index] = false;
            System.out.println("For Player "+index+ " ,on dice 4 after 6 came, so player not eligible until it gets 6");
            return true;
        }
        else return false;
    }

    public boolean isFour(int dice)
    {
        return dice == 4;
    }

    public static void main(String[] args) {

        MagicDiceGame magicDice = new MagicDiceGame(4);
        magicDice.initializeGame();

        int dice = magicDice.rollDice();

        int total = 0;
        int countSix = 0;

        while( total < score )
        {
            for (int i = 1; i < 5; ) {

                dice = magicDice.rollDice();

                if ( magicDice.isSix(i, dice) ) {
                    if (countSix == 0) {
                        countSix++;
                        continue;
                    }
                } else {
                    if (magicDice.isFour(dice)) {

                        if (!magicDice.fourRollAfterSix(i, countSix))
                            magicDice.updateScore(map, i, -4);

                    } else magicDice.updateScore(map, i, dice);

                    if (map.get(i) > total) total = map.get(i);

                    if (total >= score)
                        break;

                    System.out.println("Player name: "+i+" Total Score: "+map.get(i)+", Current Value of Dice: "+dice);

                    i++;
                    countSix = 0;
                }
            }
        }
    }

    private int rollDice() {
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }



    private void updateScore(Map<Integer, Integer> map, int index, int dice) {
        if( players[index] )
            map.put(index, map.get(index) + dice);
        else
            System.out.println("Function failed to execute updateScore() as Player "+index+" not eligible");
    }

    private void initializeGame() {
        players = new boolean[getPlayerCount() + 1];

        if(players.length < 2 && players.length > 4) {
            System.out.println("Game requires minimum 2 and maximum 4 players");
            return;
        }

        Arrays.fill(players, false);

        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);

    }
}
