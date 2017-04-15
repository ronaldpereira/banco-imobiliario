import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor
{
    public static void printStatistics(Jogador[] jogador, int numJogadas, int numJogadores) throws Exception
    {
        PrintWriter estatistica = new PrintWriter(new FileWriter("../IOFiles/estatisticas.txt"));

        int numTurns = (int) Math.ceil(numJogadas/numJogadores);
        estatistica.print("1:"+numTurns);

        estatistica.print("\n2:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaVoltasDadas());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.print("\n3:");
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

        estatistica.print("\n4:");
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

        estatistica.print("\n5:");
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

        estatistica.print("\n6:");
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

        estatistica.print("\n7:");
        for (int i = 1; i <= numJogadores; i++)
        {
            estatistica.print(i+"-"+jogador[i].retornaPassaAVez());
            if(i < numJogadores)
                estatistica.print(";");
        }

        estatistica.close();
    }
}
