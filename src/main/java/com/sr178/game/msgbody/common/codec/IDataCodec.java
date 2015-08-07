package com.sr178.game.msgbody.common.codec;

import java.util.List;

import com.sr178.game.msgbody.common.model.ICodeAble;
import com.sr178.game.msgbody.common.model.Msg;

/**
 * 数据编解码工具
 * @author magical
 *
 */
public interface IDataCodec {
	
	public List<Msg> decodeMsgUser(byte[] datas);
	
	public byte[] encodeMsgUser(List<Msg> msgs);
	
	public List<Msg> decodeMsgServer(byte[] datas);
	
	public byte[] encodeMsgServer(List<Msg> msgs);
	
	public <T extends ICodeAble> T decodeBody(Msg msg,Class<T> c);
}
