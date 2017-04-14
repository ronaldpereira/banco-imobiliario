import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor
{
    public static void printStatistics(Jogador[] jogador, int numJogadas, int numJogadores) throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        int numTurns = (int) Math.ceil(numJogadas/numJogadores);
        estatistica.print("1:"+numTurns);

        estatistica.print("\n2:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaVoltasDadas());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n3:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaSaldo());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n4:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaAluguelRecebido());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n5:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaAluguelPago());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n6:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaQuantoComprou());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n7:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaPassaAVez());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.close();
    }
}
