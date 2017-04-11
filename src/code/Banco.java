import java.io.*;
import java.util.Scanner;

public class Banco
{
    public static void Banco(String[] args) throws Exception
    {
        Scanner tabuleiro = new Scanner(new File("../IOFiles/tabuleiro.txt"));

        Scanner jogadas = new Scanner(new File("../IOFiles/jogadas.txt"));

        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        String line = tabuleiro.nextLine();
        String[] token = line.split(";");
        int numPosicoes = Integer.parseInt(token[0]);
        System.out.println("num de posicoes:"+ numPosicoes);

        for(int i=0; i < numPosicoes; i++)
        {
            line = tabuleiro.nextLine();
            token = line.split(";");
            if("3".equals(token[2]))
            {
                System.out.println(token[0]+" "+token[1]+" "+token[2]+" "+token[3]+" "+token[4]+" "+token[5]);
                estatistica.println(token[0]+" "+token[1]+" "+token[2]+" "+token[3]+" "+token[4]+" "+token[5]);
            }
            else
            {
                System.out.println(token[0]+" "+token[1]+" "+token[2]);
                estatistica.println(token[0]+" "+token[1]+" "+token[2]);
            }
        }

        line = jogadas.nextLine();
        token = line.split("%");
        int numJogadas = Integer.parseInt(token[0]);
        int numJogadores = Integer.parseInt(token[1]);
        int valorInicial = Integer.parseInt(token[2]);
        System.out.println("num jogadas:"+numJogadas+"\nnum jogadores:"+numJogadores+"\nvalor inicial:"+valorInicial);

        for(int i=0; i < numJogadas; i++)
        {
            line = jogadas.nextLine();
            token = line.split(";");
            if("DUMP".equals(line))
            {
                System.out.println(line);
                estatistica.println(line);
            }
            else
            {
                System.out.println(token[0]+" "+token[1]+" "+token[2]);
                estatistica.println(token[0]+" "+token[1]+" "+token[2]);
            }
        }

        tabuleiro.close();
        jogadas.close();
        estatistica.close();
    }
}
