/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0170Event.java
*@FileTitle : Warranty Alert list
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
  
/** 
 * ESS_MNR_0170 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0170HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신 
 * @see EES_MNR_0170HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0170Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private WarrantyAlertListINVO warrantyAlertListINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomWarrantyAlertListVO[] customWarrantyAlertListVOs = null;
    
	public EesMnr0170Event(){}
    
	public WarrantyAlertListINVO getWarrantyAlertListINVO() {
		return warrantyAlertListINVO;
	}

	public void setWarrantyAlertListINVO(WarrantyAlertListINVO warrantyAlertListINVO) {
		this.warrantyAlertListINVO = warrantyAlertListINVO;
	}
     
	public CustomWarrantyAlertListVO[] getCustomWarrantyAlertListVOs() {
		return customWarrantyAlertListVOs;
	}

	public void setCustomWarrantyAlertListVOs(
			CustomWarrantyAlertListVO[] customWarrantyAlertListVOs) {
		this.customWarrantyAlertListVOs = customWarrantyAlertListVOs;
	}
}