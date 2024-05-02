/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0152Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-25
*@LastModifier : Y
*@LastVersion : 1.0
* 2013-06-25
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.event;

import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EDI_HOLD_STATUS_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sang-Jun Kwon
 * @see 
 * @since J2EE 1.4
 */
public class EsdSce0152Event extends EventSupport{
	public EsdSce0152Event(){}
	
	public String str = null;
	
	public java.util.HashMap hdr = null;

	public java.util.HashMap getHDR(){
		return hdr; 
	}
	public void setHDR(java.util.HashMap hdr){
		this.hdr = hdr;
	}
	public String getEventName(){
		return "EsdSce0152Event";
	}
	public String toString(){
		return "EsdSce0152Event";
	}	
	public String getString(){
		return str;
	}	
	public void setString(String str){
		this.str = str;
	}	
}
