/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7010Event.java
*@FileTitle : Calculation Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_7010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang Hyo Keun
 * @see EES_DMT_7010HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CalculationTypeParmVO calculationTypeParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CalculationTypeParmVO[] calculationTypeParmVOs = null;

	public EesDmt7010Event(){}
	
	public void setCalculationTypeParmVO(CalculationTypeParmVO calculationTypeParmVO){
		this. calculationTypeParmVO = calculationTypeParmVO;
	}

	public void setCalculationTypeParmVOS(CalculationTypeParmVO[] calculationTypeParmVOs){
		if (calculationTypeParmVOs != null) {
			CalculationTypeParmVO[] tmpVOs = new CalculationTypeParmVO[calculationTypeParmVOs.length];
			System.arraycopy(calculationTypeParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.calculationTypeParmVOs = tmpVOs;
		}
	}

	public CalculationTypeParmVO getCalculationTypeParmVO(){
		return calculationTypeParmVO;
	}

	public CalculationTypeParmVO[] getCalculationTypeParmVOS(){
		CalculationTypeParmVO[] tmpVOs = null;
		if (this.calculationTypeParmVOs != null) {
			tmpVOs = new CalculationTypeParmVO[calculationTypeParmVOs.length];
			System.arraycopy(calculationTypeParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}