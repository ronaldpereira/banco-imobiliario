import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor
{
	public static int numJogadores;

    public static void ReadBoard() throws Exception
    {
        BufferedReader tabuleiro = new BufferedReader(new FileReader("../IOFiles/tabuleiro.txt"));
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        Tabuleiro board = new Tabuleiro();

        String line = tabuleiro.readLine();
        String[] token = line.split(";");
        int numPosicoes = Integer.parseInt(token[0]);
        System.out.println("num de posicoes:"+ numPosicoes);

        for(int i=0; i < numPosicoes; i++)
        {
            line = tabuleiro.readLine();
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

        

        tabuleiro.close();
        estatistica.close();
    }

    public static void ReadPlays() throws Exception
    {
        BufferedReader jogadas = new BufferedReader(new FileReader("../IOFiles/jogadas.txt"));
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        String line = jogadas.readLine();
        String[] token = line.split("%");
        int numJogadas = Integer.parseInt(token[0]);
        numJogadores = Integer.parseInt(token[1]);
        int valorInicial = Integer.parseInt(token[2]);
        System.out.println("num jogadas:"+numJogadas+"\nnum jogadores:"+numJogadores+"\nvalor inicial:"+valorInicial);

        for(int i=0; i < numJogadas; i++)
        {
            line = jogadas.readLine();
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
        jogadas.close();
        estatistica.close();
    }

    public static void PrintStatistics() throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));
    	
    	estatistica.close();
    }
}
