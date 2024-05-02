/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3107Event.java
*@FileTitle : Calculation Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.10 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;


/**
 * EES_DMT_3107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3107HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeArgumentVO[] chargeArgumentVOs = null;

	public EesDmt3107Event(){}
	
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO){
		this. chargeArgumentVO = chargeArgumentVO;
	}

	public void setChargeArgumentVOS(ChargeArgumentVO[] chargeArgumentVOs){
		this. chargeArgumentVOs = chargeArgumentVOs;
	}

	public ChargeArgumentVO getChargeArgumentVO(){
		return chargeArgumentVO;
	}

	public ChargeArgumentVO[] getChargeArgumentVOS(){
		return chargeArgumentVOs;
	}

}