package iscteiul.ista.battleship;

/**
 * Representa uma posição no tabuleiro do jogo de Batalha Naval.
 * <p>
 * Cada posição é identificada por uma linha e uma coluna e pode
 * estar ocupada por um navio e/ou ter sido atingida por um disparo.
 * </p>
 *
 * @author fba
 */

import java.util.Objects;

import static java.util.Objects.*;

/**
 * Implementação de uma posição do tabuleiro.
 */
public class Position implements IPosition {

    /** Número da linha da posição. */
    private int row;

    /** Número da coluna da posição. */
    private int column;

    /** Indica se a posição está ocupada por um navio. */
    private boolean isOccupied;

    /** Indica se a posição foi atingida por um disparo. */
    private boolean isHit;

    /**
     * Cria uma nova posição com a linha e coluna especificadas.
     * <p>
     * Inicialmente, a posição não está ocupada e não foi atingida.
     * </p>
     *
     * @param row número da linha da posição
     * @param column número da coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Obtém o número da linha da posição.
     *
     * @return número da linha
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Obtém o número da coluna da posição.
     *
     * @return número da coluna
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Calcula o código hash da posição.
     *
     * @return código hash da posição
     */
    @Override
    public int hashCode() {
        return hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outro objeto.
     * <p>
     * Duas posições são consideradas iguais quando possuem a mesma
     * linha e a mesma coluna.
     * </p>
     *
     * @param otherPosition objeto a comparar com esta posição
     * @return {@code true} se as posições tiverem a mesma linha e coluna;
     *         {@code false} caso contrário
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é adjacente a outra posição.
     * <p>
     * Uma posição é considerada adjacente quando a diferença entre
     * as suas linhas e colunas é, no máximo, uma unidade.
     * </p>
     *
     * @param other posição a verificar
     * @return {@code true} se as posições forem adjacentes;
     *         {@code false} caso contrário
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1
                && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca esta posição como ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Regista um disparo efetuado nesta posição.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Verifica se esta posição está ocupada por um navio.
     *
     * @return {@code true} se a posição estiver ocupada;
     *         {@code false} caso contrário
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se esta posição foi atingida por um disparo.
     *
     * @return {@code true} se a posição tiver sido atingida;
     *         {@code false} caso contrário
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Obtém uma representação textual da posição.
     *
     * @return texto contendo a linha e a coluna da posição
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}