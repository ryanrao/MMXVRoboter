package org.usfirst.frc.team20.robot.input;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardControllerInput implements Runnable, OperatorInput {

	private byte source;
	private byte event;
	private boolean changed;
	private Socket sock;
	private InputStream controlBoard;

	public BoardControllerInput(String hostname, int port)
		throws UnknownHostException, IOException {
		sock = new Socket(hostname, port);
		controlBoard = sock.getInputStream();
	}

	public boolean isChanged() {
		return changed;
	}

	@Override public int getEvent() {
		changed = false;
		return source << 8 | event;
	}

	// TODO synchronize read/write
	@Override public void run() {
		for (;;) {
			byte[] eventData = new byte[2];
			try {
				if (controlBoard.read(eventData) == 2) {
					changed = true;
					source = eventData[0];
					event = eventData[1];
				}
			} catch (IOException e) {
				Logger.getGlobal().log(Level.SEVERE,
					"Error on read from board.");
			}
		}
	}

	@Override public void finalize() throws Throwable {
		sock.close();
		super.finalize();
	}
}
