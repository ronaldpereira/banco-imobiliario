public class Imovel
{
    private int id;
    private int price;
    private int rent;
    private int ownerid = 0;

    private void calculaAluguel(int rent)
    {
        this.rent = this.price * rent;
    }
}
