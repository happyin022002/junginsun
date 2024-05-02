/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdSceBLPickUpEvent.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-04
*@LastModifier : Y
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EDI_BLPickUp_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimSungIl
 * @see EsdSceBLPickUpEventResponse 참조
 * @since J2EE 1.4
 */
public class EsdSceBLPickUpEvent extends EventSupport{
	private static final long serialVersionUID = 1L;

	public EsdSceBLPickUpEvent(){}
	
	public String str = null;
	
	public java.util.HashMap<String, String> hdr = null;

	public java.util.HashMap<String, String> getHDR(){
		return hdr; 
	}
	public void setHDR(java.util.HashMap<String, String> hdr){
		this.hdr = hdr;
	}
	public String getEventName(){
		return "EsdSceBLPickUpEvent";
	}
	public String toString(){
		return "EsdSceBLPickUpEvent";
	}	
	public String getString(){
		return str;
	}	
	public void setString(String str){
		this.str = str;
	}	
}

