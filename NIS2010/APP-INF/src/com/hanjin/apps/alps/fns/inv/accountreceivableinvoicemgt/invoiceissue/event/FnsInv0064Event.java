/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0064Event.java
*@FileTitle : (Korea) Terminal GIRO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.04.27 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroInputConditionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0064HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KORGiroInputVO kORGiroInputVO = null;
	private KORGiroInputConditionVO kORGiroInputConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KORGiroInputVO[] kORGiroInputVOs = null;
	private KORGiroInputConditionVO[] kORGiroInputConditionVOs = null;

	public FnsInv0064Event(){}
	
	public void setKORGiroInputVO(KORGiroInputVO kORGiroInputVO){
		this. kORGiroInputVO = kORGiroInputVO;
	}

	public void setKORGiroInputVOS(KORGiroInputVO[] kORGiroInputVOs){
		this. kORGiroInputVOs = kORGiroInputVOs;
	}

	public KORGiroInputVO getKORGiroInputVO(){
		return kORGiroInputVO;
	}

	public KORGiroInputVO[] getKORGiroInputVOS(){
		return kORGiroInputVOs;
	}
	
	public void setKORGiroInputConditionVO(KORGiroInputConditionVO kORGiroInputConditionVO){
		this. kORGiroInputConditionVO = kORGiroInputConditionVO;
	}

	public void setKORGiroInputConditionVOS(KORGiroInputConditionVO[] kORGiroInputConditionVOs){
		this. kORGiroInputConditionVOs = kORGiroInputConditionVOs;
	}

	public KORGiroInputConditionVO getKORGiroInputConditionVO(){
		return kORGiroInputConditionVO;
	}

	public KORGiroInputConditionVO[] getKORGiroInputConditionVOS(){
		return kORGiroInputConditionVOs;
	}

	
}