public class JogaJogo extends Jogada // Classe-filha da classe Jogada
{
    private static int position; // Guarda a posicao do tabuleiro que o jogador foi atualmente

    private static boolean verificaSaldo(Jogador[] jogador, Jogada[] jogada, double price, int i) // Retorna true se o saldo do jogador é maior ou igual ao custo da transacao (compra ou aluguel)
    {
        return (jogador[jogada[i].playerid].retornaSaldo() >= price);
    }

    public static void compra(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i) // Metodo que realiza a compra de um imovel
    {
        double preco = imovel[position].retornaPreco(); // Guarda o preco do imovel a ser comprado

        if(JogaJogo.verificaSaldo(jogador, jogada, preco, i)) // Se o jogador tem o saldo para comprar o imovel
        {
            jogador[jogada[i].playerid].fazCompra(preco); // Metodo que realiza a compra do imovel
            imovel[position].mudaDono(jogada[i].playerid); // Metodo que modifica o id do dono do imovel
        }
    }

    public static void aluga(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i, int numPosicoes) // Metodo que realiza o pagamento de um aluguel de um imovel
    {
        double aluguel = imovel[position].retornaAluguel(); // Guarda o aluguel do imovel a ser comprado

        if(JogaJogo.verificaSaldo(jogador, jogada, aluguel, i)) // Se o jogador tem o saldo para pagar o aluguel
        {
            jogador[jogada[i].playerid].pagaAluguel(aluguel); // Metodo que realiza o pagamento do aluguel
            jogador[imovel[position].retornaDono()].recebeAluguel(aluguel); // Metodo que realiza o recebimento do aluguel
        }

        else // Se o jogador nao tem o saldo para pagar o aluguel
            jogador[jogada[i].playerid].saiDoJogo(imovel, numPosicoes); // Metodo que realiza a devolucao de todos os imoveis do jogador que saiu do jogo para o banco
    }

    public static void jogaJogo(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int numJogadas, int numJogadores, int numPosicoes) throws Exception
    {
        int vivos; // Guarda o numero de jogadores vivos na jogada atual
        int jogadas = 0; // Guarda o numero de turnos atuais do jogo
        int primeirojogador = jogador[jogada[1].playerid].retornaID(); // Guarda o id do primeiro jogador, para que, a cada vez que ele jogue, seja incrementado uma jogada na variavel jogadas

        for(int i = 1; i < numJogadas; i++)
        {
            vivos = 0; // A cada iteracao sera feita uma nova contagem dos jogadores vivos, portanto zera o contador
            for(int j = 1; j <= numJogadores; j++)
            {
                if(jogador[j].retornaIs_playing()) // Para cada jogador que ainda esta jogando, o contador vivos eh incrementado em +1
                    vivos++;
            }

            if(vivos > 1) // Se o numero de jogadores vivos for maior do que 1
            {
                if(primeirojogador == jogador[jogada[i].playerid].retornaID()) // Se o jogador da jogada atual for o jogador que comecou a jogar, incrementa +1 a jogadas
                    jogadas++;

                if(jogador[jogada[i].playerid].retornaIs_playing()) // Se o jogador da jogada atual ainda estiver jogando
                {
         	    position = jogador[jogada[i].playerid].moveJogador(jogada[i].dice, numPosicoes); // Guarda a posicao atual do jogador no tabuleiro, que eh calculado pelo metodo moveJogador, da classe Jogador

                    if(tabuleiro[position].retornaTipoPosicao() == 3) // Se o tipo da posicao atual do jogador for um imovel
                    {
                        if(imovel[position].retornaDono() == 0) // Se o imovel pertencer ao banco
                            compra(tabuleiro, imovel, jogador, jogada, i); // O jogador tera que comprar o imovel

                        else if(imovel[position].retornaDono() != jogada[i].playerid) // Se o imovel pertecer a outro jogador
                            aluga(tabuleiro, imovel, jogador, jogada, i, numPosicoes); // O jogador tera que pagar o aluguel do imovel
                    }

                    else if(tabuleiro[position].retornaTipoPosicao() == 2) // Se o tipo da posicao atual do jogador for um passe a vez
                        jogador[jogada[i].playerid].incrementaPassados(); // Chamada do metodo que incrementa um passe a vez para o jogador atual
                }
            }
        }
        Escritor.printStatistics(jogador, numJogadas, numJogadores, jogadas); // Chamada do metodo que realiza a impressao dos dados estatisticos
    }
}  
