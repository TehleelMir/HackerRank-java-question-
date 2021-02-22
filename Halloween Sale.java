/*
You wish to buy video games from the famous online video game store Mist.

Usually, all games are sold at the same price, p dollars. However, they are planning 
to have the seasonal Halloween Sale next month in which you can buy games at a cheaper price. 
Specifically, the first game will cost p dollars, and every subsequent game will cost d dollars 
less than the previous one. This continues until the cost becomes less than or equal to m dollars, 
after which every game will cost m dollars. How many games can you buy during the Halloween Sale?
*/

//code

   // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        if(s < p) return 0;
        int games = 1;
        s -=p;
        
        while(true){
            p -= d;
            if(p <= m){
                while(s >= m){
                    games++;
                    s -= m;
                }
                break;
            }
            s -= p;
            if(s >= p) games++;
            else break;
        }
        return games;
    }
