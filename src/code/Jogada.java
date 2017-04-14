public class Jogada
{
    protected int id;
    protected int playerid;
    protected int dice;

    public void criaJogada(int id, int playerid, int dice)
    {
        this.id = id;
        this.playerid = playerid;
        this.dice = dice;
    }
}
