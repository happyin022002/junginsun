/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4016Event.java
*@FileTitle : SZPBB DEM Calculation &amp; Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.13 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;


/**
 * EES_DMT_4016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_4016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeByOfficeOrVVDVO[] chargeByOfficeOrVVDVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MovementSZPBBParmVO movementSZPBBParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MovementSZPBBParmVO[] movementSZPBBParmVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	
	private ChargeArgumentVO chargeArgumentVO = null;
	
	
	public EesDmt4016Event(){}
	
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

	
	public void setMovementSZPBBParmVO(MovementSZPBBParmVO movementSZPBBParmVO){
		this. movementSZPBBParmVO = movementSZPBBParmVO;
	}

	public void setMovementSZPBBParmVOS(MovementSZPBBParmVO[] movementSZPBBParmVOs){
		this. movementSZPBBParmVOs = movementSZPBBParmVOs;
	}

	public MovementSZPBBParmVO getMovementSZPBBParmVO(){
		return movementSZPBBParmVO;
	}

	public MovementSZPBBParmVO[] getMovementSZPBBParmVOS(){
		return movementSZPBBParmVOs;
	}

	/**
	 * @return the chargeCalculationContainerVOs
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOs() {
		return chargeCalculationContainerVOs;
	}

	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOs(
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs) {
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}

	/**
	 * @return the chargeArgumentVO
	 */
	public ChargeArgumentVO getChargeArgumentVO() {
		return chargeArgumentVO;
	}

	/**
	 * @param chargeArgumentVO the chargeArgumentVO to set
	 */
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO) {
		this.chargeArgumentVO = chargeArgumentVO;
	}
}