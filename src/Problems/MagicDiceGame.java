package Problems;

import java.util.*;

public class MagicDiceGame {

    private int playerCount;

    private static Map<Integer, Integer> map = new HashMap<>();

    private boolean[] players;


    public int getPlayerCount()
    {
        if(this.playerCount < 2 || this.playerCount > 4) {
            System.out.println("Game requires minimum 2 and maximum 4 players");
            return -1;
        }
        return this.playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Map<Integer, Integer> getMap() {
        return this.map;
    }


    public boolean[] getPlayers() {
        return this.players;
    }

    private boolean isSix(int index, int dice) {

        if( dice==6 )
        {
            if( !players[index] )
                players[index] = true;
            System.out.println("Player "+ index + " got 6, Roll Dice Again");
        }
        return dice==6;
    }

    public boolean fourRollAfterSix(int index, int followedSix)
    {
        if(followedSix > 0 )
        {
            players[index] = false;
            System.out.println("For Player "+ index + " ,on dice, 4 after 6 came, so player not eligible until it gets 6");
            return true;
        }
        else
            return false;
    }

    public boolean isFour(int dice)
    {
        return dice == 4;
    }

    private int rollDice()  {
        Random ran = new Random();

        return ran.nextInt(6) + 1 ;
    }
    public void updateScore(Map<Integer, Integer> map, int index, int dice) {
        if( players[index] )
            map.put(index, map.get(index) + dice);
        else
            System.out.println("Function failed to execute updateScore() as Player "+index+" not eligible");
    }

    public void initializeGame(List<Player> playerList, int score) {

        this.setPlayerCount(playerList.size());
        players = new boolean[getPlayerCount() + 1];

        Arrays.fill(players, false);

        for(int i = 0; i < getPlayerCount(); i++)
            map.put(i, 0);
    }

    public static void main(String[] args) {
//        Random ran = new Random();
//        int p = ran.nextInt(6) + 1;
//
//        System.out.println(p);
        MagicDiceGame magicDiceGame = new MagicDiceGame();

        for(int i = 0; i < 4; i++)
          map.put(i+1, 0);

        List<Player> list = new ArrayList<>();
        list.add(new Player("Sanket", 1));
        list.add(new Player("Suyash", 2));

        magicDiceGame.start(list, 25);
    }
    public void start(List<Player> playerList, int score ) {

        MagicDiceGame magicDice = new MagicDiceGame();
        magicDice.initializeGame(playerList, score);

        int dice = magicDice.rollDice();

        int total = 0;
        int countSix = 0;

        while( total < score )
        {
            for (int i = 0; i < playerList.size(); ) {

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

                    System.out.println("Player name: "+playerList.get(i).getName()+" Total Score: "+map.get(i)+", Current Value of Dice: "+dice);

                    i++;
                    countSix = 0;
                }
            }
        }
    }


}

//public class MagicDiceGame {
//
//    private static int id = 1;
//
//    private static int playerCount;
//    private static boolean[] players;
//    private static int score = 25;
//
//    private static Map<Player, Integer> map = new HashMap<>();
//
//    private boolean isSix(int index, int dice) {
//
//        if( dice==6 )
//        {
//            if( !players[index] )
//                players[index] = true;
//            System.out.println("Player "+ index + " got 6, Roll Dice Again");
//        }
//        return dice==6;
//    }
//
//    public int getPlayerCount()
//    {
//        return this.playerCount;
//    }
//
//    public boolean fourRollAfterSix(int index, int followedSix)
//    {
//        if(followedSix > 0 )
//        {
//            players[index] = false;
//            System.out.println("For Player "+index+ " ,on dice 4 after 6 came, so player not eligible until it gets 6");
//            return true;
//        }
//        else return false;
//    }
//
//    public boolean isFour(int dice)
//    {
//        return dice == 4;
//    }
//
//    public static void main(String[] args) {
//
//        MagicDiceGame magicDice = new MagicDiceGame();
//        magicDice.initializeGame();
//
//        int dice = magicDice.rollDice();
//
//        int total = 0;
//        int countSix = 0;
//
//        while( total < score )
//        {
//            for (int i = 1; i < 5; ) {
//
//                dice = magicDice.rollDice();
//
//                if ( magicDice.isSix(i, dice) ) {
//                    if (countSix == 0) {
//                        countSix++;
//                        continue;
//                    }
//                } else {
//                    if (magicDice.isFour(dice)) {
//
//                        if (!magicDice.fourRollAfterSix(i, countSix))
//                            magicDice.updateScore(map, i, -4);
//
//                    } else magicDice.updateScore(map, i, dice);
//
//                    if (map.get(i) > total) total = map.get(i);
//
//                    if (total >= score)
//                        break;
//
//                    System.out.println("Player name: "+i+" Total Score: "+map.get(i)+", Current Value of Dice: "+dice);
//
//                    i++;
//                    countSix = 0;
//                }
//            }
//        }
//    }
//
//    private int rollDice() {
//        Random ran = new Random();
//        return ran.nextInt(6) + 1;
//    }
//
//
//
//    private void updateScore(Map<Integer, Integer> map, int index, int dice) {
//        if( players[index] )
//            map.put(index, map.get(index) + dice);
//        else
//            System.out.println("Function failed to execute updateScore() as Player "+index+" not eligible");
//    }
//
//    private void initializeGame() {
//        players = new boolean[getPlayerCount() + 1];
//
//        if(players.length < 2 && players.length > 4) {
//            System.out.println("Game requires minimum 2 and maximum 4 players");
//            return;
//        }
//
//        Arrays.fill(players, false);
//
//        map.put(new Player(id++, "Sanket", 1), 0);
//        map.put(new Player(id++, "Suyash", 2), 0);
//    }
//}
