public class Imovel // Classe auxiliar que representa um imovel no tabuleiro
{
    private int typeid; // Guarda o ID que representa o tipo do imovel
    private double price; // Guarda o preco que imovel possui
    private double rent; // Guarda o aluguel ja calculado do imovel
    private int ownerid = 0; // Guarda o ID do dono do imovel (0 eh o id do banco, por padrao)

    private void calculaAluguel(double rent) // Metodo que realiza o calculo do aluguel
    {
        this.rent = this.price * (rent/100);
    }

    public void criaImovel(int typeid, double price, double rent) // Metodo que realiza o armazenamento das informacaoes dos dados do imovel
    {
        this.typeid = typeid;
        this.price = price;
        calculaAluguel(rent); // Chamada do metodo que calcula o aluguel
    }

    public double retornaPreco() // Metodo que retorna o preco do imovel
    {
        return this.price;
    }

    public double retornaAluguel() // Metodo que retorna o preco do aluguel do imovel
    {
        return this.rent;
    }
    
    public int retornaDono() // Metodo que retorna o ID do dono do imovel
    {
        return this.ownerid;
    }

    public void mudaDono(int newowner) // Metodo que realiza a mudanca do ID do dono do imovel
    {
        this.ownerid = newowner;
    }

    public void devolveImovel() // Metodo que realiza a devolucao do imovel para o banco
    {
        this.ownerid = 0;
    }
}
