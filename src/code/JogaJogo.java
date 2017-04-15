public class JogaJogo extends Jogada
{
  	private static int position;

  		private static boolean verificaSaldo(Jogador[] jogador, Jogada[] jogada, double price, int i)
        {
        	return (jogador[jogada[i].playerid].retornaSaldo() > price);
        }

  		public static void compra(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i)
        {
            double preco = imovel[position].retornaPreco();

        	if(JogaJogo.verificaSaldo(jogador, jogada, preco, i))
            {
              	jogador[jogada[i].playerid].fazCompra(preco);
            	imovel[position].mudaDono(jogada[i].playerid);
            }
        }

  		public static void aluga(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int i)
  		{
        	double aluguel = imovel[position].retornaAluguel();

          	if(JogaJogo.verificaSaldo(jogador, jogada, aluguel, i))
            {
             	jogador[jogada[i].playerid].pagaAluguel(aluguel);
              	jogador[imovel[position].retornaDono()].recebeAluguel(aluguel);
            }

          	else
            {
            	jogador[jogada[i].playerid].saiDoJogo(imovel);
            }
  		}

  		public static void jogaJogo(Tabuleiro[] tabuleiro, Imovel[] imovel, Jogador[] jogador, Jogada[] jogada, int numJogadas, int numJogadores, int numPosicoes) throws Exception
    	{
            int vivos;
            int jogadas = 0;
            int primeirojogador = jogador[jogada[1].playerid].retornaID();

			for(int i = 1; i < numJogadas; i++)
    		{
                vivos = 0;
                for(int j = 1; j <= numJogadores; j++)
                {
                    if(jogador[j].retornaIs_playing())
                        vivos++;
                }

                if(vivos > 1)
                {
                    if(primeirojogador == jogador[jogada[i].playerid].retornaID())
                        jogadas++;

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
        	}
            Escritor.printStatistics(jogador, numJogadas, numJogadores, jogadas);
      	}
}
