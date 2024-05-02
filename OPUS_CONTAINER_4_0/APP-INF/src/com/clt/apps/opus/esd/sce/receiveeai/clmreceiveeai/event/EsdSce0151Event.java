/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce051Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier : KimSungIl
*@LastVersion : 1.0
* 2009-11-01 KimSungIl
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.event;

import java.util.HashMap;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EDI_CLM_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimSungIl
 * @see EsdSce0150EventResponse 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("rawtypes")
public class EsdSce0151Event extends EventSupport{
	private static final long serialVersionUID = 1L;

	public EsdSce0151Event(){}
	
	public String str = null;
	
	public HashMap hdr = null; 

	public HashMap getHDR(){
		return hdr;
	}
	public void setHDR(HashMap hdr){
		this.hdr = hdr;
	}
	public String getEventName(){
		return "EsdSce0151Event";
	}
	public String toString(){
		return "EsdSce0151Event";
	}	
	public String getString(){
		return str;
	}	
	public void setString(String str){
		this.str = str;
	}	
}

