/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv001102Event.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceCorrectionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0011_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0011_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0011_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv001102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCorrectionVO aRInvoiceCorrectionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs = null;

	public FnsInv001102Event(){}
	
	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO aRInvoiceCorrectionVO){
		this. aRInvoiceCorrectionVO = aRInvoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVOS(ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs){
		if(aRInvoiceCorrectionVOs != null){
			ARInvoiceCorrectionVO[] tmpVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceCorrectionVOs = tmpVOs;
		}
	}

	public ARInvoiceCorrectionVO getARInvoiceCorrectionVO(){
		return aRInvoiceCorrectionVO;
	}

	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOS(){
		ARInvoiceCorrectionVO[] rtnVOs = null;
		if (this.aRInvoiceCorrectionVOs != null) {
			rtnVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}