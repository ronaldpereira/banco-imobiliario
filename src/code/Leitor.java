import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor // Classe auxiliar que realiza a leitura dos arquivos de entrada
{
    private int numPosicoes; // Guarda o numero de posicoes do tabuleiro lido na entrada
    private int numJogadores; // Guarda o numero de jogadores lido na entrada
    private int numJogadas; // Guarda o numero de possiveis jogadas lido na entrada
    private String line; // Guarda a linha do arquivo lida
    private String[] token; // Guarda line tokenizado, separando as informacoes
    private double valorInicial; // Guarda o valor inicial de cada jogador no jogo

    // Metodo principal que realiza toda a leitura dos dados da entrada, instancia os objetos mediante necessidade e ja coloca os dados da entrada neles
    public void Reader() throws Exception
    {
        BufferedReader entradatabuleiro = new BufferedReader(new FileReader("./tabuleiro.txt")); // Abertura do arquivo que contem a estrutura do tabuleiro

        line = entradatabuleiro.readLine(); // Le a primeira linha do arquivo de entrada
        numPosicoes = Integer.parseInt(line); // Guarda o numero de posicoes dada na primeira linha da entrada do tabuleiro

        Tabuleiro[] tabuleiro = new Tabuleiro[numPosicoes+1]; // Instancia um array de objetos da classe Tabuleiro
        Imovel[] imovel = new Imovel[numPosicoes+1]; // Instancia um array de objetos da classe Imovel

        for(int i=1; i <= numPosicoes; i++)
        {
            line = entradatabuleiro.readLine(); // Le cada linha do arquivo de entrada a cada iteracao
            token = line.split(";"); // Tokeniza a linha atual

            if("3".equals(token[2])) // Se a casa do tabuleiro for um imovel, teremos que criar um objeto imovel naquela posicao tambem
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro(); // Instancia um objeto da classe Tabuleiro para representar uma casa do tabuleiro
                imovel[Integer.parseInt(token[1])] = new Imovel(); // Instancia um objeto da classe Imovel para representar as informacoes do imovel naquela posicao

                tabuleiro[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[1]), Integer.parseInt(token[2])); // Chamada do metodo para armazenar as informacoes na casa do tabuleiro correspondente
                imovel[Integer.parseInt(token[1])].criaImovel((Integer.parseInt(token[3])), Double.parseDouble(token[4]), Double.parseDouble(token[5])); // Chamada do metodo para armazenar as informacoes no imovel correspondente
            }

            else // Se a casa nao for um imovel, ou ela sera um start ou um passe a vez, sem nenhum imovel associado a ela, nao criando assim um objeto imovel naquela casa
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro(); // Instancia um objeto da classe Tabuleiro para representar uma casa do tabuleiro

                tabuleiro[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[1]), Integer.parseInt(token[2])); // Instancia um objeto da classe Imovel para representar as informacoes do imovel naquela posicao
            }
        }

        entradatabuleiro.close(); // Fecha o arquivo de entarada tabuleiro.txt

        BufferedReader jogadas = new BufferedReader(new FileReader("./jogadas.txt")); // Abertura do arquivo que contem a estrutura das jogadas

        line = jogadas.readLine(); // Le a primeira linha do arquivo de entrada
        token = line.split("%"); // Tokeniza a primeira linha da entrada das jogadas

        numJogadas = Integer.parseInt(token[0]); // Guarda o numero de jogadas possiveis contidas na primeira linha da entrada das jogadas
        numJogadores = Integer.parseInt(token[1]); // Guarda o numero de jogadores participantes do jogo
        valorInicial = Double.parseDouble(token[2]); // Guardo o valor inicial de cada jogador no jogo

        Jogador[] jogador = new Jogador[numJogadores+1]; // Instancia um array de objetos da classe Jogador
        for (int i=1; i <= numJogadores ; i++)
            jogador[i] = new Jogador(i, valorInicial); // Instancia um objeto da classe Jogador para cada jogador no jogo e ja inicializa ele com os valores necessarios (ID e valor inicial)

        Jogada[] jogada = new Jogada[numJogadas]; // Instancia um array de objetos da classe Jogada
        for(int i=1; i <= numJogadas; i++)
        {
            line = jogadas.readLine(); // Le cada linha do arquivo de entrada a cada iteracao
            token = line.split(";"); // Tokeniza a linha atual

            if(!("DUMP".equals(line))) // Se a linha atual nao conter o comando de DUMP, guarda as informacoes da jogada
            {
                jogada[i] = new Jogada(); // Instancia um objeto da classe Jogada para representar uma jogada
                jogada[i].criaJogada(Integer.parseInt(token[0]), Integer.parseInt(token[1]) ,Integer.parseInt(token[2])); // Chamada do metodo para armazenar as informacoes da jogada
            }
        }

        jogadas.close(); // Fecha o arquivo de entrada jogadas.txt

        JogaJogo jogajogo = new JogaJogo(); // Instancia da classe-filha JogaJogo para a execucao do jogo
        JogaJogo.jogaJogo(tabuleiro, imovel, jogador, jogada, numJogadas, numJogadores, numPosicoes); // Chamada do metodo da classe-filha JogaJogo para a execucao do jogo
    }
}
