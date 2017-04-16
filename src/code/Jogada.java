public class Jogada // Classe auxiliar que guarda as jogadas do jogo
{
    protected int id; // Guarda o ID da jogada
    protected int playerid; // Guarda o ID do jogador da jogada
    protected int dice; // Guarda o numero do dado que o jogador tirou naquela jogada

    public void criaJogada(int id, int playerid, int dice) // Realiza a criacao de uma jogada com os dados passados por parametro
    {
        this.id = id;
        this.playerid = playerid;
        this.dice = dice;
    }
}
