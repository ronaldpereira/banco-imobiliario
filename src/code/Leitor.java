import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor
{
	private int numJogadores;
    public int numPosicoes;
    public int numJogadas;

    public void ReadBoard() throws Exception
    {
        BufferedReader entradatabuleiro = new BufferedReader(new FileReader("../IOFiles/tabuleiro.txt"));

        String line = entradatabuleiro.readLine();
        String[] token = line.split(";");
        numPosicoes = Integer.parseInt(token[0]);
        System.out.println("num de posicoes:"+ numPosicoes);

        Tabuleiro[] tabuleiro = new Tabuleiro[numPosicoes+1];
        Imovel[] imovel = new Imovel[numPosicoes+1];

        for(int i=1; i <= numPosicoes; i++)
        {
            line = entradatabuleiro.readLine();
            token = line.split(";");
            System.out.println(line);

            if("3".equals(token[2]))
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro();
                imovel[Integer.parseInt(token[1])] = new Imovel();

                tabuleiro[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[2]));
                imovel[Integer.parseInt(token[1])].criaImovel((Integer.parseInt(token[3])), Double.parseDouble(token[4]), Double.parseDouble(token[5]));
            }

            else
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro();

                tabuleiro[1].criaPosicao(Integer.parseInt(token[1]));
            }
        }

        entradatabuleiro.close();
    }

    public void ReadPlays() throws Exception
    {
        BufferedReader jogadas = new BufferedReader(new FileReader("../IOFiles/jogadas.txt"));

        String line = jogadas.readLine();
        String[] token = line.split("%");

        numJogadas = Integer.parseInt(token[0]);
        numJogadores = Integer.parseInt(token[1]);
        double valorInicial = Double.parseDouble(token[2]);

        System.out.println("num jogadas:"+numJogadas+"\nnum jogadores:"+numJogadores+"\nvalor inicial:"+valorInicial);

        Jogador[] jogador = new Jogador[numJogadores+1];
        for (int i=1; i <= numJogadores ; i++)
            jogador[i] = new Jogador(i, valorInicial);

        Jogada[] jogada = new Jogada[numJogadas];
        for(int i=1; i <= numJogadas; i++)
        {
            line = jogadas.readLine();
            token = line.split(";");
            System.out.println(line);

            if("DUMP".equals(line))
            {
                System.out.println("END");
            }

            else
            {
                jogada[i] = new Jogada();
                jogada[i].criaJogada(Integer.parseInt(token[0]), Integer.parseInt(token[1]) ,Integer.parseInt(token[2]));
            }
        }
        jogadas.close();
    }

    public void PrintStatistics() throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

    	estatistica.close();
    }
}
