package personal.flying.connection;

public interface INotifier {
	void fireMessageSync(IMessage msg);
	
	void fireMessage(IMessage msg);
}
