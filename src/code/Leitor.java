import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor
{
	public static int numJogadores;

    public static void ReadBoard() throws Exception
    {
        BufferedReader entradatabuleiro = new BufferedReader(new FileReader("../IOFiles/tabuleiro.txt"));
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        String line = entradatabuleiro.readLine();
        String[] token = line.split(";");
        int numPosicoes = Integer.parseInt(token[0]);
        System.out.println("num de posicoes:"+ numPosicoes);

        Tabuleiro[] board = new Tabuleiro[numPosicoes+1];
        Imovel[] property = new Imovel[numPosicoes+1];

        for(int i=0; i < numPosicoes; i++)
        {
            line = entradatabuleiro.readLine();
            token = line.split(";");
            System.out.println(line);

            if("3".equals(token[2]))
            {
                board[Integer.parseInt(token[1])] = new Tabuleiro();
                property[Integer.parseInt(token[1])] = new Imovel();

                board[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[2]));
                property[Integer.parseInt(token[1])].criaImovel((Integer.parseInt(token[3])), Double.parseDouble(token[4]), Double.parseDouble(token[5]));
            }

            else
            {
                board[Integer.parseInt(token[1])] = new Tabuleiro();

                board[1].criaPosicao(Integer.parseInt(token[1]));
            }
        }

        entradatabuleiro.close();
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
