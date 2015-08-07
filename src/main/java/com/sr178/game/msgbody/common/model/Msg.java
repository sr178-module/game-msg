package com.sr178.game.msgbody.common.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.sr178.game.msgbody.common.codec.DataCodecFactory;
import com.sr178.game.msgbody.common.io.XIOFactoryManager;
import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;


public class Msg implements ICodeAble {
    private MsgHead msgHead;
    private ICodeAble msgBody;
    private long receiverTime;
    public long getReceiverTime() {
		return receiverTime;
	}
	public void setReceiverTime(long receiverTime) {
		this.receiverTime = receiverTime;
	}
	
	private byte[] data;
	
	private String dt;
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public MsgHead getMsgHead() {
		return msgHead;
	}
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}
	public ICodeAble getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(ICodeAble msgBody) {
		this.msgBody = msgBody;
	}

	public Msg(MsgHead msgHead, ICodeAble msgBody) {
		super();
		this.msgHead = msgHead;
		this.msgBody = msgBody;
	}
	
	public Msg() {
		super();
	}
	public void decode(IXInputStream inputStream) throws IOException {
		msgHead = new MsgHead();
		msgHead.decode(inputStream);
		int size = msgHead.getSizeOfMsgBody();
		data = null;
		if(size>0){
			data = new byte[size];
			inputStream.readFully(data, 0, size);
		}
	}

	public void encode(IXOutStream outputStream) throws IOException {
		if(msgHead!=null){
			if(msgBody!=null){
				//设置msgHead里的sizeOfMsgBody变量
				//统一全部用java的数据格式进行编码~~~~
				IXOutStream temp = XIOFactoryManager.getIoFactoryByKey().getIXOutStream();
				ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
				temp.setOutputStream(bytearray);
				msgBody.encode(temp);
				msgHead.setSizeOfMsgBody(bytearray.toByteArray().length);
				data = bytearray.toByteArray();
				temp.close();
			}else{
				if(data!=null){
					msgHead.setSizeOfMsgBody(data.length);
				}else{
					msgHead.setSizeOfMsgBody(0);
				}
			}
			msgHead.encode(outputStream);
			if(data!=null){
				outputStream.writeBytes(data);
			}
		}
	}
	/**
	 * 解析消息�?
	 * @param codeAble
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public <T extends ICodeAble> T decodeBody(Class<T> c){
		msgBody = DataCodecFactory.getInstance().decodeBody(this, c);
		return (T)msgBody;
	}
}
