/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesDmt3014Event.java
*@FileTitle : Approval for Charge Deletion
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2011.07.13 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeDeletionRequstVO chargeDeletionRequstVO = null;

	public EesDmt3014Event(){}
	
	public void setChargeCalculationContainerVO(ChargeCalculationContainerVO chargeCalculationContainerVO){
		this.chargeCalculationContainerVO = chargeCalculationContainerVO;
	}

	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}
	public void setChargeDeletionRequstVO(ChargeDeletionRequstVO chargeDeletionRequstVO){
		this.chargeDeletionRequstVO = chargeDeletionRequstVO;

	}

	public ChargeCalculationContainerVO getChargeCalculationContainerVO(){
		return chargeCalculationContainerVO;
	}

	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS(){
		return chargeCalculationContainerVOs;
	}
	public ChargeDeletionRequstVO getChargeDeletionRequstVO(){
		return chargeDeletionRequstVO;
	}
}