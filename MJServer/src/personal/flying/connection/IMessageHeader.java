package personal.flying.connection;

public interface IMessageHeader {
	int getMsgLength();

	short getMsgIndex();

	byte getMsgType();
}
