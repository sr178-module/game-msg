package com.sr178.game.msgbody.common.io.iface;

import java.io.IOException;
import java.io.InputStream;


public interface IXInputStream {
   public  int readInt() throws IOException;
   public  double readDouble() throws IOException;
   public  long readLong() throws IOException;
   public  byte readByte() throws IOException;
   public  short readShort() throws IOException;
   public  float readFloat() throws IOException;
   public  char readChar() throws IOException;
   public  boolean readBoolean() throws IOException;
   public  String readUTF() throws IOException;
   public  void readFully(byte[] b,int position,int size) throws IOException;

   public void setInputStream(InputStream inputStream);
   
   public void close() throws IOException;
   
   public int available() throws IOException ;
   

}
