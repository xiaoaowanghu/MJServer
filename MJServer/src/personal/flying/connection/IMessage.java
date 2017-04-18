package personal.flying.connection;

import io.netty.buffer.ByteBuf;

public interface IMessage {
	IMessageHeader getHeader();

	ByteBuf toBuf();
}
