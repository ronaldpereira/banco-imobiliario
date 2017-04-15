public class JogaJogo extends Jogada
{
  	private static int position;

  		private static boolean verificaSaldo(Jogador[] jogador, Jogada[] jogada, double price, int i)
        {
        	return (jogador[jogada[i].playerid].retornaSaldo() >= price);
        }

  		public static void compra(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i)
        {
            double preco = imovel[position].retornaPreco();

        	if(JogaJogo.verificaSaldo(jogador, jogada, preco, i))
            {
              	jogador[jogada[i].playerid].fazCompra(preco);
            	imovel[position].mudaDono(jogada[i].playerid);
            }

        	if(jogador[jogada[i].playerid].retornaSaldo() == 0)
            	jogador[jogada[i].playerid].saiDoJogo(imovel);
        }

  		public static void aluga(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i)
  		{
        	double aluguel = imovel[position].retornaAluguel();

          	if(JogaJogo.verificaSaldo(jogador, jogada, aluguel, i))
            {
             	jogador[jogada[i].playerid].pagaAluguel(aluguel);
              	jogador[imovel[position].retornaDono()].recebeAluguel(aluguel);

              	if(jogador[jogada[i].playerid].retornaSaldo() == aluguel)
                	jogador[jogada[i].playerid].saiDoJogo(imovel);
            }

          	else
            {
            	jogador[jogada[i].playerid].saiDoJogo(imovel);
            }
  		}

  		public static void jogaJogo(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int numJogadas, int numJogadores, int numPosicoes) throws Exception
    	{
			for(int i = 1; i < numJogadas; i++)
    		{
    			if(jogador[jogada[i].playerid].retornaIs_playing())
        		{
     				position = jogador[jogada[i].playerid].moveJogador(jogada[i].dice, numPosicoes);

              		if(tabuleiro[position].retornaTipoPosicao() == 3)
                    {
                    	if(imovel[position].retornaDono() == 0)
                          compra(tabuleiro, imovel, jogador, jogada, i);

                      	else if(imovel[position].retornaDono() != jogada[i].playerid)
                          aluga(tabuleiro, imovel, jogador, jogada, i);
                    }

                    else if(tabuleiro[position].retornaTipoPosicao() == 2)
                    {
                        jogador[jogada[i].playerid].incrementaPassados();
                    }
            	}
        	}
            Escritor.printStatistics(jogador, numJogadas, numJogadores);
      	}
}
