package rcon.framework;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RConSeqAck {
	private int seq;
	private AtomicBoolean done = new AtomicBoolean(false);
	private List<String> words = Collections.EMPTY_LIST;
	
	public RConSeqAck(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return this.seq;
	}
	
	public void done(List<String> words) {
		done.set(true);
		this.words = words;
		synchronized(this) {
			this.notifyAll();
		}
	}
	
	public List<String> waitForResp() {
		synchronized (this) {
			// It's possible that the return happens before we get done 
			// setting up the monitor.
			if (done.get())
				return this.words;
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		return this.words;
	}
}
