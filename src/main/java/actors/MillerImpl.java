package actors;

import akka.actor.ActorRef;
import model.Flour;
import play.libs.F.Promise;
import promise.Miller;
import scala.concurrent.Future;

import static akka.pattern.Patterns.ask;
import static actors.MillerActorProtocol.*;

public class MillerImpl implements Miller {

    private final ActorRef millerActor;

    public MillerImpl(ActorRef millerActor) {
        this.millerActor = millerActor;
    }

    public Promise<Flour> orderFlour() {
        // Ask for flour
        Future<Object> scalaFuture = ask(millerActor, new OrderFlour(), 2000);

        // Convert to promise
        Promise<Object> promise = Promise.wrap(scalaFuture);

        // Map to return type
        return promise.map(msg -> (Flour) msg);
    }
}
