package com.sr178.game.msgbody.common.io.iface;

import java.io.IOException;
import java.io.OutputStream;


public interface IXOutStream{
	   public  void writeInt(int i) throws IOException;
	   public  void writeDouble(double d) throws IOException;
	   public  void writeLong(long l) throws IOException;
	   public  void writeByte(byte b) throws IOException;
	   public  void writeShort(short s) throws IOException;
	   public  void writeFloat(float f) throws IOException;
	   public  void writeChar(char c) throws IOException;
	   public  void writeBoolean(boolean b) throws IOException;
	   public  void writeUTF(String s) throws IOException;
	   public  void writeBytes(byte[] b) throws IOException;
	   public void setOutputStream(OutputStream outputstream);
	   public void close() throws IOException;
}
