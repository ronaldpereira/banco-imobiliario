import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor // Classe auxiliar para realizacao da impressão da saida
{
    // Metodo para realizar a impressao da saida em arquivo
    public static void printStatistics(Jogador[] jogador, int numJogadas, int numJogadores, int jogadas) throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("./estatisticas.txt")); // Abertura do arquivo de saida

        estatistica.print("1:"+jogadas); // Impressao de quantas rodadas o jogo teve

        estatistica.print("\n2:"); // Impressao de quantas voltar cada jogador deu
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaVoltasDadas());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n3:"); // Impressao do saldo restante de cada jogador ao final do jogo
        for (int i = 1; i <= numJogadores; i++)
        {
            double saldo = jogador[i].retornaSaldo();

            if(saldo - (int)(saldo) > 0.00)
            {
                estatistica.printf("%d-%.2f", i, saldo);

                if(i < numJogadores)
                    estatistica.print(";");
            }

            else
            {
                estatistica.printf("%d-%.0f", i, saldo);

                if(i < numJogadores)
                    estatistica.print(";");
            }

        }

        estatistica.print("\n4:"); // Impressao da quantidade de aluguel recebido por cada jogador
        for (int i = 1; i <= numJogadores; i++)
        {
            double aluguelrecebido = jogador[i].retornaAluguelRecebido();

            if(aluguelrecebido - (int)(aluguelrecebido) > 0.00)
            {
                estatistica.printf("%d-%.2f", i, aluguelrecebido);

                if(i < numJogadores)
                    estatistica.print(";");
            }

            else
            {
                estatistica.printf("%d-%.0f", i, aluguelrecebido);

                if(i < numJogadores)
                    estatistica.print(";");
            }
        }

        estatistica.print("\n5:"); // Impressao da quantidade de aluguel pago por cada jogador
        for (int i = 1; i <= numJogadores; i++)
        {
            double aluguelpago = jogador[i].retornaAluguelPago();

            if(aluguelpago - (int)(aluguelpago) > 0.00)
            {
                estatistica.printf("%d-%.2f", i, aluguelpago);

                if(i < numJogadores)
                    estatistica.print(";");
            }

            else
            {
                estatistica.printf("%d-%.0f", i, aluguelpago);

                if(i < numJogadores)
                    estatistica.print(";");
            }
        }

        estatistica.print("\n6:"); // Impressao da quantidade de dinheiro que cada jogador gastou comprando imoveis
        for (int i = 1; i <= numJogadores; i++)
        {
            double quantocomprou = jogador[i].retornaQuantoComprou();

            if(quantocomprou - (int)(quantocomprou) > 0.00)
            {
                estatistica.printf("%d-%.2f", i, quantocomprou);

                if(i < numJogadores)
                    estatistica.print(";");
            }

            else
            {
                estatistica.printf("%d-%.0f", i, quantocomprou);

                if(i < numJogadores)
                    estatistica.print(";");
            }
        }

        estatistica.print("\n7:"); // Impressao da quantidade de Passa a Vez que cada jogador teve
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaPassaAVez());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.close(); // Fecha o arquivo de saida estatisticas.txt
    }
}
