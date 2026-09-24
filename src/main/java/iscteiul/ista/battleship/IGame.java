package iscteiul.ista.battleship;

/**
 * Representa a interface principal de um jogo de Batalha Naval.
 * <p>
 * Define as operações necessárias para efetuar disparos, consultar
 * o estado do jogo e apresentar informações relativas aos disparos
 * e à frota.
 * </p>
 *
 * @author
 * @version 1.0
 */

import java.util.List;

/**
 * Interface que define as operações disponíveis durante um jogo
 * de Batalha Naval.
 */
public interface IGame {

    /**
     * Efetua um disparo numa determinada posição do tabuleiro.
     *
     * @param pos posição onde o disparo será efetuado
     * @return o navio atingido pelo disparo, ou {@code null} caso
     *         não tenha sido atingido nenhum navio
     */
    IShip fire(IPosition pos);

    /**
     * Obtém a lista de posições onde já foram efetuados disparos.
     *
     * @return lista de posições dos disparos efetuados
     */
    List<IPosition> getShots();

    /**
     * Obtém o número de disparos repetidos efetuados pelo jogador.
     *
     * @return número de disparos repetidos
     */
    int getRepeatedShots();

    /**
     * Obtém o número de disparos inválidos efetuados pelo jogador.
     *
     * @return número de disparos inválidos
     */
    int getInvalidShots();

    /**
     * Obtém o número total de navios atingidos.
     *
     * @return número de acertos
     */
    int getHits();

    /**
     * Obtém o número de navios que foram afundados.
     *
     * @return número de navios afundados
     */
    int getSunkShips();

    /**
     * Obtém o número de navios que ainda permanecem na frota.
     *
     * @return número de navios restantes
     */
    int getRemainingShips();

    /**
     * Imprime no terminal as posições onde é válido efetuar um disparo.
     */
    void printValidShots();

    /**
     * Imprime no terminal a informação relativa à frota de navios.
     */
    void printFleet();
}