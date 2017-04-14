public class Tabuleiro
{
  	private int position;
    private int positiontype;

    public void criaPosicao(int positiontype)
    {
        this.positiontype = positiontype;
    }

    public int retornaTipoPosicao()
    {
        return this.positiontype;
    }
}
