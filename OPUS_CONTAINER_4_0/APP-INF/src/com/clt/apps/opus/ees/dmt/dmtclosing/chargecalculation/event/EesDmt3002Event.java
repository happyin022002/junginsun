/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3002Event.java
*@FileTitle : Charge Calculation by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.13 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 황효근
 * @see EES_DMT_3002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeArgumentVO[] chargeArgumentVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	//private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;

	private ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
	

	public EesDmt3002Event(){}
	
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO){
		this. chargeArgumentVO = chargeArgumentVO;
	}

	public void setChargeArgumentVOS(ChargeArgumentVO[] chargeArgumentVOs){
		if (chargeArgumentVOs != null) {
			ChargeArgumentVO[] tmpVOs = new ChargeArgumentVO[chargeArgumentVOs.length];
			System.arraycopy(chargeArgumentVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeArgumentVOs = tmpVOs;
		}
	}
	
	public void setChargeByOfficeOrVVDVO(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO){
		this. chargeByOfficeOrVVDVO  = chargeByOfficeOrVVDVO;
	}

	public ChargeArgumentVO getChargeArgumentVO(){
		return chargeArgumentVO;
	}

	public ChargeArgumentVO[] getChargeArgumentVOS(){
		ChargeArgumentVO[] tmpVOs = null;
		if (this.chargeArgumentVOs != null) {
			tmpVOs = new ChargeArgumentVO[chargeArgumentVOs.length];
			System.arraycopy(chargeArgumentVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public ChargeByOfficeOrVVDVO getChargeByOfficeOrVVDVO(){
		return chargeByOfficeOrVVDVO;
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