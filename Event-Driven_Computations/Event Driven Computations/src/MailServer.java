import java.util.LinkedList;
import java.util.TreeSet;
/**
 * 
 * @author rileyp
 *
 */
public class MailServer extends LinkedList<Message>{
	private TreeSet<Actor> registeredActors;
	
	public MailServer() {
		registeredActors = new TreeSet<Actor>();
	}
	
	public void signUp(Actor actor) {
		if(!registeredActors.contains(actor))
			registeredActors.add(actor);
	}

	public void dispatch(Message msg) {
		if(msg.getRecipient() != null)
			msg.getRecipient().receive(msg);
		else {
			for(Actor a : registeredActors) 
				if(!a.getName().equals(msg.getRecipient().getName()))
					a.receive(msg);			
		}
	}
}