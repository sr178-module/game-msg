package com.sr178.game.msgbody.common.model;

import java.io.IOException;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;




public class MsgHead implements ICodeAble {
	public MsgHead(Short fromType, String fromID, Short toType, String toID,
			Short msgType, int msgSequense, String cmdCode,int errorCode) {
		super();
		this.fromType = fromType;
		this.fromID = fromID;
		this.toType = toType;
		this.toID = toID;
		this.msgType = msgType;
		this.msgSequense = msgSequense;
		this.cmdCode = cmdCode;
		this.errorCode = errorCode;
	}

	public MsgHead() {
		super();
	}

	public MsgHead(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	/**
	 * 消息类型
	 */
	public static final short TYPEOFREQUEST = 1;

	public static final short TYPEOFRESPONSE = 2;

	public static final short TYPEOFNOTIFY = 3;

	/**
	 * 消息广播的类�?
	 */
	//来自或去向为�?
	public static final short TO_OR_FROM_TYPE_USER = 1;
    //来自或去向为房间
	public static final short TO_OR_FROM_TYPE_ROOM = 2;
	//来自或去向为系统
	public static final short TO_OR_FROM_TYPE_SYSTEM = 3;
	
	//高优先级
	public static final byte HIGHT = 0;
	//普通优先级  可缓慢发送
	public static final byte COMMON = 1;
	//低优先级
	public static final byte LOWER = 2;
	//消息来源类型
	private short fromType;
    //消息来源ID
	private String fromID=new String("0");
    //消息目的类型
	private short toType;
    //消息目的ID
	private String toID=new String("0");
    //消息类型
	private short msgType;
    //消息序列�?
	private int msgSequense;
    //命令�?
	private String cmdCode;
    //错误�?
	private int errorCode;
    //消息体大�?
	private int sizeOfMsgBody;
	//用户序列�?
	private String userSequense=new String("0");
	//消息优先级
	private byte priority;
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof MsgHead) {
			MsgHead m = (MsgHead) obj;
			if (m.getCmdCode().equals(cmdCode)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return cmdCode.hashCode();
	}
	public void decode(IXInputStream inputStream) throws IOException {
		errorCode = inputStream.readInt();
		fromType = inputStream.readShort();
		fromID = inputStream.readUTF();
		toType = inputStream.readShort();
		toID = inputStream.readUTF();
		msgType = inputStream.readShort();
		msgSequense = inputStream.readInt();
		cmdCode = inputStream.readUTF();
		userSequense = inputStream.readUTF();
		priority = inputStream.readByte();
		sizeOfMsgBody = inputStream.readInt();
		
//		System.out.println("decode errorCode" + errorCode);
//		System.out.println("decode fromType" + fromType);
//		System.out.println("decode fromID" + fromID);
//		System.out.println("decode toType" + toType);
//		System.out.println("decode toID" + toID);
//		System.out.println("decode msgType" + msgType);
//		System.out.println("decode cmdCode" + cmdCode);
//		System.out.println("decode userSequense" + userSequense);
//		System.out.println("decode sizeOfMsgBody" + sizeOfMsgBody);
	}

	public void encode(IXOutStream outputStream) throws IOException {
		outputStream.writeInt(errorCode);
		outputStream.writeShort(fromType);
		outputStream.writeUTF(fromID);
		outputStream.writeShort(toType);
		outputStream.writeUTF(toID);
		outputStream.writeShort(msgType);
		outputStream.writeInt(msgSequense);
		outputStream.writeUTF(cmdCode);
		outputStream.writeUTF(userSequense);
		outputStream.writeByte(priority);
		outputStream.writeInt(sizeOfMsgBody);
//		System.out.println("encode errorCode" + errorCode);
//		System.out.println("encode fromType" + fromType);
//		System.out.println("encode fromID" + fromID);
//		System.out.println("encode toType" + toType);
//		System.out.println("encode toID" + toID);
//		System.out.println("encode msgType" + msgType);
//		System.out.println("encode modelId" + modelId);
//		System.out.println("encode cmdCode" + cmdCode);
//		System.out.println("encode sysNumber" + sysNumber);
//		System.out.println("encode sequense" + sequense);
//		System.out.println("encode userSequense" + userSequense);
//		System.out.println("encode sizeOfMsgBody" + sizeOfMsgBody);
	}

	

	public String toString(){
		return "cmdCode = "+cmdCode+""+",msgType="+msgType+",errorCode="+errorCode+",fromId="+fromID;
	}

	public int getMsgSequense() {
		return msgSequense;
	}

	public void setMsgSequense(int msgSequense) {
		this.msgSequense = msgSequense;
	}

	public void setCmdCode(String cmdCode) {
		this.cmdCode = cmdCode;
	}
	public MsgHead(short fromType, String fromID, short toType, String toID,
			short msgType, int msgSequense, String cmdCode,int errorCode, String userSequense) {
		super();
		this.fromType = fromType;
		this.fromID = fromID;
		this.toType = toType;
		this.toID = toID;
		this.msgType = msgType;
		this.msgSequense = msgSequense;
		this.cmdCode = cmdCode;
		this.errorCode = errorCode;
		this.userSequense = userSequense;
	}

	public short getFromType() {
		return fromType;
	}

	public void setFromType(short fromType) {
		this.fromType = fromType;
	}

	public String getFromID() {
		return fromID;
	}

	public void setFromID(String fromID) {
		this.fromID = fromID;
	}

	public short getToType() {
		return toType;
	}

	public void setToType(short toType) {
		this.toType = toType;
	}

	public String getToID() {
		return toID;
	}
	public void setToID(String toID) {
		this.toID = toID;
	}
	public short getMsgType() {
		return msgType;
	}
	public void setMsgType(short msgType) {
		this.msgType = msgType;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public int getSizeOfMsgBody() {
		return sizeOfMsgBody;
	}
	public void setSizeOfMsgBody(int sizeOfMsgBody) {
		this.sizeOfMsgBody = sizeOfMsgBody;
	}
	public String getUserSequense() {
		return userSequense;
	}
	public void setUserSequense(String userSequense) {
		this.userSequense = userSequense;
	}
	public String getCmdCode() {
		return cmdCode;
	}
	public byte getPriority() {
		return priority;
	}
	public void setPriority(byte priority) {
		this.priority = priority;
	}
	
	public MsgHead clone(){
		MsgHead cloneMsgHead = new MsgHead();
		cloneMsgHead.setCmdCode(cmdCode);
		cloneMsgHead.setErrorCode(errorCode);
		cloneMsgHead.setFromID(fromID);
		cloneMsgHead.setFromType(fromType);
		cloneMsgHead.setMsgSequense(msgSequense);
		cloneMsgHead.setMsgType(msgType);
		cloneMsgHead.setPriority(priority);
		cloneMsgHead.setSizeOfMsgBody(sizeOfMsgBody);
		cloneMsgHead.setToID(toID);
		cloneMsgHead.setToType(toType);
		cloneMsgHead.setUserSequense(userSequense);
		return cloneMsgHead;
	}
}
