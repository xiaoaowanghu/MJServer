package personal.flying.connection;

public class DefaultMsgHeader implements IMessageHeader{	
	private int msgLength;
	private short index;
	private byte msgType;

	@Override
	public int getMsgLength() {
		return msgLength;
	}

	@Override
	public short getMsgIndex() {
		return index;
	}

	@Override
	public byte getMsgType() {
		return msgType;
	}	
}
