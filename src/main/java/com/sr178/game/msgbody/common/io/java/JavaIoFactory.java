package com.sr178.game.msgbody.common.io.java;


import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;
import com.sr178.game.msgbody.common.io.iface.IoFactory;

public class JavaIoFactory implements IoFactory {
    
	public IXInputStream getIXInputStream() {
		return new JavaInput();
	}

	public IXOutStream getIXOutStream() {
		return new JavaOutput();
	}
}
