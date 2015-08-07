package com.sr178.game.msgbody.server;

import java.io.IOException;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;
import com.sr178.game.msgbody.common.model.ICodeAble;

public class NoBody implements ICodeAble {

	@Override
	public void encode(IXOutStream outputStream) throws IOException {

	}

	@Override
	public void decode(IXInputStream inputStream) throws IOException {

	}

}
