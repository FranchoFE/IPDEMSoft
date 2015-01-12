package org.javahispano.javacup.tacticas.jvc2013.quietor;

import org.javahispano.javacup.tacticas.jvc2013.pepineitor.*;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.javahispano.javacup.model.*;
import org.javahispano.javacup.model.command.*;
import org.javahispano.javacup.model.engine.GameSituations;
import org.javahispano.javacup.model.util.*;
import org.javahispano.javacup.render.EstiloUniforme;

public class quietor implements Tactic {

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
        new Position(-19.46564885496183,-21.6044776119403),
        new Position(0.2595419847328244,-21.082089552238806),
        new Position(19.984732824427482,-21.6044776119403),
        new Position(9.034965034965035,0.330316742081447),
        new Position(-8.797202797202797,0.61764705882353),
        new Position(-11.412587412587413,10.900452488687783),
        new Position(26.153846153846157,5.91628959276018),
        new Position(12.601398601398602,10.038461538461538),
        new Position(0.23776223776223776,25.391402714932127),
        new Position(-25.44055944055944,25.490950226244346)
    };

    
    class TacticDetailImpl implements TacticDetail {

        public String getTacticName() {
            return "Quietor";
        }

        public String getCountry() {
            return "España";
        }

        public String getCoach() {
            return "Espinete";
        }

        public Color getShirtColor() {
            return new Color(0, 0, 204);
        }

        public Color getShortsColor() {
            return new Color(0, 0, 0);
        }

        public Color getShirtLineColor() {
            return new Color(0, 14, 150);
        }

        public Color getSocksColor() {
            return new Color(0, 0, 0);
        }

        public Color getGoalKeeper() {
            return new Color(7, 70, 230        );
        }

        public EstiloUniforme getStyle() {
            return EstiloUniforme.SIN_ESTILO;
        }

        public Color getShirtColor2() {
            return new Color(81, 213, 72);
        }

        public Color getShortsColor2() {
            return new Color(117, 137, 93);
        }

        public Color getShirtLineColor2() {
            return new Color(27, 204, 117);
        }

        public Color getSocksColor2() {
            return new Color(58, 57, 136);
        }

        public Color getGoalKeeper2() {
            return new Color(115, 80, 13        );
        }

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

            public String getPlayerName() {
                return nombre;
            }

            public Color getSkinColor() {
                return piel;
            }

            public Color getHairColor() {
                return pelo;
            }

            public int getNumber() {
                return numero;
            }

            public boolean isGoalKeeper() {
                return portero;
            }

            public double getSpeed() {
                return velocidad;
            }

            public double getPower() {
                return remate;
            }

            public double getPrecision() {
                return presicion;
            }

        }

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
    public TacticDetail getDetail() {
        return detalle;
    }

    @Override
    public Position[] getStartPositions(GameSituations sp) {
    return alineacion1;
    }

    public Position[] getNoStartPositions(GameSituations sp) {
    return alineacion1;
    }

    @Override
    public List<Command> execute(GameSituations sp) {
        
        List<Command> hitCommands = new LinkedList<>();
        List<Command> moveCommands = new LinkedList<>();
        
        hitCommands.add(new CommandHitBall (10, new Position (0, 50), 1, true));
        moveCommands.add(new CommandMoveTo(10, sp.ballPosition()));
        
        
        hitCommands.addAll(moveCommands);
        return hitCommands;
    }
}