/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3004Event.java
*@FileTitle : Charge Inquiry by Office Or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.02 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeByOfficeOrVVDVO[] chargeByOfficeOrVVDVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	

	public EesDmt3004Event(){}
	
	public void setChargeByOfficeOrVVDVO(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO){
		this. chargeByOfficeOrVVDVO = chargeByOfficeOrVVDVO;
	}

	public void setChargeByOfficeOrVVDVOS(ChargeByOfficeOrVVDVO[] chargeByOfficeOrVVDVOs){
		if (chargeByOfficeOrVVDVOs != null) {
			ChargeByOfficeOrVVDVO[] tmpVOs = new ChargeByOfficeOrVVDVO[chargeByOfficeOrVVDVOs.length];
			System.arraycopy(chargeByOfficeOrVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeByOfficeOrVVDVOs = tmpVOs;
		}
	}

	public ChargeByOfficeOrVVDVO getChargeByOfficeOrVVDVO(){
		return chargeByOfficeOrVVDVO;
	}

	public ChargeByOfficeOrVVDVO[] getChargeByOfficeOrVVDVOS(){
		ChargeByOfficeOrVVDVO[] tmpVOs = null;
		if (this.chargeByOfficeOrVVDVOs != null) {
			tmpVOs = new ChargeByOfficeOrVVDVO[chargeByOfficeOrVVDVOs.length];
			System.arraycopy(chargeByOfficeOrVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		if (chargeCalculationContainerVOs != null) {
			ChargeCalculationContainerVO[] tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeCalculationContainerVOs = tmpVOs;
		}
	}
	
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS() {
		ChargeCalculationContainerVO[] tmpVOs = null;
		if (this.chargeCalculationContainerVOs != null) {
			tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}