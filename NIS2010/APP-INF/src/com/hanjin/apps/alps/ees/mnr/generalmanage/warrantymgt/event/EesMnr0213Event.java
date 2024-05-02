/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0213Event.java
*@FileTitle : Warranty Alert_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
  
/** 
 * ESS_MNR_0213 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0213HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신 
 * @see EES_MNR_0213HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0213Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	   
	/** Table Value Object 조회 조건 및 단건 처리  */
	private WarrantyAlertInfoINVO warrantyAlertInfoINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqRngStsVO[] customMnrEqRngStsVOs = null;

	public EesMnr0213Event(){}

	public WarrantyAlertInfoINVO getWarrantyAlertInfoINVO() {
		return warrantyAlertInfoINVO;
	}

	public void setWarrantyAlertInfoINVO(WarrantyAlertInfoINVO warrantyAlertInfoINVO) {
		this.warrantyAlertInfoINVO = warrantyAlertInfoINVO;
	}

	public CustomMnrEqRngStsVO[] getCustomMnrEqRngStsVOs() {
		return customMnrEqRngStsVOs;
	} 
		 
	public void setCustomMnrEqRngStsVOs(CustomMnrEqRngStsVO[] customMnrEqRngStsVOs) {
		this.customMnrEqRngStsVOs = customMnrEqRngStsVOs;
	}   
}