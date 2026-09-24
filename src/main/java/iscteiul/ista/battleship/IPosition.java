package iscteiul.ista.battleship;
/**
 * Representa uma posição no tabuleiro do jogo de Batalha Naval.
 * <p>
 * Uma posição é identificada por uma linha e uma coluna e pode
 * encontrar-se ocupada por um navio e/ou ter sido atingida por um disparo.
 * </p>
 *
 * @author fba
 */

/**
 * Interface que representa uma posição no tabuleiro de jogo.
 */
public interface IPosition {

    /**
     * Obtém o número da linha correspondente à posição.
     *
     * @return número da linha
     */
    int getRow();

    /**
     * Obtém o número da coluna correspondente à posição.
     *
     * @return número da coluna
     */
    int getColumn();

    /**
     * Verifica se esta posição é igual a outra posição.
     *
     * @param other objeto a comparar com esta posição
     * @return {@code true} se as posições forem iguais;
     *         {@code false} caso contrário
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente a outra posição.
     *
     * @param other posição a verificar
     * @return {@code true} se as posições forem adjacentes;
     *         {@code false} caso contrário
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como ocupada por um navio.
     */
    void occupy();

    /**
     * Regista um disparo efetuado nesta posição.
     */
    void shoot();

    /**
     * Verifica se esta posição está ocupada por um navio.
     *
     * @return {@code true} se a posição estiver ocupada;
     *         {@code false} caso contrário
     */
    boolean isOccupied();

    /**
     * Verifica se a posição foi atingida por um disparo.
     *
     * @return {@code true} se a posição tiver sido atingida;
     *         {@code false} caso contrário
     */
    boolean isHit();
}
