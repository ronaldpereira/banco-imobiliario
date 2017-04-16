public class Jogador // Classe que representa um jogador
{
    private int id; // Guarda o ID do jogador
  	private double balance; // Guarda o saldo que o jogador possui
  	private double paidrent = 0; // Guarda a quantidade de aluguel pago pelo jogador
  	private double receivedrent = 0; // Guarda a quantidade de aluguel recebido pelo jogador
    private double buys = 0; // Guarda a quantidade de dinheiro gasto em compras de imoveis pelo jogador
    private int completed = 0; // Guarda a quantidade de voltas no tabuleiro que o jogador deu
  	private int passedturns = 0; // Guarda a quantidade de passe a vez que o jogador teve
    private int position = 1; // Guarda a posicao atual do jogador no tabuleiro (1 eh a casa start, por padrao)
    private boolean is_playing = true; // Guarda a informacao de true, se o jogador ainda esta jogando e false, caso o jogador ja tenha saido do jogo

    Jogador(int id, double balance) // Para criar um objeto Jogador, precisamos dessas informacoes para ja inicializa-lo
    {
        this.id = id; // Guarda o ID do jogador
        this.balance = balance; // Guarda o saldo inicial do jogador no jogo
    }

    public int moveJogador(int dice, int numPosicoes) // Metodo que move um jogador pelo tabuleiro
    {
        this.position += dice; // Soma a posicao atual do jogador ao numero do dado que ele tirou

        while(this.position > numPosicoes) // Enquanto a posicao do jogador for maior que o numero de casas do tabuleiro
        {
            this.position -= numPosicoes; // Decrementa uma volta a posicao atual do jogador
            this.completed++; // Incrementa +1 ao numero de voltas no tabuleiro que o jogador deu
            this.balance += 500; // Aumenta o seu saldo em 500 a cada volta
        }

        return this.position; // Retorno a posicao atual do jogador no tabuleiro
    }

    public void incrementaPassados() // Metodo que realiza o incremento de quantos passa a vez o jogador teve
    {
        this.passedturns++;
    }

    public void fazCompra(double preco) // Metodo que realiza a deducao do saldo do jogador e aumenta a quantidade que ele comprou
    {
        this.balance -= preco;
        this.buys += preco;
    }

    public void pagaAluguel(double preco) // Metodo que realiza a deducao do saldo do jogador e aumenta a quantidade que ele pagou de aluguel
    {
        this.balance -= preco;
        this.paidrent += preco;
    }

    public void recebeAluguel(double preco) // Metodo que realiza o incremento do saldo do jogador e aumenta a quantidade que ele recebeu de aluguel
    {
        this.balance += preco;
        this.receivedrent += preco;
    }

    public void saiDoJogo(Imovel[] imovel, int numPosicoes) // Metodo que realiza a exclusao de um jogador do jogo
    {
        this.is_playing = false; // Coloca a variavel de controle para falso (as jogadas dele nao serao mais computadas)

        for(int i = 1; i <= numPosicoes; i++) // Caminha em todas as casas do tabuleiro
        {
            if(imovel[i] != null) // Se existir um imovel na casa atual do tabuleiro
            {
                if(imovel[i].retornaDono() == this.id) // Verifica se o dono eh o jogador que esta saindo do jogo
                    imovel[i].devolveImovel(); // Se for, chama o metodo devolveImovel, que realiza a devolucao do imovel para o banco
            }
        }
    }

    public int retornaID() // Metodo que retorna o ID do jogador
    {
        return this.id;
    }

    public int retornaVoltasDadas() // Metodo que retorna o numero de voltas dadas no tabuleiro pelo jogador
    {
        return this.completed;
    }

    public double retornaSaldo() // Metodo que retorna o saldo atual do jogador
    {
        return this.balance;
    }

    public double retornaAluguelRecebido() // Metodo que retorna o quanto de dinheiro que o jogador ganhou recebendo alugueis
    {
        return this.receivedrent;
    }

    public double retornaAluguelPago() // Metodo que retorna o quanto de dinheiro que o jogador gastou pagando alugueis
    {
        return this.paidrent;
    }

    public double retornaQuantoComprou() // Metodo que retorna o quanto de dinheiro que o jogador gastou comprando imoveis
    {
        return this.buys;
    }

    public int retornaPassaAVez() // Metodo que retorna quantos passe a vez o jogador teve
    {
        return this.passedturns;
    }

    public boolean retornaIs_playing() // Metodo que retorna se o jogador ainda esta jogando o jogo
    {
        return this.is_playing;
    }
}
