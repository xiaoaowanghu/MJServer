/**
 * 
 */
package personal.flying.mj.server;

import org.apache.log4j.Logger;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Flying
 *
 */
public class MJServer {
	private static Logger logger = Logger.getLogger(MJServer.class);  
	
	public final static int Server_Type_TCP = 0;
	public final static int Server_Type_UDP = 1;
	public final static int Server_UDP_Port = 4343;
	public final static int Server_TCP_Port = 4344;
		

	public static void main(String[] args) {		
		logger.info("MJServer is started");
		try {
			UDPListen().channel().closeFuture().await();
		} catch (InterruptedException e) {			
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	public static ChannelFuture TCPListen() throws InterruptedException{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		ServerBootstrap serverBootStrap = new ServerBootstrap();
		serverBootStrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						System.out.println("server initChannel..");
						ch.pipeline().addLast(new TimeHandlerForTest());
					}
				});

		ChannelFuture f = serverBootStrap.bind(Server_TCP_Port).sync();
		return f;
	}

	public static ChannelFuture UDPListen() throws InterruptedException {
		Bootstrap udpBoot = new Bootstrap();
		EventLoopGroup group = new NioEventLoopGroup();		
		// 由于我们用的是UDP协议，所以要用NioDatagramChannel来创建		
		udpBoot.group(group).channel(NioDatagramChannel.class)
		.option(ChannelOption.SO_BROADCAST, false)		
		.handler(new TimeHandlerForTest());
		ChannelFuture cf = udpBoot.bind(Server_UDP_Port).sync();
		return cf;
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
