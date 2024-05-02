/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4005Event.java
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.25 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_4005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_4005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeForAuditParmVO chargeForAuditParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeForAuditParmVO[] chargeForAuditParmVOs = null;

	public EesDmt4005Event(){}
	
	public void setChargeForAuditParmVO(ChargeForAuditParmVO chargeForAuditParmVO){
		this. chargeForAuditParmVO = chargeForAuditParmVO;
	}

	public void setChargeForAuditParmVOS(ChargeForAuditParmVO[] chargeForAuditParmVOs){
		if (chargeForAuditParmVOs != null) {
			ChargeForAuditParmVO[] tmpVOs = new ChargeForAuditParmVO[chargeForAuditParmVOs.length];
			System.arraycopy(chargeForAuditParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeForAuditParmVOs = tmpVOs;
		}
	}

	public ChargeForAuditParmVO getChargeForAuditParmVO(){
		return chargeForAuditParmVO;
	}

	public ChargeForAuditParmVO[] getChargeForAuditParmVOS(){
		ChargeForAuditParmVO[] tmpVOs = null;
		if (this.chargeForAuditParmVOs != null) {
			tmpVOs = new ChargeForAuditParmVO[chargeForAuditParmVOs.length];
			System.arraycopy(chargeForAuditParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}