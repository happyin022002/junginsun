/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3006Event.java
*@FileTitle : Charge Inquiry by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeArgumentVO[] chargeArgumentVOs = null;

	public EesDmt3006Event(){}
	
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

}