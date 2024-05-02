/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0227Event.java
*@FileTitle : M&R Extra W/O Inquiry Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 정영훈 
*@LastVersion : 1.0
* 2009.10.13 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0058HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 정영훈 
 * @see EES_MNR_0058HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0227Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	private GeneralWOGRPVO  generalWOGRPVO = null;
	
	public EesMnr0227Event(){}

	public GeneralWOGRPVO getGeneralWOGRPVO() {
		return generalWOGRPVO;
	}

	public void setExtraWOGRPVO(GeneralWOGRPVO generalWOGRPVO) {
		this.generalWOGRPVO = generalWOGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
	
}