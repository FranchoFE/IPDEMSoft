package org.javahispano.javacup.tacticas.jvc2013.pepineitor;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import org.javahispano.javacup.model.*;
import org.javahispano.javacup.model.command.*;
import org.javahispano.javacup.model.engine.GameSituations;
import org.javahispano.javacup.model.util.*;
import org.javahispano.javacup.render.EstiloUniforme;

public class pepineitor implements Tactic {
    
    static final double DistanceToGoal = 20;
    static final double MinDistanceToPass = 10;
    static final double MaxDistanceToPassDown = 20;
    static final double DistanceAutoPass = 20;
    static final double DistanceToEndLine = 40;
    int playerToPass = -1;
    boolean attack = false;

    Position alineacion1[]=new Position[]{
        new Position(0.2595419847328244,-50.41044776119403),
        new Position(-19.46564885496183,-31.6044776119403),
        new Position(0.2595419847328244,-31.082089552238806),
        new Position(19.984732824427482,-31.6044776119403),
        new Position(9.034965034965035,-22.330316742081447),
        new Position(-8.797202797202797,-21.61764705882353),
        new Position(-11.412587412587413,-1.900452488687783),
        new Position(26.153846153846157,-15.91628959276018),
        new Position(12.601398601398602,-4.038461538461538),
        new Position(0.23776223776223776,-16.391402714932127),
        new Position(-25.44055944055944,-14.490950226244346)
    };
    
        Position alineacion2[]=new Position[]{
        new Position(0.2595419847328244,-50.41044776119403),
        new Position(-15.692307692307693,-18.766968325791854),
        new Position(-0.7132867132867133,-20.667420814479637),
        new Position(19.734265734265733,-16.153846153846153),
        new Position(11.65034965034965,-7.126696832579185),
        new Position(-9.510489510489512,-4.98868778280543),
        new Position(-13.076923076923078,18.29185520361991),
        new Position(25.916083916083913,9.97737556561086),
        new Position(12.839160839160838,19.717194570135746),
        new Position(-0.7132867132867133,5.9389140271493215),
        new Position(-26.391608391608393,9.027149321266968)
    };
        
     Position alineacion3[]=new Position[]{
        new Position(0.2595419847328244,-50.41044776119403),
        new Position(-1.4265734265734267,-12.115384615384617),
        new Position(16.405594405594407,-6.651583710407239),
        new Position(-19.97202797202797,-5.463800904977376),
        new Position(12.125874125874127,4.513574660633484),
        new Position(-12.363636363636363,3.3257918552036196),
        new Position(-10.6993006993007,34.20814479638009),
        new Position(25.202797202797203,25.18099547511312),
        new Position(10.223776223776223,34.44570135746606),
        new Position(-1.6643356643356644,21.142533936651585),
        new Position(-29.244755244755243,23.28054298642534)
    };

    private boolean canKick(int i, GameSituations sp) {
        boolean canKick = false;
        for (int j : sp.canKick())
        {
            if (i == j)
            {
                canKick = true;
                break;
            }
        }
        
        return canKick;
    }
    
