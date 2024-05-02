/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0054Event.java
*@FileTitle : M&R Extra Expense W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 권영법 
*@LastVersion : 1.0
* 2009.06.03 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0054HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법 
 * @see EES_MNR_0054HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0054Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	private GeneralWOGRPVO  generalWOGRPVO = null;
	
	public EesMnr0054Event(){}

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