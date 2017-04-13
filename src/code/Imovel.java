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
}
