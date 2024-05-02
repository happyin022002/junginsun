/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0009Event.java
*@FileTitle : Invoice Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.08 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceInputByBLNoVO invInput = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0009Event(){}
	
	public void setARInvoiceInputByBLNoVO(ARInvoiceInputByBLNoVO invInput){
		this. invInput = invInput;
	}

	public void setARInvoiceByBLNoVOS(ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs){
		if(aRInvoiceByBLNoVOs != null){
			ARInvoiceByBLNoVO[] tmpVOs = new ARInvoiceByBLNoVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceByBLNoVOs = tmpVOs;
		}
	}

	public ARInvoiceInputByBLNoVO getARInvoiceInputByBLNoVO(){
		return invInput;
	}

	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOS(){
		ARInvoiceByBLNoVO[] rtnVOs = null;
		if (this.aRInvoiceByBLNoVOs != null) {
			rtnVOs = new ARInvoiceByBLNoVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}