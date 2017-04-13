public class BancoImobiliario
{
    public static void main(String[] args) throws Exception
    {
        Leitor entrada = new Leitor();
        entrada.ReadBoard();
        entrada.ReadPlays();
        entrada.PrintStatistics();
    }
}
