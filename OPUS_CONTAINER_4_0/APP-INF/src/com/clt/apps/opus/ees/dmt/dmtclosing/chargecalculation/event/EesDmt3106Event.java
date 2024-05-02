/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3106Event.java
*@FileTitle : Manual Batch by POD ETA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.03 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3106HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManualChargeCreationVO manualChargeCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ManualChargeCreationVO[] manualChargeCreationVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VDMovementVO vdMovementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VDMovementVO[] vdMovementVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	
	
	public EesDmt3106Event(){}
	

	public void setManualChargeCreationVO(ManualChargeCreationVO manualChargeCreationVO){
		this. manualChargeCreationVO = manualChargeCreationVO;
	}

	public void setManualChargeCreationVOs(ManualChargeCreationVO[] manualChargeCreationVOs){
		if (manualChargeCreationVOs != null) {
			ManualChargeCreationVO[] tmpVOs = new ManualChargeCreationVO[manualChargeCreationVOs.length];
			System.arraycopy(manualChargeCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualChargeCreationVOs = tmpVOs;
		}
	}
	

	public ManualChargeCreationVO getManualChargeCreationVO(){
		return manualChargeCreationVO;
	}

	public ManualChargeCreationVO[] getManualChargeCreationVOs(){
		ManualChargeCreationVO[] tmpVOs = null;
		if (this.manualChargeCreationVOs != null) {
			tmpVOs = new ManualChargeCreationVO[manualChargeCreationVOs.length];
			System.arraycopy(manualChargeCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @return the vdMovementVO
	 */
	public VDMovementVO getVdMovementVO() {
		return vdMovementVO;
	}

	/**
	 * @param vdMovementVO the vdMovementVO to set
	 */
	public void setVdMovementVO(VDMovementVO vdMovementVO) {
		this.vdMovementVO = vdMovementVO;
	}

	/**
	 * @return the vdMovementVOs
	 */
	public VDMovementVO[] getVdMovementVOs() {
		VDMovementVO[] tmpVOs = null;
		if (this.vdMovementVOs != null) {
			tmpVOs = new VDMovementVO[vdMovementVOs.length];
			System.arraycopy(vdMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param vdMovementVOs the vdMovementVOs to set
	 */
	public void setVdMovementVOs(VDMovementVO[] vdMovementVOs) {
		if (vdMovementVOs != null) {
			VDMovementVO[] tmpVOs = new VDMovementVO[vdMovementVOs.length];
			System.arraycopy(vdMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vdMovementVOs = tmpVOs;
		}
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


	/**
	 * @return the chargeCalculationContainerVOs
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOs() {
		ChargeCalculationContainerVO[] tmpVOs = null;
		if (this.chargeCalculationContainerVOs != null) {
			tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOs(
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs) {
		if (chargeCalculationContainerVOs != null) {
			ChargeCalculationContainerVO[] tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeCalculationContainerVOs = tmpVOs;
		}
	}

}