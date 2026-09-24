    package iscteiul.ista.battleship;

    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;

    import java.util.Scanner;

    /**
     * Classe responsável pela execução das diferentes tarefas do jogo.
     */
    public class Tasks {

        /** Logger utilizado para apresentar informação durante a execução. */
        private static final Logger LOGGER = LogManager.getLogger();

        /** Número de disparos efetuados numa ronda. */
        private static final int NUMBER_SHOTS = 3;

        /** Mensagem apresentada quando o utilizador termina o jogo. */
        private static final String GOODBYE_MESSAGE = "Bons ventos!";

        /** Comando utilizado para criar uma nova frota. */
        private static final String NOVAFROTA = "nova";

        /** Comando utilizado para abandonar o jogo. */
        private static final String DESISTIR = "desisto";

        /** Comando utilizado para efetuar uma rajada de disparos. */
        private static final String RAJADA = "rajada";

        /** Comando utilizado para visualizar as posições válidas para disparo. */
        private static final String VERTIROS = "ver";

        /** Comando utilizado para visualizar o mapa da frota. */
        private static final String BATOTA = "mapa";

        /** Comando utilizado para consultar o estado da frota. */
        private static final String STATUS = "estado";

        /**
         * Executa a tarefa de construção e teste de navios.
         * <p>
         * Para cada navio lido da entrada, são lidas três posições e é indicado
         * se cada uma delas é ocupada pelo navio.
         * </p>
         */
        public static void taskA() {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                Ship s = readShip(in);
                if (s != null)
                    for (int i = 0; i < NUMBER_SHOTS; i++) {
                        Position p = readPosition(in);
                        LOGGER.info("{} {}", p, s.occupies(p));
                    }
            }
        }

        /**
         * Executa a tarefa de construção e consulta de uma frota.
         * <p>
         * Permite criar uma nova frota e consultar o seu estado através
         * dos comandos introduzidos pelo utilizador.
         * </p>
         */
        public static void taskB() {
            Scanner in = new Scanner(System.in);
            IFleet fleet = null;
            String command = in.next();
            while (!command.equals(DESISTIR)) {
                switch (command) {
                    case NOVAFROTA:
                        fleet = buildFleet(in);
                        break;
                    case STATUS:
                        if (fleet != null)
                            fleet.printStatus();
                        break;
                    default:
                        LOGGER.info("Que comando é esse??? Repete lá ...");
                }

                command = in.next();
            }
            LOGGER.info(GOODBYE_MESSAGE);
        }

        /**
         * Executa a tarefa de construção de frotas, incluindo a possibilidade
         * de visualizar o mapa da frota.
         * <p>
         * Para além das operações disponíveis na tarefa anterior, permite
         * utilizar o comando de visualização do mapa da frota.
         * </p>
         */
        public static void taskC() {
            Scanner in = new Scanner(System.in);
            IFleet fleet = null;
            String command = in.next();
            while (!command.equals(DESISTIR)) {
                switch (command) {
                    case NOVAFROTA:
                        fleet = buildFleet(in);
                        break;
                    case STATUS:
                        if (fleet != null)
                            fleet.printStatus();
                        break;
                    case BATOTA:
                        LOGGER.info(fleet);
                        break;
                    default:
                        LOGGER.info("Que comando é esse??? Repete lá ...");
                }

                command = in.next();
            }
            LOGGER.info(GOODBYE_MESSAGE);
        }

        /**
         * Executa a tarefa correspondente à componente de combate do jogo.
         * <p>
         * Permite criar uma frota, iniciar um jogo, consultar o estado da frota,
         * visualizar o mapa, efetuar rondas de três disparos e consultar as
         * posições válidas para disparar.
         * </p>
         */
        public static void taskD() {

            Scanner in = new Scanner(System.in);
            IFleet fleet = null;
            IGame game = null;
            String command = in.next();

            while (!command.equals(DESISTIR)) {
                switch (command) {
                    case NOVAFROTA:
                        fleet = buildFleet(in);
                        game = new Game(fleet);
                        break;
                    case STATUS:
                        if (fleet != null)
                            fleet.printStatus();
                        break;
                    case BATOTA:
                        if (fleet != null)
                            game.printFleet();
                        break;
                    case RAJADA:
                        if (game != null) {
                            firingRound(in, game);

                            LOGGER.info("Hits: {} Inv: {} Rep: {} Restam {} navios.",
                                    game.getHits(), game.getInvalidShots(),
                                    game.getRepeatedShots(), game.getRemainingShips());

                            if (game.getRemainingShips() == 0)
                                LOGGER.info(
                                        "Maldito sejas, Java Sparrow, eu voltarei, glub glub glub...");
                        }
                        break;
                    case VERTIROS:
                        if (game != null)
                            game.printValidShots();
                        break;
                    default:
                        LOGGER.info("Que comando é esse??? Repete ...");
                }

                command = in.next();
            }

            LOGGER.info(GOODBYE_MESSAGE);
        }

        /**
         * Constrói uma frota a partir dos dados fornecidos pelo utilizador.
         * <p>
         * Os navios são lidos sucessivamente até ser atingido o número de
         * navios definido para a frota. Apenas os navios que possam ser
         * adicionados com sucesso são contabilizados.
         * </p>
         *
         * @param in scanner utilizado para ler os dados dos navios
         * @return frota construída a partir dos dados fornecidos
         */
        static Fleet buildFleet(Scanner in) {
            assert in != null;

            Fleet fleet = new Fleet();
            int i = 0;

            while (i <= Fleet.FLEET_SIZE) {
                IShip s = readShip(in);
                if (s != null) {
                    boolean success = fleet.addShip(s);
                    if (success)
                        i++;
                    else
                        LOGGER.info("Falha na criacao de {} {} {}",
                                s.getCategory(), s.getBearing(), s.getPosition());
                } else {
                    LOGGER.info("Navio desconhecido!");
                }
            }

            LOGGER.info("{} navios adicionados com sucesso!", i);
            return fleet;
        }

        /**
         * Lê os dados de um navio, cria o navio correspondente e devolve-o.
         * <p>
         * São lidos o tipo de navio, a posição inicial e a orientação.
         * </p>
         *
         * @param in scanner utilizado para ler os dados do navio
         * @return navio criado a partir dos dados lidos
         */
        static Ship readShip(Scanner in) {
            String shipKind = in.next();
            Position pos = readPosition(in);
            char c = in.next().charAt(0);
            Compass bearing = Compass.charToCompass(c);

            return Ship.buildShip(shipKind, bearing, pos);
        }

        /**
         * Lê uma posição do tabuleiro a partir dos dados fornecidos.
         *
         * @param in scanner utilizado para ler os dados da posição
         * @return posição criada a partir da linha e coluna lidas
         */
        static Position readPosition(Scanner in) {
            int row = in.nextInt();
            int column = in.nextInt();

            return new Position(row, column);
        }

        /**
         * Executa uma ronda de três disparos sobre a frota no contexto
         * de um determinado jogo.
         * <p>
         * Para cada disparo é lida uma posição e efetuado um disparo no jogo.
         * Caso um navio seja atingido, é apresentada uma mensagem através
         * do logger.
         * </p>
         *
         * @param in scanner utilizado para ler as posições dos disparos
         * @param game jogo no qual os disparos são efetuados
         */
        static void firingRound(Scanner in, IGame game) {
            for (int i = 0; i < NUMBER_SHOTS; i++) {
                IPosition pos = readPosition(in);
                IShip sh = game.fire(pos);

                if (sh != null)
                    LOGGER.info(
                            "Mas... mas... {}s nao sao a prova de bala? :-(",
                            sh.getCategory());
            }
        }
    }