/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrEDIInterfaceEvent.java
*@FileTitle : EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신 
*@LastVersion : 1.0   
* 2009.05.12 박명신 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
    
/**
 * MNR_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MNR_COM_HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author lee ju hyun
 * @see MNR_INTERFACE_HTMLAction 참조
 * @since J2EE 1.4
 * 
 */ 
     
public class MnrEDIInterfaceEvent extends EventSupport { 
	private static final long serialVersionUID = 1L;
		
	public MnrEDIInterfaceEvent(){} 
		
	/** Table Value Object 조회 조건 */
	private String ediMsg = null;

	public String getEdi_msg() {	
		return ediMsg;
	}
	
	public void setEdi_msg(String ediMsg) {
		this.ediMsg = ediMsg;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}