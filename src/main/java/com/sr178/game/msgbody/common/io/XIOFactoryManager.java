package com.sr178.game.msgbody.common.io;

import java.util.HashMap;
import java.util.Map;

import com.sr178.game.msgbody.common.constant.MsgConstant;
import com.sr178.game.msgbody.common.io.iface.IoFactory;
import com.sr178.game.msgbody.common.io.java.JavaIoFactory;

public class XIOFactoryManager {
    private static Map<Integer,IoFactory> ioMap = new HashMap<Integer,IoFactory>();
    static{
//    	ioMap.put(SystemConstant.AS_CLIENT, new AmfIoFactory());
    	ioMap.put(MsgConstant.JAVA_CLIENT, new JavaIoFactory());
    }
    
	public static IoFactory getIoFactoryByKey(){
		return ioMap.get(MsgConstant.JAVA_CLIENT);
	}
//	
//	public static int getTypeByInputStream(IXInputStream input){
//		 if(input instanceof Amf3Input){
//			 return SystemConstant.AS_CLIENT;
//		 }else if(input instanceof JavaInput){
//			 return SystemConstant.JAVA_CLIENT;
//		 }else{
//			 throw new NullPointerException("不存在的io类型");
//		 }
//	}
//	
//	public static int getTypeByOutputStream(IXOutStream output){
//		 if(output instanceof Amf3Output){
//			 return SystemConstant.AS_CLIENT;
//		 }else if(output instanceof JavaOutput){
//			 return SystemConstant.JAVA_CLIENT;
//		 }else{
//			 throw new NullPointerException("不存在的io类型");
//		 }
//	}
	
}
