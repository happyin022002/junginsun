/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0023Event.java
*@FileTitle : Other Revenue Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;


/**
 * FNS_INV_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0023HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NonShippingInputVO nonShippingInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private NonShippingInputVO[] nonShippingInputVOs = null;

	public FnsInv0023Event(){}
	
	public void setNonShippingInputVO(NonShippingInputVO nonShippingInputVO){
		this. nonShippingInputVO = nonShippingInputVO;
	}

	public void setNonShippingInputVOS(NonShippingInputVO[] nonShippingInputVOs){
		this. nonShippingInputVOs = nonShippingInputVOs;
	}

	public NonShippingInputVO getNonShippingInputVO(){
		return nonShippingInputVO;
	}

	public NonShippingInputVO[] getNonShippingInputVOS(){
		return nonShippingInputVOs;
	}

}