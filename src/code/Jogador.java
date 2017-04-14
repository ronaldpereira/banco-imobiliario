public class Jogador
{
    private int id;
  	private double balance;
  	private double paidrent = 0;
  	private double receivedrent = 0;
    private double buys = 0;
    private int completed = 0;
  	private int passedturns = 0;
    private int position = 1;
    private boolean is_playing = true;

    Jogador(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }

    public int moveJogador(int dice, int numPosicoes)
    {
        if(this.position + dice > numPosicoes)
        {
            this.position += dice - numPosicoes;
            this.completed++;
            this.balance += 500;
        }

        else
            this.position += dice;

        return this.position;
    }

    public void incrementaPassados()
    {
        this.passedturns++;
    }

    public int retornaVoltasDadas()
    {
        return this.completed;
    }

    public double retornaSaldo()
    {
        return this.balance;
    }

    public double retornaAluguelRecebido()
    {
        return this.receivedrent;
    }

    public double retornaAluguelPago()
    {
        return this.paidrent;
    }

    public double retornaQuantoComprou()
    {
        return this.buys;
    }

    public int retornaPassaAVez()
    {
        return this.passedturns;
    }

    public boolean retornaIs_playing()
    {
        return this.is_playing;
    }

    public void fazCompra(double preco)
    {
        this.balance -= preco;
        this.buys += preco;
    }

    public void pagaAluguel(double preco)
    {
        this.balance -= preco;
        this.paidrent += preco;
    }

    public void recebeAluguel(double preco)
    {
        this.balance += preco;
        this.receivedrent += preco;
    }

    public void saiDoJogo(Imovel[] imovel)
    {
        this.is_playing = false;

        for(int i = 1; i <= 10; i++)
        {
            if(imovel[i] != null)
            {
                if(imovel[i].retornaDono() == this.id)
                    imovel[i].devolveImovel();
            }
        }
    }
}
