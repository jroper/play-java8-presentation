package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import model.Flour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import actors.MillerActorProtocol.*;

/**
 * A miller actor
 */
public class MillerActor extends UntypedActor {

    // The flour that miller has in stock
    private final LinkedList<Flour> bagsOfFlour = new LinkedList<Flour>();

    private final ActorRef mill;

    public MillerActor(ActorRef mill) {
        this.mill = mill;
    }

    public void onReceive(Object msg) throws Exception {

        // A flour order
        if (msg instanceof OrderFlour) {
            if (bagsOfFlour.isEmpty()) {
                mill.forward(msg, context());
            } else {
                sender().tell(bagsOfFlour.pollFirst(), self());
            }
        }

    }
}
