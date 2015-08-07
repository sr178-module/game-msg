package com.sr178.game.msgbody.server;

import java.io.IOException;

import com.sr178.game.msgbody.common.io.iface.IXInputStream;
import com.sr178.game.msgbody.common.io.iface.IXOutStream;
import com.sr178.game.msgbody.common.model.ICodeAble;

public class ReqRegisterChannelMsgBody implements ICodeAble {
    /***服务器类型*******/
	private String serverType;
	/***通道类型*******/
	private String channelType;
	public void encode(IXOutStream outputStream) throws IOException {
		outputStream.writeUTF(serverType);
		outputStream.writeUTF(channelType);
	}
	public void decode(IXInputStream inputStream) throws IOException {
		serverType = inputStream.readUTF();
		channelType = inputStream.readUTF();
	}
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	
}
