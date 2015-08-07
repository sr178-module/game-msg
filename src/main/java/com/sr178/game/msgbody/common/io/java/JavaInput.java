package com.sr178.game.msgbody.common.io.java;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;

public class JavaInput implements IXInputStream {
private DataInputStream dataInputStream;
	public void close() throws IOException {
		dataInputStream.close();
	}

	public boolean readBoolean() throws IOException {
		return dataInputStream.readBoolean();
	}

	public byte readByte() throws IOException {
		return dataInputStream.readByte();
	}

	public char readChar() throws IOException {
		return dataInputStream.readChar();
	}

	public double readDouble() throws IOException {
		return dataInputStream.readDouble();
	}

	public float readFloat() throws IOException {
		return dataInputStream.readFloat();
	}

	public void readFully(byte[] b, int position, int size) throws IOException {
		dataInputStream.readFully(b, position, size);
		
	}
	public int read(byte[] b, int off, int len) throws IOException{
		return dataInputStream.read(b, off, len);
	}
	public int readInt() throws IOException {
		return dataInputStream.readInt();
	}

	public long readLong() throws IOException {
		return dataInputStream.readLong();
	}

	public short readShort() throws IOException {
		return dataInputStream.readShort();
	}

	public String readUTF() throws IOException {
		 int utflen = dataInputStream.readUnsignedShort();
		 if(utflen>0){
			 byte[] bytes = new byte[utflen];
			 dataInputStream.read(bytes, 0, utflen);
//			 StringBuffer result = new StringBuffer();
//			 for(int i=0;i<bytes.length;i++){
//					result.append(bytes[i]+",");
//			 }
			 String resultT = new String(bytes,"utf-8");
//			 System.out.println("READ----string="+resultT+",lenght="+utflen+",byte = "+result.toString());
			 return resultT;
		 }else{
			 return null;
		 }
		 
	}

	public void setInputStream(InputStream inputStream) {
		dataInputStream = new DataInputStream(inputStream);
	}

	public int available() throws IOException {
		return dataInputStream.available();
	} 
}
