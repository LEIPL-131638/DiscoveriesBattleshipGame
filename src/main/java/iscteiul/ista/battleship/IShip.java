package iscteiul.ista.battleship;

/**
 * Representa um navio no jogo de Batalha Naval.
 * <p>
 * Um navio possui uma categoria, um tamanho, uma orientação e um
 * conjunto de posições que ocupa no tabuleiro. A interface permite
 * também verificar o seu estado, a sua localização e a proximidade
 * relativamente a outras posições ou navios.
 * </p>
 *
 * @author fba
 */

import java.util.List;

/**
 * Interface que representa um navio no jogo de Batalha Naval.
 */
public interface IShip {

    /**
     * Obtém a categoria do navio.
     *
     * @return categoria do navio
     */
    String getCategory();

    /**
     * Obtém o tamanho do navio, correspondente ao número de posições
     * que este ocupa no tabuleiro.
     *
     * @return tamanho do navio
     */
    Integer getSize();

    /**
     * Obtém todas as posições ocupadas pelo navio.
     *
     * @return lista de posições ocupadas pelo navio
     */
    List<IPosition> getPositions();

    /**
     * Obtém uma posição ocupada pelo navio.
     *
     * @return uma posição do navio
     */
    IPosition getPosition();

    /**
     * Obtém a orientação do navio no tabuleiro.
     *
     * @return orientação do navio
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda está a flutuar, ou seja, se ainda
     * possui pelo menos uma posição que não foi atingida.
     *
     * @return {@code true} se o navio ainda estiver a flutuar;
     *         {@code false} se estiver afundado
     */
    boolean stillFloating();

    /**
     * Obtém a posição da extremidade superior do navio.
     *
     * @return índice da posição mais acima ocupada pelo navio
     */
    int getTopMostPos();

    /**
     * Obtém a posição da extremidade inferior do navio.
     *
     * @return índice da posição mais abaixo ocupada pelo navio
     */
    int getBottomMostPos();

    /**
     * Obtém a posição da extremidade esquerda do navio.
     *
     * @return índice da posição mais à esquerda ocupada pelo navio
     */
    int getLeftMostPos();

    /**
     * Obtém a posição da extremidade direita do navio.
     *
     * @return índice da posição mais à direita ocupada pelo navio
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return {@code true} se o navio ocupar a posição;
     *         {@code false} caso contrário
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio está demasiado próximo de outro navio.
     *
     * @param other outro navio a verificar
     * @return {@code true} se os navios estiverem demasiado próximos;
     *         {@code false} caso contrário
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se este navio está demasiado próximo de uma determinada
     * posição.
     *
     * @param pos posição a verificar
     * @return {@code true} se o navio estiver demasiado próximo da posição;
     *         {@code false} caso contrário
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Efetua um disparo numa posição ocupada pelo navio.
     *
     * @param pos posição onde o disparo será efetuado
     */
    void shoot(IPosition pos);
}
