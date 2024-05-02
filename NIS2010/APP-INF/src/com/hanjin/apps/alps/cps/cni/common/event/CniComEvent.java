/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniComEvent.java
*@FileTitle : CNI 공통 Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.event;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CNI 공통 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CNI_COM_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CNI_COM_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CniComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private Map<String, Object> attrs = Collections.synchronizedMap(new HashMap<String, Object>());
	
	public CniComEvent(){}
	
	public void setObject(String key, Object value){
	    if(key==null) return;
	    attrs.put(key, value);
	}
	
	public void setString(String key, String value){
        if(key==null) return;
	    attrs.put(key, value);
	}
	
    public void setLong(String key, long value){
        if(key==null) return;
        attrs.put(key, String.valueOf(value));
    }
    
    
    public void setInt(String key, int value){
        if(key==null) return;
        attrs.put(key, String.valueOf(value));
    }
    
    public Object getObject(String key){
        return (key==null) ? null : attrs.get(key);
    }
    
    
    public String getString(String key){
        return (key==null) ? "" : (String)attrs.get(key);
    }
    
    
    public long getLong(String key){
        String s = this.getString(key);
        return ("".equals(s)) ? 0L : Long.parseLong(s);
    }
    
    
    public int getInt(String key){
        String s = this.getString(key);
        return ("".equals(s)) ? 0 : Integer.parseInt(s);
    }
    
}