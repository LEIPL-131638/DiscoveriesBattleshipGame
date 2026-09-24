/**
 * Representa a implementação base de um navio no jogo de Batalha Naval.
 * <p>
 * Esta classe abstrata contém o comportamento comum aos diferentes tipos
 * de navios, incluindo a sua categoria, orientação, posição inicial e
 * posições ocupadas no tabuleiro.
 * </p>
 *
 * @author fba
 */
        package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe abstrata que define o comportamento comum dos navios.
 */
public abstract class Ship implements IShip {

    /** Categoria correspondente ao navio Galeão. */
    private static final String GALEAO = "galeao";

    /** Categoria correspondente ao navio Fragata. */
    private static final String FRAGATA = "fragata";

    /** Categoria correspondente ao navio Nau. */
    private static final String NAU = "nau";

    /** Categoria correspondente ao navio Caravela. */
    private static final String CARAVELA = "caravela";

    /** Categoria correspondente ao navio Barca. */
    private static final String BARCA = "barca";

    /**
     * Cria um navio do tipo especificado.
     *
     * @param shipKind tipo ou categoria do navio
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     * @return navio correspondente ao tipo especificado, ou {@code null}
     *         se o tipo não for reconhecido
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    /** Categoria do navio. */
    private String category;

    /** Orientação do navio no tabuleiro. */
    private Compass bearing;

    /** Posição inicial do navio. */
    private IPosition pos;

    /** Lista de posições ocupadas pelo navio. */
    protected List<IPosition> positions;

    /**
     * Constrói um navio com a categoria, orientação e posição inicial
     * especificadas.
     *
     * @param category categoria do navio
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Obtém a categoria do navio.
     *
     * @return categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Obtém a lista de posições ocupadas pelo navio.
     *
     * @return lista de posições do navio
     */
    @Override
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Obtém a posição inicial do navio.
     *
     * @return posição inicial do navio
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Obtém a orientação do navio.
     *
     * @return orientação do navio
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se o navio ainda está a flutuar.
     * <p>
     * O navio encontra-se a flutuar enquanto existir pelo menos uma
     * das suas posições que ainda não tenha sido atingida.
     * </p>
     *
     * @return {@code true} se o navio ainda estiver a flutuar;
     *         {@code false} se todas as suas posições tiverem sido atingidas
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Obtém a linha da posição mais acima ocupada pelo navio.
     *
     * @return número da linha mais acima ocupada pelo navio
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Obtém a linha da posição mais abaixo ocupada pelo navio.
     *
     * @return número da linha mais abaixo ocupada pelo navio
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Obtém a coluna da posição mais à esquerda ocupada pelo navio.
     *
     * @return número da coluna mais à esquerda ocupada pelo navio
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Obtém a coluna da posição mais à direita ocupada pelo navio.
     *
     * @return número da coluna mais à direita ocupada pelo navio
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Verifica se o navio ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return {@code true} se o navio ocupar a posição;
     *         {@code false} caso contrário
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Verifica se este navio está demasiado próximo de outro navio.
     * <p>
     * A verificação é efetuada comparando as posições deste navio com
     * todas as posições do outro navio.
     * </p>
     *
     * @param other outro navio a verificar
     * @return {@code true} se os navios estiverem demasiado próximos;
     *         {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Verifica se o navio está demasiado próximo de uma determinada
     * posição.
     *
     * @param pos posição a verificar
     * @return {@code true} se a posição estiver adjacente a uma posição
     *         ocupada pelo navio; {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Efetua um disparo numa posição do navio.
     * <p>
     * Se a posição indicada for ocupada pelo navio, esta é marcada
     * como atingida.
     * </p>
     *
     * @param pos posição onde o disparo será efetuado
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Obtém uma representação textual do navio.
     *
     * @return texto contendo a categoria, orientação e posição inicial
     *         do navio
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }
}
