/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FnsInv0119Event.java
*@FileTitle : APC Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.14
*@LastModifier : myoungsin park
*@LastVersion : 1.0
* 2014.12.14 myoungsin park
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvArIssVO;


/**
 * FNS_INV_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungsin park
 * @see FNS_INV_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private APCInvoiceVO aPCInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private APCInvoiceVO[] aPCInvoiceVOs = null;

	public FnsInv0113Event(){}

	public APCInvoiceVO getaPCInvoiceVO() {
		return aPCInvoiceVO;
	}

	public void setaPCInvoiceVO(APCInvoiceVO aPCInvoiceVO) {
		this.aPCInvoiceVO = aPCInvoiceVO;
	}

	public APCInvoiceVO[] getaPCInvoiceVOs() {
		APCInvoiceVO[] rtnVOs = null;
		if (this.aPCInvoiceVOs != null) {
			rtnVOs = new APCInvoiceVO[aPCInvoiceVOs.length];
			System.arraycopy(aPCInvoiceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setaPCInvoiceVOs(APCInvoiceVO[] aPCInvoiceVOs) {
		if (aPCInvoiceVOs != null) {
			APCInvoiceVO[] tmpVOs = new APCInvoiceVO[aPCInvoiceVOs.length];
			System.arraycopy(aPCInvoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aPCInvoiceVOs = tmpVOs;
		}
	}
}