package com.sr178.game.msgbody.common.io.java;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.sr178.game.msgbody.common.io.iface.IXOutStream;

public class JavaOutput implements IXOutStream {
    private DataOutputStream dataOutputStream;
	public void close() throws IOException {
		dataOutputStream.close();
	}

	public void setOutputStream(OutputStream outputstream) {
		dataOutputStream = new DataOutputStream(outputstream);
	}

	public void writeBoolean(boolean b) throws IOException {
		dataOutputStream.writeBoolean(b);
	}

	public void writeByte(byte b) throws IOException {
		dataOutputStream.write(b);
	}

	public void writeBytes(byte[] b) throws IOException {
		dataOutputStream.write(b);
	}

	public void writeChar(char c) throws IOException {
		dataOutputStream.writeChar(c);
	}

	public void writeDouble(double d) throws IOException {
		dataOutputStream.writeDouble(d);
	}

	public void writeFloat(float f) throws IOException {
		dataOutputStream.writeFloat(f);
	}

	public void writeInt(int i) throws IOException {
		dataOutputStream.writeInt(i);
	}

	public void writeLong(long l) throws IOException {
		dataOutputStream.writeLong(l);
	}

	public void writeShort(short s) throws IOException {
		dataOutputStream.writeShort(s);
	}

	public void writeUTF(String s) throws IOException {
		if(s!=null){
			byte[] bytes = s.getBytes();
			short lenght = (short)bytes.length;
			dataOutputStream.writeShort(lenght);
			dataOutputStream.write(bytes);
//			StringBuffer result = new StringBuffer();
//			for(int i=0;i<bytes.length;i++){
//				result.append(bytes[i]+",");
//			}
//			System.out.println("WRITE----string="+s+",lenght="+lenght+",byte = "+result.toString());
		}else{
			dataOutputStream.writeShort(0);
		}
	}
}
