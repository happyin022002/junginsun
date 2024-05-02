/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4008Event.java
*@FileTitle : Issued Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.08 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_4008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IssuedInvoiceParamVO issuedInvoiceParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IssuedInvoiceParamVO[] issuedInvoiceParamVOs = null;

	public EesDmt4008Event(){}
	
	public void setIssuedInvoiceParamVO(IssuedInvoiceParamVO issuedInvoiceParamVO){
		this. issuedInvoiceParamVO = issuedInvoiceParamVO;
	}

	public void setIssuedInvoiceParamVOS(IssuedInvoiceParamVO[] issuedInvoiceParamVOs){
		if (issuedInvoiceParamVOs != null) {
			IssuedInvoiceParamVO[] tmpVOs = new IssuedInvoiceParamVO[issuedInvoiceParamVOs.length];
			System.arraycopy(issuedInvoiceParamVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.issuedInvoiceParamVOs = tmpVOs;
		}
	}

	public IssuedInvoiceParamVO getIssuedInvoiceParamVO(){
		return issuedInvoiceParamVO;
	}

	public IssuedInvoiceParamVO[] getIssuedInvoiceParamVOS(){
		IssuedInvoiceParamVO[] tmpVOs = null;
		if (this.issuedInvoiceParamVOs != null) {
			tmpVOs = new IssuedInvoiceParamVO[issuedInvoiceParamVOs.length];
			System.arraycopy(issuedInvoiceParamVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}