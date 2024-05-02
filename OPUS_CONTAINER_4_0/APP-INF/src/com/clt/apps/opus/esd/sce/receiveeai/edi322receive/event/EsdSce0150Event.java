/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0085Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EDI_214_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimSungIl
 * @see EsdSce0150EventResponse 참조
 * @since J2EE 1.4
 */
@SuppressWarnings( "rawtypes" )
public class EsdSce0150Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	public EsdSce0150Event(){}
	
	public String str = null;
	
	public java.util.HashMap hdr = null;

	public java.util.HashMap getHDR(){
		return hdr; 
	}
	public void setHDR(java.util.HashMap hdr){
		this.hdr = hdr;
	}
	public String getEventName(){
		return "EsdSce0150Event";
	}
	public String toString(){
		return "EsdSce0150Event";
	}	
	public String getString(){
		return str;
	}	
	public void setString(String str){
		this.str = str;
	}	
}

