/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0052Event.java
*@FileTitle : M&R Simple W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 권영법 
*@LastVersion : 1.0
* 2009.08.11 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0052HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법 
 * @see EES_MNR_0052HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0052Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	private GeneralWOGRPVO  generalWOGRPVO = null;
	
	public EesMnr0052Event(){}

	public GeneralWOGRPVO getGeneralWOGRPVO() {
		return generalWOGRPVO;
	}

	public void setGeneralWOGRPVO(GeneralWOGRPVO generalWOGRPVO) {
		this.generalWOGRPVO = generalWOGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
	
}