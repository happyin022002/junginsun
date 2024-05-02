/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0032Event.java
 *@FileTitle : Invoice Report by No Good & Not Issue
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodNotIssueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0032HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object Multi Data 처리 */
	private ARInvoiceNoGoodNotIssueListVO[] aRInvoiceNoGoodNotIssueListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ARInvoiceNoGoodInPutVO noGoodNoIssueVO = null;

	public FnsInv0032Event() {
	}

	public void setARInvoiceNoGoodNotIssueListVOS(ARInvoiceNoGoodNotIssueListVO[] aRInvoiceNoGoodNotIssueListVOs) {
		this.aRInvoiceNoGoodNotIssueListVOs = aRInvoiceNoGoodNotIssueListVOs;
	}

	public ARInvoiceNoGoodNotIssueListVO[] getARInvoiceNoGoodNotIssueListVOS() {
		return aRInvoiceNoGoodNotIssueListVOs;
	}

	public ARInvoiceNoGoodInPutVO getNoGoodNoIssueVO() {
		return noGoodNoIssueVO;
	}

	public void setNoGoodNoIssueVO(ARInvoiceNoGoodInPutVO noGoodNoIssueVO) {
		this.noGoodNoIssueVO = noGoodNoIssueVO;
	}

}