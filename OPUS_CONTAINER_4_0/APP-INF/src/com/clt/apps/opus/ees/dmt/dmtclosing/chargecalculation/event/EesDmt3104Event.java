/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3104Event.java
*@FileTitle : Exemption Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.16 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;

	public EesDmt3104Event(){}
	
	public void setChargeCalculationContainerVO(ChargeCalculationContainerVO chargeCalculationContainerVO){
		this. chargeCalculationContainerVO = chargeCalculationContainerVO;
	}

	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		if (chargeCalculationContainerVOs != null) {
			ChargeCalculationContainerVO[] tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeCalculationContainerVOs = tmpVOs;
		}
	}

	public ChargeCalculationContainerVO getChargeCalculationContainerVO(){
		return chargeCalculationContainerVO;
	}

	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS(){
		ChargeCalculationContainerVO[] tmpVOs = null;
		if (this.chargeCalculationContainerVOs != null) {
			tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}