/**
 * 
 */
package personal.flying.mj;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Flying
 *
 */
public class MJServer {
	
	public final static int Server_Type_TCP = 0;
	public final static int Server_Type_UDP = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		ServerBootstrap server = new ServerBootstrap();
		server.group(bossGroup, workGroup)
		.channel(NioServerSocketChannel.class);		
	}
	
	public MJServer(){
		this(Server_Type_TCP);
	}
	
	public MJServer(int _server_Type)
	{   }
		
	public void start(){}
	
	public void setServerType(int _server_Type)
	{}


}
