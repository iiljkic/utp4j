package ch.uzh.csg.utp4j.channels.impl.accept;

import java.io.IOException;

import ch.uzh.csg.utp4j.channels.futures.UtpAcceptFuture;
import ch.uzh.csg.utp4j.channels.impl.UtpSocketChannelImpl;

public class UtpAcceptFutureImpl extends UtpAcceptFuture {
	
	public UtpAcceptFutureImpl() throws InterruptedException {
		semaphore.acquire();
		System.out.println("accept future blocked");
	}

	public void synRecieved(UtpSocketChannelImpl utpChannel) {
		this.channel = utpChannel;
		this.isDone = true;
		semaphore.release();
		System.out.println("accept future released");

	}

	public void setIOException(IOException e) {
		this.exception = e;	
	}


}