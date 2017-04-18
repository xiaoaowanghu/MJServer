package personal.flying.connection.udp;

import io.netty.buffer.ByteBuf;
import personal.flying.connection.IMessage;
import personal.flying.connection.IMessageHeader;

public class UDPAckMsg implements IMessage{
	private short refMsgIndex;
	
	@Override
	public IMessageHeader getHeader() {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public ByteBuf toBuf() {
		// TODO Auto-generated method stub
		return null;
	}
}
