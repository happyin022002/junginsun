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
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;


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
		this. chargeByOfficeOrVVDVOs = chargeByOfficeOrVVDVOs;
	}

	public ChargeByOfficeOrVVDVO getChargeByOfficeOrVVDVO(){
		return chargeByOfficeOrVVDVO;
	}

	public ChargeByOfficeOrVVDVO[] getChargeByOfficeOrVVDVOS(){
		return chargeByOfficeOrVVDVOs;
	}

	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}
	
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS() {
		return chargeCalculationContainerVOs;
	}

}