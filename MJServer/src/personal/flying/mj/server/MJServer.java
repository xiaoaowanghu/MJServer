/**
 * 
 */
package personal.flying.mj.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Flying
 *
 */
public class MJServer {

	public final static int Server_Type_TCP = 0;
	public final static int Server_Type_UDP = 1;

	public static void main(String[] args) {
		try {
			EventLoopGroup bossGroup = new NioEventLoopGroup();
			EventLoopGroup workGroup = new NioEventLoopGroup();

			ServerBootstrap server = new ServerBootstrap();
			server.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							System.out.println("server initChannel..");
							ch.pipeline().addLast(new TimeHandlerForTest());
						}
					});
			
			ChannelFuture f = server.bind(4000).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MJServer() {
		this(Server_Type_TCP);
	}

	public MJServer(int _server_Type) {
	}

	public void start() {
	}

	public void setServerType(int _server_Type) {
	}

}
