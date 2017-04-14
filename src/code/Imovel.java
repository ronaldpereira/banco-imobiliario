public class Imovel
{
    private int typeid;
    private double price;
    private double rent;
    private int ownerid = 0;

    private void calculaAluguel(double rent)
    {
        this.rent = this.price * (rent/100);
    }

    public void criaImovel(int typeid, double price, double rent)
    {
        this.typeid = typeid;
        this.price = price;
        calculaAluguel(rent);
    }

    public double retornaPreco()
    {
        return this.price;
    }

    public double retornaAluguel()
    {
        return this.rent;
    }

    public void mudaDono(int newowner)
    {
        this.ownerid = newowner;
    }

    public void devolveImovel()
    {
        this.ownerid = 0;
    }
}
