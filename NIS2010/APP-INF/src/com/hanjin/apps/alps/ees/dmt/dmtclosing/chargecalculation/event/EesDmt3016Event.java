/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3016Event.java
*@FileTitle : OP-MT Detention Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.07.23 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OPMTChargeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;


/**
 * EES_DMT_3016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_3016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OPMTChargeParmVO oPMTChargeParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OPMTChargeParmVO[] oPMTChargeParmVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	//private ChargeCalculationContainerVO chargeCalculationContainerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	

	public EesDmt3016Event(){}
	
	public void setOPMTChargeParmVO(OPMTChargeParmVO oPMTChargeParmVO){
		this. oPMTChargeParmVO = oPMTChargeParmVO;
	}

	public void setOPMTChargeParmVOS(OPMTChargeParmVO[] oPMTChargeParmVOs){
		this. oPMTChargeParmVOs = oPMTChargeParmVOs;
	}

	public OPMTChargeParmVO getOPMTChargeParmVO(){
		return oPMTChargeParmVO;
	}

	public OPMTChargeParmVO[] getOPMTChargeParmVOS(){
		return oPMTChargeParmVOs;
	}
	
	public void setChargeCalculationContainerVOS(ChargeCalculationContainerVO[] chargeCalculationContainerVOs){
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
	}
	
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOS() {
		return chargeCalculationContainerVOs;
	}

}