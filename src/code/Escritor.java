import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor
{
    public static void printStatistics(Jogador[] jogador, int numJogadas, int numJogadores) throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        int numTurns = (int) Math.ceil(numJogadas/numJogadores);
        estatistica.println("1:"+numTurns);

        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.println("2:"+i+"-"+jogador[i].completed);
        }

        for (int i = 1; i <= numJogadores; i++)
        {

        }

        for (int i = 1; i <= numJogadores; i++)
        {

        }

        for (int i = 1; i <= numJogadores; i++)
        {

        }

        for (int i = 1; i <= numJogadores; i++)
        {

        }

        for (int i = 1; i <= numJogadores; i++)
        {

        }

        estatistica.close();
    }
}
