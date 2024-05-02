/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0085EventResponse.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * EDI_214_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yjlee
 * @see EsdSce0085EventResponse 참조
 * @since J2EE 1.4
 */

public class EsdSce0085EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;

	public String str = null;
	
	public String msgstart = null;
	public java.util.HashMap hdr = null;
	public java.util.HashMap cntr = null;
	public java.util.HashMap loc = null;

	/**
	 * EsdSce0085EventResponse 객체를 생성
	 */

	public EsdSce0085EventResponse(){}
	/**
	 * String을 반환
	 * @param String str
	 */
	public EsdSce0085EventResponse(String str){
		this.str = str;
	}

	/**
	 * 객체 표현 문자열(EsdSce0085EventResponse)을 반환
	 *
	 * @return String EsdSce0085EventResponse
	 */
	public String toString(){
		return "EsdSce0085EventResponse";
	}


	/**
	 * 이벤트 명(EsdSce0085EventResponse)을 반환
	 *
	 * @return String EsdSce0085EventResponse
	 */
	public String getEventName(){
		return "EsdSce0085EventResponse";
	}

	public String getString(){
		return str;
	}


	public void setString(String str){
		this.str = str;
	}
	
	public void setMSGSTART(String msgstart){
		this.msgstart = msgstart;
	}

	public String getMSGSTART(){
		return msgstart;
	}
	
	public java.util.HashMap getHDR(){
		return hdr;
	}

	public void setHDR(java.util.HashMap hdr){
		this.hdr = hdr;
	}

	public java.util.HashMap getcntr(){
		return cntr;
	}

	public void setCNTR(java.util.HashMap cntr){
		this.cntr = cntr;
	}
	
	public java.util.HashMap getLOC(){
		return loc;
	}

	public void setLOC(java.util.HashMap loc){
		this.loc = loc;
	}

}