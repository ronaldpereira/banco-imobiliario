public class Jogador
{
    private int id;
  	private double balance;
  	private double paidRent = 0;
  	private double receivedRent = 0;
  	private int buys = 0;
    private int turns = 0;
    private int completed = 0;
  	private int passedturns = 0;
    private int position = 0;
    private boolean is_playing = true;

    Jogador(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }

    public int moveJogador(int dice, int numPosicoes)
    {
        if(this.position + dice >= numPosicoes)
        {
            this.position = (this.position + dice) % numPosicoes;
            this.completed++;
            this.balance += 500;
        }

        else
            this.position += dice;

        return this.position;
    }

    public void reduzSaldo(double preco)
    {

    }

    public void incrementaComprado()
    {

    }

    public void pagaAluguel()
    {

    }

    public void recebeAluguel()
    {

    }

    public void saiDoJogo()
    {
        this.is_playing = false;

        //TODO colocar o ownerid de todos os imoveis = 0 usando imove.devolveImovel
    }
}