    private int getPassPlayer(GameSituations sp, int index, double min, double maxDown) 
    { 
        int playerToPass = -1;
        
        // Obtengo los que están más cerca del balón, sin contar el que está más cerca, que 
        // presumiblemente será el que chute
        LinkedList<Integer> players = orderPlayerFromDistance (sp, sp.myPlayers()[index]);
        players.remove(0);
        
        // Si todavía estoy lejos de la porteria
        if (sp.myPlayers()[index].distance(new Position (0, 50)) > DistanceToGoal) 
        {   
            // Busco entre todos los jugadores 
            for (int i : players)
            {
                // Si está más adelantado que yo
                if (sp.myPlayers()[i].getY() > sp.myPlayers()[index].getY())
                {
                    // Si no hay distancia mínima
                    if (min == -1)
                    {
                        // Este es el más cercano
                        playerToPass = i;
                        break;
                    }
                    else // Hay una distancia mínima
                    {
                        // Si está a más distancia mía de la mínima
                        if (sp.myPlayers()[i].distance(sp.myPlayers()[index]) > min)
                        {
                            // Es el que está más cercano y cumple la condición
                            playerToPass = i;
                            break;
                        }
                    }
                }
            }
            
            // No se ha encontrado ninguno más adelantado, se mira alguno más atrasado
            if (playerToPass == -1)
            {
                for (int i : players)
                {
                    // Si está más atrasado que yo
                    if (sp.myPlayers()[i].getY() < sp.myPlayers()[index].getY())
                    {
                        // Si no hay distancia máxima
                        if (maxDown == -1)
                        {
                            // Este es el más cercano
                            playerToPass = i;
                            break;
                        }
                        else // Hay una distancia máxima
                        {
                            // Si está a más distancia mía de la mínima
                            if (sp.myPlayers()[i].distance(sp.myPlayers()[index]) < maxDown)
                            {
                                // Es el que está más cercano y cumple la condición
                                playerToPass = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return playerToPass;
    }

    private LinkedList<Integer> orderPlayerFromDistance(GameSituations sp, Position refPosition) {
        LinkedList<Integer> players = new LinkedList<>();
        
        int index = 0;
        for (Position position : sp.myPlayers())
        {
            double distance = position.distance(refPosition);
            
            int indexToInsert = 0;
            for (Integer index2 : players)
            {
                if (sp.myPlayers()[index2].distance(refPosition) > distance)
                {
                    break;
                }
                indexToInsert++;
            }
            
            if (players.isEmpty())
            {
                players.add(index);
            }
            else
            {
                players.add(indexToInsert, index);
            }
            
            index++;
        }
        
        return players;
    }

    class TacticDetailImpl implements TacticDetail {

        @Override
        public String getTacticName() {
            return "Pepineitor";
        }

        @Override
        public String getCountry() {
            return "España";
        }

        @Override
        public String getCoach() {
            return "Félez";
        }

        @Override
        public Color getShirtColor() {
            return new Color(0, 0, 204);
        }

        @Override
        public Color getShortsColor() {
            return new Color(255, 255, 255);
        }

        @Override
        public Color getShirtLineColor() {
            return new Color(153, 14, 15);
        }

        @Override
        public Color getSocksColor() {
            return new Color(0, 0, 0);
        }

        @Override
        public Color getGoalKeeper() {
            return new Color(7, 70, 230        );
        }

        @Override
        public EstiloUniforme getStyle() {
            return EstiloUniforme.SIN_ESTILO;
        }

        @Override
        public Color getShirtColor2() {
            return new Color(81, 213, 72);
        }

        @Override
        public Color getShortsColor2() {
            return new Color(117, 137, 93);
        }

        @Override
        public Color getShirtLineColor2() {
            return new Color(27, 204, 117);
        }

        @Override
        public Color getSocksColor2() {
            return new Color(58, 57, 136);
        }

        @Override
        public Color getGoalKeeper2() {
            return new Color(115, 80, 13        );
        }

        @Override
        public EstiloUniforme getStyle2() {
            return EstiloUniforme.LINEAS_VERTICALES;
        }

        class JugadorImpl implements PlayerDetail {

            String nombre;
            int numero;
            Color piel, pelo;
            double velocidad, remate, presicion;
            boolean portero;
            Position Position;

            public JugadorImpl(String nombre, int numero, Color piel, Color pelo,
                    double velocidad, double remate, double presicion, boolean portero) {
                this.nombre=nombre;
                this.numero=numero;
                this.piel=piel;
                this.pelo=pelo;
                this.velocidad=velocidad;
                this.remate=remate;
                this.presicion=presicion;
                this.portero=portero;
            }

            @Override
            public String getPlayerName() {
                return nombre;
            }

            @Override
            public Color getSkinColor() {
                return piel;
            }

            @Override
            public Color getHairColor() {
                return pelo;
            }

            @Override
            public int getNumber() {
                return numero;
            }

            @Override
            public boolean isGoalKeeper() {
                return portero;
            }

            @Override
            public double getSpeed() {
                return velocidad;
            }

            @Override
            public double getPower() {
                return remate;
            }

            @Override
            public double getPrecision() {
                return presicion;
            }

        }

        @Override
        public PlayerDetail[] getPlayers() {
            return new PlayerDetail[]{
                new JugadorImpl("Ortega", 1, new Color(255,200,150), new Color(50,0,0),1.0d,1.0d,1.0d, true),
                new JugadorImpl("Cuberos", 2, new Color(255,200,150), new Color(50,0,0),0.55d,0.72d,0.61d, false),
                new JugadorImpl("Juanlu", 3, new Color(255,200,150), new Color(50,0,0),0.76d,0.74d,0.76d, false),
                new JugadorImpl("Bitar", 4, new Color(255,200,150), new Color(50,0,0),0.71d,0.88d,0.77d, false),
                new JugadorImpl("Crespo", 5, new Color(255,200,150), new Color(50,0,0),0.76d,0.75d,0.61d, false),
                new JugadorImpl("Quino", 6, new Color(255,200,150), new Color(50,0,0),0.96d,0.94d,0.91d, false),
                new JugadorImpl("Francho", 7, new Color(255,200,150), new Color(50,0,0),0.66d,0.81d,0.82d, false),
                new JugadorImpl("Pepe", 8, new Color(255,200,150), new Color(50,0,0),0.87d,0.73d,0.85d, false),
                new JugadorImpl("Antonio Luis", 9, new Color(255,200,150), new Color(50,0,0),0.5d,0.5d,0.5d, false),
                new JugadorImpl("Fernando", 10, new Color(255,200,150), new Color(50,0,0),0.59d,0.82d,1.0d, false),
                new JugadorImpl("Colom", 11, new Color(255,200,150), new Color(50,0,0),0.88d,0.68d,0.8d, false)
            };
        }
    }

    TacticDetail detalle=new TacticDetailImpl();
    @Override
    public TacticDetail getDetail() {
        return detalle;
    }

    @Override
    public Position[] getStartPositions(GameSituations sp) {
    return alineacion1;
    }

    @Override
    public Position[] getNoStartPositions(GameSituations sp) {
    return alineacion1;
    }

    @Override
    public List<Command> execute(GameSituations sp) {
        
        System.out.println ("Iteración: " + sp.iteration() + " " + sp.myGoals() + "-" + sp.rivalGoals());
        
        if ((sp.canKick().length != 0) && (sp.rivalCanKick().length == 0))
        {
            attack = true;
        }
        else if ((sp.canKick().length == 0) && (sp.rivalCanKick().length != 0))
        {
            attack = false;
            playerToPass = -1;
        }
        
        List<Command> hitCommands = new LinkedList<>();
        List<Command> moveCommands = new LinkedList<>();
        
        Position ballPosition = sp.ballPosition();
        Position goalKeeperPosition = new Position (ballPosition.getX()/2, -50);
        
        // Primero los movimientos del portero
        if (canKick (0, sp))
        {
            int player = getPassPlayer (sp, 0, 50, 0);
            Position hitPosition;
            if (player != -1)
            {
                hitPosition = sp.myPlayers()[player];
                playerToPass = player;
            }
            else
            {
                hitPosition = new Position (30, 0);
                playerToPass = -1;
            }
            double power = hitPosition.distance(sp.myPlayers()[0]) / 10;
            hitCommands.add(new CommandHitBall (0, hitPosition, power, true));
            System.out.println ("Golpeo 0");
        }
        else if (ballPosition.distance(goalKeeperPosition) < 15)
        {
            goalKeeperPosition.setPosition (ballPosition.getX(), -50);
            moveCommands.add(new CommandMoveTo(0, ballPosition));
        }
        else
        {
            moveCommands.add(new CommandMoveTo(0, goalKeeperPosition));
        }
        
        int index = 0;
        LinkedList<Integer> players = orderPlayerFromDistance (sp, ballPosition);
        for (int i : players)
        {
            boolean canKick = canKick (i, sp);
            
            if (canKick)
            {
                double power = 1;
                Position hitPosition;
                if (sp.myPlayers()[i].distance(new Position (0, 50))< DistanceToGoal)
                {
                    hitPosition = new Position (0, 50);
                    playerToPass = -1;
                }
                else if (sp.myPlayers()[i].getY() > DistanceToEndLine)
                {
                    hitPosition = new Position (0, 45);
                    playerToPass = -1;
                }
                else
                {
                    int player = getPassPlayer (sp, i, MinDistanceToPass, MaxDistanceToPassDown);
                    if (player != -1)
                    {
                        hitPosition = sp.myPlayers()[player];
                        playerToPass = player;
                    }
                    else
                    {
                        // Por defecto tiro un poquito palante
                        hitPosition = new Position (sp.myPlayers()[i].getX(), sp.myPlayers()[i].getY() + DistanceAutoPass);
                        playerToPass = i;
                    }
                    double distance = hitPosition.distance(sp.myPlayers()[i]) / 15;
                    power = distance;
                    boolean highKick = false;
                    if (distance > 20)
                    {
                        highKick = true;
                    }
                }
                
                hitCommands.add(new CommandHitBall (i, hitPosition, power, false));
                System.out.println ("Golpeo " + i);
            }
            else
            {
                Position position = sp.myPlayers()[i];
              
                if (((i != 0) && (index < 2)) || (playerToPass == i))
                {
                    moveCommands.add(new CommandMoveTo(i, ballPosition));
                }
                else if (position.distance(ballPosition) > 15)
                {
                    if (attack)
                    {
                        if (ballPosition.getY() < -30)
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion1[i]));
                        }
                        else if (ballPosition.getY() < 20)
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion2[i]));
                        }
                        else
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion3[i]));
                        }
                    }
                    else
                    {
                        if (ballPosition.getY() < -15)
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion1[i]));
                        }
                        else if (ballPosition.getY() < 10)
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion2[i]));
                        }
                        else
                        {
                            moveCommands.add(new CommandMoveTo(i, alineacion3[i]));
                        }
                    }
                }
            }
            
            index ++;
        }
        
        // Que no caigan los jugadores en fuera de juego
        boolean[] offSidePlayers = sp.getOffSidePlayers();
        for (int i = 0; i < 11; i ++)
        {
            if (offSidePlayers[i])
            {
                moveCommands.add(new CommandMoveTo(i, sp.myPlayers()[i].movePosition(0, -5)));
            }
        }
        
        System.out.println();
        hitCommands.addAll(moveCommands);
        return hitCommands;
    }
}