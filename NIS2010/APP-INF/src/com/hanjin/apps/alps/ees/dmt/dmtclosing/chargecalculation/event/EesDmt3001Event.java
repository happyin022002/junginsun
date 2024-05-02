/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3001Event.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;


/**
 * EES_DMT_3001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_3001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeByOfficeOrVVDVO[] chargeByOfficeOrVVDVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	//private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	

	public EesDmt3001Event(){}
	
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