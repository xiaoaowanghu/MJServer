package personal.flying.connection;

import io.netty.buffer.ByteBuf;

public interface IMessageBody {
	ByteBuf toBuf();
}
