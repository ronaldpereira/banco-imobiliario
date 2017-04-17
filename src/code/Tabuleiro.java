public class Tabuleiro // Classe que representa o tabuleiro do jogo
{
    private int position; // Guarda a posicao da casa no tabuleiro
    private int positiontype; // Guarda o tipo de posicao da casa

    public void criaPosicao(int position, int positiontype) // Inicializa a casa do tabuleiro
    {
        this.position = position; // Guarda a posicao referente a casa no tabuleiro
        this.positiontype = positiontype; // Guarda o tipo da casa no tabuleiro
    }

    public int retornaTipoPosicao() // Metodo que retorna o tipo da posicao da casa do tabuleiro
    {
        return this.positiontype;
    }
}
