package com.sr178.game.msgbody.common.model;

import java.io.IOException;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;





public interface ICodeAble {
   public void encode(IXOutStream outputStream) throws IOException;
   public void decode(IXInputStream inputStream) throws IOException;
}
