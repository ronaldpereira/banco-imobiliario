import java.io.*;
import java.util.Scanner;

public class TP1PM
{
    public static void main(String[] args) throws Exception
    {
        Leitor entrada = new Leitor();
        entrada.ReadBoard();
        entrada.ReadPlays();
        Jogador[] players = new Jogador[entrada.numJogadores];
        entrada.PrintStatistics();
    }
}
