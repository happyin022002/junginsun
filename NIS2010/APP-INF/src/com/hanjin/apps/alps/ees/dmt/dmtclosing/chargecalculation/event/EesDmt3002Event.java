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
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;


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
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeCalculationContainerVO chargeCalculationContainerVO = null;

	private ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
	

	public EesDmt3002Event(){}
	
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO){
		this. chargeArgumentVO = chargeArgumentVO;
	}

	public void setChargeArgumentVOS(ChargeArgumentVO[] chargeArgumentVOs){
		this. chargeArgumentVOs = chargeArgumentVOs;
	}
	
	public void setChargeByOfficeOrVVDVO(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO){
		this. chargeByOfficeOrVVDVO  = chargeByOfficeOrVVDVO;
	}

	public ChargeArgumentVO getChargeArgumentVO(){
		return chargeArgumentVO;
	}

	public ChargeArgumentVO[] getChargeArgumentVOS(){
		return chargeArgumentVOs;
	}
	
	public ChargeByOfficeOrVVDVO getChargeByOfficeOrVVDVO(){
		return chargeByOfficeOrVVDVO;
	}

	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}
	
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS() {
		return chargeCalculationContainerVOs;
	}
	public void setChargeCalculationContainerVO(ChargeCalculationContainerVO chargeCalculationContainerVO){
		this.chargeCalculationContainerVO = chargeCalculationContainerVO;
	}
	
	public ChargeCalculationContainerVO getChargeCalculationContainerVO() {
		return chargeCalculationContainerVO;
	}

}