/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtEvent.java
*@FileTitle : Booking_History_Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.event;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * Booking_History_Mgt 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  Booking_History_MgtHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see Booking_History_MgtHTMLAction 참조
 * @since J2EE 1.4
 */

public class BkgComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private Map<String, Object> attrs = Collections.synchronizedMap(new HashMap<String, Object>());
	
	public BkgComEvent(){}
	
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